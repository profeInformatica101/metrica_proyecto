package com.cinenova.entidades;

/**
 *
 * @author Juan Carlos
 */
public class Empleado extends Persona {
    private String DNI;
    private double sueldo;

    public Empleado(String DNI, double sueldo, String nombre, String apellidos, String correo) {
        super(nombre, apellidos, correo);
        this.DNI = DNI;
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return super.toString() + "Empleado{" + "DNI=" + DNI + ", sueldo=" + sueldo + '}';
    }

    

    
    
    
}
