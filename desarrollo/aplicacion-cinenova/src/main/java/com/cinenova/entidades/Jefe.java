package com.cinenova.entidades;

/**
 * Clase donde se definen los atributos y métodos de los jefes. Hereda de Empleado e implícitamente de Persona.
 * 
 * @author Juan Carlos
 */
public class Jefe extends Empleado {

    /**
     * Constructor de la clase Jefe
     * 
     * @param DNI DNI del jefe
     * @param sueldo Sueldo del jefe
     * @param nombre Nombre del jefe
     * @param apellidos Apellidos del jefe
     * @param correo Correo electrónico del jefe
     * @param contrasena Contraseña del jefe
     * @param esEmpleado Indica si es empleado
     * @param esJefe Indica si es jefe
     */
    public Jefe(String DNI, double sueldo, String nombre, String apellidos, String correo, String contrasena, boolean esEmpleado, boolean esJefe) {
        super(DNI, sueldo, nombre, apellidos, correo, contrasena, esEmpleado, esJefe);
    }

    /**
     * Representación en forma de cadena del objeto Jefe
     * 
     * @return Cadena con los datos del jefe
     */
    @Override
    public String toString() {
        return "Jefe{" + super.toString() + '}';
    }
    
    
}
