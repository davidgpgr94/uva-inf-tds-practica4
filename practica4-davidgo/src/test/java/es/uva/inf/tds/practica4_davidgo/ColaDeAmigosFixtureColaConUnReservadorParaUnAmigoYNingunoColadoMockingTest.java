package es.uva.inf.tds.practica4_davidgo;

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
public class ColaDeAmigosFixtureColaConUnReservadorParaUnAmigoYNingunoColadoMockingTest {

	private ColaDeAmigos cola;
	
	@Mock
	private Persona p1, p2, p3, p4, p5;
	
	@Before
	public void setUp() throws Exception {
		//p1 considera amigos a p2 y p3
		//p1 considera conocidos a p2, p3 y p4
		//p1 ha pedido vez para 1 amigo
		//p5 no es ni conocido ni amigo de nadie
		p1 = createMock(Persona.class);
		p2 = createMock(Persona.class);
		p3 = createMock(Persona.class);
		p4 = createMock(Persona.class);
		p5 = createMock(Persona.class);
		
		cola = new ColaDeAmigos();
		cola.pedirVez(p1, 1);
	}

	@After
	public void tearDown() throws Exception {
		verify(p1);
		verify(p2);
		verify(p3);
		verify(p4);
		verify(p5);
	}
	
	@Test
	public void testMOCKpuedeColarseTrue() {
		expect(p1.esAmigo(p2)).andReturn(true).anyTimes();
		replay(p1);
		replay(p2);
		replay(p3);
		replay(p4);
		replay(p5);
		
		assertTrue(cola.puedeColarse(p2));
	}
	
	@Test
	public void testMOCKpuedeColarseFalse() {
		expect(p1.esAmigo(p4)).andReturn(false).anyTimes();
		expect(p1.esAmigo(p5)).andReturn(false).anyTimes();
		expect(p1.esAmigo(p2)).andReturn(true).anyTimes();
		expect(p1.esAmigo(p3)).andReturn(true).anyTimes();
		replay(p1);
		replay(p2);
		replay(p3);
		replay(p4);
		replay(p5);
		
		assertFalse(cola.puedeColarse(p1));
		assertFalse(cola.puedeColarse(p4));
		assertFalse(cola.puedeColarse(p5));
		cola.colarA(p2);
		assertFalse(cola.puedeColarse(p3));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMOCKpuedeColarseNull() {
		replay(p1);
		replay(p2);
		replay(p3);
		replay(p4);
		replay(p5);
		@SuppressWarnings("unused")
		boolean res = cola.puedeColarse(null);
	}

	@Test
	public void testMOCKcuantosPuedeColar() {
		replay(p1);
		replay(p2);
		replay(p3);
		replay(p4);
		replay(p5);
		assertEquals(1, cola.cuantosPuedeColar(p1));
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMOCKcuantosPuedeColarAlguienQueNoEsReservador() {
		expect(p1.esAmigo(p2)).andReturn(true).anyTimes();
		replay(p1);
		replay(p2);
		replay(p3);
		replay(p4);
		replay(p5);
		cola.colarA(p2);
		@SuppressWarnings("unused")
		int res = cola.cuantosPuedeColar(p2);
	}

	@Test(expected = IllegalStateException.class)
	public void testMOCKcuantosPuededColarAlguienQueNoEstaEnCola() {
		replay(p1);
		replay(p2);
		replay(p3);
		replay(p4);
		replay(p5);
		@SuppressWarnings("unused")
		int res = cola.cuantosPuedeColar(p2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMOCKcuantosPuedeColarNull() {
		replay(p1);
		replay(p2);
		replay(p3);
		replay(p4);
		replay(p5);
		@SuppressWarnings("unused")
		int res = cola.cuantosPuedeColar(null);
	}
	
}