package modelo;

public class ParedVerticalIzquierdaHorizontalAbajo extends NoComestible {

	public ParedVerticalIzquierdaHorizontalAbajo(Posicion posicion,Laberinto laberinto) {
		super(posicion, laberinto);
	}

	public boolean esOcupable(Fantasma unFantasma) {
		return false;
	}

	@Override
	public boolean esOcupablePorPacman() {
		return false;
	}
	
}
