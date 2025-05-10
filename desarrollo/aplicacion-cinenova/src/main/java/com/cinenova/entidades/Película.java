package com.cinenova.entidades;

import java.util.Date;

/**
 *
 * @author Juan Carlos
 */
public class Película {
    private String nombre;
    private int anioLanzamiento;
    private Date fechaPublicacionCartelera;
    private String director;
    private int duracion;

    public Película(String nombre, int anioLanzamiento, Date fechaPublicacionCartelera, String director, int duracion) {
        this.nombre = nombre;
        this.anioLanzamiento = anioLanzamiento;
        this.fechaPublicacionCartelera = fechaPublicacionCartelera;
        this.director = director;
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Pel\u00edcula{" + "nombre=" + nombre + ", anioLanzamiento=" + anioLanzamiento + ", fechaPublicacionCartelera=" + fechaPublicacionCartelera + ", director=" + director + ", duracion=" + duracion + '}';
    }
    
    
}
