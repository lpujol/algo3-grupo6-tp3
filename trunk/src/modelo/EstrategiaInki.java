package modelo;

import java.util.ArrayList;

public class EstrategiaInki implements IEstrategia {

	Fantasma fantasma;
	public EstrategiaInki(Fantasma fantasma)
	{
		this.fantasma=fantasma; 
	}
	/*
	 * (non-Javadoc)
	 * @see modelo.IEstrategia#getDestino()
	 */
	
	@Override
	public Posicion getDestino() {
		Laberinto laberinto=fantasma.getLaberinto();
		ArrayList<Fantasma> fantasmas=laberinto.getFantasmas();
		Fantasma cazador=null;
		for(Fantasma f : fantasmas)
		{
			//horible esto, despues lo cambiamos
			if(f.getEstrategiaActual() instanceof EstrategiaPerseguidor)
				cazador=f;
		}
		if(cazador== null || laberinto.distancia(laberinto.getBloqueEnPosicion(fantasma.getPosicion()), laberinto.getBloqueEnPosicion(cazador.getPosicion()))>5)
		{
			Posicion posicionPacman=laberinto.getPacman().getPosicion();
			Direccion direccionPacman=laberinto.getPacman().getDireccion();
			switch(direccionPacman)
			{
			case Arriba:
				return new Posicion(posicionPacman.getX()-2,posicionPacman.getY()-2);
			case Abajo:
				return new Posicion(posicionPacman.getX(),posicionPacman.getY()+2);
			case Derecha:
				return new Posicion(posicionPacman.getX()+2,posicionPacman.getY());
			case Izquierda:
				return new Posicion(posicionPacman.getX()-2,posicionPacman.getY());
			}
		}
		else
		{
			return laberinto.getPacman().getPosicion();
		}
		return null;
	}

}
