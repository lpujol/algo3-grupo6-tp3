package modelo;



public class PuntoDePoder extends Comestible {
	
		
	PuntoDePoder(Posicion posicion,Laberinto laberinto) {
		this.comido = false;
		this.laberinto=laberinto;
		this.posicion=posicion;
		
	}
	
	public void comer() {
		this.comido = true;
		this.laberinto.getJuego().puntoDePoderComido();
	}
}
