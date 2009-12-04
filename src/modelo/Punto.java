package modelo;

public class Punto extends Comestible {

	public Punto(Posicion posicion, Laberinto laberinto) {
		super(posicion, laberinto);
	}

	@Override
	public void comer() {
		this.comido = true;
		this.laberinto.puntoComido();
	}

	@Override
	public boolean esOcupablePorPacman() {
		return true;
	}
	
}