package es.uva.inf.tds.practica4_davidgo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author davidgo
 *
 */
public class ColaDeAmigosTDDTest {

	@Test
	public void testTDDConstructorColaDeAmigos() {
		ColaDeAmigos c = new ColaDeAmigos();
		assertNotNull(c);
		fail("Obligado a fallar");
		//TODO repasar una vez implementada la clase ColaDeAmigos
	}
	
	@Test
	public void testTDDpedirVez() {
		Persona p1 = new Persona("a");
		ColaDeAmigos c = new ColaDeAmigos();
		c.pedirVez(p1, 0);
		assertEquals(p1, c.siguiente());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTDDpedirVezPersonaNull() {
		Persona p1 = null;
		ColaDeAmigos c = new ColaDeAmigos();
		c.pedriVez(p1, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDpedirVezNamigosNegativo() {
		Persona p1 = new Persona("a");
		ColaDeAmigos c = new ColaDeAmigos();
		c.pedirVez(p1, -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDpedirVezParaMasDe10Amigos() {
		Persona p1 = new Persona("a");
		ColaDeAmigos c = new ColaDeAmigos();
		c.pedirVez(p1, 11);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDpedirVezDosVecesSinSerAtendido() {
		Persona p1 = new Persona("a");
		ColaDeAmigos c = new ColaDeAmigos();
		c.pedirVez(p1, 0);
		c.pedirVez(p1, 0);
	}
	
	@Test(expected = IllegalStateException.class) 
	public void testTDDpedirVezHabiendoSidoColado() {
		Persona p2 = new Persona("b");
		Persona[] conocidos = {p2};
		Persona p1 = new Persona("a", conocidos);
		p1.serAmigoDe(p2);
		ColaDeAmigos c = new ColaDeAmigos();
		c.pedirVez(p1, 1);
		c.colarA(p2);
		c.pedirVez(p2, 0);
	}
}
