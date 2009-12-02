package modelo;

public class ParedVerticalDerecha extends NoComestible {

	public ParedVerticalDerecha(Posicion posicion,Laberinto laberinto) {
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
