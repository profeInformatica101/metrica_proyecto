package com.cinenova.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase donde se definen los atributos y métodos de las sesiones de cine.
 * Una sesión representa la proyección de una película en una sala en una fecha y hora específica,
 * con un precio asociado.
 * 
 * @author Juan Carlos Pizarro Alonso
 */
public class Sesión {
    
    private Date fechaHora;
    private Película pelicula;
    private Sala sala;
    private double precio;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    /**
     * Constructor de la clase Sesión.
     * 
     * @param pelicula Película que se proyecta
     * @param sala Sala donde se proyecta la película
     * @param fechaHora Fecha y hora de la sesión
     * @param precio Precio de la entrada para esta sesión
     */
    public Sesión(Película pelicula, Sala sala, Date fechaHora, double precio) {
        this.fechaHora = fechaHora;
        this.pelicula = pelicula;
        this.sala = sala;
        this.precio = precio;
    }

    /**
     * Obtiene la fecha y hora de la sesión.
     * 
     * @return Fecha y hora de la sesión
     */
    public Date getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora de la sesión.
     * 
     * @param fechaHora Nueva fecha y hora de la sesión
     */
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene la película que se proyecta en la sesión.
     * 
     * @return Película de la sesión
     */
    public Película getPelicula() {
        return pelicula;
    }

    /**
     * Establece la película que se proyecta en la sesión.
     * 
     * @param pelicula Nueva película para la sesión
     */
    public void setPelicula(Película pelicula) {
        this.pelicula = pelicula;
    }

    /**
     * Obtiene la sala donde se proyecta la película.
     * 
     * @return Sala de la sesión
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * Establece la sala donde se proyecta la película.
     * 
     * @param sala Nueva sala para la sesión
     */
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    /**
     * Obtiene el precio de la entrada para esta sesión.
     * 
     * @return Precio de la sesión
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio de la entrada para esta sesión.
     * 
     * @param precio Nuevo precio de la sesión
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Devuelve una representación textual de la sesión con título de la película,
     * número de sala, fecha y hora formateadas, y precio.
     * 
     * @return Cadena representativa de la sesión
     */
    @Override
    public String toString() {
        return pelicula.getTitulo() + "," + sala.getNumero() + "," + formato.format(fechaHora) + "," + precio;
    }
    
    
    
    
    
    
}
