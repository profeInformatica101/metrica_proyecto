package com.cinenova.entidades;

/**
 * Clase donde se definen los atributos y métodos de las salas.
 * 
 * @author Juan Carlos
 */
public class Sala {
    private int numero;
    private int capacidad;
    private boolean es3D;
    private boolean esVIP;

    /**
     * Constructor de la clase Sala
     * 
     * @param numero
     * @param capacidad
     * @param esVIP
     * @param es3D 
     */
    public Sala(int numero, int capacidad, boolean esVIP, boolean es3D) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.es3D = es3D;
        this.esVIP = esVIP;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEs3D() {
        return es3D;
    }

    public void setEs3D(boolean es3D) {
        this.es3D = es3D;
    }

    public boolean isEsVIP() {
        return esVIP;
    }

    public void setEsVIP(boolean esVIP) {
        this.esVIP = esVIP;
    }
    
    
    @Override
    public String toString() {
        return "Sala{" + "nombre=" + numero + ", capacidad=" + capacidad + ", es3D=" + es3D + ", esVIP=" + esVIP + '}';
    }
    
    
    
}
