package com.cinenova.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase donde se definen los atributos y métodos de las sesiones.
 * 
 * @author Juan Carlos
 */
public class Sesión {
    private Date fechaHora;
    private Película pelicula;
    private Sala sala;
    private double precio;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    /**
     * Constructor de la clase Sesión
     * 
     * @param pelicula
     * @param sala
     * @param fechaHora
     * @param precio 
     */
    public Sesión(Película pelicula, Sala sala, Date fechaHora, double precio) {
        this.fechaHora = fechaHora;
        this.pelicula = pelicula;
        this.sala = sala;
        this.precio = precio;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Película getPelicula() {
        return pelicula;
    }

    public void setPelicula(Película pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
    @Override
    public String toString() {
        return pelicula.getTitulo() + "," + sala.getNumero() + "," + formato.format(fechaHora) + "," + precio;
    }

    

    
    
    
}
