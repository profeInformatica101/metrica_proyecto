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

    public void setPrecioFinal(double precio) {
        int puntos = cliente.getPuntosGanados();
        if(puntos >= 100 && puntos < 200){
            this.precioFinal = sesion.getPrecio() * 0.9;
            cliente.setPuntosGanados(puntos - 100);
        }else if(puntos >= 200 && puntos < 300){
            this.precioFinal = sesion.getPrecio() * 0.8;
            cliente.setPuntosGanados(puntos - 200);
        }else if(puntos >= 300 && puntos < 400){
            this.precioFinal = sesion.getPrecio() * 0.7;
            cliente.setPuntosGanados(puntos - 300);
        }else if(puntos >= 400 && puntos < 500){
            this.precioFinal = sesion.getPrecio() * 0.6;
            cliente.setPuntosGanados(puntos - 400);
        }else if(puntos >= 500){
            this.precioFinal = sesion.getPrecio() * 0.5;
            cliente.setPuntosGanados(puntos - 500);
        }
    }
    
    public String mostrarEntradaFormato() {
        StringBuilder entrada = new StringBuilder();
        entrada.append("╔════════════════════════════╗\n");
        entrada.append("║         CINENOVA 🎬        ║\n");
        entrada.append("╠════════════════════════════╣\n");
        entrada.append("║ Película:  ").append(sesion.getPelicula().getTitulo()).append("\n");
        entrada.append("║ Sala:      ").append(sesion.getSala().getNumero()).append("\n");
        entrada.append("║ Asiento:   ").append(asiento).append("\n");
        entrada.append("║ Fecha/Hora:").append(" ").append(formato.format(sesion.getFechaHora())).append("\n");
        entrada.append("║ Precio:    ").append(precioFinal).append(" €").append("\n");
        entrada.append("╚════════════════════════════╝\n");
        return entrada.toString();
    }
    @Override
    public String toString() {
        return sesion.getPelicula().getTitulo() + " | Sala: " + sesion.getSala().getNumero() + " Asiento: " + asiento + " | Fecha/Hora: " + formato.format(sesion.getFechaHora()) + " | Precio: " + precioFinal;
    }

    
    
    
    
}
