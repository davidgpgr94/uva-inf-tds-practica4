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
public class ColaDeAmigosFixtureColaConDosReservadoresTDDTest {

	private Persona p1, p2, p3, p4, p5;
	private ColaDeAmigos cola;
	
	@Before
	public void setUp() throws Exception {
		//p1 y p4 son los que piden vez
		//p1 considera amigos a p2 y p3
		//p4 considera amigo a p5
		//finalmente tenemos en la cola a p2, p1, p5, p4 en este orden
		p2 = new Persona("b");
		p3 = new Persona("c");
		p5 = new Persona("e");
		Persona[] conocidosP1 = {p2, p3};
		Persona[] conocidosP4 = {p5};
		p1 = new Persona("a", conocidosP1);
		p4 = new Persona("d", conocidosP4);
		p1.serAmigoDe(p2);
		p1.serAmigoDe(p3);
		p4.serAmigoDe(p5);
		
		cola = new ColaDeAmigos();
		cola.pedirVez(p1, 2);
		cola.pedirVez(p4, 1);
		cola.colarA(p2);
		cola.colarA(p5);
	}

	@Test
	public void testTDDnumeroAmigosReservados() {
		assertEquals(2, cola.numeroAmigosReservados(p1));
		assertEquals(1, cola.numeroAmigosReservados(p4));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDnumeroAmigosReservadosNull() {
		@SuppressWarnings("unused")
		int res = cola.numeroAmigosReservados(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDnumeroAmigosReservadosNoReservador() {
		@SuppressWarnings("unused")
		int res = cola.numeroAmigosReservados(p2);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDnumeroAmigosReservadosNoEstaEnCola() {
		@SuppressWarnings("unused")
		int res = cola.numeroAmigosReservados(p3);
	}


	@Test
	public void testTDDcoladosPor() {
		Persona[] expP1 = {p2};
		Persona[] expP4 = {p5};
		assertArrayEquals(expP1, cola.coladosPor(p1));
		assertArrayEquals(expP4, cola.coladosPor(p4));
	}
	
	@Test
	public void testTDDcoladosPorTrasSerAtendido() {
		Persona[] expP1 = {p2};
		Persona[] expP4 = {p5};
		cola.atender();
		assertArrayEquals(expP1, cola.coladosPor(p1));
		assertArrayEquals(expP4, cola.coladosPor(p4));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDcoladosPorNull() {
		@SuppressWarnings("unused")
		Persona[] res = cola.coladosPor(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDcoladosPorNoReservador() {
		@SuppressWarnings("unused")
		Persona[] res = cola.coladosPor(p5);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDcoladosPorNoEstaEnCola() {
		@SuppressWarnings("unused")
		Persona[] res = cola.coladosPor(p3);
	}
	
}