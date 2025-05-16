package com.cinenova.consultas;

import com.cinenova.entidades.Cliente;
import com.cinenova.entidades.Empleado;
import com.cinenova.entidades.Jefe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Carlos
 */
public class consultasPersona {
    
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
    
    public static List<Cliente> obtenerClientes(){
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Persona WHERE esEmpleado = 0 AND esJefe = 0";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             Statement statement = conn.createStatement()) {
            
            conn.setAutoCommit(true);

            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                Cliente cliente = new Cliente(resultSet.getInt("puntosGanados"), resultSet.getString("nombre"), resultSet.getString("apellidos"), resultSet.getString("correo"), resultSet.getString("contrasena"), resultSet.getBoolean("esEmpleado"), resultSet.getBoolean("esJefe"));
                
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return clientes;
    }
    
    public static List<Empleado> obtenerEmpleados(){
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
    
    public static List<Jefe> obtenerJefes(){
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

    public static int actualizarPuntos(Cliente cliente) {
        int row = 0;
        String sql = "UPDATE Persona SET puntosGanados = ? WHERE correo = ?";
        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, cliente.getPuntosGanados() + 5);
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
