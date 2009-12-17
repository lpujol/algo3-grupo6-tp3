package modelo;

public class EstrategiaSalirDeCasa implements IEstrategia {

	/*
	 * Estrategia para que los fantrasmas puedan salir 
	 * de la casa, dandole la direccion de la puerta.
	 * 
	 * */
	
	Fantasma fantasma;
	
	public EstrategiaSalirDeCasa(Fantasma fantasma)
	{
		this.fantasma=fantasma;
	}

	@Override
	public Posicion getDestino() {
		
		Posicion posicionPuerta=fantasma.getLaberinto().getPosicionPuerta();
		if(this.fantasma.getPosicion().equals(posicionPuerta)){
			fantasma.restablecerEstrategiaNativa();
			fantasma.setEnCasa(false);
		}
		return posicionPuerta;
	}

}

