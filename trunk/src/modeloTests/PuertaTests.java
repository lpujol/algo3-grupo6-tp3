package modeloTests;

import modelo.FantasmaRojo;
import modelo.Juego;
import modelo.Laberinto;
import modelo.Posicion;
import modelo.PosicionInvalidaException;
import modelo.Puerta;
import junit.framework.TestCase;

public class PuertaTests extends TestCase {

	private Juego juego;
	private Laberinto laberinto;
	
	protected void setUp() throws Exception {
		super.setUp();
		super.setUp();
		this.juego = new Juego();
		this.laberinto = juego.getLaberinto();

	}
	
	// Testea que una puerta creada en una posicion valida tenga asignada la
	// posicion una vez creada
	public void testCrearPuertaEnPosicionValida() {
		Puerta puerta = new Puerta(new Posicion(1, 1), this.laberinto);
		assertTrue(puerta.getPosicion().getX() == 1);
		assertTrue(puerta.getPosicion().getY() == 1);
	}

	// Testea que una puerta creada en una posicion invalida lance una excepcion
	public void testCrearPuertadEnPosicionInvalida() {
		try {
			@SuppressWarnings("unused")
			Puerta puerta = new Puerta(new Posicion(0, -1), this.laberinto);
			fail();
		} catch (PosicionInvalidaException e) {
			assertTrue(true);
		}
	}
	
	// Testea que una puerta recien creada no este comida
	public void testPuertaRecienCreadaNoEstaComida() {
		Puerta puerta = new Puerta(new Posicion(1, 1), this.laberinto);
		assertTrue(puerta.comido() == false);
	}
	
	// Testea que una puerta no pueda ser ocupada
	public void testPuertaNoEsOcupable() {
		Puerta puerta = new Puerta(new Posicion(1, 1), this.laberinto);
		assertFalse(puerta.esOcupablePorFantasma(new FantasmaRojo(laberinto,1)));
	}
	
	// Testea que  una puerta no pueda ser comida
	public void testComerPuertaCambiaElEstado() {
		Puerta puerta = new Puerta(new Posicion(1, 1), this.laberinto);
		puerta.comer();
		assertFalse(puerta.comido());
	}

}
