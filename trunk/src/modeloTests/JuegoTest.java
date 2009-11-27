package modeloTests;

import modelo.CargadorDeNiveles;
import modelo.Juego;
import modelo.Laberinto;
import modelo.Nivel;
import modelo.Pacman;
import modelo.Posicion;
import junit.framework.TestCase;

public class JuegoTest extends TestCase {
	
	private Juego unJuego;
	private Nivel nivel;
	private CargadorDeNiveles cargador;
	private Laberinto laberinto;
	private Pacman unPacman;
	private Posicion unaPosicion;
	
		protected void setUp() throws Exception {
	        super.setUp();
	        
	        unaPosicion=  new Posicion(40,20);
	        unJuego = new Juego();
	        nivel = null;
	        laberinto = null;
	        unPacman= new Pacman(unaPosicion,unJuego.getLaberinto());
	        

	}

		/*s e prueba  que  cuando pasa de nivel 
		 el nivel  se actualiza
		 */
		public void testPasarNivel() {
			
			Nivel unNivel= unJuego.getLaberinto().getNivel();
			unJuego.pasarNivel();
			Nivel otroNivel= unJuego.getLaberinto().getNivel();
			assertFalse(unNivel==otroNivel);
			
		}

		
		/* se  come  a pacman 3 veces  y se  prueva  que el  juego
		 *   esta  perdido*/
		public void testPerdido() {

			unJuego.getLaberinto().getPacman().comer();
			unJuego.getLaberinto().getPacman().comer();
			unJuego.getLaberinto().getPacman().comer();
			
			assertTrue(unJuego.perdido());

			
		}
	   /*  se  come el punto de poder y se prueba  que 
	    * se  activo  el punto de poder
	    */
		public void testPuntoDePoderActivo() {
			
			unJuego.puntoDePoderComido();
			assertTrue(unJuego.puntoDePoderActivo());
		}

		
		public void testFantasmaComido() {
			fail("Not yet implemented");
		}

		
		/* se prueba que  ante el mensaje del juego pacmanComido()
		 * pacman reducio  su vida  una unidad
		 */
		public void testPacmanComido() {
			
			unJuego.pacmanComido();
			assertEquals(2,unJuego.getLaberinto().getPacman().getCantidadVidas());
		}

	}



