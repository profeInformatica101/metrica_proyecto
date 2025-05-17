package com.cinenova.entidades;

import com.cinenova.consultas.consultasPersona;
import com.cinenova.consultas.consultasSesion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Clase donde se definen los atributos y métodos de las personas.
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
     * @param nombre
     * @param apellidos
     * @param correo
     * @param contrasena
     * @param esEmpleado
     * @param esJefe 
     */
    public Persona(String nombre, String apellidos, String correo, String contrasena, boolean esEmpleado, boolean esJefe) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasena = contrasena;
        this.esEmpleado = esEmpleado;
        this.esJefe = esJefe;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isEsEmpleado() {
        return esEmpleado;
    }

    public void setEsEmpleado(boolean esEmpleado) {
        this.esEmpleado = esEmpleado;
    }

    public boolean isEsJefe() {
        return esJefe;
    }

    public void setEsJefe(boolean esJefe) {
        this.esJefe = esJefe;
    }
    
    public static Cliente iniciarSesión(String correo){
        consultasPersona.obtenerClientes();
        List<Cliente> clientes = consultasPersona.obtenerClientes();
        Cliente cliente = new Cliente(0, "Prueba", "Prueba", "Prueba", "prueba", false, false);
        for(int i = 0; i < clientes.size(); i++){
            if(clientes.get(i).getCorreo().equals(correo)){
                cliente = clientes.get(i);
            }
        }
        return cliente;
    }

    public List<Sesión> verSesionesFuturo(){
        List<Sesión> sesiones = consultasSesion.obtenerConsulta();
        List<Sesión> sesionesFuturo = new ArrayList<>();
        Date hoy = new Date();
        for(int i = 0; i < sesiones.size(); i++){
            if(sesiones.get(i).getFechaHora().after(hoy)){
                sesionesFuturo.add(sesiones.get(i));
            }
        }
        Comparator ordenaciónPorFecha = new ordenarSesionesPorFecha();
        Collections.sort(sesionesFuturo, ordenaciónPorFecha);
        return sesionesFuturo;
    }
    
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + ", contrasena=" + contrasena + ", esEmpleado=" + esEmpleado + ", esJefe=" + esJefe + '}';
    }

    

    

    

     

    
}
