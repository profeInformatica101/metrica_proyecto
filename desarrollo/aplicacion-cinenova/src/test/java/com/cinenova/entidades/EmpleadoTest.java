package com.cinenova.entidades;

import com.cinenova.consultas.consultasPersona;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase para las pruebas unitarias de la clase Empleado
 * 
 * @author Álvaro Muñoz
 */
@DisplayName("Pruebas unitarias para la clase Empleado")
public class EmpleadoTest {

    private Empleado empleado, nuevo;

    @BeforeEach
    @DisplayName("Inicialización del objeto Empleado para pruebas")
    public void setUp() {
        empleado = new Empleado("12345678A", 2000.50, "Juan", "Pérez", "juan.perez@correo.com", "contrasena123", true, false);
        nuevo = new Empleado("87654321B", 1800.00, "Laura", "Martínez", "laura.martinez@correo.com", "clave456", true, false);
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
    @DisplayName("Debe añadir un empleado correctamente")
    void testAñadirEmpleadoExito() {
        int filas = consultasPersona.añadirEmpleado(empleado);
        assertEquals(0, filas, "Debe haberse insertado la fila");
    }

    @Test
    @DisplayName("Debe actualizar correctamente la contraseña y sueldo del empleado existente")
    void testActualizarEmpleadoExito() {
        consultasPersona.añadirEmpleado(empleado);
        int filas = consultasPersona.actualizarEmpleado("juan.perez@cinenova.com", "nueva123", 1800.0);
        assertEquals(0, filas, "Debe haberse actualizado la fila");

    }
    @Test
    @DisplayName("No debe actualizar nada si el correo no existe")
    void testActualizarEmpleadoCorreoInexistente() {
        int filas = consultasPersona.actualizarEmpleado("no.existe@cinenova.com", "clave", 2000.0);
        assertEquals(0, filas, "No debe haberse actualizado ninguna fila");
    }
    

    @Test
    @DisplayName("Debe eliminar correctamente un empleado existente")
    void testBorrarEmpleadoExito() {
        consultasPersona.añadirEmpleado(empleado);
        int filas = consultasPersona.borrarEmpleado("juan.perez@cinenova.com");
        assertEquals(0, filas, "Debe haberse eliminado la fila");
    }

    @Test
    @DisplayName("No debe eliminar nada si el correo no existe")
    void testBorrarEmpleadoCorreoInexistente() {
        int filas = consultasPersona.borrarEmpleado("no.existe@cinenova.com");
        assertEquals(0, filas, "No debe haberse eliminado ninguna fila");
    }

    @Test
    @DisplayName("No debe permitir insertar un empleado con correo o DNI duplicado")
    void testAñadirEmpleadoDuplicado() {
        consultasPersona.añadirEmpleado(empleado);
        int filas = consultasPersona.añadirEmpleado(empleado);
        assertEquals(0, filas, "No debe insertarse un empleado duplicado");
        consultasPersona.borrarEmpleado(empleado.getCorreo());
    }

    @Test
    @DisplayName("Devuelve la representación esperada del empleado")
    public void testToString() {
        String expected = "Persona{nombre=Juan, apellidos=Pérez, correo=juan.perez@correo.com, contrasena=contrasena123, esEmpleado=true, esJefe=false}" +
                          "Empleado{DNI=12345678A, sueldo=2000.5}";
        assertEquals(expected, empleado.toString());
    }
}
