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
 * Clase que recoge todas las consultas relacionadas con la tabla Persona en la base de datos
 * 
 * @author Juan Carlos Pizarro Alonso, Álvaro Muñoz Fernández
 */
public class consultasPersona {
    
    /**
     * Método que devuelve el número de filas afectadas tras añadir un cliente en la tabla Persona de la base de datos
     * 
     * @param correo Correo
     * @param nombre Nombre
     * @param apellidos Apellidos
     * @param contrasena Contraseña
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
     * Método para obtener todos los empleados registrados
     * 
     * @return Listado de empleados registrados
     */
    public static List<Empleado> obtenerEmpleados(){
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM Persona WHERE esEmpleado = 1 AND esJefe = 0";

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
     * Método para obtener todos los jefes registrados
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
     * @param cliente Cliente
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
     * @param cliente Cliente
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
    
    
     /** Método que actualiza la contraseña y el sueldo de un empleado en la base de datos
     * 
     * @param correo Correo del empleado a actualizar
     * @param nuevaContrasena Nueva contraseña para el empleado
     * @param nuevoSueldo Nuevo sueldo a asignar
     * @return Número de filas afectadas tras la actualización
     */
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
    
    /**
     * Método que elimina un empleado de la base de datos a partir de su DNI
     * 
     * @param correo Correo del empleado a eliminar
     * @return Número de filas afectadas tras la eliminación
     */
    public static int borrarEmpleado(String correo) {
        int row = 0;
        String sql = "DELETE FROM Persona WHERE correo = ?";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, correo);

            row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }
    
    /**
     * Método que añade un nuevo empleado a la base de datos
     * 
     * @param empleado Empleado
     * @return Número de filas afectadas tras la inserción en la base de datos
     */
    public static int añadirEmpleado(Empleado empleado){
        int row = 0;
        String sql = "INSERT INTO Persona (nombre, apellidos, correo, contrasena, DNI, sueldo, esEmpleado, esJefe) VALUES (?, ?, ?, ?, ?, ?, 1, 0)";        

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            
                preparedStatement.setString(1, empleado.getNombre());
                preparedStatement.setString(2, empleado.getApellidos());
                preparedStatement.setString(3, empleado.getCorreo());
                preparedStatement.setString(4, empleado.getContrasena());
                preparedStatement.setString(5, empleado.getDNI());
                preparedStatement.setDouble(6, empleado.getSueldo());
            

            row = preparedStatement.executeUpdate();


        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return row;
    }
    
    /**
     * Método que elimina un cliente en la base de datos
     * 
     * @param cliente Cliente
     * 
     * @return Número de filas afectadas tras la eliminación en la base de datos
     */
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
