package es.uva.inf.tds.practica4_davidgo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
	public void test() {
		fail("Not yet implemented");
	}

}
