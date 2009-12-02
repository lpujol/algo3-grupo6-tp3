package modelo;

public class EspacioVacio extends NoComestible {

	public EspacioVacio(Posicion posicion, Laberinto laberinto) {
		super(posicion, laberinto);
		// TODO Auto-generated constructor stub
	}
	
	public boolean esOcupable(){
		return true;
	}

	@Override
	public boolean esOcupablePorPacman() {		
		return true;
	}

}
