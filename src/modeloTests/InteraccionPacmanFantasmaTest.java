package modeloTests;

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
		posicionFantasma=pacman.getPosicion();
		posicionFantasma.avanzarHorizontal(Laberinto.getTamanoDelBloque());
		miFantasma=new FantasmaCeleste(posicionFantasma.getX(),posicionFantasma.getY(),miLaberinto,4);
		miLaberinto.getNivel().agregarFantasma(miFantasma);		
	}
	
	public void testPacmanComido(){
		int vidas=pacman.getCantidadVidas();		
		pacman.cambiarDireccion(Direccion.Izquierda);
		
		miFantasma.vivir();		
	//	miFantasma.vivir();
//		miFantasma.vivir();
		assertEquals(2,pacman.getCantidadVidas());
		assertEquals(Direccion.Derecha,pacman.getDireccion());
	}
	
	public void testFantasmaComido(){
		int vidas=pacman.getCantidadVidas();
		IEstrategia estrategiaFantasma=miFantasma.getEstrategiaActual();
		miLaberinto.getJuego().puntoDePoderComido();
		miFantasma.vivir();
		miFantasma.vivir();
		miFantasma.vivir();
		assertEquals(vidas, pacman.getCantidadVidas());
		assertNotSame(estrategiaFantasma, miFantasma.getEstrategiaActual());
		
	}

}
