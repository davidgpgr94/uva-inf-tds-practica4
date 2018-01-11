package es.uva.inf.tds.practica4.davidgo;

import static org.junit.Assert.*;

import org.easymock.Mock;
import static org.easymock.EasyMock.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * 
 * @author davidgo
 *
 */
@Category(Isolation.class)
public class ColaDeAmigosFixtureColaConUnReservadorParaDosAmigosYUnoColadoMockingTest {
	
	private ColaDeAmigos cola;
	
	@Mock
	private Persona p1, p2, p3;

	@Before
	public void setUp() throws Exception {
		//en la cola estan p2 y luego p1 en este orden.
		//p1 todavía puede colar a 1 amigo más
		p1 = createMock(Persona.class);
		p2 = createMock(Persona.class);
		p3 = createMock(Persona.class);
		expect(p1.esAmigo(p2)).andReturn(true).anyTimes();
		expect(p1.esAmigo(p3)).andReturn(true).anyTimes();
		replay(p1);
		replay(p2);
		replay(p3);
		
		cola = new ColaDeAmigos();
		cola.pedirVez(p1, 2);
		cola.colarA(p2);
	}
	
	@After
	public void tearDown() throws Exception {
		verify(p1);
		verify(p2);
		verify(p3);
	}

	@Test
	public void testMOCKsiguiente() {
		assertEquals(p2, cola.siguiente());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMOCKsiguienteNoHayNadieEnLaCola() {
		cola = new ColaDeAmigos();
		cola.siguiente();
	}

	@Test
	public void testMOCKhaySiguienteTrue() {
		assertTrue(cola.haySiguiente());
	}
	
	@Test
	public void testMOCKhaySiguienteFalse() {
		cola = new ColaDeAmigos();
		assertFalse(cola.haySiguiente());
	}

	@Test
	public void testMOCKesReservadorTrue() {
		assertTrue(cola.esReservador(p1));
	}
	
	@Test
	public void testMOCKesReservadorFalse() {
		assertFalse(cola.esReservador(p2));
		assertFalse(cola.esReservador(p3));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMOCKesReservadorNull() {
		@SuppressWarnings("unused")
		boolean res = cola.esReservador(null);
	}
	
	@Test
	public void testMOCKestaEnColaTrue() {
		assertTrue(cola.estaEnCola(p1));
		assertTrue(cola.estaEnCola(p2));
	}
	
	@Test
	public void testMOCKestaEnColaFalse() {
		assertFalse(cola.estaEnCola(p3));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMOCKestaEnColaNull() {
		@SuppressWarnings("unused")
		boolean res = cola.estaEnCola(null);
	}

}