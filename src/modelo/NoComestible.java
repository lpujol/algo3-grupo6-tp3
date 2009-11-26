package modelo;

public abstract class NoComestible extends Bloque {

	public NoComestible(Posicion posicion, Laberinto laberinto) {
		super(posicion, laberinto);
	}
	
	public void comer() {
		this.comido = false;
	}

}
