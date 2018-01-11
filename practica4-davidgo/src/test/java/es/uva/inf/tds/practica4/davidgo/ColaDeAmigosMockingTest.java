package es.uva.inf.tds.practica4.davidgo;

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
public class ColaDeAmigosMockingTest {

	@Mock
	private Persona p1, p2, p3;
	
	@Before
	public void setUp() throws Exception {
		p1 = createMock(Persona.class);
		expect(p1.getDni()).andReturn("a").anyTimes();
	}
	
	@After
	public void tearDown() throws Exception {
		verify(p1);
	}
	
	@Test
	public void testMOCKConstructorColaDeAmigos() {
		replay(p1);
		ColaDeAmigos c = new ColaDeAmigos();
		assertNotNull(c);
	}
	
	@Test
	public void testMOCKpedirVez() {
		expect(p1.getAmigos()).andReturn(new Persona[0]).anyTimes();
		expect(p1.getConocidos()).andReturn(new Persona[0]).anyTimes();
		replay(p1);
		ColaDeAmigos c = new ColaDeAmigos();
		c.pedirVez(p1, 0);
		assertEquals(p1, c.siguiente());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMOCKpedirVezPersonaNull() {
		replay(p1);
		ColaDeAmigos c = new ColaDeAmigos();
		c.pedirVez(null, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMOCKpedirVezNamigosNegativo() {
		replay(p1);
		ColaDeAmigos c = new ColaDeAmigos();
		c.pedirVez(p1, -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMOCKpedirVezParaMasDe10Amigos() {
		replay(p1);
		ColaDeAmigos c = new ColaDeAmigos();
		c.pedirVez(p1, 11);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMOCKpedirVezDosVecesSinSerAtendido() {
		replay(p1);
		ColaDeAmigos c = new ColaDeAmigos();
		c.pedirVez(p1, 0);
		c.pedirVez(p1, 0);
	}
	
	@Test(expected = IllegalStateException.class) 
	public void testMOCKpedirVezHabiendoSidoColado() {
		p2 = createMock(Persona.class);
		expect(p1.esAmigo(p2)).andReturn(true).anyTimes();
		replay(p1);
		replay(p2);
		
		ColaDeAmigos c = new ColaDeAmigos();
		c.pedirVez(p1, 1);
		c.colarA(p2);
		c.pedirVez(p2, 0);
		verify(p2);
	}
	
	@Test
	public void testMOCKcolarA() {
		p2 = createMock(Persona.class);
		expect(p1.esAmigo(p2)).andReturn(true).anyTimes();
		replay(p1);
		replay(p2);
		
		ColaDeAmigos c = new ColaDeAmigos();
		c.pedirVez(p1, 1);
		c.colarA(p2);
		assertEquals(p2, c.siguiente());
		verify(p2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMOCKcolarAPersonaNull() {
		replay(p1);
		ColaDeAmigos c = new ColaDeAmigos();
		c.pedirVez(p1, 1);
		c.colarA(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMOCKcolarAUnReservador() {
		replay(p1);
		
		ColaDeAmigos c = new ColaDeAmigos();
		c.pedirVez(p1, 1);
		c.colarA(p1);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMOCKcolarANoHayReservadorQueConsidereAmigoAlColado() {
		p2 = createMock(Persona.class);
		expect(p1.esAmigo(p2)).andReturn(false).anyTimes();
		replay(p1);
		replay(p2);
		
		ColaDeAmigos c = new ColaDeAmigos();
		c.pedirVez(p1, 1);
		c.colarA(p2);
		verify(p2);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMOCKcolarAElReservadorQueConsideraComoAmigoAlColadoYaHaColadoAlLosAmigosParaLosQuePidioVez() {
		p2 = createMock(Persona.class);
		p3 = createMock(Persona.class);
		expect(p1.esAmigo(p2)).andReturn(true).anyTimes();
		expect(p1.esAmigo(p3)).andReturn(true).anyTimes();
		replay(p1);
		replay(p2);
		replay(p3);
		
		ColaDeAmigos c = new ColaDeAmigos();
		c.pedirVez(p1, 1);
		c.colarA(p2);
		c.colarA(p3);
		verify(p2);
		verify(p3);
	}

	@Test
	public void testMOCKatender() {
		replay(p1);
		ColaDeAmigos cola = new ColaDeAmigos();
		cola.pedirVez(p1, 0);
		cola.atender();
		assertFalse(cola.estaEnCola(p1));
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMOCKatenderNoQuedaNadie() {
		replay(p1);
		ColaDeAmigos cola = new ColaDeAmigos();
		cola.atender();
	}
	
}