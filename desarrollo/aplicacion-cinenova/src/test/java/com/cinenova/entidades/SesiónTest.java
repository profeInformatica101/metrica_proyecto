package com.cinenova.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase para las pruebas unitarias de la clase Sesión
 * 
 * @author Álvaro Muñoz
 */
@DisplayName("Pruebas unitarias para la clase Sesión")
public class SesiónTest {

    private Sesión sesion;
    private Película pelicula;
    private Sala sala;
    private Date fecha;
    private final SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    @BeforeEach
    @DisplayName("Inicialización de Sesión con valores de prueba")
    public void setUp() throws ParseException {
        pelicula = new Película(1, "Matrix", 136, "Acción", "+16", "Película de ciencia ficción");
        sala = new Sala(5, 100, false, true);
        fecha = formato.parse("25/12/2025 20:00");
        sesion = new Sesión(pelicula, sala, fecha, 8.5);
    }

    @Test
    @DisplayName("Devuelve la fecha y hora correctamente")
    public void testGetFechaHora() {
        assertEquals(fecha, sesion.getFechaHora());
    }

    @Test
    @DisplayName("Actualiza correctamente la fecha y hora")
    public void testSetFechaHora() throws ParseException {
        Date nuevaFecha = formato.parse("01/01/2026 18:30");
        sesion.setFechaHora(nuevaFecha);
        assertEquals(nuevaFecha, sesion.getFechaHora());
    }

    @Test
    @DisplayName("Devuelve correctamente el objeto Película")
    public void testGetPelicula() {
        assertEquals(pelicula, sesion.getPelicula());
    }

    @Test
    @DisplayName("Actualiza correctamente el objeto Película")
    public void testSetPelicula() {
        Película nueva = new Película(2, "Interestelar", 169, "Ciencia ficción", "+12", "Viaje espacial y agujeros de gusano");
        sesion.setPelicula(nueva);
        assertEquals(nueva, sesion.getPelicula());
    }

    @Test
    @DisplayName("Devuelve correctamente el objeto Sala")
    public void testGetSala() {
        assertEquals(sala, sesion.getSala());
    }

    @Test
    @DisplayName("Actualiza correctamente el objeto Sala")
    public void testSetSala() {
        Sala nueva = new Sala(2, 80, true, false);
        sesion.setSala(nueva);
        assertEquals(nueva, sesion.getSala());
    }

    @Test
    @DisplayName("Devuelve correctamente el precio")
    public void testGetPrecio() {
        assertEquals(8.5, sesion.getPrecio());
    }

    @Test
    @DisplayName("Actualiza correctamente el precio")
    public void testSetPrecio() {
        sesion.setPrecio(10.0);
        assertEquals(10.0, sesion.getPrecio());
    }

    @Test
    @DisplayName("Devuelve el formato esperado de la sesión")
    public void testToString() {
        String expected = "Matrix,5,25/12/2025 20:00,8.5";
        assertEquals(expected, sesion.toString());
    }
}
