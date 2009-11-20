package modelo;


public class EstrategiaEmboscador implements IEstrategia {

	private Fantasma fantasma;
	
	public EstrategiaEmboscador(Fantasma fantasma) {
		this.fantasma=fantasma;
	}
	
	
	public Posicion getDestino() {
		
		Laberinto laberinto=fantasma.getLaberinto();
		Posicion posicionPacman=laberinto.getPacman().getPosicion();
		Direccion direccionDePacman=laberinto.getPacman().getDireccion();
		return laberinto.getInterseccionMasCercana(posicionPacman,direccionDePacman);
			
		
	}

}
