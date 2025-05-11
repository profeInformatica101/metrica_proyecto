package com.cinenova.entidades;

/**
 *
 * @author Juan Carlos
 */
public class Cliente extends Persona{
    private String codigoCliente;

    public Cliente(String codigoCliente, String nombre, String apellidos, String correo, String contrasena) {
        super(nombre, apellidos, correo, contrasena);
        this.codigoCliente = codigoCliente;
    }

    @Override
    public String toString() {
        return super.toString() + "Cliente{" + "codigoCliente=" + codigoCliente + '}';
    }
    
    
}
