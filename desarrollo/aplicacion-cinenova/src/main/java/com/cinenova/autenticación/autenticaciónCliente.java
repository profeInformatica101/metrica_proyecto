
package com.cinenova.autenticación;

import com.cinenova.consultas.consultasPersona;
import com.cinenova.entidades.Cliente;
import java.util.List;

/**
 *
 * @author Juan Carlos
 */
public class autenticaciónCliente {
    
    public static boolean esCliente(String correo, String contrasena){
        boolean autenticado = false;
        List<Cliente> clientes = consultasPersona.obtenerClientes();
        for(int i=0; i < clientes.size(); i++){
            if((clientes.get(i).getCorreo().equals(correo)) && (clientes.get(i).getContrasena().equals(contrasena))){
                autenticado = true;
            }
        }
        return autenticado;
    }
}
