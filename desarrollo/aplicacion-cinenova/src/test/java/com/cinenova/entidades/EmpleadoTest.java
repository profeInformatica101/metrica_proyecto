package com.cinenova.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas unitarias para la clase Empleado")
public class EmpleadoTest {

    private Empleado empleado;

    @BeforeEach
    @DisplayName("Inicialización del objeto Empleado para pruebas")
    public void setUp() {
        empleado = new Empleado("12345678A", 2000.50, "Juan", "Pérez", "juan.perez@correo.com", "contrasena123", true, false);
    }

    @Test
    @DisplayName("Verifica que los valores iniciales se asignen correctamente")
    public void testConstructorAndGetters() {
        assertEquals("12345678A", empleado.getDNI());
        assertEquals(2000.50, empleado.getSueldo());
        assertEquals("Juan", empleado.getNombre());
        assertEquals("Pérez", empleado.getApellidos());
        assertEquals("juan.perez@correo.com", empleado.getCorreo());
        assertEquals("contrasena123", empleado.getContrasena());
        assertTrue(empleado.isEsEmpleado());
        assertFalse(empleado.isEsJefe());
    }

    @Test
    @DisplayName("Actualiza correctamente el DNI del empleado")
    public void testSetDNI() {
        empleado.setDNI("87654321B");
        assertEquals("87654321B", empleado.getDNI());
    }

    @Test
    @DisplayName("Actualiza correctamente el sueldo del empleado")
    public void testSetSueldo() {
        empleado.setSueldo(2500.75);
        assertEquals(2500.75, empleado.getSueldo());
    }

    @Test
    @DisplayName("Devuelve la representación esperada del empleado")
    public void testToString() {
        String expected = "Persona{nombre=Juan, apellidos=Pérez, correo=juan.perez@correo.com, contrasena=contrasena123, esEmpleado=true, esJefe=false}" +
                          "Empleado{DNI=12345678A, sueldo=2000.5}";
        assertEquals(expected, empleado.toString());
    }
}
