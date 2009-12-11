package modelo;

public class ParedVerticalDerechaHorizontalArriba extends NoComestible {

	public ParedVerticalDerechaHorizontalArriba(Posicion posicion,Laberinto laberinto) {
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
