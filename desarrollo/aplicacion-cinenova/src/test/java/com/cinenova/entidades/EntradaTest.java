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

class EntradaTest {
	
	Cliente cliente, cliente2;
    Entrada entrada;
    Sesión sesion, sesion2;
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
    			cliente2 = clientes.get(i+1);
    		}
    	}
    	for(int i = 0; i < sesiones.size(); i++) {
    		if(i == 0) {
    			sesion = sesiones.get(i);
    			sesion2 = sesiones.get(i+1);
    		}
    	}
        entrada = new Entrada(10, cliente, sesion, sesion.getPrecio());
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
    @DisplayName("Pruebas para el método setAsiento(int asiento)")
    public void testSetAsiento() {
        int nuevoAsiento = 36;
        entrada.setAsiento(nuevoAsiento);
        assertEquals(nuevoAsiento, entrada.getAsiento(), "El asiento esperado no coinciden con el obtenido");
    }
	
	@Test
    @DisplayName("Pruebas para el método setCliente(Cliente cliente)")
    public void testSetCliente() {
		Cliente esperado = cliente2;
		entrada.setCliente(cliente2);
        assertEquals(esperado.getCorreo(), entrada.getCliente().getCorreo(), "El cliente esperado no coinciden con el obtenido");
    }
	
	@Test
    @DisplayName("Pruebas para el método setSesión(Sesión sesion)")
    public void testSetSesión() {
		Sesión esperado = sesion2;
		entrada.setSesion(sesion2);
        assertEquals(sesion2, entrada.getSesion(), "La sesión esperada no coinciden con la obtenida");
    }
	
	@Test
    @DisplayName("Pruebas para el método getPrecioFinal()")
    public void testGetPrecioFinal() {
        double precioFinalEsperado = sesion.getPrecio();
        assertEquals(precioFinalEsperado, entrada.getPrecioFinal(), "El precio final esperado no coinciden con el obtenido");
    }
	
	@Test
    @DisplayName("Pruebas para el método setPrecioFinal()")
    public void testSetPrecioFinal100200() {
		double precioFinalEsperado = sesion.getPrecio() * 0.9;
        entrada.setPrecioFinal();
        assertEquals(precioFinalEsperado, entrada.getPrecioFinal(), "El precio final esperado no coinciden con el obtenido");
    }
	
	@Test
    @DisplayName("Pruebas para el método setPrecioFinal()")
    public void testSetPrecioFinal200300() {
		cliente.setPuntosGanados(200);
		double precioFinalEsperado = sesion.getPrecio() * 0.8;
        entrada.setPrecioFinal();
        assertEquals(precioFinalEsperado, entrada.getPrecioFinal(), "El precio final esperado no coinciden con el obtenido");
    }
	
	@Test
    @DisplayName("Pruebas para el método setPrecioFinal()")
    public void testSetPrecioFinal300400() {
		cliente.setPuntosGanados(300);
		double precioFinalEsperado = sesion.getPrecio() * 0.7;
        entrada.setPrecioFinal();
        assertEquals(precioFinalEsperado, entrada.getPrecioFinal(), "El precio final esperado no coinciden con el obtenido");
    }
	
	@Test
    @DisplayName("Pruebas para el método setPrecioFinal()")
    public void testSetPrecioFinal400500() {
		cliente.setPuntosGanados(400);
		double precioFinalEsperado = sesion.getPrecio() * 0.6;
        entrada.setPrecioFinal();
        assertEquals(precioFinalEsperado, entrada.getPrecioFinal(), "El precio final esperado no coinciden con el obtenido");
    }
	
	@Test
    @DisplayName("Pruebas para el método setPrecioFinal()")
    public void testSetPrecioFinalMas500() {
		cliente.setPuntosGanados(500);
		double precioFinalEsperado = sesion.getPrecio() * 0.5;
        entrada.setPrecioFinal();
        assertEquals(precioFinalEsperado, entrada.getPrecioFinal(), "El precio final esperado no coinciden con el obtenido");
    }

}
