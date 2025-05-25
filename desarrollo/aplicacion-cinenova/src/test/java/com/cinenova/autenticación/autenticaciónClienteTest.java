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

/**
 * Clase para las pruebas unitarias de la clase autenticaciónCliente
 * 
 * @author Juan Carlos Pizarro
 */
class autenticaciónClienteTest {
	
	Cliente cliente, clienteExiste;
    List<Cliente> clientes = consultasPersona.obtenerClientes();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		cliente = new Cliente(100, "Cliente1", "Cliente1", "Cliente1", "Cliente1", false, false);
		for(int i = 0; i < clientes.size(); i++) {
    		if(i == 0) {
    			clienteExiste = clientes.get(i);
    		}
    	}
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
    @DisplayName("Pruebas para el método esCliente(String correo, String contrasena) cuando no existe")
    public void testNoEsCliente() {
        boolean valorEsperado = false;
        boolean valorDevuelto = autenticaciónCliente.esCliente(cliente.getCorreo(), cliente.getContrasena());
        assertEquals(valorEsperado, valorDevuelto, "El cliente si está registrado en la base de datos");
    }
	
	@Test
    @DisplayName("Pruebas para el método esCliente(String correo, String contrasena) cuando sí existe")
    public void testEsCliente() {
        boolean valorEsperado = true;
        boolean valorDevuelto = autenticaciónCliente.esCliente(clienteExiste.getCorreo(), clienteExiste.getContrasena());
        assertEquals(valorEsperado, valorDevuelto, "El cliente no está registrado en la base de datos");
    }
	
	@Test
    @DisplayName("Pruebas para el método esCliente(String correo, String contrasena) cuando no existe el correo")
    public void testCorreoNoExiste() {
		boolean resultado = autenticaciónCliente.esCliente("correo no existe", "contrasena");
        assertFalse(resultado, "Debe retornar false cuando el correo no existe");
    }

	@Test
    @DisplayName("Pruebas para el método esCliente(String correo, String contrasena) cuando no existe la contraseña")
    public void testContraseñaNoExiste() {
		boolean resultado = autenticaciónCliente.esCliente(cliente.getCorreo(), "contrasena");
        assertFalse(resultado, "Debe retornar false cuando la contraseña no existe");
    }
}
