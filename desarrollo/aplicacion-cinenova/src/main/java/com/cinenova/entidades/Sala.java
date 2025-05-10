package com.cinenova.entidades;

/**
 *
 * @author Juan Carlos
 */
public class Sala {
    private String nombre;
    private int capacidad;
    private boolean es3D;
    private boolean esVIP;

    public Sala(String nombre, int capacidad, boolean es3D, boolean esVIP) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.es3D = es3D;
        this.esVIP = esVIP;
    }

    @Override
    public String toString() {
        return "Sala{" + "nombre=" + nombre + ", capacidad=" + capacidad + ", es3D=" + es3D + ", esVIP=" + esVIP + '}';
    }
    
    
}
