package modeloTests;

import java.util.ArrayList;

import modelo.Bloque;
import modelo.Juego;
import modelo.Nivel;
import junit.framework.TestCase;

public class CargadorDeNivelesTests extends TestCase {

	private Juego juego;
	private Nivel nivel;
	
	/*
	 * se testea el cargador de niveles indirectamente
	 * ya que no hay forma de utilizarlo de manera directa
	 */
	
	protected void setUp() throws Exception {
		super.setUp();
		juego = new Juego();
		nivel = juego.getLaberinto().getNivel();	
		//CargadorDeNiveles cargador = new CargadorDeNiveles(this.juego, this.laberinto);
		//nivel=cargador.cargar(new Nivel("nivel.txt",juego,laberinto), "nivel.txt");
	}
	
	// Testea que le de al nivel devuelto su numero correcto

	public void testCantidadDeNiveles() {
		assertTrue(this.nivel.getNumero() == 1);
	}

	// Testea que el nivel devuelto tiene los bloques especificados en el
	// archivo de origen
	public void testBloquesCorrectos() {
		ArrayList<Bloque> bloques = this.nivel.getBloques();
		
		assertTrue(28*31==bloques.size());
		
		//Bloque bloque = bloques.remove(bloques.size() - 1);
		//Posicion posicion=laberinto.aCoordenadasReales(new Posicion(28,31));
		//assertTrue(bloque.getPosicion().getX() == posicion.getX());
		//assertTrue(bloque.getPosicion().getY() == posicion.getY());
		
		Bloque bloque2 = bloques.remove(29);
		assertTrue(bloque2.esOcupable());
	}
}
