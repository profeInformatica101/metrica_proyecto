package com.cinenova.entidades;

import java.util.Date;

/**
 *
 * @author Juan Carlos
 */
public class Sesión {
    private Date fechaHora;
    private Película pelicula;
    private Sala sala;
    private double precio;

    public Sesión(Película pelicula, Sala sala, Date fechaHora, double precio) {
        this.fechaHora = fechaHora;
        this.pelicula = pelicula;
        this.sala = sala;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Sesi\u00f3n{" + "fechaHora=" + fechaHora + ", pelicula=" + pelicula + ", sala=" + sala + ", precio=" + precio + '}';
    }

    

    
    
    
}
