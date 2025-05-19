package com.cinenova.consultas;

import com.cinenova.entidades.Película;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    
    /**
     * Método para actualizar los datos de una película existente en la base de datos
     * 
     * @param id ID de la película a actualizar
     * @param titulo Nuevo título de la película
     * @param duracion Nueva duración en minutos
     * @param genero Nuevo género de la película
     * @param clasificacionEdad Nueva clasificación por edad
     * @param descripcion Nueva descripción de la película
     * @return Número de filas afectadas por la actualización
     */
    public static int actualizarPelicula(int id, String titulo, int duracion, String genero, String clasificacionEdad, String descripcion) {
        int row = 0;
        String sql = "UPDATE Pelicula SET titulo = ?, duracion = ?, genero = ?, clasificacionEdad = ?, descripcion = ? WHERE id_Pelicula = ?";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, titulo);
            preparedStatement.setInt(2, duracion);
            preparedStatement.setString(3, genero);
            preparedStatement.setString(4, clasificacionEdad);
            preparedStatement.setString(5, descripcion);
            preparedStatement.setInt(6, id);

            row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }

    /**
     * Método para añadir una nueva película a la base de datos
     * 
     * @param titulo Título de la nueva película
     * @param duracion Duración de la película en minutos
     * @param genero Género de la película
     * @param clasificacionEdad Clasificación por edad
     * @param descripcion Descripción de la película
     * @return Número de filas insertadas en la base de datos
     */
    public static int añadirPelicula(String titulo, int duracion, String genero, String clasificacionEdad, String descripcion) {
        int row = 0;
        String sql = "INSERT INTO Pelicula (titulo, duracion, genero, clasificacionEdad, descripcion) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, titulo);
            preparedStatement.setInt(2, duracion);
            preparedStatement.setString(3, genero);
            preparedStatement.setString(4, clasificacionEdad);
            preparedStatement.setString(5, descripcion);

            row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }

    /**
     * Método para borrar una película existente de la base de datos
     * 
     * @param idPelicula ID de la película que se desea eliminar
     * @return Número de filas eliminadas de la base de datos
     */
    public static int borrarPelicula(int idPelicula) {
        
        int row = 0;
        String sql = "DELETE FROM Pelicula WHERE id_pelicula = ?";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, idPelicula);
            
            row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }
}
