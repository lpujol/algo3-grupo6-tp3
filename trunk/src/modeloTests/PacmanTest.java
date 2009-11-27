package modeloTests;

import modelo.Direccion;
import modelo.Juego;
import modelo.Pacman;
import modelo.Posicion;
import junit.framework.TestCase;

public class PacmanTest extends TestCase {
	
	private Juego unJuego;
	private Pacman unPacman;
	private Posicion unaPosicion;
	
		
		protected void setUp() throws Exception {
	        super.setUp();
	    
	        unJuego = new Juego();
	        unaPosicion= unJuego.getLaberinto().getPacman().getPosicion();
	        unPacman= unJuego.getLaberinto().getPacman();
	        
	}


		public void testVivir() {
			fail("Not yet implemented");
		}

		
		/*prueba  como la cantidad de vidas se va  actualizando
		 *  medida que pacman  va siendo  comido 
		 */
		public void testGetCantidadVidas() {
			assertEquals(unPacman.getCantidadVidas(),3);
			unPacman.comer();
			assertEquals(unPacman.getCantidadVidas(),2);
			unPacman.comer();
			assertEquals(unPacman.getCantidadVidas(),1);
		}
		

		/*se prueba como pacman  luego de moverse cambia de  posicion */
		public void testMoverse() {
			
			assertEquals(unPacman.getPosicion(),unaPosicion);
			unPacman.moverse();
			assertTrue(unPacman.getPosicion()!=unaPosicion);
			
		}
		
		/*se prueba que al empezar el juego pacman puede ocupar
		 * las posiciones de su izquierda y derecha */
		public void testPosicionSiguienteOcupableOk(){
			
			assertTrue(unPacman.posicionSiguienteOcupable());
			unPacman.cambiarDireccion(Direccion.Izquierda);
			assertTrue(unPacman.posicionSiguienteOcupable());
			
		}
		
		/*prueba que el  metodo no hace lo que no tiene que hacer 
		 * al empezar el juego le cambiamos  la direccion hacia 
		 * arriba  encuentra una posicion no ocupable (pared)
		 */
		public void testPosicionSiguienteOcupableError(){
			
			unPacman.cambiarDireccion(Direccion.Arriba);
			assertFalse(unPacman.posicionSiguienteOcupable());
		}

		
		public void testComer() {
			
			assertEquals(unPacman.getCantidadVidas(),3);
			
			unPacman.comer();unPacman.comer();
			assertEquals(unPacman.getCantidadVidas(),1);
			
			
		}

	}



