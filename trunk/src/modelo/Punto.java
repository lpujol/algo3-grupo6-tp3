package modelo;

public class Punto extends Comestible {

	public Punto(Posicion posicion, Laberinto laberinto) {
		super(posicion, laberinto);
	}

	public void comer() {
		this.comido = true;
		this.laberinto.getJuego().puntoComido();
	}
	
}