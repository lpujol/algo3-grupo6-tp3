package modeloTests;

import junit.framework.TestCase;
import modelo.Juego;
import modelo.Laberinto;
import modelo.Posicion;
import modelo.PuntoDePoder;

public class PuntoDePoderTests extends TestCase {
	
	private Juego juego;
	private Laberinto laberinto;
	
	protected void setUp() throws Exception {
		super.setUp();
		super.setUp();
		this.juego = new Juego();
		this.laberinto = juego.getLaberinto();

	}
	
	// Testea que un punto creado en una posicion valida tenga asignada la
	// posicion una vez creado
	public void testCrearPuntoEnPosicionValida() {
		PuntoDePoder punto = new PuntoDePoder(new Posicion(1, 1), this.laberinto);
		assertTrue(punto.getPosicion().getX() == 1);
		assertTrue(punto.getPosicion().getY() == 1);
	}

	// Testea que un punto creado en una posicion invalida lance una excepcion
	public void testCrearPuntoEnPosicionInvalida() {
		try {
			@SuppressWarnings("unused")
			PuntoDePoder punto = new PuntoDePoder(new Posicion(0, -1), this.laberinto);
			fail();
		} catch (IllegalArgumentException e) {
			assertNotNull(e);
		}
	}
	
	// Testea que un punto recien creado no esta comido
	public void testPuntoRecienCreadoNoEstaComido() {
		PuntoDePoder punto = new PuntoDePoder(new Posicion(1, 1), this.laberinto);
		assertTrue(punto.comido() == false);
	}
	
	// Testea que un punto pueda ser ocupado
	public void testPuntoEsOcupable() {
		PuntoDePoder punto = new PuntoDePoder(new Posicion(1, 1), this.laberinto);
		assertTrue(punto.esOcupable(null));
	}
	
	// Testea que comer un punto cambie el estado correctamente
	public void testComerPuntoCambiaElEstado() {
		PuntoDePoder punto = new PuntoDePoder(new Posicion(1, 1), this.laberinto);
		punto.comer();
		assertTrue(punto.comido() == true);
	}
	
}
