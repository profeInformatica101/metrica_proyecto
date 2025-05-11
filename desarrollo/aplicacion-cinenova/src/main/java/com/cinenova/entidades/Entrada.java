package com.cinenova.entidades;

/**
 *
 * @author Juan Carlos
 */
public class Entrada {
    private int asiento;
    private Cliente cliente;
    private Sesión sesion;
    private double precioFinal;

    public Entrada(int asiento, Cliente cliente, Sesión sesion, double precioFinal) {
        this.asiento = asiento;
        this.cliente = cliente;
        this.sesion = sesion;
        this.precioFinal = precioFinal;
    }

    @Override
    public String toString() {
        return "Entrada{" + "asiento=" + asiento + ", cliente=" + cliente + ", sesion=" + sesion + ", precioFinal=" + precioFinal + '}';
    }

    
    
    
    
}
