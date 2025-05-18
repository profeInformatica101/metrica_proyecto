package com.cinenova.autenticación;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cinenova.consultas.consultasPersona;
import com.cinenova.entidades.Cliente;
import com.cinenova.entidades.Empleado;

class autenticaciónEmpleadoTest {

	Empleado empleado, empleadoExiste;
    List<Empleado> empleados = consultasPersona.obtenerEmpleados();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		empleado = new Empleado("29654321Q", 2000.0, "Empleado1", "Empleado1", "Empleado1", "Empleado1", true, false);
		for(int i = 0; i < empleados.size(); i++) {
    		if(i == 0) {
    			empleadoExiste = empleados.get(i);
    		}
    	}
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
    @DisplayName("Pruebas para el método esEmpleado(String correo, String contrasena) cuando no existe")
    public void testNoEsEmpleado() {
        boolean valorEsperado = false;
        boolean valorDevuelto = autenticaciónEmpleado.esEmpleado(empleado.getCorreo(), empleado.getContrasena());
        assertEquals(valorEsperado, valorDevuelto, "El empleado sí está registrado en la base de datos");
    }

	@Test
    @DisplayName("Pruebas para el método esEmpleado(String correo, String contrasena) cuando sí existe")
    public void testEsEmpleado() {
        boolean valorEsperado = true;
        boolean valorDevuelto = autenticaciónEmpleado.esEmpleado(empleadoExiste.getCorreo(), empleadoExiste.getContrasena());
        assertEquals(valorEsperado, valorDevuelto, "El empleado no está registrado en la base de datos");
    }
}
