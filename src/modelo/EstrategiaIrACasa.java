package modelo;

public class EstrategiaIrACasa implements IEstrategia {

	private Fantasma fantasma;
	
	public EstrategiaIrACasa(Fantasma fantasma)	{
		this.fantasma=fantasma;
	}
	
	@Override
	public Posicion getDestino() {
		return fantasma.getLaberinto().obtenerPosicionCasa();
	}

}
