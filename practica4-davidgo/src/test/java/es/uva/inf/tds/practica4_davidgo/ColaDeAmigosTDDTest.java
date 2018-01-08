package es.uva.inf.tds.practica4_davidgo;

import static org.junit.Assert.*;

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
		c.pedirVez(p1, 0);
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
	
	@Test
	public void testTDDcolarA() {
		Persona p2 = new Persona("b");
		Persona[] conocidos = {p2};
		Persona p1 = new Persona("a", conocidos);
		p1.serAmigoDe(p2);
		ColaDeAmigos c = new ColaDeAmigos();
		c.pedirVez(p1, 1);
		c.colarA(p2);
		assertEquals(p2, c.siguiente());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDcolarAPersonaNull() {
		Persona p1 = new Persona("a");
		ColaDeAmigos c = new ColaDeAmigos();
		c.pedirVez(p1, 1);
		c.colarA(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDcolarAUnReservador() {
		Persona p1 = new Persona("a");
		ColaDeAmigos c = new ColaDeAmigos();
		c.pedirVez(p1, 1);
		c.colarA(p1);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDcolarANoHayReservadorQueConsidereAmigoAlColado() {
		Persona p2 = new Persona("b");
		Persona[] conocidos = {p2};
		Persona p1 = new Persona("a", conocidos);
		ColaDeAmigos c = new ColaDeAmigos();
		c.pedirVez(p1, 1);
		c.colarA(p2);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDcolarAElReservadorQueConsideraComoAmigoAlColadoYaHaColadoAlLosAmigosParaLosQuePidioVez() {
		Persona p2 = new Persona("b");
		Persona p3 = new Persona("c");
		Persona[] conocidos = {p2, p3};
		Persona p1 = new Persona("a", conocidos);
		ColaDeAmigos c = new ColaDeAmigos();
		c.pedirVez(p1, 1);
		c.colarA(p2);
		c.colarA(p3);
	}

	@Test
	public void testTDDatender() {
		Persona p1 = new Persona("a");
		ColaDeAmigos cola = new ColaDeAmigos();
		cola.pedirVez(p1, 0);
		cola.atender();
		assertFalse(cola.estaEnCola(p1));
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDatenderNoQuedaNadie() {
		ColaDeAmigos cola = new ColaDeAmigos();
		cola.atender();
	}
	
}