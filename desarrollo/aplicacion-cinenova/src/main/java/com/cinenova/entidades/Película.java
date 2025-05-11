package com.cinenova.entidades;

/**
 *
 * @author Juan Carlos
 */
public class Película {
    private int idPelicula;
    private String titulo;
    private int duracion;
    private String genero;
    private String clasificacionEdad;
    private String descripcion;

    public Película(int idPelicula, String titulo, int duracion, String genero, String clasificacionEdad, String descripcion) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.clasificacionEdad = clasificacionEdad;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Pel\u00edcula{" + "titulo=" + titulo + ", duracion=" + duracion + ", genero=" + genero + ", clasificacionEdad=" + clasificacionEdad + ", descripcion=" + descripcion + '}';
    }

    
    
    
    
    
}
