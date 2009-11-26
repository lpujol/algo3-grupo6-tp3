package modeloTests;

import java.util.ArrayList;

import modelo.Bloque;
import modelo.CargadorDeNiveles;
import modelo.Juego;
import modelo.Laberinto;
import modelo.Nivel;
import junit.framework.TestCase;

public class CargadorDeNivelesTests extends TestCase {

	private Juego juego;
	private Nivel nivel;
	private Laberinto laberinto;
	
	protected void setUp() throws Exception {
		super.setUp();
		juego = new Juego();
		nivel = null;
		laberinto = null;
		CargadorDeNiveles cargador = new CargadorDeNiveles(this.juego, this.laberinto);
		nivel = cargador.getSiguiente();
	}
	
	// Testea que le de al nivel devuelto su numero correcto
	public void testCantidadDeNiveles() {
		assertTrue(this.nivel.getNumero() == 1);
	}

	// Testea que el nivel devuelto tiene los bloques especificados en el
	// archivo de origen
	public void testBloquesCorrectos() {
		ArrayList<Bloque> bloques = this.nivel.getBloques();
		Bloque bloque = bloques.remove(bloques.size() - 1);
		assertTrue(bloque.getPosicion().getX() == 28);
		assertTrue(bloque.getPosicion().getY() == 31);
		Bloque bloque2 = bloques.remove(29);
		assertTrue(bloque2.esOcupable());
	}
}
