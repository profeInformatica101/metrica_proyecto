package com.cinenova.consultas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Álvaro Muñoz Fernández
 */
public class borrarPelicula {
    
    public static int borrarPelicula(int idPelicula) {
        
        int row = 0;
        String sql = "DELETE FROM Pelicula WHERE id_pelicula = ?";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, idPelicula);

            row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }
    
}
