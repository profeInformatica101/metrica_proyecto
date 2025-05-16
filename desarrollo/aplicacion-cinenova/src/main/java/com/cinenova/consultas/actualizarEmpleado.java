package com.cinenova.consultas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Álvaro Muñoz Fernández
 */
public class actualizarEmpleado {
    
    public static int actualizarEmpleado(String correo, String nuevaContrasena, double nuevoSueldo) {
        int row = 0;
        String sql = "UPDATE Persona SET contrasena = ?, sueldo = ? WHERE correo = ?";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, nuevaContrasena);
            preparedStatement.setDouble(2, nuevoSueldo);
            preparedStatement.setString(3, correo);

            row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }

}
