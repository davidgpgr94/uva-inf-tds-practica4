package es.uva.inf.tds.practica4_davidgo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ColaDeAmigosFixtureColaConUnReservadorParaUnAmigoYNingunoColado {

	private Persona p1, p2, p3, p4, p5;
	private ColaDeAmigos cola;
	
	@Before
	public void setUp() throws Exception {
		//p1 considera amigos a p2 y p3
		//p1 considera conocidos a p2, p3 y p4
		//p1 ha pedido vez para 1 amigo
		//p5 no es ni conocido ni amigo de nadie
		p2 = new Persona("b");
		p3 = new Persona("c");
		p4 = new Persona("d");
		p5 = new Persona("e");
		Persona[] conocidos = {p2, p3, p4};
		p1 = new Persona("a", conocidos);
		p1.serAmigoDe(p2);
		p1.serAmigoDe(p3);
		
		cola = new ColaDeAmigos();
		cola.pedirVez(p1, 1);
	}

	@Test
	public void testTDDpuedeColarseTrue() {
		assertTrue(cola.puedeColarse(p2));
	}
	
	@Test
	public void testTDDpuedeColarseFalse() {
		assertFalse(cola.puedeColarse(p4));
		assertFalse(cola.puedeColarse(p5));
		cola.colarA(p2);
		assertFalse(cola.puedeColarse(p3));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDpuedeColarseNull() {
		@SuppressWarnings("unused")
		boolean res = cola.puedeColarse(null);
	}

	@Test
	public void testTDDcuantosPuedeColar() {
		assertEquals(1, cola.cuantosPuedeColar(p1));
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDcuantosPuedeColarAlguienQueNoEsReservador() {
		cola.colarA(p2);
		@SuppressWarnings("unused")
		int res = cola.cuantosPuedeColar(p2);
	}

	@Test(expected = IllegalStateException.class)
	public void testTDDcuantosPuededColarAlguienQueNoEstaEnCola() {
		@SuppressWarnings("unused")
		int res = cola.cuantosPuedeColar(p2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDcuantosPuedeColarNull() {
		@SuppressWarnings("unused")
		int res = cola.cuantosPuedeColar(null);
	}
	
}