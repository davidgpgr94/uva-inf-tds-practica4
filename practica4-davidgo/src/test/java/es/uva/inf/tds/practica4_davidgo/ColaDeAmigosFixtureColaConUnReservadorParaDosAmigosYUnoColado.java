package es.uva.inf.tds.practica4_davidgo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author davidgo
 *
 */
public class ColaDeAmigosFixtureColaConUnReservadorParaDosAmigosYUnoColado {
	
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
		fail("Obligado a fallar");
		//TODO repasar una vez implementada la clase ColaDeAmigos
	}

	@Test
	public void testTDDesReservadorTrue() {
		assertTrue(cola.esReservador(p1));
	}
	
	@Test
	public void testTDDesReservadorFalse() {
		assertFalse(cola.esReservador(p2));
		fail("Obligado a fallar");
		//TODO repasar una vez implementada la clase ColaDeAmigos
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDesReservadorNull() {
		@SuppressWarnings("unused")
		boolean res = cola.esReservador(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDesReservadorNoEstaEnCola() {
		@SuppressWarnings("unused")
		boolean res = cola.esReservador(p3);
	}
}
