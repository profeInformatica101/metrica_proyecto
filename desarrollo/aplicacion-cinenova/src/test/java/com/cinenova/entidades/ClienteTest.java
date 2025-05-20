package com.cinenova.entidades;

import java.io.File;
import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cinenova.consultas.consultasPersona;
import com.cinenova.consultas.consultasSesion;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 * Clase para las pruebas unitarias de la clase Cliente
 * 
 * @author Juan Carlos Pizarro Alonso
 */
public class ClienteTest {
    
    Cliente cliente;
    Entrada entrada;
    Sesión sesion;
    List<Cliente> clientes = consultasPersona.obtenerClientes();
	List<Sesión> sesiones = consultasSesion.obtenerConsulta();
	List<Entrada> entradas;
   
    
    @BeforeEach
    public void setUp() throws ParseException {
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

    /**
     * Test of getPuntosGanados method, of class Cliente.
     */
    @Test
    @DisplayName("Pruebas para el método getPuntosGanados()")
    public void testGetPuntosGanados() {
        int puntosEsperados = 75;
        assertEquals(puntosEsperados, cliente.getPuntosGanados(), "Los puntos esperados no coinciden con los obtenidos");
    }

    /**
     * Test of setPuntosGanados method, of class Cliente.
     */
    @Test
    @DisplayName("Pruebas para el método setPuntosGanados()")
    public void testSetPuntosGanados() {
        int puntosNuevos = 200;
        cliente.setPuntosGanados(puntosNuevos);
        assertEquals(puntosNuevos, cliente.getPuntosGanados(), "No se han añadido correctamente los puntos");
    }

    @Test
    @DisplayName("Pruebas para el método actualizarPuntosGanados(Cliente cliente) en caso de éxito")
    public void testActualizarPuntosGanadosÉxito() {
        boolean valorEsperado = true;
        boolean resultado = cliente.actualizarPuntosGanados();
        assertEquals(valorEsperado, resultado, "No se han añadido correctamente los puntos");
    }
    
    @Test
    @DisplayName("Pruebas para el método actualizarPuntosGanados(Cliente cliente) en caso de no éxito")
    public void testActualizarPuntosGanadosSinÉxito() {
        boolean valorEsperado = false;
        Cliente cliente2 = new Cliente(0, "miguel@hotmail.com", "Miguel", "Lopez", "miguel", false, false);
        boolean resultado = cliente2.actualizarPuntosGanados();
        assertEquals(valorEsperado, resultado, "Se han añadido correctamente los puntos");
    }
    
    @Test
    @DisplayName("Pruebas para el método actualizarPuntosGanados(Cliente cliente) en caso de éxito")
    public void testActualizarPuntosDevueltosÉxito() {
        boolean valorEsperado = true;
        boolean resultado = cliente.actualizarPuntosDevueltos();
        assertEquals(valorEsperado, resultado, "No se han añadido correctamente los puntos");
    }
    
    @Test
    @DisplayName("Pruebas para el método actualizarPuntosGanados(Cliente cliente) en caso de no éxito")
    public void testActualizarPuntosDevuletosSinÉxito() {
        boolean valorEsperado = false;
        Cliente cliente2 = new Cliente(0, "miguel@hotmail.com", "Miguel", "Lopez", "miguel", false, false);
        boolean resultado = cliente2.actualizarPuntosDevueltos();
        assertEquals(valorEsperado, resultado, "Se han añadido correctamente los puntos");
    }
    
    /**
     * Test of comprarEntrada method, of class Cliente.
     */
    
    @Test
    @DisplayName("Pruebas para el método comprarEntrada(Entrada entrada) cuando se compra con éxito")
    public void testEntradaComprada() {
        boolean valorEsperado = true;
        boolean resultado = cliente.comprarEntrada(entrada);
        assertEquals(valorEsperado, resultado, "La entrada no se ha comprado correctamente");
    }
    
    @Test
    @DisplayName("Pruebas para el método comprarEntrada(Entrada entrada) cuando no se compra con éxito")
    public void testEntradaNoComprada() {
        boolean valorEsperado = false;
        boolean resultado = cliente.comprarEntrada(entrada);
        assertEquals(valorEsperado, resultado, "La entrada sí se ha comprado correctamente");
    }

    
    /**
     * Test of devolverEntrada method, of class Cliente.
     */
    
    @Test
    @DisplayName("Pruebas para el método devolverEntrada(Entrada entrada) cuando se devuelve con éxito")
    public void testEntradaDevuelta() {
    	boolean valorEsperado = true;
        boolean resultado = cliente.devolverEntrada(entrada);
        assertEquals(valorEsperado, resultado, "La entrada no se ha devuelto correctamente");
    }
    
    @Test
    @DisplayName("Pruebas para el método devolverEntrada(Entrada entrada) cuando no se devuelve con éxito")
    public void testEntradaNoDevuelta() {
    	boolean valorEsperado = false;
        boolean resultado = cliente.devolverEntrada(entrada);
        assertEquals(valorEsperado, resultado, "La entrada sí se ha devuelto correctamente");
    }

    /**
     * Test of descargarEntrada method, of class Cliente.
     */
    
    @Test
    @DisplayName("Pruebas para el método descargarEntrada(Entrada entrada) cuando se descarga con éxito")
    public void testEntradaDescargada() {
        File archivoDestino = new File("entrada_descargada.txt");
        boolean resultadoEsperado = true;
        boolean resultado = cliente.descargarEntrada(entrada, archivoDestino);
        assertEquals(resultadoEsperado, resultado, "La entrada no se ha descargado correctamente");
    }
    /*
    @Test
    @DisplayName("Pruebas para el método descargarEntrada(Entrada entrada) cuando no se descarga con éxito")
    public void testEntradaNoDescargada() {
        File archivoDestino = new File("entrada_descargada.txt");
        Exception e = assertThrows(IllegalArgumentException.class, () -> cliente.descargarEntrada(entrada, archivoDestino));
        String mensajeEsperado = "Error al escribir la entrada: "  + e.getMessage();
		assertEquals(mensajeEsperado, e.getMessage(), "Deben coincidir los mensajes al no poder descargar la entrada");
    }
	*/
    /**
     * Test of verEntradas method, of class Cliente.
     */
    
    @Test
    @DisplayName("Pruebas para el método verEntradas()")
    public void testVerEntradas() {
        int entradasEsperadas = 2;
        assertEquals(entradasEsperadas, cliente.verEntradas().size(), "El número de entradas del cliente no coincide con el esperado");
    }

    /**
     * Test of verEntradasFuturo method, of class Cliente.
     */
    
    @Test
    @DisplayName("Pruebas para el método verEntradasFuturo()")
    public void testVerEntradasFuturo() {
        int entradasEsperadas = 1;
        assertEquals(entradasEsperadas, cliente.verEntradasFuturo().size(), "El número de entradas del futuro del cliente no coincide con el esperado");
    }

    /**
     * Test of filtrarPorPelículas method, of class Cliente.
     */
    
    @Test
    @DisplayName("Pruebas para el método filtrarPorPelículas(String título)")
    public void testFiltrarPorPeliculas() {
        int peliculasEsperadas = 0;
        assertEquals(peliculasEsperadas, cliente.filtrarPorPelículas("Titanic").size(), "El número de peliculas no coincide con el esperado");
    }

    /**
     * Test of peliculasSesionesDisponibles method, of class Cliente.
     */
    
    @Test
    @DisplayName("Pruebas para el método peliculasSesionesDisponibles(List<Sesion> sesiones)")
    public void testPeliculasSesionesDisponibles() {
        int peliculasEsperadas = 3;
        assertEquals(peliculasEsperadas, cliente.peliculasSesionesDisponibles(sesiones).size(), "El número de peliculas no coincide con el esperado");
    }

    @Test
    @DisplayName("Pruebas para el método verSesionesFuturo()")
    public void testVerSesionesFuturo() {
        int sesionesEsperadas = 3;
        assertEquals(sesionesEsperadas, cliente.verSesionesFuturo().size(), "El número de sesiones del futuro del cliente no coincide con el esperado");
    }
    
    @Test
    @DisplayName("Pruebas para el método eliminarCuenta() cuando no se elimina con éxito")
    public void testCuentaNoEliminada() {
    	boolean valorEsperado = false;
    	cliente.setCorreo("aaa");
        boolean resultado = cliente.eliminarCuenta();
        assertEquals(valorEsperado, resultado, "La cuenta sí se ha eliminado correctamente");
    }
    
    @Test
    @DisplayName("Pruebas para el método eliminarCuenta() cuando sí se elimina con éxito")
    public void testCuentaEliminada() {
    	boolean valorEsperado = true;
        boolean resultado = cliente.eliminarCuenta();
        assertEquals(valorEsperado, resultado, "La cuenta no se ha eliminado correctamente");
    }
    
    /**
     * Test of toString method, of class Cliente.
     */
    /*
    @Test
    @DisplayName("Pruebas para el método toString()")
    public void testToString() {
    	String stringPadre = super.toString();
        String resultadoEsperado = stringPadre + "Cliente{" + "puntosGanados=" + cliente.getPuntosGanados() + '}';
        String mensaje = cliente.toString();
        assertEquals(resultadoEsperado, mensaje, "El método no devuelve la cadena esperada");
    }
    */
    
    
}
