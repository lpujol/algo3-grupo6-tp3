package modelo;

public class EstrategiaIrACasa implements IEstrategia {

	private Fantasma fantasma;
	
	public EstrategiaIrACasa(Fantasma fantasma)	{
		this.fantasma=fantasma;
		this.fantasma.setVelocidad(2);
	}
	
	
	public Posicion getDestino() {
		return fantasma.getLaberinto().obtenerPosicionCasa();		
	}

}
