package modelo;

public class ParedHorizontal extends NoComestible {

	public ParedHorizontal(Posicion posicion,Laberinto laberinto) {
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