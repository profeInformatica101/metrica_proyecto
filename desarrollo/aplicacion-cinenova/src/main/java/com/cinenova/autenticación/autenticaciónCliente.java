
package com.cinenova.autenticación;

import com.cinenova.consultas.consultasPersona;
import com.cinenova.entidades.Cliente;
import java.util.List;

/**
 * Clase para confirmar si un cliente existe en la base de datos
 * 
 * @author Juan Carlos Pizarro Alonso, Álvaro Muñoz Fernández
 */
public class autenticaciónCliente {
    
    /**
     * Método que devuelve true en caso de estar registrado el usuario introducido y false en caso contrario
     * 
     * @param correo
     * @param contrasena
     * @return True en caso de que el cliente este registrado y false en caso contrario
     */
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
