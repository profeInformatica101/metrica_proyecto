package com.cinenova.consultas;

import com.cinenova.entidades.Cliente;
import com.cinenova.entidades.Entrada;
import com.cinenova.entidades.Sesión;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author usuarioDAW
 */
public class consultasEntrada {
    
    public static List<Entrada> obtenerConsulta(){
        List<Entrada> entradas = new ArrayList<>();
        String sql = "SELECT * FROM Entrada";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             Statement statement = conn.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);
            List<Cliente> clientes = consultasPersona.obtenerClientes();
            List<Sesión> sesiones = consultasSesion.obtenerConsulta();
            Cliente cliente = null;
            Sesión sesion = null;
            while (resultSet.next()) {
                for(int i = 0; i < clientes.size(); i++){
                    if((clientes.get(i).getCorreo().equals(resultSet.getString("correoPersona")))){
                        cliente = clientes.get(i);
                    }
                }
                for(int i = 0; i < sesiones.size(); i++){
                    if(sesiones.get(i).getPelicula().getIdPelicula() == resultSet.getInt("id_pelicula") && sesiones.get(i).getFechaHora().equals(resultSet.getTimestamp("fechaHora"))){
                        sesion = sesiones.get(i);
                    }
                }
                Entrada entrada = new Entrada(resultSet.getInt("asiento"), cliente, sesion, resultSet.getDouble("precioFinal"));
                
                entradas.add(entrada);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return entradas;
    }
    
    public static Map<Integer, Integer> obtenerEntradasCompradasPorSala() {
        Map<Integer, Integer> entradasPorSala = new HashMap<>();
        String sql = "SELECT numeroSala FROM Entrada";

        try (Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int sala = resultSet.getInt("numeroSala");
                entradasPorSala.merge(sala, 1, Integer::sum);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entradasPorSala;
    }
    
    public static List<Integer> obtenerAsientosOcupadosDeSala(Integer numeroSala) {
        List<Integer> asientosOcupados = new ArrayList<>();
        String sql = "SELECT asiento FROM Entrada WHERE numeroSala = ?";
        int row = 0;
        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

         

            preparedStatement.setInt(1, numeroSala);
            
            
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int asiento = resultSet.getInt("asiento");
                asientosOcupados.add(asiento);
            }
        }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return asientosOcupados;
    }
    
    public static int eliminarEntrada(Entrada entrada){
        int row = 0;
        int id_pelicula = entrada.getSesion().getPelicula().getIdPelicula();
        int sala = entrada.getSesion().getSala().getNumero();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String fechaHora = formato.format(entrada.getSesion().getFechaHora());
        String correo = entrada.getCliente().getCorreo();
        int asiento = entrada.getAsiento();
        String sql = "DELETE FROM Entrada WHERE id_pelicula = ? AND numeroSala = ? AND correoPersona = ? AND fechaHora = ? AND asiento = ?";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

         

            preparedStatement.setInt(1, id_pelicula);
            preparedStatement.setInt(2, sala);
            preparedStatement.setString(3, correo);
            preparedStatement.setString(4, fechaHora);
            preparedStatement.setInt(5, asiento);
            


            row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return row;
    }
    
    public static int añadirEntrada(Entrada entrada){
        int row = 0;
        String sql = "INSERT INTO Entrada (id_pelicula, numeroSala, fechaHora, correoPersona, asiento, precioFinal) VALUES (?, ?, ?, ?, ?, ?)";        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            
                preparedStatement.setInt(1, entrada.getSesion().getPelicula().getIdPelicula());
                preparedStatement.setInt(2, entrada.getSesion().getSala().getNumero());
                preparedStatement.setString(3, formato.format(entrada.getSesion().getFechaHora()));
                preparedStatement.setString(4, entrada.getCliente().getCorreo());
                preparedStatement.setInt(5, entrada.getAsiento());
                preparedStatement.setDouble(6, entrada.getPrecioFinal());
            

            row = preparedStatement.executeUpdate();


        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return row;
    }
}
