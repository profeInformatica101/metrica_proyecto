package com.cinenova.autenticación;

import com.cinenova.consultas.consultasPersona;
import com.cinenova.entidades.Empleado;
import java.util.List;

/**
 *
 * @author Juan Carlos
 */
public class autenticaciónEmpleado {
    
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
