package modelo;

public class Pared extends NoComestible {

	public Pared(Posicion posicion,Laberinto laberinto) {
		this.comido = false;
		this.laberinto=laberinto;
		this.posicion=posicion;
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
