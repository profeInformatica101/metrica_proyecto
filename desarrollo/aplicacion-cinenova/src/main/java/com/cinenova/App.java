package com.cinenova;

import com.cinenova.consultas.obtenerClientes;
import com.cinenova.consultas.obtenerEmpleados;
import com.cinenova.consultas.obtenerPeliculas;
import com.cinenova.consultas.obtenerSalas;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(obtenerSalas.obtenerConsulta());
        System.out.println(obtenerPeliculas.obtenerConsulta());
        System.out.println(obtenerClientes.obtenerConsulta());
        System.out.println(obtenerEmpleados.obtenerConsulta());
        System.out.println("Hola");
    }
}
