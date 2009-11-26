package modelo;

import junit.framework.TestCase;

public class FantasmaCelesteTest extends TestCase {

	public void testMovimiento(){
		Nivel miNivel=new Nivel(1);		
		Laberinto miLaberinto=new Laberinto(miNivel, null);
		Fantasma miFantasma=new FantasmaCeleste(24,40,null,4);
		Pacman miPacman= new Pacman(40,24,null);
		miNivel.agregarFantasma(miFantasma);
		miNivel.setPacman(miPacman);
		Bloque bloque1= new Pared(new Posicion(1,1), miLaberinto);
		Bloque bloque2= new Pared(new Posicion(1,2), miLaberinto);
		Bloque bloque3= new Pared(new Posicion(1,3), miLaberinto);
		Bloque bloque4= new Pared(new Posicion(1,4), miLaberinto);
		Bloque bloque5= new Pared(new Posicion(2,1), miLaberinto);
		Bloque bloque6= new Pared(new Posicion(2,2), miLaberinto);
		Bloque bloque7= new Pared(new Posicion(2,4), miLaberinto);
		Bloque bloque8= new Pared(new Posicion(3,1), miLaberinto);
		Bloque bloque9= new Pared(new Posicion(3,4), miLaberinto);
		Bloque bloque10= new Pared(new Posicion(4,1), miLaberinto);
		Bloque bloque11= new Pared(new Posicion(4,2), miLaberinto);
		Bloque bloque12= new Pared(new Posicion(4,3), miLaberinto);
		Bloque bloque13= new Pared(new Posicion(4,4), miLaberinto);
		Bloque bloque14= new Punto(new Posicion(3,3), miLaberinto);
		Bloque bloque15= new Punto(new Posicion(2,3), miLaberinto);
		Bloque bloque16= new Punto(new Posicion(3,2), miLaberinto);
		miNivel.agregarBloque(bloque1);
		miNivel.agregarBloque(bloque2);
		miNivel.agregarBloque(bloque3);
		miNivel.agregarBloque(bloque4);
		miNivel.agregarBloque(bloque5);
		miNivel.agregarBloque(bloque6);
		miNivel.agregarBloque(bloque7);
		miNivel.agregarBloque(bloque8);
		miNivel.agregarBloque(bloque9);
		miNivel.agregarBloque(bloque10);
		miNivel.agregarBloque(bloque11);
		miNivel.agregarBloque(bloque12);
		miNivel.agregarBloque(bloque13);
		miNivel.agregarBloque(bloque14);
		miNivel.agregarBloque(bloque15);
		miNivel.agregarBloque(bloque16);
		miLaberinto=new Laberinto(miNivel, null);
		miPacman.setLaberinto(miLaberinto);
		miFantasma=miLaberinto.getFantasmas().get(0);
		miFantasma.setLaberinto(miLaberinto);
		miFantasma.vivir();
				
		Posicion posicionSiguiente=new Posicion(28,40);
		assertEquals(posicionSiguiente.getX(),miFantasma.getPosicion().getX());
		assertEquals(posicionSiguiente.getY(),miFantasma.getPosicion().getY());
		
	};
	
	
	
	
	
}
