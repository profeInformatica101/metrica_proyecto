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
    private boolean esEmpleado;
    private boolean esJefe;

    public Persona(String nombre, String apellidos, String correo, String contrasena, boolean esEmpleado, boolean esJefe) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasena = contrasena;
        this.esEmpleado = esEmpleado;
        this.esJefe = esJefe;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isEsEmpleado() {
        return esEmpleado;
    }

    public void setEsEmpleado(boolean esEmpleado) {
        this.esEmpleado = esEmpleado;
    }

    public boolean isEsJefe() {
        return esJefe;
    }

    public void setEsJefe(boolean esJefe) {
        this.esJefe = esJefe;
    }

    
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + ", contrasena=" + contrasena + ", esEmpleado=" + esEmpleado + ", esJefe=" + esJefe + '}';
    }

    

    

    

     

    
}
