package modelo;

public class EstrategiaEscapar implements IEstrategia {

	private Fantasma fantasma;
	private Laberinto laberinto;

	
	public EstrategiaEscapar(Fantasma fantasma)
	{
		this.fantasma=fantasma;
		this.laberinto=fantasma.getLaberinto();
	}
	
	/*
	 * En esta estrategia, para calcular el destino al que 
	 * se le va a asignar al fantasma, se obtienen la posicion
	 * actual del pacman de laberinto actual.
	 * En base a este datos, se le otorga su destino como la esquina
	 * mas alejada del pacman.
	 * 
	 */
	@Override
	public Posicion getDestino() {
		Posicion posicionPacman=laberinto.getPacman().getPosicion();
		//si el pacman esta a la izquierda del fanstasma
		if(posicionPacman.getX()>fantasma.getPosicion().getX())
		{
			//si el pacman esta arriba del fantasma
			if(posicionPacman.getY()<fantasma.getPosicion().getY())
				return esquinaInferiorIzquierda();
			else
				return esquinaSuperiorIzquierda();
		}
		else
		{
			if(posicionPacman.getY()<fantasma.getPosicion().getY())
				return esquinaInferiorDerecha();
			else
				return esquinaSuperiorDerecha();
			
		
		}
		
	}

	private Posicion esquinaInferiorIzquierda() {
		//laberinto.getEsquinaInferiorIzquierda() ?
		return new Posicion(1,30);
	}

	private Posicion esquinaSuperiorDerecha() {
		// laberinto.getEsquinaSuperiorDerecha() ?
		// el ancho del laberinto es 28
		//corresponderia, laberinto.getAncho()
		return new Posicion(27,1);
	}

	private Posicion esquinaSuperiorIzquierda() {
		// laberinto.getEsquinaSuperiorIzquierda() ?		
		return new Posicion(2,2);
	}

	private Posicion esquinaInferiorDerecha() {
		// laberinto.getEsquinaInferiorDerecha() ?
		//28 ancho del laberinto
		//31 alto del laberinto
		return new Posicion(30,27);

	}

}
