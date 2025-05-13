package com.cinenova.entidades;

import java.text.SimpleDateFormat;

/**
 *
 * @author Juan Carlos
 */
public class Entrada {
    private int asiento;
    private Cliente cliente;
    private Sesión sesion;
    private double precioFinal;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public Entrada(int asiento, Cliente cliente, Sesión sesion, double precioFinal) {
        this.asiento = asiento;
        this.cliente = cliente;
        this.sesion = sesion;
        this.precioFinal = precioFinal;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Sesión getSesion() {
        return sesion;
    }

    public void setSesion(Sesión sesion) {
        this.sesion = sesion;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }
    
    @Override
    public String toString() {
        return sesion.getPelicula().getTitulo() + " | Sala: " + sesion.getSala().getNumero() + " Asiento: " + asiento + " | Fecha/Hora: " + formato.format(sesion.getFechaHora()) + " | Precio: " + precioFinal;
    }

    
    
    
    
}
