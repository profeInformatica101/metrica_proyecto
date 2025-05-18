package com.cinenova.entidades;

import com.cinenova.consultas.consultasEntrada;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase donde se definen los atributos y métodos de los clientes. Hereda de Persona.
 * 
 * @author Juan Carlos
 */
public class Cliente extends Persona{
    private int puntosGanados;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    
    /**
     * Constructor de la clase Cliente
     * 
     * @param puntosGanados puntosGanados
     * @param nombre Nombre
     * @param apellidos Apellidos
     * @param correo Correo
     * @param contrasena Contraseña
     * @param esEmpleado esEmpleado
     * @param esJefe esJefe
     */
    public Cliente(int puntosGanados, String nombre, String apellidos, String correo, String contrasena, boolean esEmpleado, boolean esJefe) {
        super(nombre, apellidos, correo, contrasena, esEmpleado, esJefe);
        this.puntosGanados = puntosGanados;
    }
    
    /**
     * Método que devuelve los puntos ganados por el cliente
     * 
     * @return 
     */
    public int getPuntosGanados() {
        return puntosGanados;
    }
    
    /**
     * Método que establece los puntos ganados por el cliente a los pasados como parámetro
     * 
     * @param puntosGanados puntosGanados
     */
    public void setPuntosGanados(int puntosGanados) {
        this.puntosGanados = puntosGanados;
    }
    
    /**
     * Método que devuelve un boolean a true si la entrada pasada como parámetro se compró con éxito y a false en caso contrario
     * 
     * @param entrada Entrada
     * @return True en caso de éxito de compra y false en caso contrario
     */
    public boolean comprarEntrada(Entrada entrada){
        boolean comprada = false;
        if(consultasEntrada.añadirEntrada(entrada) == 1){
            comprada = true;
        }
        return comprada;
    }
    
    /**
     * Método que devuelve un boolean a true si la entrada pasada como parámetro se eliminó con éxito y a false en caso contrario
     * 
     * @param entrada Entrada
     * @return True en caso de éxito de devolución y false en caso contrario
     */
    public boolean devolverEntrada(Entrada entrada){
        boolean exito = false;
        int row = consultasEntrada.eliminarEntrada(entrada);
        if(row != 0){
            exito = true;
        }
        return exito;
    }
    
     /**
     * Método que devuelve un boolean a true si la entrada pasada como parámetro se descargó con éxito y a false en caso contrario
     * 
     * @param entrada Entrada
     * @param archivoDestino archivoDestino
     * @return True en caso de éxito de descarga y false en caso contrario
     */
    public boolean descargarEntrada(Entrada entrada, File archivoDestino){
        boolean descargada = false;
        try{
            FileWriter entradaTXT = new FileWriter(archivoDestino);
            entradaTXT.write(entrada.mostrarEntradaFormato());
            entradaTXT.close();
            descargada = true;
        }catch(IOException e){
            System.out.println("Error al escribir la entrada: " + e.getMessage());
        }
        
        return descargada;
    }
    
    /**
     * Método que devuelve las entradas que tiene el cliente compradas o ha comprado en el pasado
     * 
     * @return Listado de entradas total del cliente
     */
    public List<Entrada> verEntradas(){
        List<Entrada> entradasCliente = new ArrayList<>();
        List<Entrada> entradas = consultasEntrada.obtenerConsulta();
        for(int i = 0; i < entradas.size(); i++){
            if(Cliente.this.getCorreo().equals(entradas.get(i).getCliente().getCorreo())){
                entradasCliente.add(entradas.get(i));
            }
        }
        return entradasCliente;
    }
    
    /**
     * Método que devuelve las entradas que tiene el cliente compradas las cuáles aún no se ha celebrado su sesión
     * 
     * @return Listado de entradas que aún no se ha celebrado su sesión del cliente
     */
    public List<Entrada> verEntradasFuturo(){
        List<Entrada> entradasCliente = Cliente.this.verEntradas();
        List<Entrada> entradasClienteFuturo = new ArrayList<>();
        Date hoy = new Date();
        for(int i = 0; i < entradasCliente.size(); i++){
            if(entradasCliente.get(i).getSesion().getFechaHora().after(hoy)){
                entradasClienteFuturo.add(entradasCliente.get(i));
            }
        }
        return entradasClienteFuturo;
    }
    
    /**
     * Método toString de la clase Cliente
     * 
     * @return Cliente en formato toString
     */
    @Override
    public String toString() {
        return super.toString() + "Cliente{" + "puntosGanados=" + puntosGanados + '}';
    }
}