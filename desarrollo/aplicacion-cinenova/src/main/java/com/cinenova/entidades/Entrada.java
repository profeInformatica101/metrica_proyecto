package com.cinenova.entidades;

import java.text.SimpleDateFormat;

/**
 * Clase donde se definen los atributos y métodos de las entradas.
 * 
 * @author Juan Carlos
 */
public class Entrada {
    private int asiento;
    private Cliente cliente;
    private Sesión sesion;
    private double precioFinal;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    /**
     * Contructor de la clase Entrada
     * 
     * @param asiento
     * @param cliente
     * @param sesion
     * @param precioFinal 
     */
    public Entrada(int asiento, Cliente cliente, Sesión sesion, double precioFinal) {
        this.asiento = asiento;
        this.cliente = cliente;
        this.sesion = sesion;
        this.precioFinal = precioFinal;
    }

    /**
     * Método que devuelve el asiento asignado a la entrada
     * 
     * @return Asiento de la entrada
     */
    public int getAsiento() {
        return asiento;
    }

    /**
     * Método que asigna el asiento pasado como parámetro a la entrada
     * 
     * @param asiento 
     */
    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    /**
     * Método que devuelve el cliente asignado a la entrada
     * 
     * @return Cliente asignado a la entrada
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Método que asigna el cliente pasado como parámetro a la entrada
     * 
     * @param cliente 
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Método que devuelve la sesión asignada a la entrada
     * 
     * @return Sesión asignada a la entrada
     */
    public Sesión getSesion() {
        return sesion;
    }

    /**
     * Método que asigna la sesión pasada como parámetro a la entrada
     * 
     * @param sesion 
     */
    public void setSesion(Sesión sesion) {
        this.sesion = sesion;
    }

    /**
     * Método que devuelve el precio final asignado a la entrada
     * 
     * @return Precio final asignado a la entrada
     */
    public double getPrecioFinal() {
        return precioFinal;
    }

    /**
     * Método que asigna el precio final a la entrada en función del número de puntos ganados del cliente
     * 
     */
    public void setPrecioFinal() {
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
    
    /**
     * Método que devuelve un string con el formato de entrada correspondiente para su posterior descarga
     * 
     * @return String en formato de entrada
     */
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
    
    /**
     * Método toString de la clase Entrada
     * 
     * @return Entrada en formato toString
     */
    @Override
    public String toString() {
        return sesion.getPelicula().getTitulo() + " | Sala: " + sesion.getSala().getNumero() + " Asiento: " + asiento + " | Fecha/Hora: " + formato.format(sesion.getFechaHora()) + " | Precio: " + precioFinal;
    }

    
    
    
    
}
