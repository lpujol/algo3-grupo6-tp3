package modeloTests;

import modelo.CargadorDeNiveles;
import modelo.Juego;
import modelo.Laberinto;
import modelo.Nivel;
import modelo.Posicion;
import modelo.Puerta;
import junit.framework.TestCase;

public class PuertaTests extends TestCase {

	private Juego juego;
	private Nivel nivel;
	private CargadorDeNiveles cargador;
	private Laberinto laberinto;
	
	protected void setUp() throws Exception {
		super.setUp();
		super.setUp();
		this.juego = new Juego();
		this.nivel = null;
		this.laberinto = null;
		this.cargador = new CargadorDeNiveles(juego, this.laberinto);
		this.nivel = cargador.getSiguiente();
		this.laberinto = new Laberinto(nivel, juego);
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
			Puerta puerta = new Puerta(new Posicion(0, -1), this.laberinto);
			fail();
		} catch (IllegalArgumentException e) {
			assertNotNull(e);
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
		assertFalse(puerta.esOcupable());
	}
	
	// Testea que comer una puerta no pueda ser comida
	public void testComerPuertaCambiaElEstado() {
		Puerta puerta = new Puerta(new Posicion(1, 1), this.laberinto);
		puerta.comer();
		assertFalse(puerta.comido());
	}

}
