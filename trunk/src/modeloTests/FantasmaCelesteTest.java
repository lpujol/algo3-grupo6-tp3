package modeloTests;

import modelo.Bloque;
import modelo.Fantasma;
import modelo.FantasmaCeleste;
import modelo.Laberinto;
import modelo.Nivel;
import modelo.Pacman;
import modelo.Pared;
import modelo.Posicion;
import modelo.Punto;
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
		Fantasma miFantasma=new FantasmaCeleste(152,312,miLaberinto,4);
		miLaberinto.getNivel().agregarFantasma(miFantasma);
		miFantasma.vivir();				
		Posicion posicionSiguiente=new Posicion(152,308);
		assertEquals(posicionSiguiente.getX(),miFantasma.getPosicion().getX());
		assertEquals(posicionSiguiente.getY(),miFantasma.getPosicion().getY());
		miFantasma.vivir();
		miFantasma.vivir();
		miFantasma.vivir();
		posicionSiguiente=new Posicion(152,296);
		assertEquals(posicionSiguiente.getX(),miFantasma.getPosicion().getX());
		assertEquals(posicionSiguiente.getY(),miFantasma.getPosicion().getY());
		
	};
	
	
	
	
	
}
