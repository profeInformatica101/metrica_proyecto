package com.cinenova.entidades;

/**
 *
 * @author Juan Carlos
 */
public class Cliente extends Persona{
    private String codigoCliente;

    public Cliente(String codigoCliente, String nombre, String apellidos, String correo) {
        super(nombre, apellidos, correo);
        this.codigoCliente = codigoCliente;
    }

    @Override
    public String toString() {
        return super.toString() + "Cliente{" + "codigoCliente=" + codigoCliente + '}';
    }
    
    
}
