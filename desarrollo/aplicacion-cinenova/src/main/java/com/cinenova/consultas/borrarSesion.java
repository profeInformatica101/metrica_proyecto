package com.cinenova.consultas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Álvaro Muñoz Fernández
 */
public class borrarSesion {
    
    public static int borrarSesion(int idPelicula, int numeroSala, Timestamp fechaHora) {
        int row = 0;
        String sql = "DELETE FROM Sesion WHERE id_pelicula = ? AND numeroSala = ? AND fechaHora = ?";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, idPelicula);
            preparedStatement.setInt(2, numeroSala);
            preparedStatement.setTimestamp(3, fechaHora);

            row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }



}
