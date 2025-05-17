package com.cinenova.entidades;

/**
 * Clase donde se definen los atributos y métodos de los jefes. Hereda de Empleado e implícitamente de Persona.
 * 
 * @author Juan Carlos
 */
public class Jefe extends Empleado{

    public Jefe(String DNI, double sueldo, String nombre, String apellidos, String correo, String contrasena, boolean esEmpleado, boolean esJefe) {
        super(DNI, sueldo, nombre, apellidos, correo, contrasena, esEmpleado, esJefe);
    }

    @Override
    public String toString() {
        return "Jefe{" + super.toString() + '}';
    }
    
    
}
