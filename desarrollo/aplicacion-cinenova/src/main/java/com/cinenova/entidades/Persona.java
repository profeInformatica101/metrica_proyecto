package com.cinenova.entidades;

/**
 *
 * @author Juan Carlos
 */
public abstract class Persona {
    private String nombre;
    private String apellidos;
    private String correo;

    public Persona(String nombre, String apellidos, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + '}';
    }

    

    
}
