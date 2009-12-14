package modelo;

public class EstrategiaClyde implements IEstrategia {

	private Fantasma fantasma;
	
	public EstrategiaClyde(Fantasma fantasma)
	{
		this.fantasma=fantasma;
	}
	
	/*
	 * (non-Javadoc)
	 * la estrategia de este fantasma es acercarse al pacman cuando
	 * esta a mas de 8 cuadros de distancia
	 * y luego alejarse :S
	 */
	@Override
	public Posicion getDestino() {
		Laberinto laberinto=fantasma.getLaberinto();
		Posicion posicionPacman=laberinto.getPacman().getPosicion();
		if(laberinto.distancia(laberinto.getBloqueEnPosicion(fantasma.getPosicion()), laberinto.getBloqueEnPosicion(posicionPacman))>8*Laberinto.getTamanoDelBloque())
		{
			return posicionPacman;
		}
		else
		{
			if(posicionPacman.getX()<fantasma.posicion.getX())
			{
				if(posicionPacman.getY()<fantasma.getPosicion().getY())
					return new Posicion(28,31);//esquina inferior derecha
				else
					return new Posicion(28,1);//esquina superior derecha
			}
			else
			{
				if(posicionPacman.getY()<fantasma.getPosicion().getY())
					return new Posicion(1,31);//esquina inferior izquierda
				else
					return new Posicion(1,1);//esquina superior Izquierda
			}
		}
		// TODO Auto-generated method stub
		
	}

}
