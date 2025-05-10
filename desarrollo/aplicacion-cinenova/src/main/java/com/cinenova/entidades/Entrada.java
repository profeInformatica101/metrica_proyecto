package com.cinenova.entidades;

/**
 *
 * @author Juan Carlos
 */
public class Entrada {
    private String asiento;
    private Cliente cliente;
    private Sesión sesion;

    public Entrada(String asiento, Cliente cliente, Sesión sesion) {
        this.asiento = asiento;
        this.cliente = cliente;
        this.sesion = sesion;
    }

    @Override
    public String toString() {
        return "Entrada{" + "asiento=" + asiento + ", cliente=" + cliente + ", sesion=" + sesion + '}';
    }
    
    
    
}
