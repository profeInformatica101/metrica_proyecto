package com.cinenova.consultas;

import com.cinenova.entidades.Cliente;
import com.cinenova.entidades.Empleado;
import com.cinenova.entidades.Entrada;
import com.cinenova.entidades.Jefe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que recoge todas las consultas relacionadas con la tabla Persona en la base de datos
 * 
 * @author Juan Carlos Pizarro Alonso, Álvaro Muñoz Fernández
 */
public class consultasPersona {
    
    /**
     * Método que devuelve el número de filas afectadas tras añadir un cliente en la tabla Persona de la base de datos
     * 
     * @param correo
     * @param nombre
     * @param apellidos
     * @param contrasena
     * @return Número de filas afectadas tras la inserción en la base de datos
     */
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
    
    /**
     * Método para obtener todas los clientes registrados
     * 
     * @return Listado de clientes registrados
     */
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
    
    /**
     * Método para obtener todas los empleados registrados
     * 
     * @return Listado de empleados registrados
     */
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
    
    /**
     * Método para obtener todas los jefes registrados
     * 
     * @return Listado de jefes registrados
     */
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
    
    /**
     * Método que actualiza sumando puntos extra a los puntos de un cliente en la base de datos
     * 
     * @param cliente
     * @return Número de filas afectadas tras la actuaización de la base de datos
     */
    public static int actualizarPuntosGanados(Cliente cliente) {
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
    
    /**
     * Método que actualiza restando puntos a los puntos de un cliente en la base de datos
     * 
     * @param cliente
     * @return Número de filas afectadas tras la actuaización de la base de datos
     */
    public static int actualizarPuntosDevueltos(Cliente cliente) {
        int row = 0;
        String sql = "UPDATE Persona SET puntosGanados = ? WHERE correo = ?";
        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, cliente.getPuntosGanados() - 5);
            preparedStatement.setString(2, cliente.getCorreo());
            
            row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return row;
    }
    
    public static int eliminarCliente(Cliente cliente){
        int row = 0;
        String sql = "DELETE FROM Persona WHERE correo = ?";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

         

            preparedStatement.setString(1, cliente.getCorreo());
            


            row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return row;
    }
}
