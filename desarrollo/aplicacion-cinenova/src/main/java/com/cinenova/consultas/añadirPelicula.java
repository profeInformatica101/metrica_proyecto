package com.cinenova.consultas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Álvaro Muñoz Fernández
 */
public class añadirPelicula {
    
    public static int añadirPelicula(String titulo, int duracion, String genero, String clasificacionEdad, String descripcion) {
        int row = 0;
        String sql = "INSERT INTO Pelicula (titulo, duracion, genero, clasificacionEdad, descripcion) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, titulo);
            preparedStatement.setInt(2, duracion);
            preparedStatement.setString(3, genero);
            preparedStatement.setString(4, clasificacionEdad);
            preparedStatement.setString(5, descripcion);

            row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }

}
