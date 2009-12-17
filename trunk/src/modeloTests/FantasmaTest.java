package modeloTests;

import java.util.ArrayList;

import modelo.EstadoFantasma;
import modelo.EstrategiaNulaException;
import modelo.Fantasma;
import modelo.FantasmaCeleste;
import modelo.Juego;
import modelo.Laberinto;
import modelo.Pacman;
import modelo.Portal;
import modelo.Posicion;
import modelo.VelocidadInvalidaException;
import junit.framework.TestCase;

public class FantasmaTest extends TestCase {

/*
 * Testea el movimiento del fantasma siguiendo una estrategia perseguidor que 
 * se encuentra en la siguiente posicion respecto al pacman:
 *    	
 *     	 #o## ######## ##o#     
 *	######o##F######## ##o######
 *	#oooooooooooo##oooooooooooo#
 *  #Ooo##oooooooP ooooooo##ooO#
 * 
 * De acuerdo a la estrategia planteada, el fantasma debe elegir moverse a 
 * hacia abajo aumentando el valor de la coordenada Y.
 * 
 * */
	
	public void testMovimientoEstrategico(){
		Laberinto miLaberinto=new Laberinto(null);
		Fantasma unFantasma=new FantasmaCeleste(152,312,miLaberinto,4);
		miLaberinto.getNivel().agregarFantasma(unFantasma);
		unFantasma.vivir();				
		Posicion posicionSiguiente=new Posicion(152,316);
		assertEquals(posicionSiguiente.getX(),unFantasma.getPosicion().getX());
		assertEquals(posicionSiguiente.getY(),unFantasma.getPosicion().getY());
		for(int i=0;i<3;i++){
		unFantasma.vivir();		
		};
		posicionSiguiente=new Posicion(152,328);
		assertEquals(posicionSiguiente.getX(),unFantasma.getPosicion().getX());
		assertEquals(posicionSiguiente.getY(),unFantasma.getPosicion().getY());
		for(int i=0;i<4;i++){
			unFantasma.vivir();		
			};
		posicionSiguiente=new Posicion(168,328);
		assertEquals(posicionSiguiente.getX(),unFantasma.getPosicion().getX());
		assertEquals(posicionSiguiente.getY(),unFantasma.getPosicion().getY());
		
	};

	/*Verifica que el fantasma se dirija hacia Pacman simulando los primeros segundos 
	 de juego sin cambiarle la direccion inicial a Pacman.
	 
	  
	 * */
	
 	public void testPersecucion(){
        Juego miJuego = new Juego();        
        Pacman miPacman= miJuego.getLaberinto().getPacman();		
        miJuego.getLaberinto().getNivel().agregarFantasma(new FantasmaCeleste(200,56,miJuego.getLaberinto(),4));
		Fantasma miFantasma=miJuego.getLaberinto().getFantasmas().get(0);				
		
	};
	
	/*
	 *Prueba que el fantasma atraviesa correctamente ambos portales. 
	 * */
	public void testFantasmaAtraviesaPortal(){
        Juego miJuego = new Juego();        
        Pacman miPacman= miJuego.getLaberinto().getPacman();		
        miPacman.setPosicion(new Posicion(376,232));
        miJuego.getLaberinto().getNivel().agregarFantasma(new FantasmaCeleste(360,232,miJuego.getLaberinto(),4));// ubica al fantasma en el pasillo que lleva al portal
        ArrayList<Portal> portales=miJuego.getLaberinto().getNivel().getPortales();
        Posicion posicionPortalIzquierdo=null;
        Posicion posicionLuegoDeAtravesarPortalIzq=null;
        for(int j=0;j<portales.size();j++){
        	if (portales.get(j).getPosicion().getX()<miJuego.getLaberinto().getPosicionPuerta().getX())
        		posicionPortalIzquierdo=portales.get(j).getPosicion().clone();
        	}
        posicionLuegoDeAtravesarPortalIzq=posicionPortalIzquierdo.getPosicionSiguienteHorizontal(20);//Atraviesa el portal derecho y aparece 1 casillero(16 pasos) por delante del portal izquierdo y ademas avanza 4 mas porque invoca a moverse luego de atravesarlo.
        Fantasma miFantasma=miJuego.getLaberinto().getFantasmas().get(0);		
		miFantasma.setPosicion(new Posicion(360,232));
		miFantasma.restablecerEstrategiaNativa();		
		Posicion posicionSiguiente=new Posicion(360,232);
		assertEquals(posicionSiguiente.getX(),miFantasma.getPosicion().getX());
		assertEquals(posicionSiguiente.getY(),miFantasma.getPosicion().getY());
		for(int i=0;i<15;i++){
			miFantasma.vivir();
			miPacman.vivir();	
		}		
	
		assertEquals(posicionLuegoDeAtravesarPortalIzq.getX(),miFantasma.getPosicion().getX());
		assertEquals(posicionLuegoDeAtravesarPortalIzq.getY(),miFantasma.getPosicion().getY());
	}

	/*
	 * Prueba que luego de ser comido, el fantasma adquiere estado muerto.
	 * */
	public void testFantasmaComido(){
		Juego miJuego = new Juego();  
        FantasmaCeleste unFantasma = new FantasmaCeleste(360,232,miJuego.getLaberinto(),4);
		miJuego.getLaberinto().getNivel().agregarFantasma(unFantasma);
        unFantasma.comer();
        assertEquals(EstadoFantasma.Muerto,unFantasma.getEstado());	
	}

	public void testIncrementoDeVelocidad(){
		Juego miJuego = new Juego();  
        FantasmaCeleste unFantasma = new FantasmaCeleste(360,232,miJuego.getLaberinto(),4);
		miJuego.getLaberinto().getNivel().agregarFantasma(unFantasma);
		int nuevaVelocidad=unFantasma.getVelocidad()+8;
		unFantasma.incrementarVelocidad(8);
		assertEquals(nuevaVelocidad,unFantasma.getVelocidad());
	};
	
	
	/*
	 * Prueba que no se le pueda asignar un elemento nulo 
	 * a la estrategia del fantasma.
	 * 
	 * */
	public void testSetEstrategiaActualNulaError(){
		Juego miJuego = new Juego();  
        FantasmaCeleste unFantasma = new FantasmaCeleste(360,232,miJuego.getLaberinto(),4);
		miJuego.getLaberinto().getNivel().agregarFantasma(unFantasma);
		try{
			unFantasma.setEstrategiaActual(null);
			fail();
		}catch(EstrategiaNulaException e){
			assertTrue(true);
		}
		
	};
	
	/*
	 * Prueba que no se le pueda asignar una velocidad
	 * negativa al fantasma.
	 * 
	 * */
	public void testSetVelocidadNegativaError(){
		Juego miJuego = new Juego();  
        FantasmaCeleste unFantasma = new FantasmaCeleste(360,232,miJuego.getLaberinto(),4);
		miJuego.getLaberinto().getNivel().agregarFantasma(unFantasma);
		try{
			unFantasma.setVelocidad(-1);
			fail();
		}catch(VelocidadInvalidaException e){
			assertTrue(true);
		}
	};

}
