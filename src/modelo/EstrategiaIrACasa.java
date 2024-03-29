package modelo;

public class EstrategiaIrACasa implements IEstrategia {

	private Fantasma fantasma;
	
	public EstrategiaIrACasa(Fantasma fantasma)	{
		this.fantasma=fantasma;
		this.fantasma.setVelocidad(2*fantasma.getVelocidad());
	}
	
	
	public Posicion getDestino() {
		if(fantasma.getPosicion().equals(fantasma.getPosicionInicial())){
			fantasma.setEstrategiaActual(new EstrategiaSalirDeCasa(fantasma));
			fantasma.recuperarVelocidadInicial();
			fantasma.estaVivo();
			fantasma.setEnCasa(true);
		}
		return fantasma.getPosicionInicial();		
	}

}
