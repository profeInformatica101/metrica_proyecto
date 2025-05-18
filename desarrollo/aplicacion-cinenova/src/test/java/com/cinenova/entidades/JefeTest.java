package com.cinenova.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas unitarias para la clase Jefe")
public class JefeTest {

    private Jefe jefe;

    @BeforeEach
    @DisplayName("Inicialización del objeto Jefe para pruebas")
    public void setUp() {
        jefe = new Jefe("11112222C", 5000.00, "Ana", "Gómez", "ana.gomez@correo.com", "claveSegura456", true, true);
    }

    @Test
    @DisplayName("Verifica que los atributos heredados se asignen correctamente")
    public void testConstructorAndGetters() {
        assertEquals("11112222C", jefe.getDNI());
        assertEquals(5000.00, jefe.getSueldo());
        assertEquals("Ana", jefe.getNombre());
        assertEquals("Gómez", jefe.getApellidos());
        assertEquals("ana.gomez@correo.com", jefe.getCorreo());
        assertEquals("claveSegura456", jefe.getContrasena());
        assertTrue(jefe.isEsEmpleado());
        assertTrue(jefe.isEsJefe());
    }

    @Test
    @DisplayName("Devuelve la representación esperada del objeto Jefe")
    public void testToString() {
        String expected = "Jefe{" +
            "Persona{nombre=Ana, apellidos=Gómez, correo=ana.gomez@correo.com, contrasena=claveSegura456, esEmpleado=true, esJefe=true}" +
            "Empleado{DNI=11112222C, sueldo=5000.0}" +
            "}";
        assertEquals(expected, jefe.toString());
    }
}
