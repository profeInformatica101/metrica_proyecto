package com.cinenova.consultas;

import com.cinenova.entidades.Sala;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que recoge todas las consultas relacionadas con la tabla Sala en la base de datos
 * 
 * @author Juan Carlos Pizarro Alonso, Álvaro Muñoz Fernández
 */
public class consultasSala {
    
     /**
     * Método para obtener todas las salas disponibles
     * 
     * @return Listado de salas total
     */
    public static List<Sala> obtenerConsulta(){
        List<Sala> salas = new ArrayList<>();
        String sql = "SELECT * FROM Sala";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             Statement statement = conn.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                Sala sala = new Sala(resultSet.getInt("numero"), resultSet.getInt("capacidad"), resultSet.getBoolean("esVIP"), resultSet.getBoolean("es3D"));
                
                salas.add(sala);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return salas;
    }
    
}
