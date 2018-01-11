package es.uva.inf.tds.practica4.davidgo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PersonaCajaNegraTest.class, PersonaFixturePersonaConConocidosTDDTest.class,
		PersonaFixturePersonaConConocidosYAmigosTDDTest.class, PersonaTDDTest.class })
public class AllPersonaTests {

}
