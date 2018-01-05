package es.uva.inf.tds.practica4_davidgo;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonaCajaNegraTest {

	@Test
	public void testCajaNegraConstructorUnParametroNombreUnaLetra() {
		Persona p = new Persona("a");
		assertNull(p.getAmigos());
		assertNull(p.getConocidos());
		assertEquals("a", p.getNombre());
	}
	
	@Test
	public void testCajaNegraConstructorDosParametrosNombreUnaLetraUnConocido() {
		Persona[] conocidos = {new Persona("a")};
		Persona p = new Persona("b", conocidos);
		assertNull(p.getAmigos());
		assertArrayEquals(conocidos, p.getConocidos());
		assertEquals("b", p.getNombre());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCajaNegraConstructorDosArgumentosNombreValidoPrimerConocidoNuloDemasNoNulos() {
		Persona[] conocidos = {null, new Persona("a"), new Persona("b")};
		@SuppressWarnings("unused")
		Persona p = new Persona("c", conocidos);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCajaNegraConstructorDosArgumentosNombreValidoUltimoConocidoNuloDemasNoNulos() {
		Persona[] conocidos = {new Persona("a"), new Persona("b"), null};
		@SuppressWarnings("unused")
		Persona p = new Persona("c", conocidos);
	}
	
}
