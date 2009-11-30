package modelo;

public class Bonus extends Comestible {


	public Bonus(Posicion posicion, Laberinto laberinto) {
		super(posicion, laberinto);
	}
	
	@Override
	public void comer() {
		this.comido = true;
		this.laberinto.getJuego().bonusComido();
	}

	@Override
	public boolean esOcupablePorPacman() {
		return true;
	}

}
