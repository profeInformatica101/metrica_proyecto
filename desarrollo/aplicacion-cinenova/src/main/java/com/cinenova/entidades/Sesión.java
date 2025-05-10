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

    public Sesión(Date fechaHora, Película pelicula, Sala sala) {
        this.fechaHora = fechaHora;
        this.pelicula = pelicula;
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Sesi\u00f3n{" + "fechaHora=" + fechaHora + ", pelicula=" + pelicula + ", sala=" + sala + '}';
    }
    
    
}
