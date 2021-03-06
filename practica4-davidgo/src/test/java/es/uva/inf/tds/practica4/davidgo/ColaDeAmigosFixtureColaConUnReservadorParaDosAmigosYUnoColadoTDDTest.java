package es.uva.inf.tds.practica4.davidgo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * 
 * @author davidgo
 *
 */
@Category({TDD.class, Integration.class})
public class ColaDeAmigosFixtureColaConUnReservadorParaDosAmigosYUnoColadoTDDTest {
	
	private Persona p1, p2, p3;
	private ColaDeAmigos cola;

	@Before
	public void setUp() throws Exception {
		//en la cola estan p2 y luego p1 en este orden.
		//p1 todavía puede colar a 1 amigo más
		p2 = new Persona("b");
		p3 = new Persona("c");
		Persona[] conocidos = {p2, p3};
		p1 = new Persona("a", conocidos);
		p1.serAmigoDe(p2);
		p1.serAmigoDe(p3);
		cola = new ColaDeAmigos();
		cola.pedirVez(p1, 2);
		cola.colarA(p2);
	}

	@Test
	public void testTDDsiguiente() {
		assertEquals(p2, cola.siguiente());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDsiguienteNoHayNadieEnLaCola() {
		cola = new ColaDeAmigos();
		cola.siguiente();
	}

	@Test
	public void testTDDhaySiguienteTrue() {
		assertTrue(cola.haySiguiente());
	}
	
	@Test
	public void testTDDhaySiguienteFalse() {
		cola = new ColaDeAmigos();
		assertFalse(cola.haySiguiente());
	}

	@Test
	public void testTDDesReservadorTrue() {
		assertTrue(cola.esReservador(p1));
	}
	
	@Test
	public void testTDDesReservadorFalse() {
		assertFalse(cola.esReservador(p2));
		assertFalse(cola.esReservador(p3));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDesReservadorNull() {
		@SuppressWarnings("unused")
		boolean res = cola.esReservador(null);
	}
	
	@Test
	public void testTDDestaEnColaTrue() {
		assertTrue(cola.estaEnCola(p1));
		assertTrue(cola.estaEnCola(p2));
	}
	
	@Test
	public void testTDDestaEnColaFalse() {
		assertFalse(cola.estaEnCola(p3));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDestaEnColaNull() {
		@SuppressWarnings("unused")
		boolean res = cola.estaEnCola(null);
	}

}