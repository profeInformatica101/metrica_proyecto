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
     * @param idPelicula Identificador único de la película
     * @param titulo Título de la película
     * @param duracion Duración de la película en minutos
     * @param genero Género de la película
     * @param clasificacionEdad Clasificación por edad de la película
     * @param descripcion Breve sinopsis o descripción de la película
     */
    public Película(int idPelicula, String titulo, int duracion, String genero, String clasificacionEdad, String descripcion) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.clasificacionEdad = clasificacionEdad;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el ID de la película
     * 
     * @return ID de la película
     */
    public int getIdPelicula() {
        return idPelicula;
    }

    /**
     * Establece el ID de la película
     * 
     * @param idPelicula Nuevo ID de la película
     */
    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    /**
     * Obtiene el título de la película
     * 
     * @return Título de la película
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la película
     * 
     * @param titulo Nuevo título de la película
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene la duración de la película
     * 
     * @return Duración de la película en minutos
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Establece la duración de la película
     * 
     * @param duracion Nueva duración de la película en minutos
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * Obtiene el género de la película
     * 
     * @return Género de la película
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género de la película
     * 
     * @param genero Nuevo género de la película
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la clasificación por edad de la película
     * 
     * @return Clasificación por edad de la película
     */
    public String getClasificacionEdad() {
        return clasificacionEdad;
    }

    /**
     * Establece la clasificación por edad de la película
     * 
     * @param clasificacionEdad Nueva clasificación por edad
     */
    public void setClasificacionEdad(String clasificacionEdad) {
        this.clasificacionEdad = clasificacionEdad;
    }

    /**
     * Obtiene la descripción de la película
     * 
     * @return Descripción de la película
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la película
     * 
     * @param descripcion Nueva descripción de la película
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Representación textual del objeto Película
     * 
     * @return Cadena con los datos principales de la película
     */
    @Override
    public String toString() {
        return "Película{" + "titulo=" + titulo + ", duracion=" + duracion + ", genero=" + genero + ", clasificacionEdad=" + clasificacionEdad + ", descripcion=" + descripcion + '}';
    }
    
    
    
    
    
    
}
