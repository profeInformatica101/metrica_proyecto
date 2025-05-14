package com.cinenova.consultas;

import com.cinenova.entidades.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Juan Carlos
 */
public class actualizarPuntosGanados {
    
    public static int actualizarPuntos(Cliente cliente){
        int row = 0;
        String sql = "UPDATE Persona SET puntosGanados = ? WHERE correo = ?";
        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, cliente.getPuntosGanados());
            preparedStatement.setString(2, cliente.getCorreo());
            
            row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return row;
    }
}
