package es.uva.inf.tds.practica4_davidgo;

import static org.junit.Assert.*;

import org.easymock.Mock;
import static org.easymock.EasyMock.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * 
 * @author davidgo
 *
 */
@Category(Isolation.class)
public class ColaDeAmigosFixtureColaConDosReservadoresMockingTest {

	private ColaDeAmigos cola;
	
	@Mock
	private Persona p1, p2, p3, p4, p5;
	
	@Before
	public void setUp() throws Exception {
		//p1 y p4 son los que piden vez
		//p1 considera amigos a p2 y p3
		//p4 considera amigo a p5
		//finalmente tenemos en la cola a p2, p1, p5, p4 en este orden
		p1 = createMock(Persona.class);
		p2 = createMock(Persona.class);
		p3 = createMock(Persona.class);
		p4 = createMock(Persona.class);
		p5 = createMock(Persona.class);
		expect(p1.esAmigo(p2)).andReturn(true).anyTimes();
		expect(p1.esAmigo(p3)).andReturn(true).anyTimes();
		expect(p1.esAmigo(p5)).andReturn(false).anyTimes();
		expect(p4.esAmigo(p2)).andReturn(false).anyTimes();
		expect(p4.esAmigo(p5)).andReturn(true).anyTimes();
		replay(p1);
		replay(p2);
		replay(p3);
		replay(p4);
		replay(p5);
		
		cola = new ColaDeAmigos();
		cola.pedirVez(p1, 2);
		cola.pedirVez(p4, 1);
		cola.colarA(p2);
		cola.colarA(p5);
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
	public void testMOCKnumeroAmigosReservados() {
		assertEquals(2, cola.numeroAmigosReservados(p1));
		assertEquals(1, cola.numeroAmigosReservados(p4));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMOCKnumeroAmigosReservadosNull() {
		@SuppressWarnings("unused")
		int res = cola.numeroAmigosReservados(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMOCKnumeroAmigosReservadosNoReservador() {
		@SuppressWarnings("unused")
		int res = cola.numeroAmigosReservados(p2);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMOCKnumeroAmigosReservadosNoEstaEnCola() {
		@SuppressWarnings("unused")
		int res = cola.numeroAmigosReservados(p3);
	}


	@Test
	public void testMOCKcoladosPor() {
		Persona[] expP1 = {p2};
		Persona[] expP4 = {p5};
		assertArrayEquals(expP1, cola.coladosPor(p1));
		assertArrayEquals(expP4, cola.coladosPor(p4));
	}
	
	@Test
	public void testMOCKcoladosPorTrasSerAtendido() {
		Persona[] expP1 = {p2};
		Persona[] expP4 = {p5};
		cola.atender();
		assertArrayEquals(expP1, cola.coladosPor(p1));
		assertArrayEquals(expP4, cola.coladosPor(p4));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMOCKcoladosPorNull() {
		@SuppressWarnings("unused")
		Persona[] res = cola.coladosPor(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMOCKcoladosPorNoReservador() {
		@SuppressWarnings("unused")
		Persona[] res = cola.coladosPor(p5);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMOCKcoladosPorNoEstaEnCola() {
		@SuppressWarnings("unused")
		Persona[] res = cola.coladosPor(p3);
	}
	
}