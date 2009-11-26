package modelo;

public abstract class Bloque {
	
	protected Laberinto laberinto;
	protected Posicion posicion;
	protected boolean comido;
	
/**	public Bloque(Posicion posicion) throws IllegalArgumentException {
		if ((posicion.getX() > 0) && (posicion.getY() > 0)) {
			this.posicion = posicion;
		} else {
			throw new IllegalArgumentException();
		}
		this.comido = false;
	}
**/
	
	
	public abstract boolean esOcupable();

	public Posicion getPosicion() {
		return this.posicion;
	}

	public void setPosicion(Posicion posicionNueva) {
		this.posicion = posicionNueva;
	}

	public abstract void comer();

	public boolean comido() {
		
		return comido;
	}
	
}
