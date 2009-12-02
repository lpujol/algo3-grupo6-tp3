package modelo;

public class ParedVerticalDerechaHorizontalArriba extends NoComestible {

	public ParedVerticalDerechaHorizontalArriba(Posicion posicion,Laberinto laberinto) {
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
