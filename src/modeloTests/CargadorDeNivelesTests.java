package modeloTests;

import java.util.ArrayList;

import modelo.Bloque;
import modelo.CargadorDeNiveles;
import modelo.Juego;
import modelo.Nivel;
import junit.framework.TestCase;

public class CargadorDeNivelesTests extends TestCase {

	// Testea que le de al nivel devuelto su numero correcto
	public void testCantidadDeNiveles() {
		Juego juego = new Juego();
		Nivel nivel = null;
		CargadorDeNiveles cargador = new CargadorDeNiveles(juego);
		nivel = cargador.getSiguiente();
		assertTrue(nivel.getNumero() == 1);
	}

	// Testea que el nivel devuelto tiene los bloques especificados en el
	// archivo de origen
	public void testBloquesCorrectos() {
		Juego juego = new Juego();
		Nivel nivel = null;
		CargadorDeNiveles cargador = new CargadorDeNiveles(juego);
		nivel = cargador.getSiguiente();
		ArrayList<Bloque> bloques = nivel.getBloques();
		Bloque bloque = bloques.remove(bloques.size() - 1);
		assertTrue(bloque.getPosicion().getX() == 28);
		assertTrue(bloque.getPosicion().getY() == 31);
		Bloque bloque2 = bloques.remove(29);
		assertTrue(bloque2.esOcupable());
	}
}
