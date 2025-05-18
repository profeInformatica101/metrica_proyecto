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
import com.cinenova.entidades.Empleado;
import com.cinenova.entidades.Jefe;

class autenticaciónJefeTest {
	
	Jefe jefe, jefeExiste;
    List<Jefe> jefes = consultasPersona.obtenerJefes();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		jefe = new Jefe("29654321Q", 2000.0, "Empleado1", "Empleado1", "Empleado1", "Empleado1", false, true);
		for(int i = 0; i < jefes.size(); i++) {
    		if(i == 0) {
    			jefeExiste = jefes.get(i);
    		}
    	}
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
    @DisplayName("Pruebas para el método esJefe(String correo, String contrasena) cuando no existe")
    public void testNoEsJefe() {
        boolean valorEsperado = false;
        boolean valorDevuelto = autenticaciónJefe.esJefe(jefe.getCorreo(), jefe.getContrasena());
        assertEquals(valorEsperado, valorDevuelto, "El jefe sí está registrado en la base de datos");
    }
	
	@Test
    @DisplayName("Pruebas para el método esJefe(String correo, String contrasena) cuando sí existe")
    public void testEsJefe() {
        boolean valorEsperado = true;
        boolean valorDevuelto = autenticaciónJefe.esJefe(jefeExiste.getCorreo(), jefeExiste.getContrasena());
        assertEquals(valorEsperado, valorDevuelto, "El jefe no está registrado en la base de datos");
    }

}
