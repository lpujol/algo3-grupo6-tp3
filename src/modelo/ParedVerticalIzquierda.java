package modelo;

public class ParedVerticalIzquierda extends NoComestible {

	public ParedVerticalIzquierda(Posicion posicion,Laberinto laberinto) {
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
