package modelo;

public class EstrategiaEscapar implements IEstrategia {

	private Fantasma fantasma;
	private Laberinto laberinto;

	
	public EstrategiaEscapar(Fantasma fantasma)
	{
		this.fantasma=fantasma;
		this.fantasma.setVelocidad(fantasma.getVelocidadNativa()-1);
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
	
		return new Posicion(1,(laberinto.getAltoEnBloques()-1)*Laberinto.getTamanoDelBloque());
	}

	private Posicion esquinaSuperiorDerecha() {
		
		return new Posicion((laberinto.getAnchoEnBloques()-1)*Laberinto.getTamanoDelBloque(),1);
	}

	private Posicion esquinaSuperiorIzquierda() {
			
		return new Posicion(2,2);
	}

	private Posicion esquinaInferiorDerecha() {
	
		return new Posicion((laberinto.getAnchoEnBloques()-1)*Laberinto.getTamanoDelBloque(),(laberinto.getAltoEnBloques()-1)*Laberinto.getTamanoDelBloque());

	}

}
