package modeloTests;

import java.util.ArrayList;

import junit.framework.TestCase;
import modelo.*;

public class InteraccionPacmanFantasmaTest extends TestCase {

	Pacman pacman;
	Laberinto miLaberinto;
	Posicion posicionFantasma;
	Fantasma miFantasma;
	
	protected void setUp() throws Exception {
		super.setUp();
		Juego juego=new Juego();
		miLaberinto=juego.getLaberinto();
		pacman=miLaberinto.getPacman();
		posicionFantasma=pacman.getPosicion().clone();
		posicionFantasma.avanzarHorizontal(Laberinto.getTamanoDelBloque());
		miFantasma=new FantasmaCeleste(posicionFantasma.getX(),posicionFantasma.getY(),miLaberinto,4);
		miFantasma.restablecerEstrategiaNativa();
		miLaberinto.getNivel().agregarFantasma(miFantasma);		
	}
	
	/*
	 * Testea que pacman , una vez comido por un fantasma que lo alcanza 
	 * en su posicion, revive con una vida menos y con direccion 
	 * hacia la derecha.
	 * 
	 * */
	public void testPacmanComido(){
		int vidas=pacman.getCantidadVidas();		
		pacman.cambiarDireccion(Direccion.Izquierda);		
		miFantasma.vivir();		
		miFantasma.vivir();		
		miFantasma.vivir();		
		pacman.vivir();		
		assertEquals(2,pacman.getCantidadVidas());
		assertEquals(Direccion.Derecha,pacman.getDireccion());
	}
	
	/*
	 * Testea que el fantasma , una vez comido por pacman que lo alcanza 
	 * en su posicion, muere y pacman queda con la misma cantidad de vidas.
	 * 
	 * */
	public void testFantasmaComido(){
		int vidas=pacman.getCantidadVidas();		
		miFantasma.setEnCasa(false);
		miLaberinto.getJuego().activarPuntoDePoder();
		ArrayList<Fantasma> fantasmas=miLaberinto.getFantasmas();
		for(Fantasma fantasma:fantasmas){
			if(fantasma.getEstado().ordinal()!=EstadoFantasma.Muerto.ordinal()&&(fantasma.estaEnCasa()==false)){
				fantasma.setEstrategiaActual(new EstrategiaEscapar(fantasma));
				fantasma.estaHuyendo();
			}
		}
		miFantasma.vivir();
		pacman.vivir();
		pacman.vivir();
		pacman.vivir();
		miFantasma.vivir();
		assertEquals(vidas, pacman.getCantidadVidas());
		assertEquals(EstadoFantasma.Muerto, miFantasma.getEstado());
		
	}

}
