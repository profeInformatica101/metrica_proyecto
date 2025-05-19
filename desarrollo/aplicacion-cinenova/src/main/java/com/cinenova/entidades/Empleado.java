package com.cinenova.entidades;

/**
 * Clase donde se definen los atributos y métodos de los empleados. Hereda de Persona.
 * 
 * @author Juan Carlos
 */
public class Empleado extends Persona {
    private String DNI;
    private double sueldo;

    /**
     * Constructor de la clase Empleado
     * 
     * @param DNI DNI del empleado
     * @param sueldo Sueldo del empleado
     * @param nombre Nombre del empleado
     * @param apellidos Apellidos del empleado
     * @param correo Correo electrónico del empleado
     * @param contrasena Contraseña del empleado
     * @param esEmpleado Indica si es empleado
     * @param esJefe Indica si es jefe
     */
    public Empleado(String DNI, double sueldo, String nombre, String apellidos, String correo, String contrasena, boolean esEmpleado, boolean esJefe) {
        super(nombre, apellidos, correo, contrasena, esEmpleado, esJefe);
        this.DNI = DNI;
        this.sueldo = sueldo;
    }

    /**
     * Método que devuelve el DNI del empleado
     * 
     * @return DNI del empleado
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Método para establecer el DNI del empleado
     * 
     * @param DNI Nuevo DNI del empleado
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * Método que devuelve el sueldo del empleado
     * 
     * @return Sueldo del empleado
     */
    public double getSueldo() {
        return sueldo;
    }

    /**
     * Método para establecer el sueldo del empleado
     * 
     * @param sueldo Nuevo sueldo del empleado
     */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * Representación en forma de cadena del objeto Empleado
     * 
     * @return Cadena con los datos del empleado
     */
    @Override
    public String toString() {
        return super.toString() + "Empleado{" + "DNI=" + DNI + ", sueldo=" + sueldo + '}';
    }
    
    
    
    
    
    
}
