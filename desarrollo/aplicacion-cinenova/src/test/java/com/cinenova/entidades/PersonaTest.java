package com.cinenova.entidades;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cinenova.consultas.consultasPersona;
import com.cinenova.consultas.consultasSesion;

class PersonaTest {

	Cliente cliente;
    Entrada entrada;
    Sesión sesion;
    List<Cliente> clientes = consultasPersona.obtenerClientes();
	List<Sesión> sesiones = consultasSesion.obtenerConsulta();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		for(int i = 0; i < clientes.size(); i++) {
    		if(i == 0) {
    			cliente = clientes.get(i);
    		}
    	}
    	for(int i = 0; i < sesiones.size(); i++) {
    		if(i == 0) {
    			sesion = sesiones.get(i);
    		}
    	}
        entrada = new Entrada(10, cliente, sesion, sesion.getPrecio());
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
    @DisplayName("Pruebas para el método inciarSesión()")
    public void testIniciarSesión() {
        String correoEsperado = cliente.getCorreo();
        Cliente clienteDevuelto = Persona.iniciarSesión(correoEsperado);
        assertEquals(correoEsperado, clienteDevuelto.getCorreo(), "El cliente esperado no coincide con el obtenido");
    }
	
	@Test
    @DisplayName("Pruebas para el método getNombre()")
    public void testGetNombre() {
        String nombreEsperado = "Ana";
        assertEquals(nombreEsperado, cliente.getNombre(), "El nombre del cliente esperado no coincide con el obtenido");
    }
	
	@Test
    @DisplayName("Pruebas para el método setNombre(String nombre)")
    public void testSetNombre() {
        String nuevoNombre = "ANA";
        cliente.setNombre(nuevoNombre);
        assertEquals(nuevoNombre, cliente.getNombre(), "El nombre del cliente esperado no coincide con el obtenido");
    }
	
	@Test
    @DisplayName("Pruebas para el método getApellidos()")
    public void testGetApellidos() {
        String apellidosEsperados = "Pérez López";
        assertEquals(apellidosEsperados, cliente.getApellidos(), "Los apellidos del cliente esperado no coincide con el obtenido");
    }
	
	@Test
    @DisplayName("Pruebas para el método setApellidos()")
    public void testSetApellidos() {
        String nuevosApellidos = "PÉREZ LÓPEZ";
        cliente.setApellidos(nuevosApellidos);
        assertEquals(nuevosApellidos, cliente.getApellidos(), "Los apellidos del cliente esperado no coincide con el obtenido");
    }
	
	@Test
    @DisplayName("Pruebas para el método getCorreo()")
    public void testGetCorreo() {
        String correoEsperado = "ana.perez@gmail.com";
        assertEquals(correoEsperado, cliente.getCorreo(), "El correo del cliente esperado no coincide con el obtenido");
    }
	
	@Test
    @DisplayName("Pruebas para el método setCorreo()")
    public void testSetCorreo() {
        String nuevoCorreo = "ana.perez@hotmail.com";
        cliente.setCorreo(nuevoCorreo);
        assertEquals(nuevoCorreo, cliente.getCorreo(), "El correo del cliente esperado no coincide con el obtenido");
    }
	
	@Test
    @DisplayName("Pruebas para el método getContrasena()")
    public void testGetContrasena() {
        String contrasenaEsperada = "ana123";
        assertEquals(contrasenaEsperada, cliente.getContrasena(), "La contraseña del cliente esperado no coincide con el obtenido");
    }
	
	@Test
    @DisplayName("Pruebas para el método setContrasena()")
    public void testSetContrasena() {
        String nuevaContraseña = "ana123456";
        cliente.setContrasena(nuevaContraseña);
        assertEquals(nuevaContraseña, cliente.getContrasena(), "La contraseña del cliente esperado no coincide con el obtenido");
    }
	
	@Test
    @DisplayName("Pruebas para el método isEsEmpleado()")
    public void testIsEsEmpleado() {
        boolean valorEsperado = false;
        assertEquals(valorEsperado, cliente.isEsEmpleado(), "El cliente esperado no coincide con el obtenido");
    }
	
	@Test
    @DisplayName("Pruebas para el método setEsEmpleado()")
    public void testSetEsEmpleado() {
        boolean nuevoValor = true;
        cliente.setEsEmpleado(nuevoValor);
        assertEquals(nuevoValor, cliente.isEsEmpleado(), "El cliente esperado no coincide con el obtenido");
    }
	
	@Test
    @DisplayName("Pruebas para el método isEsJefe()")
    public void testIsEsJefe() {
		boolean valorEsperado = false;
        assertEquals(valorEsperado, cliente.isEsJefe(), "El cliente esperado no coincide con el obtenido");
    }

	@Test
    @DisplayName("Pruebas para el método SetEsJefe()")
    public void testSetEsJefe() {
		boolean nuevoValor = true;
		cliente.setEsJefe(nuevoValor);
        assertEquals(nuevoValor, cliente.isEsJefe(), "El cliente esperado no coincide con el obtenido");
    }
	
	
	
}
