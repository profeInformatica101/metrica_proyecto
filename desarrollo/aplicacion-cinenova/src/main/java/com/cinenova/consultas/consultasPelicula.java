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
 *
 * @author Juan Carlos
 */
public class consultasPelicula {
    
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
