package com.cinenova.entidades;

import com.cinenova.consultas.devolverEntrada;
import com.cinenova.consultas.obtenerEntradas;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Carlos
 */
public class Cliente extends Persona{
    private int puntosGanados;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public Cliente(int puntosGanados, String nombre, String apellidos, String correo, String contrasena, boolean esEmpleado, boolean esJefe) {
        super(nombre, apellidos, correo, contrasena, esEmpleado, esJefe);
        this.puntosGanados = puntosGanados;
    }

    public int getPuntosGanados() {
        return puntosGanados;
    }

    public void setPuntosGanados(int puntosGanados) {
        this.puntosGanados = puntosGanados;
    }

    public void comprarEntrada(Entrada entrada){
        
    }
    
    public boolean devolverEntrada(Entrada entrada){
        boolean exito = false;
        int row = devolverEntrada.eliminarEntrada(entrada);
        if(row != 0){
            exito = true;
        }
        return exito;
    }
    
    public boolean descargarEntrada(Entrada entrada){
        boolean descargada = false;
        try{
            FileWriter entradaTXT = new FileWriter("entrada_descargada" + ".txt");
            entradaTXT.write(entrada.toString());
            entradaTXT.close();
            descargada = true;
        }catch(IOException e){
            System.out.println("Error al escribir la entrada: " + e.getMessage());
        }
        
        return descargada;
    }
    
    public List<Entrada> verEntradas(){
        List<Entrada> entradasCliente = new ArrayList<>();
        List<Entrada> entradas = obtenerEntradas.obtenerConsulta();
        for(int i = 0; i < entradas.size(); i++){
            if(Cliente.this.getCorreo().equals(entradas.get(i).getCliente().getCorreo())){
                entradasCliente.add(entradas.get(i));
            }
        }
        return entradasCliente;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Cliente{" + "puntosGanados=" + puntosGanados + '}';
    }

   

    
    
}
