package com.cinenova.entidades;

import com.cinenova.consultas.consultasPersona;
import com.cinenova.consultas.consultasSesion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Clase abstracta donde se definen los atributos y métodos comunes a todas las personas del sistema.
 * Es la clase base para empleados, jefes y clientes.
 * 
 * @author Juan Carlos
 */
public abstract class Persona {
    private String nombre;
    private String apellidos;
    private String correo;
    private String contrasena;
    private boolean esEmpleado;
    private boolean esJefe;

    /**
     * Constructor de la clase Persona
     * 
     * @param nombre Nombre de la persona
     * @param apellidos Apellidos de la persona
     * @param correo Correo electrónico de la persona
     * @param contrasena Contraseña de acceso
     * @param esEmpleado Indica si la persona es un empleado
     * @param esJefe Indica si la persona es un jefe
     */
    public Persona(String nombre, String apellidos, String correo, String contrasena, boolean esEmpleado, boolean esJefe) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasena = contrasena;
        this.esEmpleado = esEmpleado;
        this.esJefe = esJefe;
    }

    /**
     * Obtiene el nombre de la persona
     * 
     * @return Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona
     * 
     * @param nombre Nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos de la persona
     * 
     * @return Apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos de la persona
     * 
     * @param apellidos Nuevos apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el correo electrónico de la persona
     * 
     * @return Correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico de la persona
     * 
     * @param correo Nuevo correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la contraseña de la persona
     * 
     * @return Contraseña
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña de la persona
     * 
     * @param contrasena Nueva contraseña
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Indica si la persona es un empleado
     * 
     * @return true si es empleado, false si no
     */
    public boolean isEsEmpleado() {
        return esEmpleado;
    }

    /**
     * Establece si la persona es un empleado
     * 
     * @param esEmpleado true si es empleado, false si no
     */
    public void setEsEmpleado(boolean esEmpleado) {
        this.esEmpleado = esEmpleado;
    }

    /**
     * Indica si la persona es un jefe
     * 
     * @return true si es jefe, false si no
     */
    public boolean isEsJefe() {
        return esJefe;
    }

    /**
     * Establece si la persona es un jefe
     * 
     * @param esJefe true si es jefe, false si no
     */
    public void setEsJefe(boolean esJefe) {
        this.esJefe = esJefe;
    }

    /**
     * Método estático para iniciar sesión como cliente mediante el correo.
     * 
     * @param correo Correo del cliente a buscar
     * @return Objeto Cliente si se encuentra, objeto Cliente vacío si no
     */
    public static Cliente iniciarSesión(String correo) {
        List<Cliente> clientes = consultasPersona.obtenerClientes();
        Cliente cliente = new Cliente(0, "Prueba", "Prueba", "Prueba", "prueba", false, false);
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCorreo().equals(correo)) {
                cliente = clientes.get(i);
            }
        }
        
        return cliente;
    }
    
     /**
     * Método para registrar a un nuevo cliente en la base de datos
     * 
     * @param correo
     * @param nombre
     * @param apellidos
     * @param contrasena
     * @return True en caso de éxito en el registro y false en caso contrario
     */
    public static boolean registrarCliente(String correo, String nombre, String apellidos, String contrasena){
        boolean registrado = false;
        int éxito = consultasPersona.añadirCliente(correo, nombre, apellidos, contrasena);
        if(éxito > 0){
            registrado = true;
        }
        return registrado;
    }
    

    /**
     * Devuelve una lista de sesiones futuras a partir de la fecha actual.
     * 
     * @return Lista de objetos Sesión con fecha posterior a hoy, ordenadas por fecha
     */
    public List<Sesión> verSesionesFuturo() {
        List<Sesión> sesiones = consultasSesion.obtenerConsulta();
        List<Sesión> sesionesFuturo = new ArrayList<>();
        Date hoy = new Date();
        for (int i = 0; i < sesiones.size(); i++) {
            if (sesiones.get(i).getFechaHora().after(hoy)) {
                sesionesFuturo.add(sesiones.get(i));
            }
        }
        Comparator ordenaciónPorFecha = new ordenarSesionesPorFecha();
        Collections.sort(sesionesFuturo, ordenaciónPorFecha);
        return sesionesFuturo;
    }
    

    /**
     * toString del objeto Persona
     * 
     * @return Cadena con los datos principales de la persona
     */
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + ", contrasena=" + contrasena + ", esEmpleado=" + esEmpleado + ", esJefe=" + esJefe + '}';
    }
    
    
    
    
    
    
    
    
    
    
}
