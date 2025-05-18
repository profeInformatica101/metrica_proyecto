package com.cinenova.autenticación;

import com.cinenova.consultas.consultasPersona;
import com.cinenova.entidades.Jefe;
import java.util.List;

/**
 * Clase para confirmar si un jefe existe en la base de datos
 * 
 * @author Juan Carlos Pizarro Alonso, Álvaro Muñoz Fernández
 */
public class autenticaciónJefe {
    
    /**
     * Método que devuelve true en caso de estar registrado el jefe introducido y false en caso contrario
     * 
     * @param correo
     * @param contrasena
     * @return True en caso de que el jefe este registrado y false en caso contrario
     */
    public static boolean esJefe(String correo, String contrasena){
        boolean autenticado = false;
        List<Jefe> jefes = consultasPersona.obtenerJefes();
        for(int i=0; i < jefes.size(); i++){
            if((jefes.get(i).getCorreo().equals(correo)) && (jefes.get(i).getContrasena().equals(contrasena))){
                autenticado = true;
            }
        }
        return autenticado;
    }
}