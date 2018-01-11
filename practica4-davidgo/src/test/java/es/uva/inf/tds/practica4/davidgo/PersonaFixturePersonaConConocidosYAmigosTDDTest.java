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
@Category({Unit.class, TDD.class, Integration.class})
public class PersonaFixturePersonaConConocidosYAmigosTDDTest {

	private Persona p1, p2, p3;
	private Persona[] conocidos;
	
	@Before
	public void setUp() throws Exception {
		//p1 considera amigo a p2
		//p1 considera conocido a p2 y p3
		p2 = new Persona("b");
		p3 = new Persona("c");
		Persona[] aux = {p2, p3};
		conocidos = aux;
		p1 = new Persona("a", conocidos);
		p1.serAmigoDe(p2);
	}

	@Test
	public void testTDDEsConocidoSiendoAmigo() {
		assertTrue(p1.esConocido(p2));
	}
	
	@Test
	public void testTDDEsAmigoTrue() {
		assertTrue(p1.esAmigo(p2));
	}

	@Test
	public void testTDDEsAmigoFalse() {
		assertFalse(p1.esAmigo(p3));
	}
	
	@Test
	public void testTDDEsAmigoFalseNiConocido() {
		Persona p4 = new Persona("d");
		assertFalse(p1.esAmigo(p4));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDEsAmigoUnoMismo() {
		@SuppressWarnings("unused")
		boolean res = p1.esAmigo(p1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDEsAmigoArgumentoNull() {
		@SuppressWarnings("unused")
		boolean res = p1.esAmigo(null);
	}
	
	@Test
	public void testTDDDejarSerAmigoDe() {
		p1.dejarSerAmigoDe(p2);
		Persona[] exp = {};
		assertArrayEquals(exp, p1.getAmigos());
		assertArrayEquals(conocidos, p1.getConocidos());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDDejarSerAmigoDeUnConocidoNoAmigo() {
		p1.dejarSerAmigoDe(p3);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDDejarSerAmigoDeNiAmigoNiConocido() {
		Persona p4 = new Persona("d");
		p1.dejarSerAmigoDe(p4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDDejarSerAmigoDeNull() {
		p1.dejarSerAmigoDe(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDDejarSerAmigoDeUnoMismo() {
		p1.dejarSerAmigoDe(p1);
	}
	
}
