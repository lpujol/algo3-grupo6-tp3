package modelo;

public class ParedVerticalIzquierdaHorizontalArriba extends NoComestible {

	public ParedVerticalIzquierdaHorizontalArriba(Posicion posicion,Laberinto laberinto) {
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
