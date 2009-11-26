package modelo;

public class Bonus extends Comestible {


	public Bonus(Posicion posicion, Laberinto laberinto) {
		this.comido = false;
		this.laberinto=laberinto;
		this.posicion=posicion;
				
	};
	
	public void comer() {
	this.comido=true;
	this.laberinto.getJuego().bonusComido();

	}

}
