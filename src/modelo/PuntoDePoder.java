package modelo;



public class PuntoDePoder extends Comestible {
	
		
	PuntoDePoder(Posicion posicion, Laberinto laberinto) {
		super(posicion, laberinto);
	}
	
	public void comer() {
		this.comido = true;
		this.laberinto.getJuego().puntoDePoderComido();
	}
}
