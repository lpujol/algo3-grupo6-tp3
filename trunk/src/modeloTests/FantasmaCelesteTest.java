package modeloTests;

import modelo.Fantasma;
import modelo.FantasmaCeleste;
import modelo.Juego;
import modelo.Laberinto;
import modelo.Pacman;
import modelo.Posicion;
import junit.framework.TestCase;

public class FantasmaCelesteTest extends TestCase {

/*
 * Testea el movimiento del fantasma siguiendo una estrategia perseguidor que 
 * se encuentra en la siguiente posicion respecto al pacman:
 *    	 #o## ######## ##o#     
 *    	 #o##     P    ##o#     
 *     	 #o## ######## ##o#     
 *	######o##F######## ##o######
 *	#oooooooooooo##oooooooooooo#
 * 
 * De acuerdo a la estrategia planteada, el fantasma debe elegir moverse a 
 * hacia arriba disminuyendo el valor de la coordenada Y.
 * 
 * */
	
	public void testMovimiento(){
		Laberinto miLaberinto=new Laberinto(null);
		Fantasma unFantasma=new FantasmaCeleste(152,312,miLaberinto,4);
		miLaberinto.getNivel().agregarFantasma(unFantasma);
		unFantasma.vivir();				
		Posicion posicionSiguiente=new Posicion(152,316);
		assertEquals(posicionSiguiente.getX(),unFantasma.getPosicion().getX());
		assertEquals(posicionSiguiente.getY(),unFantasma.getPosicion().getY());
		unFantasma.vivir();
		unFantasma.vivir();
		unFantasma.vivir();
		posicionSiguiente=new Posicion(152,328);
		assertEquals(posicionSiguiente.getX(),unFantasma.getPosicion().getX());
		assertEquals(posicionSiguiente.getY(),unFantasma.getPosicion().getY());
		
	};

	
	public void testPersecucion(){
        Juego miJuego = new Juego();        
        Pacman miPacman= miJuego.getLaberinto().getPacman();		
        miJuego.getLaberinto().getNivel().agregarFantasma(new FantasmaCeleste(200,56,miJuego.getLaberinto(),4));
		Fantasma miFantasma=miJuego.getLaberinto().getFantasmas().get(0);				
		miFantasma.vivir();	
		miPacman.vivir();
		miFantasma.vivir();
		miPacman.vivir();
		miFantasma.vivir();
		miPacman.vivir();
		miFantasma.vivir();
		miPacman.vivir();
		Posicion posicionSiguiente=new Posicion(200,72);
		assertEquals(posicionSiguiente.getX(),miFantasma.getPosicion().getX());
		assertEquals(posicionSiguiente.getY(),miFantasma.getPosicion().getY());
		for(int i = 0; i < 108; i++){
			miFantasma.vivir();
			miPacman.vivir();}		
		posicionSiguiente=new Posicion(296,312);
		assertEquals(posicionSiguiente.getX(),miFantasma.getPosicion().getX());
		assertEquals(posicionSiguiente.getY(),miFantasma.getPosicion().getY());
		for(int i = 0; i < 4; i++){
			miFantasma.vivir();
			miPacman.vivir();}		
		posicionSiguiente=new Posicion(296,328);
		assertEquals(posicionSiguiente.getX(),miFantasma.getPosicion().getX());
		assertEquals(posicionSiguiente.getY(),miFantasma.getPosicion().getY());	
		for(int i = 0; i < 12; i++){
			miFantasma.vivir();
			miPacman.vivir();}		
		posicionSiguiente=new Posicion(344,328);
		assertEquals(posicionSiguiente.getX(),miFantasma.getPosicion().getX());
		assertEquals(posicionSiguiente.getY(),miFantasma.getPosicion().getY());
		miFantasma.vivir();
		miPacman.vivir();		
		posicionSiguiente=new Posicion(344,332);
		assertEquals(posicionSiguiente.getX(),miFantasma.getPosicion().getX());
		assertEquals(posicionSiguiente.getY(),miFantasma.getPosicion().getY());
		
	};
	
	
}
