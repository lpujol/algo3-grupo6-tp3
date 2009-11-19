package modelo;

import java.awt.Point;

public class EstrategiaEmboscador implements Estrategia {

	private Fantasma fantasma;
	
	public EstrategiaEmboscador(Fantasma fantasma) {
		this.fantasma=fantasma;
	}
	
	@Override
	public void vivir() {
		
		Laberinto laberinto=fantasma.getLaberinto();
		Point posicionPacman=laberinto.getPosicionPacman();
		Direccion direccionDePacman=laberinto.getPacman().getDireccion();
		Point interseccion=laberinto.getInterseccionMasCercana(posicionPacman,direccionDePacman);
		this.fantasma.mover(interseccion);		
		
	}

}
