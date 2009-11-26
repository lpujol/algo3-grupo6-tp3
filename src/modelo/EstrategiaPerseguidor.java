package modelo;

public class EstrategiaPerseguidor implements IEstrategia {

	private Fantasma fantasma;
	
	public EstrategiaPerseguidor(Fantasma fantasma) {
		this.fantasma=fantasma;
	}
	
	public Posicion getDestino() {
		return this.fantasma.getLaberinto().getPacman().getPosicion();
		
	}

}
