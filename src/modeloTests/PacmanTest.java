package modeloTests;

import junit.framework.TestCase;
import modelo.Direccion;
import modelo.EstrategiaIrALaIzquierda;
import modelo.Juego;
import modelo.Pacman;
import modelo.Posicion;


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
		/*
		 *Prueba el avance de Pacman hacia la derecha hasta toparse con una pared. 
		 * 
		 * */

		public void testVivirAvanzandoALaDerecha() {
			unPacman.cambiarDireccion(Direccion.Derecha);
			unPacman.setPosicion(new Posicion(328,376));
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			Posicion posicionSiguiente=new Posicion(344,376);
			assertEquals(posicionSiguiente.getX(),unPacman.getPosicion().getX());
			assertEquals(posicionSiguiente.getY(),unPacman.getPosicion().getY());
			unPacman.vivir();			
			assertEquals(posicionSiguiente.getX(),unPacman.getPosicion().getX());
			assertEquals(posicionSiguiente.getY(),unPacman.getPosicion().getY());

		}

		/*
		 *Prueba el cambio de direccion del Pacman hacia la izquierda habiendo comenzado
		 * moviendose a la derecha.   
		 * 
		 * */

	/*	public void testVivirCambioDireccionLaIzquierda() {
			unPacman.cambiarDireccion(Direccion.Derecha);
			unPacman.setPosicion(new Posicion(120,376));
			unPacman.vivir();	
			Posicion posicionSiguiente=new Posicion(121,376);
			assertEquals(posicionSiguiente.getX(),unPacman.getPosicion().getX());
			assertEquals(posicionSiguiente.getY(),unPacman.getPosicion().getY());
			unPacman.setEstrategia(new EstrategiaIrALaIzquierda(unPacman));
			unPacman.vivir();			
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			posicionSiguiente=new Posicion(125,376);
			assertEquals(posicionSiguiente.getX(),unPacman.getPosicion().getX());
			assertEquals(posicionSiguiente.getY(),unPacman.getPosicion().getY());
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			posicionSiguiente=new Posicion(129,376);
			assertEquals(posicionSiguiente.getX(),unPacman.getPosicion().getX());
			assertEquals(posicionSiguiente.getY(),unPacman.getPosicion().getY());
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();			
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			posicionSiguiente=new Posicion(134,376);
			assertEquals(posicionSiguiente.getX(),unPacman.getPosicion().getX());
			assertEquals(posicionSiguiente.getY(),unPacman.getPosicion().getY());
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();			
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();			
			unPacman.vivir();
			posicionSiguiente=new Posicion(120,376);
			assertEquals(posicionSiguiente.getX(),unPacman.getPosicion().getX());
			assertEquals(posicionSiguiente.getY(),unPacman.getPosicion().getY());
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();			
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();			
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			posicionSiguiente=new Posicion(104,376);
			assertEquals(posicionSiguiente.getX(),unPacman.getPosicion().getX());
			assertEquals(posicionSiguiente.getY(),unPacman.getPosicion().getY());
			unPacman.vivir();
			posicionSiguiente=new Posicion(104,376);
			assertEquals(posicionSiguiente.getX(),unPacman.getPosicion().getX());
			assertEquals(posicionSiguiente.getY(),unPacman.getPosicion().getY());
		

		}*/

		public void testAtravesarPortal(){
			unPacman.setPosicion(new Posicion(376,232));//lo ubica en el pasillo que lleva al portal
			unPacman.vivir();
			for(int i=0;i<10;i++){
				unPacman.vivir();
			}
			
			unPacman.vivir();
			Posicion posicionSiguiente=new Posicion(56,232);
			assertEquals(posicionSiguiente.getX(),unPacman.getPosicion().getX());
			assertEquals(posicionSiguiente.getY(),unPacman.getPosicion().getY());
			
			unPacman.setEstrategia(new EstrategiaIrALaIzquierda(unPacman));
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			
			posicionSiguiente=new Posicion(392,232);
			assertEquals(posicionSiguiente.getX(),unPacman.getPosicion().getX());
			assertEquals(posicionSiguiente.getY(),unPacman.getPosicion().getY());
			
			
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
			
			assertTrue(unPacman.getPosicion().equals(unaPosicion));
			unPacman.cambiarDireccion(Direccion.Derecha);
			unPacman.moverse();
			assertNotSame(unaPosicion.getX(),unPacman.getPosicion().getX());

		}
		
	
		
		public void testComer() {
			
			assertEquals(unPacman.getCantidadVidas(),3);
			
			unPacman.comer();unPacman.comer();
			assertEquals(unPacman.getCantidadVidas(),1);
			
			
		}

	}



