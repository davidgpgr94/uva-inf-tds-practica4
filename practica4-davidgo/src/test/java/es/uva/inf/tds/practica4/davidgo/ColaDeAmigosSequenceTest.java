package es.uva.inf.tds.practica4.davidgo;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * 
 * @author davidgo
 *
 */
@Category(Sequences.class)
public class ColaDeAmigosSequenceTest {

	private ColaDeAmigos cola;
	private Persona p1, p2, p3, p4, p5;
	
	@Before
	public void setUp() throws Exception {
		cola = new ColaDeAmigos();
		p1 = new Persona("a");
		p2 = new Persona("b");
		p3 = new Persona("c");
		p4 = new Persona("d");
		p5 = new Persona("e");
		Persona[] conocidosP1 = {p2, p3};
		Persona[] conocidosP3 = {p4};
		Persona[] conocidosP4 = {p2, p3};
		Persona[] conocidosP5 = {p1};
		p1.conocerA(conocidosP1);
		p3.conocerA(conocidosP3);
		p4.conocerA(conocidosP4);
		p5.conocerA(conocidosP5);
		p1.serAmigoDe(p3);
		p5.serAmigoDe(p1);
	}

	@After
	public void tearDown() throws Exception {
		p1 = null;
		p2 = null;
		p3 = null;
		p4 = null;
		p5 = null;
	}

	@Test
	public void testSecuenciaPersonaSeHaceAmigoDeAlguienMientrasEstaEnCola() {
		cola.pedirVez(p3, 1);
		p3.serAmigoDe(p4);
		cola.colarA(p4);
		assertTrue(cola.haySiguiente());
		assertEquals(p4, cola.siguiente());
		cola.atender();
		assertEquals(p3, cola.siguiente());
	}

	@Test
	public void testSecuenciaAPideVezYEsColadoDespuesPorOtro() {
		cola.pedirVez(p1, 0);
		cola.pedirVez(p5, 1);
		assertEquals(p1, cola.siguiente());
		cola.atender();
		assertEquals(p5, cola.siguiente());
		cola.colarA(p1);
		assertEquals(p1, cola.siguiente());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testSecuenciaAPideVezYEsColadoDespuesPorOtroYAIntentaColarAUnAmigoSuyo() {
		cola.pedirVez(p1, 0);
		cola.pedirVez(p5, 1);
		assertEquals(p1, cola.siguiente());
		cola.atender();
		assertEquals(p5, cola.siguiente());
		cola.colarA(p1);
		assertEquals(p1, cola.siguiente());
		cola.colarA(p3);	
	}
	
	@Test(expected = IllegalStateException.class)
	public void testSecuenciaEsColadoDejaDeSerAmigoEIntentaVolverASerColadoPorElMismo() {
		cola.pedirVez(p1, 2);
		cola.colarA(p3);
		assertEquals(p3, cola.siguiente());
		p1.dejarSerAmigoDe(p3);
		cola.atender();
		cola.colarA(p3);
	}
}
