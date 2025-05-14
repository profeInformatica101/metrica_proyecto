package com.cinenova.consultas;

import com.cinenova.entidades.Entrada;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 *
 * @author usuarioDAW
 */
public class añadirEntrada {
    
    public static int añadirEntrada(Entrada entrada){
        int row = 0;
        String sql = "INSERT INTO Entrada (id_pelicula, numeroSala, fechaHora, correoPersona, asiento, precioFinal) VALUES (?, ?, ?, ?, ?, ?)";        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xe", "CineNova", "CineNova");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            
                preparedStatement.setInt(1, entrada.getSesion().getPelicula().getIdPelicula());
                preparedStatement.setInt(2, entrada.getSesion().getSala().getNumero());
                preparedStatement.setString(3, formato.format(entrada.getSesion().getFechaHora()));
                preparedStatement.setString(4, entrada.getCliente().getCorreo());
                preparedStatement.setInt(5, entrada.getAsiento());
                preparedStatement.setDouble(6, entrada.getPrecioFinal());
            

            row = preparedStatement.executeUpdate();


        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return row;
    }
    
}
