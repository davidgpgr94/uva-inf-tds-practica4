package es.uva.inf.tds.practica4_davidgo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * 
 * @author davidgo
 *
 */
@Category({Unit.class, TDD.class, Integration.class})
public class PersonaFixturePersonaConConocidosTDDTest {

	private Persona p1, p2, p3;
	private Persona[] conocidos;
	
	@Before
	public void setUp() throws Exception {
		p2 = new Persona("b");
		p3 = new Persona("c");
		Persona[] aux = {p2, p3};
		conocidos = aux;
		p1 = new Persona("a", conocidos);
	}

	@Test
	public void testTDDEsConocidoTrue() {
		assertTrue(p1.esConocido(p2));
	}
	
	@Test
	public void testTDDEsConocidoFalse() {
		Persona p4 = new Persona("d");
		assertFalse(p1.esConocido(p4));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTDDEsConocidoUnoMismo() {
		@SuppressWarnings("unused")
		boolean res = p1.esConocido(p1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDEsConocidoArgumentoNull() {
		@SuppressWarnings("unused")
		boolean res = p1.esConocido(null);
	}
	
}
