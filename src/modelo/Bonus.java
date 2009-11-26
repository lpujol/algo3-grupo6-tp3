package modelo;

public class Bonus extends Comestible {


	public Bonus(Posicion posicion, Laberinto laberinto) {
		super(posicion, laberinto);
	}
		
	public void comer() {
		this.comido=true;
		this.laberinto.getJuego().bonusComido();
	}

}
