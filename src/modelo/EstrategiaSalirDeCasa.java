package modelo;

public class EstrategiaSalirDeCasa implements IEstrategia {

	Fantasma fantasma;
	
	public EstrategiaSalirDeCasa(Fantasma fantasma)
	{
		this.fantasma=fantasma;
	}

	@Override
	public Posicion getDestino() {
		
		Posicion posicionPuerta=fantasma.getLaberinto().getPosicionPuerta();
		if(this.fantasma.getPosicion().equals(posicionPuerta))
			fantasma.restablecerEstrategiaNativa();
		return posicionPuerta;
	}

}

