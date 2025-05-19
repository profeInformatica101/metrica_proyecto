package com.cinenova.consultas;

import com.cinenova.entidades.Película;
import com.cinenova.entidades.Sala;
import com.cinenova.entidades.Sesión;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase que recoge todas las consultas relacionadas con la tabla Sesión en la base de datos
 * 
 * @author Juan Carlos Pizarro Alonso, Álvaro Muñoz Fernández
 */
public class consultasSesion {
    
    /**
     * Método para obtener todas las sesiones disponibles
     * 
     * @return Listado de sesiones total
     */
    public static List<Sesión> obtenerConsulta(){
        List<Sesión> sesiones = new ArrayList<>();
        String sql = "SELECT * FROM Sesion";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             Statement statement = conn.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);
            List<Película> peliculas = consultasPelicula.obtenerConsulta();
            List<Sala> salas = consultasSala.obtenerConsulta();
            Película pelicula = null;
            Sala sala = null;
            while (resultSet.next()) {
                for(int i = 0; i < peliculas.size(); i++){
                    if(peliculas.get(i).getIdPelicula() == resultSet.getInt("id_pelicula")){
                        pelicula = peliculas.get(i);
                    }
                }
                for(int i = 0; i < salas.size(); i++){
                    if(salas.get(i).getNumero() == resultSet.getInt("numeroSala")){
                        sala = salas.get(i);
                    }
                }
                Sesión sesion = new Sesión(pelicula, sala, resultSet.getDate("fechaHora"), resultSet.getDouble("precio"));
                
                sesiones.add(sesion);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return sesiones;
    }
    
    /**
     * Método que devuelve el listado de títulos de películas que se encuentran en las sesiones disponibles
     * 
     * @return Listado de títulos de películas de las sesiones disponibles
     */
    public static List<String> obtenerPeliculasSesiones(){
        List<String> peliculasTitulos = new ArrayList<>();
        String sql = "SELECT p.titulo FROM Sesion s, Pelicula p WHERE p.id_pelicula = s.id_pelicula";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             Statement statement = conn.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {                
                peliculasTitulos.add(resultSet.getString("titulo"));
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return peliculasTitulos;
    }
    
    /**
     * Método que devuelve una lista de sesiones que tienen como título de película el pasado como parámetro
     * 
     * @param titulo Titulo
     * @return Listado de sesiones con el mismo título de película
     */
    public static List<Sesión> obtenerSesionesPorPelículas(String titulo){
        List<Sesión> sesionesPeliculas = new ArrayList<>();
        String sql = "SELECT s.*, p.titulo FROM Sesion s, Pelicula p WHERE p.id_pelicula = s.id_pelicula AND p.titulo = ?";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

         

            preparedStatement.setString(1, titulo);
            List<Película> peliculas = consultasPelicula.obtenerConsulta();
            List<Sala> salas = consultasSala.obtenerConsulta();
            Película pelicula = null;
            Sala sala = null;
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                for(int i = 0; i < peliculas.size(); i++){
                    if(peliculas.get(i).getTitulo().equals(resultSet.getString("titulo"))){
                        pelicula = peliculas.get(i);
                    }
                }
                for(int i = 0; i < salas.size(); i++){
                    if(salas.get(i).getNumero() == resultSet.getInt("numeroSala")){
                        sala = salas.get(i);
                    }
                }
                Sesión sesion = new Sesión(pelicula, sala, resultSet.getDate("fechaHora"), resultSet.getDouble("precio"));
                
                sesionesPeliculas.add(sesion);
                }
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return sesionesPeliculas;
    }
    
        /**
     * Método que elimina una sesión concreta de la base de datos a partir de su película, sala y fecha/hora
     * 
     * @param idPelicula ID de la película asociada a la sesión
     * @param numeroSala Número de sala donde se proyecta la sesión
     * @param fechaHora Fecha y hora exacta de la sesión
     * @return Número de filas afectadas por la operación de borrado
     */
    public static int borrarSesion(int idPelicula, int numeroSala, Timestamp fechaHora) {
        int row = 0;

        String deleteEntradasSQL = "DELETE FROM Entrada WHERE id_pelicula = ? AND numeroSala = ? AND fechaHora = ?";
        String deleteSesionSQL = "DELETE FROM Sesion WHERE id_pelicula = ? AND numeroSala = ? AND fechaHora = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova")) {
            conn.setAutoCommit(false);

            try (PreparedStatement psEntradas = conn.prepareStatement(deleteEntradasSQL);
                 PreparedStatement psSesion = conn.prepareStatement(deleteSesionSQL)) {

                psEntradas.setInt(1, idPelicula);
                psEntradas.setInt(2, numeroSala);
                psEntradas.setTimestamp(3, fechaHora);
                psEntradas.executeUpdate();

                psSesion.setInt(1, idPelicula);
                psSesion.setInt(2, numeroSala);
                psSesion.setTimestamp(3, fechaHora);
                row = psSesion.executeUpdate();

                conn.commit();

            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        return row;
    }


    /**
     * Método que añade una nueva sesión a la base de datos con los datos proporcionados
     * 
     * @param idPelicula ID de la película que se proyectará en la sesión
     * @param numeroSala Número de la sala donde tendrá lugar la sesión
     * @param fechaHora Fecha y hora exacta de la sesión
     * @param precio Precio de entrada para la sesión
     * @return Número de filas afectadas por la operación de inserción
     */
    public static int añadirSesion(int idPelicula, int numeroSala, Timestamp fechaHora, double precio) {
        int row = 0;
        String sql = "INSERT INTO Sesion (id_pelicula, numeroSala, fechaHora, precio) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, idPelicula);
            preparedStatement.setInt(2, numeroSala);
            preparedStatement.setTimestamp(3, fechaHora);
            preparedStatement.setDouble(4, precio);

            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        return row;
    }


}
