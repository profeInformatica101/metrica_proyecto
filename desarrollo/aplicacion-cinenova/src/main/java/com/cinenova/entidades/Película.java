package com.cinenova.entidades;

/**
 * Clase donde se definen los atributos y métodos de las películas.
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

    /**
     * Constructor de la clase Película
     * 
     * @param idPelicula
     * @param titulo
     * @param duracion
     * @param genero
     * @param clasificacionEdad
     * @param descripcion 
     */
    public Película(int idPelicula, String titulo, int duracion, String genero, String clasificacionEdad, String descripcion) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.clasificacionEdad = clasificacionEdad;
        this.descripcion = descripcion;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClasificacionEdad() {
        return clasificacionEdad;
    }

    public void setClasificacionEdad(String clasificacionEdad) {
        this.clasificacionEdad = clasificacionEdad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Override
    public String toString() {
        return "Pel\u00edcula{" + "titulo=" + titulo + ", duracion=" + duracion + ", genero=" + genero + ", clasificacionEdad=" + clasificacionEdad + ", descripcion=" + descripcion + '}';
    }

    
    
    
    
    
}
