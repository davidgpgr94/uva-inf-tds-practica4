package es.uva.inf.tds.practica4_davidgo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ColaDeAmigosFixtureColaConDosReservadoresTDDTest.class,
		ColaDeAmigosFixtureColaConUnReservadorParaDosAmigosYUnoColadoTDDTest.class,
		ColaDeAmigosFixtureColaConUnReservadorParaUnAmigoYNingunoColadoTDDTest.class, ColaDeAmigosTDDTest.class })
public class AllColaDeAmigosTests {

}
