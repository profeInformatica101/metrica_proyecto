package com.cinenova.consultas;

import com.cinenova.entidades.Cliente;
import com.cinenova.entidades.Entrada;
import com.cinenova.entidades.Sesión;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuarioDAW
 */
public class obtenerEntradas {
    
    public static List<Entrada> obtenerConsulta(){
        List<Entrada> entradas = new ArrayList<>();
        String sql = "SELECT * FROM Entrada";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             Statement statement = conn.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);
            List<Cliente> clientes = obtenerClientes.obtenerConsulta();
            List<Sesión> sesiones = obtenerSesiones.obtenerConsulta();
            Cliente cliente = null;
            Sesión sesion = null;
            while (resultSet.next()) {
                for(int i = 0; i < clientes.size(); i++){
                    if((clientes.get(i).getCorreo().equals(resultSet.getString("correoPersona")))){
                        cliente = clientes.get(i);
                    }
                }
                for(int i = 0; i < sesiones.size(); i++){
                    if(sesiones.get(i).getPelicula().getIdPelicula() == resultSet.getInt("id_pelicula") && sesiones.get(i).getSala().getNumero() == resultSet.getInt("numeroSala") && sesiones.get(i).getFechaHora() == resultSet.getDate("fechaHora")){
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
}
