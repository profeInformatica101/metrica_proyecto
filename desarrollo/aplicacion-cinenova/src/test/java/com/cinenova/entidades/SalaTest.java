package com.cinenova.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase para las pruebas unitarias de la clase Sala
 * 
 * @author Álvaro Muñoz
 */
@DisplayName("Pruebas unitarias para la clase Sala")
public class SalaTest {

    private Sala sala;

    @BeforeEach
    @DisplayName("Inicialización del objeto Sala para pruebas")
    public void setUp() {
        sala = new Sala(1, 120, true, true);
    }

    @Test
    @DisplayName("Devuelve correctamente el número de sala")
    public void testGetNumero() {
        assertEquals(1, sala.getNumero());
    }

    @Test
    @DisplayName("Actualiza correctamente el número de sala")
    public void testSetNumero() {
        sala.setNumero(2);
        assertEquals(2, sala.getNumero());
    }

    @Test
    @DisplayName("Devuelve correctamente la capacidad de la sala")
    public void testGetCapacidad() {
        assertEquals(120, sala.getCapacidad());
    }

    @Test
    @DisplayName("Actualiza correctamente la capacidad de la sala")
    public void testSetCapacidad() {
        sala.setCapacidad(80);
        assertEquals(80, sala.getCapacidad());
    }

    @Test
    @DisplayName("Devuelve correctamente si la sala es 3D")
    public void testIsEs3D() {
        assertTrue(sala.isEs3D());
    }

    @Test
    @DisplayName("Actualiza correctamente el estado 3D de la sala")
    public void testSetEs3D() {
        sala.setEs3D(false);
        assertFalse(sala.isEs3D());
    }

    @Test
    @DisplayName("Devuelve correctamente si la sala es VIP")
    public void testIsEsVIP() {
        assertTrue(sala.isEsVIP());
    }

    @Test
    @DisplayName("Actualiza correctamente el estado VIP de la sala")
    public void testSetEsVIP() {
        sala.setEsVIP(false);
        assertFalse(sala.isEsVIP());
    }

    @Test
    @DisplayName("Devuelve la representación esperada del objeto Sala")
    public void testToString() {
        String expected = "Sala{nombre=1, capacidad=120, es3D=true, esVIP=true}";
        assertEquals(expected, sala.toString());
    }
}
