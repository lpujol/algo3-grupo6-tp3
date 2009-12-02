package modelo;

public class ParedVerticalIzquierdaHorizontalAbajo extends NoComestible {

	public ParedVerticalIzquierdaHorizontalAbajo(Posicion posicion,Laberinto laberinto) {
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
