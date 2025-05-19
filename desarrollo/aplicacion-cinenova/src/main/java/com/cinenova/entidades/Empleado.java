package com.cinenova.entidades;

/**
 * Clase donde se definen los atributos y métodos de los empleados. Hereda de Persona.
 * 
 * @author Juan Carlos
 */
public class Empleado extends Persona {
    private String DNI;
    private double sueldo;

    public Empleado(String DNI, double sueldo, String nombre, String apellidos, String correo, String contrasena, boolean esEmpleado, boolean esJefe) {
        super(nombre, apellidos, correo, contrasena, esEmpleado, esJefe);
        this.DNI = DNI;
        this.sueldo = sueldo;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    

    @Override
    public String toString() {
        return super.toString() + "Empleado{" + "DNI=" + DNI + ", sueldo=" + sueldo + '}';
    }

    

    
    
    
}
