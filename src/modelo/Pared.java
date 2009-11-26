package modelo;

public class Pared extends NoComestible {

	public Pared(Posicion posicion,Laberinto laberinto) {
		super(posicion, laberinto);
	}

	@Override
	public void comer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean esOcupable() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
