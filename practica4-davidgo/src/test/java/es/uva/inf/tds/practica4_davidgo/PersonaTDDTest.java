package es.uva.inf.tds.practica4_davidgo;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author davidgo
 *
 */
public class PersonaTDDTest {

	@Test
	public void testTDDConstructorPersona() {
		Persona p = new Persona("Pepe");
		Persona[] exp = {};
		assertArrayEquals(exp, p.getAmigos());
		assertArrayEquals(exp, p.getConocidos());
		assertEquals("Pepe", p.getNombre());
	}

	@Test
	public void testTDDConstructorPersonaConConocidos() {
		Persona[] conocidos = {new Persona("Eva"), new Persona("Manu")};
		Persona p = new Persona("Pepe", conocidos);
		assertArrayEquals(conocidos, p.getConocidos());
		assertEquals("Pepe", p.getNombre());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDConstructorConNombreNulo() {
		@SuppressWarnings("unused")
		Persona p = new Persona(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDConstructorConNombreVacio() {
		@SuppressWarnings("unused")
		Persona p = new Persona("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDConstructorConListaConocidosVacia() {
		Persona[] conocidos = {};
		@SuppressWarnings("unused")
		Persona p = new Persona("Pepe", conocidos);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDConstructorConConocidosNulos() {
		Persona[] conocidos = {null, null};
		@SuppressWarnings("unused")
		Persona p = new Persona("Pepe", conocidos);
	}

	@Test
	public void testTDDSerAmigoDe() {
		Persona p1 = new Persona("a");
		Persona[] conocidos = {p1};
		Persona p2 = new Persona("b", conocidos);
		p2.serAmigoDe(p1);
		Persona[] amigos = {p1};
		assertArrayEquals(amigos, p2.getAmigos());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDSerAmigoDeSinQueSeaConocidoPreviamente() {
		Persona p1 = new Persona("a");
		Persona p2 = new Persona("b");
		p2.serAmigoDe(p1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDSerAmigoDeNULL() {
		Persona p = new Persona("a");
		Persona p2 = null;
		p.serAmigoDe(p2);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDSerAmigoDeUnAmigo() {
		Persona p1 = new Persona("a");
		Persona[] conocidos = {p1};
		Persona p2 = new Persona("b", conocidos);
		p2.serAmigoDe(p1);
		p2.serAmigoDe(p1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDSerAmigoDeSiMismo() {
		Persona p1 = new Persona("a");
		Persona[] conocidos = {p1};
		Persona p2 = new Persona("b", conocidos);
		p2.serAmigoDe(p2);
	}

	@Test
	public void testTDDConocerA() {
		Persona p1 = new Persona("a");
		Persona p2 = new Persona("b");
		Persona[] nuevoConocido = {p2};
		p1.conocerA(nuevoConocido);
		assertArrayEquals(nuevoConocido, p1.getConocidos());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDConocerAYaEsConocido() {
		Persona p2 = new Persona("b");
		Persona[] conocidos = {p2};
		Persona p1 = new Persona("a", conocidos);
		p1.conocerA(conocidos);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDConocerAUnoMismo() {
		Persona p1 = new Persona("a");
		Persona[] nConocidos = {p1};
		p1.conocerA(nConocidos);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDConocerAalgunoEsNull() {
		Persona p1 = new Persona("a");
		Persona p2 = new Persona("b");
		Persona[] nConocidos = {p2, null};
		p1.conocerA(nConocidos);
	}

	@Test
	public void testTDDequals() {
		Persona p1 = new Persona("a");
		Persona p2 = new Persona("b");
		Persona[] conocidos = {p1, p2};
		Persona p3 = new Persona("c", conocidos);
		p3.serAmigoDe(p1);
		
		Persona pEqualsP3 = new Persona("c", conocidos);
		pEqualsP3.serAmigoDe(p1);
		
		assertTrue(p3.equals(pEqualsP3));
	}
	
	@Test
	public void testTDDequalsFalseDistintoNombre() {
		Persona p1 = new Persona("a");
		Persona p2 = new Persona("b");
		Persona[] conocidos = {p1, p2};
		Persona p3 = new Persona("c", conocidos);
		p3.serAmigoDe(p1);
		
		Persona pNotEqualsP3 = new Persona("d", conocidos);
		pNotEqualsP3.serAmigoDe(p1);
		
		assertFalse(p3.equals(pNotEqualsP3));
	}
	
	@Test
	public void testTDDequalsFalseDistintosConocidos() {
		Persona p1 = new Persona("a");
		Persona p2 = new Persona("b");
		Persona[] conocidos = {p1, p2};
		Persona p3 = new Persona("c", conocidos);
		p3.serAmigoDe(p1);
		
		Persona[] conocidos2 = {p1};
		Persona pNotEqualsP3 = new Persona("c", conocidos2);
		pNotEqualsP3.serAmigoDe(p1);
		
		assertFalse(p3.equals(pNotEqualsP3));
	}
	
	@Test
	public void testTDDequalsFalseDistintosAmigos() {
		Persona p1 = new Persona("a");
		Persona p2 = new Persona("b");
		Persona[] conocidos = {p1, p2};
		Persona p3 = new Persona("c", conocidos);
		p3.serAmigoDe(p1);
		
		Persona pNotEqualsP3 = new Persona("c", conocidos);
		
		assertFalse(p3.equals(pNotEqualsP3));
	}
	
	@Test
	public void testTDDequalsFalseNoEsUnaPersona() {
		Persona p1 = new Persona("a");
		Persona p2 = new Persona("b");
		Persona[] conocidos = {p1, p2};
		Persona p3 = new Persona("c", conocidos);
		p3.serAmigoDe(p1);
		
		String auxTest = "string para test";
		
		assertFalse(p3.equals(auxTest));
	}
}