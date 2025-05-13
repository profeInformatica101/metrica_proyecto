package com.cinenova.consultas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Juan Carlos
 */
public class añadirPersona {
    
    public static int añadirCliente(String correo, String nombre, String apellidos, String contrasena){
        int row = 0;
        String sql = "INSERT INTO Persona (correo, nombre, apellidos, contrasena) VALUES (?, ?, ?, ?)";        

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            
                preparedStatement.setString(1, correo);
                preparedStatement.setString(2, nombre);
                preparedStatement.setString(3, apellidos);
                preparedStatement.setString(4, contrasena);
            

            row = preparedStatement.executeUpdate();


        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return row;
    }
}
