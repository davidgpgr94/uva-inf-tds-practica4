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
		assertArrayEquals(null, p.getAmigos());
		assertArrayEquals(null, p.getConocidos());
		assertEquals("Pepe", p.getNombre());
	}

	@Test
	public void testTDDConstructorPersonaConConocidos() {
		Persona[] conocidos = {new Persona("Eva"), new Persona("Manu")};
		Persona p = new Persona("Pepe", conocidos);
		assertArrayEquals(conocidos, p.getConocidos());
		assertEquals("Pepe", p.getNombre());
	}

}
