package modelo;

public class PuntoDePoder extends Comestible {
		
	public PuntoDePoder(Posicion posicion, Laberinto laberinto) {
		super(posicion, laberinto);
	}
	
	@Override
	public void comer() {
		this.comido = true;
		this.laberinto.puntoDePoderComido();
	}

	@Override
	public boolean esOcupablePorPacman() {
		return true;
	}
}
