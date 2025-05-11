package com.cinenova.entidades;

/**
 *
 * @author Juan Carlos
 */
public class Cliente extends Persona{
    private int puntosGanados;

    public Cliente(int puntosGanados, String nombre, String apellidos, String correo, String contrasena, boolean esEmpleado, boolean esJefe) {
        super(nombre, apellidos, correo, contrasena, esEmpleado, esJefe);
        this.puntosGanados = puntosGanados;
    }

    public int getPuntosGanados() {
        return puntosGanados;
    }

    public void setPuntosGanados(int puntosGanados) {
        this.puntosGanados = puntosGanados;
    }

    
    
    @Override
    public String toString() {
        return super.toString() + "Cliente{" + "puntosGanados=" + puntosGanados + '}';
    }

   

    
    
}
