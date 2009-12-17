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
			unPacman.setPosicion(new Posicion(280,376));
			for(int i=0;i<17;i++){
				unPacman.vivir();
			}
			Posicion posicionSiguiente=new Posicion(344,376);
			assertEquals(posicionSiguiente.getX(),unPacman.getPosicion().getX());
			assertEquals(posicionSiguiente.getY(),unPacman.getPosicion().getY());
			unPacman.vivir();			
			assertEquals(posicionSiguiente.getX(),unPacman.getPosicion().getX());
			assertEquals(posicionSiguiente.getY(),unPacman.getPosicion().getY());

		}

		/*
		 *Prueba el cambio de direccion del Pacman hacia la izquierda habiendo comenzado
		 * moviendose a la derecha, continua moviendose hasta toparse con una pared.   
		 * 
		 * */

		public void testVivirCambioDireccionLaIzquierda() {
			unPacman.cambiarDireccion(Direccion.Derecha);
			unPacman.setPosicion(new Posicion(120,376));
			unPacman.vivir();	
			Posicion posicionSiguiente=new Posicion(124,376);
			assertEquals(posicionSiguiente.getX(),unPacman.getPosicion().getX());
			assertEquals(posicionSiguiente.getY(),unPacman.getPosicion().getY());
			unPacman.setEstrategia(new EstrategiaIrALaIzquierda(unPacman));
			unPacman.vivir();			
			unPacman.vivir();
			unPacman.vivir();
			posicionSiguiente=new Posicion(136,376);
			assertEquals(posicionSiguiente.getX(),unPacman.getPosicion().getX());
			assertEquals(posicionSiguiente.getY(),unPacman.getPosicion().getY());
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			unPacman.vivir();
			posicionSiguiente=new Posicion(120,376);
			assertEquals(posicionSiguiente.getX(),unPacman.getPosicion().getX());
			assertEquals(posicionSiguiente.getY(),unPacman.getPosicion().getY());
			for(int i=0;i<8;i++){
				unPacman.vivir();
			};
			posicionSiguiente=new Posicion(104,376);
			assertEquals(posicionSiguiente.getX(),unPacman.getPosicion().getX());
			assertEquals(posicionSiguiente.getY(),unPacman.getPosicion().getY());
		}

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
			for(int i=0;i<8;i++){
				unPacman.vivir();			
			}
			posicionSiguiente=new Posicion(392,232);
			assertEquals(posicionSiguiente.getX(),unPacman.getPosicion().getX());
			assertEquals(posicionSiguiente.getY(),unPacman.getPosicion().getY());
			
			
		} 
			
		
		
		/*prueba  como la cantidad de vidas se va  actualizando
		 *  medida que pacman  va siendo  comido 
		 */
		public void testGetCantidadVidas() {
			assertEquals(3,unPacman.getCantidadVidas());
			unPacman.comer();
			assertEquals(2,unPacman.getCantidadVidas());
			unPacman.comer();
			assertEquals(1,unPacman.getCantidadVidas());
		}
	}



