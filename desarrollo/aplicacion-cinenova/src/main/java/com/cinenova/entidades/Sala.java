package com.cinenova.entidades;

/**
 *
 * @author Juan Carlos
 */
public class Sala {
    private int numero;
    private int capacidad;
    private boolean es3D;
    private boolean esVIP;

    public Sala(int numero, int capacidad, boolean esVIP, boolean es3D) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.es3D = es3D;
        this.esVIP = esVIP;
    }
    

    @Override
    public String toString() {
        return "Sala{" + "nombre=" + numero + ", capacidad=" + capacidad + ", es3D=" + es3D + ", esVIP=" + esVIP + '}';
    }
    
    
    
}
