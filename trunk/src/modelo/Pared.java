package modelo;

public class Pared extends NoComestible {

	public Pared(Posicion posicion,Laberinto laberinto) {
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
