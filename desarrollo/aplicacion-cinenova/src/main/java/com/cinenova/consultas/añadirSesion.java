package com.cinenova.consultas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author alvmu
 */
public class añadirSesion {
    
    public static int añadirSesion(int idPelicula, int numeroSala, Timestamp fechaHora, double precio) {
        int row = 0;
        String sql = "INSERT INTO Sesion (id_pelicula, numeroSala, fechaHora, precio) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, idPelicula);
            preparedStatement.setInt(2, numeroSala);
            preparedStatement.setTimestamp(3, fechaHora);
            preparedStatement.setDouble(4, precio);

            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        return row;
    }

}
