package modeloTests;

import java.util.ArrayList;

import modelo.Bloque;
import modelo.CargadorDeNiveles;
import modelo.FantasmaRojo;
import modelo.Juego;
import modelo.Nivel;
import modelo.PosicionPacmanInexistenteException;
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
			
		
		Bloque bloque2 = bloques.remove(29);
		assertTrue(bloque2.esOcupablePorFantasma(new FantasmaRojo(juego.getLaberinto(),1)));
	}
	
	/*
	 * 
	 * Prueba que no se puede cargar un nivel si en el archivo fuente
	 * no hay una posicion asiganada para pacman.
	 * 
	 * */
	public void testCargaSinPacmanError(){
		CargadorDeNiveles miCargador=new CargadorDeNiveles(juego, juego.getLaberinto());
		try{
			miCargador.cargar(nivel,"nivelTest.txt");
			fail();
		
		}catch(PosicionPacmanInexistenteException e ){
			assertTrue(true);
		}
		
	};
	
}
