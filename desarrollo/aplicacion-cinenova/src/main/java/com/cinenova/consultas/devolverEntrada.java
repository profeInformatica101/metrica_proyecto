package com.cinenova.consultas;

import com.cinenova.entidades.Entrada;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Juan Carlos
 */
public class devolverEntrada {
    
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
}
