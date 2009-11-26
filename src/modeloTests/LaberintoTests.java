package modeloTests;

import modelo.Bloque;
import modelo.CargadorDeNiveles;
import modelo.Juego;
import modelo.Laberinto;
import modelo.Nivel;
import modelo.Posicion;
import junit.framework.TestCase;

public class LaberintoTests extends TestCase {
	
	private Juego juego;
	private Nivel nivel;
	private CargadorDeNiveles cargador;
	private Laberinto laberinto;
	
	protected void setUp() throws Exception {
		super.setUp();
		this.juego = new Juego();
		this.nivel = null;
		this.laberinto = null;
		this.cargador = new CargadorDeNiveles(juego, this.laberinto);
		this.nivel = cargador.getSiguiente();
		this.laberinto = new Laberinto(nivel, juego);
	}
	
	// Testea que el laberinto devuelva el bloque que se le pide.
	public void testObtenerBloque() {
		Bloque bloque1 = this.laberinto.getBloqueEnPosicion(new Posicion(8,8));
		assertTrue(bloque1.getClass().getSimpleName().equals("Pared"));
		Bloque bloque2 = this.laberinto.getBloqueEnPosicion(new Posicion(24,8));
		assertTrue(bloque2.getClass().getSimpleName().equals("Pared"));
	}
	
	// Testea que sea posible obtener exactamente el mismo bloque desde distintas
	// coordenadas.
	public void testObtenerMismoBloqueDePosicinesDistintas() {
		Bloque bloque1 = this.laberinto.getBloqueEnPosicion(new Posicion(8,8));
		Bloque bloque2 = this.laberinto.getBloqueEnPosicion(new Posicion(3,2));
		assertTrue(bloque1 == bloque2);
	}
}
