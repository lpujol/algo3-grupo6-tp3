package modeloTests;

import modelo.FantasmaRojo;
import modelo.IEstrategia;
import modelo.Juego;
import modelo.Nivel;
import junit.framework.TestCase;

public class JuegoTest extends TestCase {
	
	private Juego unJuego;
	
		protected void setUp() throws Exception {
	        super.setUp();	        
	        unJuego = new Juego();
	        

	}

		/*s e prueba  que  cuando pasa de nivel 
		 el nivel  se actualiza
		 */
		public void testPasarNivel() {
			
			int numeroNivel= unJuego.getLaberinto().getNivel().getNumero();
			unJuego.pasarNivel();
			Nivel otroNivel= unJuego.getLaberinto().getNivel();
			assertFalse(numeroNivel==otroNivel.getNumero());
			
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
			FantasmaRojo fantasma=new FantasmaRojo(unJuego.getLaberinto(), 0);
			IEstrategia estrategia=fantasma.getEstrategiaActual();
			unJuego.fantasmaComido(fantasma);
			assertNotSame(estrategia,fantasma.getEstrategiaActual());
			
		}

		
		/* se prueba que  ante el mensaje del juego pacmanComido()
		 * pacman reducio  su vida  una unidad
		 */
		public void testPacmanComido() {
			
			unJuego.pacmanComido();
			assertEquals(2,unJuego.vidasPacman());
		}

	}



