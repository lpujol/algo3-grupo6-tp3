package vista;

import modelo.*;
import ar.uba.fi.algo3.titiritero.Posicionable;

public class EstadoJuego implements Posicionable {
	
	public Posicion posicion;
	public Juego juego;
	public EstadoJuego(Juego juego){
		int x=8;
		int y=juego.getLaberinto().getAltoEnBloques()*Laberinto.getTamanoDelBloque()+8;		
		posicion=new Posicion(x,y);
		this.juego=juego;
	}

	@Override
	public int getX() {
		return posicion.getX();
	}

	@Override
	public int getY() {
		return posicion.getY();
	}
	
	public int getAncho(){
		return Laberinto.getTamanoDelBloque()*juego.getLaberinto().getAnchoEnBloques();
	}
	
	public int getAlto(){
		return 50;
	}
	
	public int vidas(){
		return juego.vidasPacman();
	}
	
	public String puntos(){		
		return Integer.toString((int)juego.getPuntosAcumulados());
	}

	public String numeroNivel() {
		Integer ret=this.juego.getLaberinto().getNivel().getNumero();
		return ret.toString();
	}

}
