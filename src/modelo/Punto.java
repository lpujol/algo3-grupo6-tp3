package modelo;

public class Punto extends Comestible {

	protected boolean comido;
	
	public Punto(Posicion posicion, Laberinto laberinto) {
		this.comido = false;
		this.laberinto=laberinto;
		this.posicion=posicion;
	}

	public void comer() {
		this.comido=true;
		this.laberinto.getJuego().puntoComido();
		
	}
	
	
}