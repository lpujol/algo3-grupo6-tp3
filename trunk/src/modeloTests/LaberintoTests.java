package modeloTests;

import modelo.Bloque;
import modelo.Juego;
import modelo.Laberinto;
import modelo.Posicion;
import junit.framework.TestCase;

public class LaberintoTests extends TestCase {
	
	private Juego juego;
	private Laberinto laberinto;
	
	protected void setUp() throws Exception {
		super.setUp();
		this.juego = new Juego();
		this.laberinto = juego.getLaberinto();		
	}
	
	// Testea que el laberinto devuelva el bloque que se le pide.
	public void testObtenerBloque() {
		Bloque bloque1 = this.laberinto.getBloqueEnPosicion(new Posicion(8,8));
		assertTrue(bloque1.getClass().getSimpleName().equals("Pared"));
		Bloque bloque2 = this.laberinto.getBloqueEnPosicion(new Posicion(24,24));
		assertTrue(bloque2.getClass().getSimpleName().equals("Punto"));
	}
	
	// Testea que sea posible obtener exactamente el mismo bloque desde distintas
	// coordenadas.
	public void testObtenerMismoBloqueDePosicinesDistintas() {
		Bloque bloque1 = this.laberinto.getBloqueEnPosicion(new Posicion(8,8));
		Bloque bloque2 = this.laberinto.getBloqueEnPosicion(new Posicion(3,2));
		assertTrue(bloque1 == bloque2);
	}
	
	/*se prueba que al empezar el juego pacman puede ocupar
	 * las posiciones de su izquierda y derecha */
	/*public void testPosicionSiguienteOcupableOk(){
		
		assertTrue(unPacman.posicionSiguienteOcupable());
		unPacman.cambiarDireccion(Direccion.Izquierda);
		assertTrue(unPacman.posicionSiguienteOcupable());
		
	}
	
	/*prueba que el  metodo no hace lo que no tiene que hacer 
	 * al empezar el juego le cambiamos  la direccion hacia 
	 * arriba  encuentra una posicion no ocupable (pared)
	 */
	/*public void testPosicionSiguienteOcupableError(){
		
		unPacman.cambiarDireccion(Direccion.Arriba);			
		unPacman.vivir();
		unPacman.cambiarDireccion(Direccion.Arriba);
		assertFalse(unPacman.posicionSiguienteOcupable());
	}
    */
	
}

