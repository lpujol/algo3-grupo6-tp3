package modelo;

public class EstrategiaIrACasa implements IEstrategia {

	private Fantasma fantasma;
	
	public EstrategiaIrACasa(Fantasma fantasma)	{
		this.fantasma=fantasma;
		this.fantasma.setVelocidad(2);
	}
	
	
	public Posicion getDestino() {
		if(fantasma.getPosicion().equals(fantasma.getLaberinto().obtenerPosicionCasa())){
			fantasma.setEstrategiaActual(new EstrategiaSalirDeCasa(fantasma));
			fantasma.recuperarVelocidadInicial();
			fantasma.estaVivo();
		}
		return fantasma.getLaberinto().obtenerPosicionCasa();		
	}

}
