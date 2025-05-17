package com.cinenova.entidades;

import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author Juan Carlos
 */
public class ClienteTest {
    
    Cliente cliente;
    Entrada entrada;
    Sesión sesion;
    Sala sala;
    Película pelicula;
    
    public ClienteTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        cliente = new Cliente(100, "Juan", "Perez", "juan@gmail.com", "juan", false, false);
        sala = new Sala(1, 40, false, false);
        pelicula = new Película(1, "Titanic", 200, "Drama", "+7", "Película antigua");
        sesion = new Sesión(pelicula, sala, new Date(), 10);
        entrada = new Entrada(10, cliente, sesion, 10);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getPuntosGanados method, of class Cliente.
     */
    @Test
    @DisplayName("Pruebas para el método getPuntosGanados()")
    public void testGetPuntosGanados() {
        int puntosEsperados = 100;
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

    /**
     * Test of comprarEntrada method, of class Cliente.
     */
    /*
    @Test
    @DisplayName("Pruebas para el método comprarEntrada(Entrada entrada)")
    public void testComprarEntrada() {
        boolean valorEsperado = true;
        boolean resultado = cliente.comprarEntrada(entrada);
        assertEquals(valorEsperado, resultado, "La entrada no se ha comprado correctamente");
    }

    
    /**
     * Test of devolverEntrada method, of class Cliente.
     */
    /*
    @Test
    public void testDevolverEntrada() {
        System.out.println("devolverEntrada");
        Entrada entrada = null;
        Cliente instance = null;
        boolean expResult = false;
        boolean result = instance.devolverEntrada(entrada);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of descargarEntrada method, of class Cliente.
     */
    /*
    @Test
    public void testDescargarEntrada() {
        System.out.println("descargarEntrada");
        Entrada entrada = null;
        File archivoDestino = null;
        Cliente instance = null;
        boolean expResult = false;
        boolean result = instance.descargarEntrada(entrada, archivoDestino);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verEntradas method, of class Cliente.
     */
    /*
    @Test
    public void testVerEntradas() {
        System.out.println("verEntradas");
        Cliente instance = null;
        List<Entrada> expResult = null;
        List<Entrada> result = instance.verEntradas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verEntradasFuturo method, of class Cliente.
     */
    /*
    @Test
    public void testVerEntradasFuturo() {
        System.out.println("verEntradasFuturo");
        Cliente instance = null;
        List<Entrada> expResult = null;
        List<Entrada> result = instance.verEntradasFuturo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of filtrarPorPelículas method, of class Cliente.
     */
    /*
    @Test
    public void testFiltrarPorPelículas() {
        System.out.println("filtrarPorPel\u00edculas");
        String titulo = "";
        Cliente instance = null;
        List<Sesión> expResult = null;
        List<Sesión> result = instance.filtrarPorPelículas(titulo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of peliculasSesionesDisponibles method, of class Cliente.
     */
    /*
    @Test
    public void testPeliculasSesionesDisponibles() {
        System.out.println("peliculasSesionesDisponibles");
        List<Sesión> sesiones = null;
        Cliente instance = null;
        List<String> expResult = null;
        List<String> result = instance.peliculasSesionesDisponibles(sesiones);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Cliente.
     */
    /*
    @Test
    public void testToString() {
        System.out.println("toString");
        Cliente instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    
}
