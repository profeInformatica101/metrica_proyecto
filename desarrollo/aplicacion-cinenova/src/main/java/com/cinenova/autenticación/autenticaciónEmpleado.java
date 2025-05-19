package com.cinenova.autenticación;

import com.cinenova.consultas.consultasPersona;
import com.cinenova.entidades.Empleado;
import java.util.List;

/**
 * Clase para confirmar si un empleado existe en la base de datos
 * 
 * @author Juan Carlos Pizarro Alonso, Álvaro Muñoz Fernández
 */
public class autenticaciónEmpleado {
    
    /**
     * Método que devuelve true en caso de estar registrado el empleado introducido y false en caso contrario
     * 
     * @param correo Correo
     * @param contrasena Contraseña 
     * @return True en caso de que el empleado este registrado y false en caso contrario
     */
    public static boolean esEmpleado(String correo, String contrasena){
        boolean autenticado = false;
        List<Empleado> empleados = consultasPersona.obtenerEmpleados();
        for(int i=0; i < empleados.size(); i++){
            if((empleados.get(i).getCorreo().equals(correo)) && (empleados.get(i).getContrasena().equals(contrasena))){
                autenticado = true;
            }
        }
        return autenticado;
    }
}