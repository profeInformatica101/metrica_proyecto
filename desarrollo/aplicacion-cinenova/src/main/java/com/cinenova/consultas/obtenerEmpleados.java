package com.cinenova.consultas;

import com.cinenova.entidades.Empleado;
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
public class obtenerEmpleados {
    
    public static List<Empleado> obtenerConsulta(){
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM Persona WHERE esEmpleado = 1 OR esJefe = 1";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             Statement statement = conn.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                Empleado empleado = new Empleado(resultSet.getString("dni"), resultSet.getDouble("sueldo"), resultSet.getString("nombre"), resultSet.getString("apellidos"), resultSet.getString("correo"), resultSet.getString("contrasena"), resultSet.getBoolean("esEmpleado"), resultSet.getBoolean("esJefe"));
                
                empleados.add(empleado);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return empleados;
    }
}
