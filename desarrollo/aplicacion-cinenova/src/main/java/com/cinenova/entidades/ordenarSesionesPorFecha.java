package com.cinenova.entidades;

import java.util.Comparator;

/**
 *
 * @author Juan Carlos
 */
public class ordenarSesionesPorFecha implements Comparator{
    
    @Override
       public int compare(Object o1, Object o2) {
           Sesión d1 = (Sesión)o1;
           Sesión d2 = (Sesión)o2;
           return d1.getFechaHora().compareTo(d2.getFechaHora());
       }
}
