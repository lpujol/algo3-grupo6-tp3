package modeloTests;

import junit.framework.TestCase;
import modelo.Punto;

public class PuntoTests extends TestCase {

	// Testea que un punto creado en una posicion valida tenga asignada la
	// posicion una vez creado
	public void testCrearPuntoEnPosicionValida() {
		Punto punto = new Punto(1, 1);
		assertTrue(punto.getX() == 1);
		assertTrue(punto.getY() == 1);
	}

	// Testea que un punto creado en una posicion invalida lance una excepcion
	public void testCrearPuntoEnPosicionInvalida() {
		try {
			Punto punto = new Punto(0, -1);
			fail();
		} catch (IllegalArgumentException e) {
			assertNotNull(e);
		}
	}
	
	// Testea que un punto recien creado no esta comido
	public void testPuntoRecienCreadoNoEstaComido() {
		Punto punto = new Punto(1, 1);
		assertTrue(punto.comido() == false);
	}
	
	// Testea que un punto pueda ser ocupado
	public void testPuntoEsOcupable() {
		Punto punto = new Punto(1, 1);
		assertTrue(punto.esOcupable());
	}
	
	// Testea que comer un punto cambie el estado correctamente
	public void testComerPuntoCambiaElEstado() {
		Punto punto = new Punto(1, 1);
		punto.comer();
		assertTrue(punto.comido() == true);
	}

}
