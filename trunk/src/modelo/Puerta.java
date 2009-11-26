package modelo;

public class Puerta extends NoComestible {

	public Puerta(Posicion posicion, Laberinto laberinto) {
		super(posicion, laberinto);
	}
	
	public boolean esOcupable() {
		return false;
	}
}
