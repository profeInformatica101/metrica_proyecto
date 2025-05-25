package com.cinenova.entidades;

import com.cinenova.consultas.consultasPersona;

/**
 * Clase donde se definen los atributos y métodos de los empleados. Hereda de Persona.
 * 
 * @author Álvaro Muñoz Fernández
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
     * Método para añadir un nuevo empleado
     * 
     * @param empleado Empleado a añadir
     * @return True en caso de éxito al añadir el empleado y false en caso contrario
     */
    public boolean añadirEmpleado(Empleado empleado){
        boolean añadido = false;
        if(consultasPersona.añadirEmpleado(empleado) == 1){
            añadido = true;
        }
        return añadido;
    }
    
    /**
     * Método para actualizar la información de un empleado
     * 
     * @param empleado Empleado del cual actualizar la información
     * @return True en caso de éxito al actualizar la información y false en caso contrario
     */
    public boolean actualizarEmpleado(Empleado empleado) {
        boolean actualizado = false;
        if (consultasPersona.actualizarEmpleado(empleado.getCorreo(), empleado.getContrasena(), empleado.getSueldo()) == 1) {
            actualizado = true;
        }
        return actualizado;
    }

    /**
     * Método para eliminar un empleado de la base de datos
     * 
     * @param empleado Empleado a eliminar
     * @return True en caso de éxito en la eliminación del empleado y false en caso contrario
     */
    public boolean borrarEmpleado(Empleado empleado) {
        boolean borrado = false;
        if (consultasPersona.borrarEmpleado(empleado.getCorreo()) == 1) {
            borrado = true;
        }
        return borrado;
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
