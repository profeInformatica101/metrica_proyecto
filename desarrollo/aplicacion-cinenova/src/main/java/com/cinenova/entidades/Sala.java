package com.cinenova.entidades;

/**
 * Clase donde se definen los atributos y métodos de las salas de cine.
 * Cada sala puede tener distintas características como si es 3D o VIP.
 * 
 * @author Juan Carlos
 */
public class Sala {

    private int numero;
    private int capacidad;
    private boolean es3D;
    private boolean esVIP;

    /**
     * Constructor de la clase Sala.
     * 
     * @param numero Número identificador de la sala
     * @param capacidad Capacidad máxima de la sala
     * @param esVIP true si la sala es VIP, false en caso contrario
     * @param es3D true si la sala es 3D, false en caso contrario
     */
    public Sala(int numero, int capacidad, boolean esVIP, boolean es3D) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.es3D = es3D;
        this.esVIP = esVIP;
    }

    /**
     * Obtiene el número de la sala.
     * 
     * @return Número de sala
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Establece el número de la sala.
     * 
     * @param numero Nuevo número de sala
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Obtiene la capacidad máxima de la sala.
     * 
     * @return Capacidad de la sala
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Establece la capacidad máxima de la sala.
     * 
     * @param capacidad Nueva capacidad
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Indica si la sala tiene tecnología 3D.
     * 
     * @return true si es 3D, false en caso contrario
     */
    public boolean isEs3D() {
        return es3D;
    }

    /**
     * Establece si la sala debe ser 3D o no.
     * 
     * @param es3D true si es 3D, false si no
     */
    public void setEs3D(boolean es3D) {
        this.es3D = es3D;
    }

    /**
     * Indica si la sala es VIP.
     * 
     * @return true si es VIP, false en caso contrario
     */
    public boolean isEsVIP() {
        return esVIP;
    }

    /**
     * Establece si la sala debe ser VIP o no.
     * 
     * @param esVIP true si es VIP, false si no
     */
    public void setEsVIP(boolean esVIP) {
        this.esVIP = esVIP;
    }

    /**
     * Devuelve una representación textual del objeto Sala.
     * 
     * @return Cadena de texto con los atributos principales de la sala
     */
    @Override
    public String toString() {
        return "Sala{" + "nombre=" + numero + ", capacidad=" + capacidad + ", es3D=" + es3D + ", esVIP=" + esVIP + '}';
    }
    
    
    
}
