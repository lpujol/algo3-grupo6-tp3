package modelo;

public class ParedHorizontalArriba extends NoComestible {

	public ParedHorizontalArriba(Posicion posicion,Laberinto laberinto) {
		super(posicion, laberinto);
	}

	public boolean esOcupable() {
		return false;
	}

	@Override
	public boolean esOcupablePorPacman() {
		return false;
	}

	
}