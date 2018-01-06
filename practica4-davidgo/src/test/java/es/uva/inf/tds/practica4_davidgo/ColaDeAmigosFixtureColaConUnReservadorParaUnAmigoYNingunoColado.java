package es.uva.inf.tds.practica4_davidgo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ColaDeAmigosFixtureColaConUnReservadorParaUnAmigoYNingunoColado {

	private Persona p1, p2, p3, p4, p5;
	private ColaDeAmigos cola;
	
	@Before
	public void setUp() throws Exception {
		//p1 considera amigos a p2 y p3
		//p1 considera conocidos a p2, p3 y p4
		//p1 ha pedido vez para 1 amigo
		//p5 no es ni conocido ni amigo de nadie
		p2 = new Persona("b");
		p3 = new Persona("c");
		p4 = new Persona("d");
		p5 = new Persona("e");
		Persona[] conocidos = {p2, p3, p4};
		p1 = new Persona("a", conocidos);
		p1.serAmigoDe(p2);
		p1.serAmigoDe(p3);
		
		cola = new ColaDeAmigos();
		cola.pedirVez(p1, 1);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
