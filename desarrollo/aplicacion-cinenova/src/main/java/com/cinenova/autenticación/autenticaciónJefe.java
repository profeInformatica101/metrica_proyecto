package com.cinenova.autenticación;

import com.cinenova.consultas.obtenerJefes;
import com.cinenova.entidades.Jefe;
import java.util.List;

/**
 *
 * @author Juan Carlos
 */
public class autenticaciónJefe {
    
    public static boolean esJefe(String correo, String contrasena){
        boolean autenticado = false;
        List<Jefe> jefes = obtenerJefes.obtenerConsulta();
        for(int i=0; i < jefes.size(); i++){
            if((jefes.get(i).getCorreo().equals(correo)) && (jefes.get(i).getContrasena().equals(contrasena))){
                autenticado = true;
            }
        }
        return autenticado;
    }
}
