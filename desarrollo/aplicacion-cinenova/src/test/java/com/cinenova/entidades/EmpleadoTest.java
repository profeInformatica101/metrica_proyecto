package com.cinenova.entidades;

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
    @DisplayName("Añade correctamente un nuevo empleado a la base de datos")
    public void testAñadirEmpleado() {
        Empleado nuevo = new Empleado("87654321B", 1800.00, "Laura", "Martínez", "laura.martinez@correo.com", "clave456", true, false);
        boolean resultado = nuevo.añadirEmpleado(nuevo);
        assertTrue(resultado, "El empleado debería haberse añadido correctamente");
        nuevo.borrarEmpleado(nuevo);
    }

    @Test
    @DisplayName("Actualiza correctamente la contraseña y sueldo de un empleado existente")
    public void testActualizarEmpleado() {
        Empleado actualizar = new Empleado("11223344C", 1500.00, "Carlos", "Gómez", "carlos.gomez@correo.com", "pass123", true, false);
        actualizar.añadirEmpleado(actualizar);

        actualizar.setContrasena("nuevaPass789");
        actualizar.setSueldo(2000.00);
        boolean resultado = actualizar.actualizarEmpleado(actualizar);
        assertTrue(resultado, "El empleado debería haberse actualizado correctamente");

        actualizar.borrarEmpleado(actualizar);
    }

    @Test
    @DisplayName("Elimina correctamente un empleado de la base de datos")
    public void testBorrarEmpleado() {
        Empleado borrar = new Empleado("33445566D", 1700.00, "Ana", "Ruiz", "ana.ruiz@correo.com", "clave789", true, false);
        borrar.añadirEmpleado(borrar);
        boolean resultado = borrar.borrarEmpleado(borrar);
        assertTrue(resultado, "El empleado debería haberse borrado correctamente");
    }

    @Test
    @DisplayName("Devuelve la representación esperada del empleado")
    public void testToString() {
        String expected = "Persona{nombre=Juan, apellidos=Pérez, correo=juan.perez@correo.com, contrasena=contrasena123, esEmpleado=true, esJefe=false}" +
                          "Empleado{DNI=12345678A, sueldo=2000.5}";
        assertEquals(expected, empleado.toString());
    }
}
