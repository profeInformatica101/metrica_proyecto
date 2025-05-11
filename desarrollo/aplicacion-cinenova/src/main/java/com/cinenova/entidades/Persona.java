package com.cinenova.entidades;

/**
 *
 * @author Juan Carlos
 */
public abstract class Persona {
    private String nombre;
    private String apellidos;
    private String correo;
    private String contrasena;

    public Persona(String nombre, String apellidos, String correo, String contrasena) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + '}';
    }

     

    
}
