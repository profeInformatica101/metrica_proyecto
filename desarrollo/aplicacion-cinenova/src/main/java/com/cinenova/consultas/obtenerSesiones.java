package com.cinenova.consultas;

import com.cinenova.entidades.Película;
import com.cinenova.entidades.Sala;
import com.cinenova.entidades.Sesión;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuarioDAW
 */
public class obtenerSesiones {
    
    public static List<Sesión> obtenerConsulta(){
        List<Sesión> sesiones = new ArrayList<>();
        String sql = "SELECT * FROM Sesion";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             Statement statement = conn.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);
            List<Película> peliculas = obtenerPeliculas.obtenerConsulta();
            List<Sala> salas = obtenerSalas.obtenerConsulta();
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
    
}
