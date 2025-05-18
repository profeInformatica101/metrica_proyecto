package com.cinenova.entidades;

import java.util.Comparator;

/**
 * Clase donde se define un método de ordenación de sesiones por fecha
 * 
 * @author Juan Carlos
 */
public class ordenarSesionesPorFecha implements Comparator{
    
    /**
     * Método que devuelve los dos objetos (sesiones) pasados como parámetro ordenados por fecha de más reciente a más lejana
     * 
     * @param o1 o1
     * @param o2 o2
     * @return Entero con el orden de ordenación de ambas sesiones por fecha de más cercana a más lejana
     */
    @Override
       public int compare(Object o1, Object o2) {
           Sesión d1 = (Sesión)o1;
           Sesión d2 = (Sesión)o2;
           return d1.getFechaHora().compareTo(d2.getFechaHora());
       }
}