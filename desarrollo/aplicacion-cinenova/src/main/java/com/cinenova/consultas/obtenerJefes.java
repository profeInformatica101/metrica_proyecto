package com.cinenova.consultas;

import com.cinenova.entidades.Jefe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Carlos
 */
public class obtenerJefes {
    
    public static List<Jefe> obtenerConsulta(){
        List<Jefe> jefes = new ArrayList<>();
        String sql = "SELECT * FROM Persona WHERE esJefe = 1";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             Statement statement = conn.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                Jefe jefe = new Jefe(resultSet.getString("dni"), resultSet.getDouble("sueldo"), resultSet.getString("nombre"), resultSet.getString("apellidos"), resultSet.getString("correo"), resultSet.getString("contrasena"), resultSet.getBoolean("esEmpleado"), resultSet.getBoolean("esJefe"));
                
                jefes.add(jefe);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return jefes;
    }
}
