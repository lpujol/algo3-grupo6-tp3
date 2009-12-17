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
			
			unJuego.getLaberinto().getNivel().pasarDeNivel();
			assertEquals(2,unJuego.getLaberinto().getNivel().getNumero());
		}

		
		/* se  come  a pacman 3 veces  y se  prueba  que el  juego
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
		public void testPuntoDePoderComido() {
			
			unJuego.puntoDePoderComido();
			assertTrue(unJuego.puntoDePoderActivo());
			
		}
		
		/* prueba  que    comenzar()   hace que el  juego  se  inicie
		 * dejandolo  en un estado "jugando"  y  con  su demas  estado
		 *   inicial
		 */
		public void  testComenzar(){
			
			assertEquals(unJuego.estaJugando(),false);
			unJuego.comenzar();
			assertEquals(unJuego.estaJugando(),true);
			
			unJuego.pasarNivel();
			unJuego.setPuntosAcumulados(1000);
			unJuego.pacmanComido();
			unJuego.pacmanComido();
			unJuego.pacmanComido();
			unJuego.pacmanComido();
			unJuego.comenzar();
		    assertEquals(1,unJuego.getLaberinto().getNivel().getNumero());
		    assertEquals(3,unJuego.getCantidadVidas());

		}

		
		public void testFantasmaComido() {
			FantasmaRojo fantasma=new FantasmaRojo(unJuego.getLaberinto(), 0);
			IEstrategia estrategia=fantasma.getEstrategiaActual();
			unJuego.fantasmaComido(fantasma);
			assertNotSame(estrategia,fantasma.getEstrategiaActual());
			
		}

		
		/* se prueba que  ante el mensaje del juego pacmanComido()
		 * pacman redujo  su vida  una unidad
		 */
		public void testPacmanComido() {
			
			unJuego.pacmanComido();
			assertEquals(2,unJuego.vidasPacman());
		}

	}



