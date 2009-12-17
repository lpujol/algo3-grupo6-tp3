package modelo;

public class ParedVerticalDerechaHorizontalAbajo extends NoComestible {

	public ParedVerticalDerechaHorizontalAbajo(Posicion posicion,Laberinto laberinto) {
		super(posicion, laberinto);
	}

	public boolean esOcupablePorFantasma(Fantasma unFantasma) {
		return false;
	}

	@Override
	public boolean esOcupablePorPacman() {
		return false;
	}
	
}
