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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author usuarioDAW
 */
public class consultasSesion {
    
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
    
    public static List<Date> obtenerFechasSesiones(){
        List<Date> fechasSesiones = new ArrayList<>();
        String sql = "SELECT fechaHora FROM Sesion";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             Statement statement = conn.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {                
                fechasSesiones.add(resultSet.getDate("fechaHora"));
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return fechasSesiones;
    }

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
}
