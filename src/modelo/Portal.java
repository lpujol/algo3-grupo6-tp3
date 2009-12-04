package modelo;

public class Portal extends NoComestible {

	public Portal(Posicion posicion, Laberinto laberinto) {
		super(posicion, laberinto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean esOcupablePorPacman() {
		// TODO Auto-generated method stub
		return true;
	}

}
