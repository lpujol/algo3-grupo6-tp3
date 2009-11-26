package modelo;

public class EstrategiaIrACasa implements IEstrategia {

	private Fantasma fantasma;
	
	public EstrategiaIrACasa(Fantasma fantasma)	{
		this.fantasma=fantasma;
	}
	
	
	public Posicion getDestino() {
		return fantasma.getLaberinto().obtenerPosicionCasa();
	}

}
