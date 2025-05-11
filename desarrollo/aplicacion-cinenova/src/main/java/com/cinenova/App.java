package com.cinenova;

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
    }
}
