package es.uva.inf.tds.practica4.davidgo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * 
 * @author davidgo
 *
 */
@Category({Unit.class, Integration.class})
public class PersonaCajaNegraTest {

	@Test
	public void testCajaNegraConstructorUnParametroNombreUnaLetra() {
		Persona p = new Persona("a");
		Persona[] exp = {};
		assertArrayEquals(exp, p.getAmigos());
		assertArrayEquals(exp, p.getConocidos());
		assertEquals("a", p.getDni());
	}
	
	@Test
	public void testCajaNegraConstructorDosParametrosNombreUnaLetraUnConocido() {
		Persona[] conocidos = {new Persona("a")};
		Persona p = new Persona("b", conocidos);
		Persona[] expAmigos = {};
		assertArrayEquals(expAmigos, p.getAmigos());
		assertArrayEquals(conocidos, p.getConocidos());
		assertEquals("b", p.getDni());
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
