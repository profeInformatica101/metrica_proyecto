package com.cinenova.consultas;

import com.cinenova.entidades.Película;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que recoge todas las consultas relacionadas con la tabla Película en la base de datos
 * 
 * @author Juan Carlos Pizarro Alonso, Álvaro Muñoz Fernández
 */
public class consultasPelicula {
    
    /**
     * Método para obtener todas las películas disponibles
     * 
     * @return Listado de películas total
     */
    public static List<Película> obtenerConsulta(){
        List<Película> peliculas = new ArrayList<>();
        String sql = "SELECT * FROM Pelicula";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             Statement statement = conn.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                Película pelicula = new Película(resultSet.getInt("id_pelicula"), resultSet.getString("titulo"), resultSet.getInt("duracion"), resultSet.getString("genero"), resultSet.getString("clasificacionEdad"), resultSet.getString("descripcion"));
                
                peliculas.add(pelicula);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return peliculas;
    }
}
