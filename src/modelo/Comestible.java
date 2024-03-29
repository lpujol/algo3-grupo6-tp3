package modelo;

public abstract class Comestible extends Bloque {
	
	public Comestible(Posicion posicion, Laberinto laberinto) {
		super(posicion, laberinto);
	}
	
	public boolean esOcupablePorFantasma(Fantasma unFantasma) {
		return true;
	}
	
	public abstract void comer();

}