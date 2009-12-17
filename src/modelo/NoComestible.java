package modelo;

public abstract class NoComestible extends Bloque {

	public NoComestible(Posicion posicion, Laberinto laberinto) {
		super(posicion, laberinto);
	}
	
	public boolean esOcupablePorFantasma(Fantasma unFantasma) {
		return false;
	}
	
	public void comer() {
		this.comido = false;
	}

}
