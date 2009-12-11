package modelo;

import ar.uba.fi.algo3.titiritero.Posicionable;

public abstract class Bloque implements Posicionable {

	protected Laberinto laberinto;
	protected Posicion posicion;
	protected boolean comido;

	public Bloque(Posicion posicion, Laberinto laberinto)
			throws IllegalArgumentException {
		if ((posicion.getX() > 0) && (posicion.getY() > 0)) {
			this.posicion = posicion;
		} else {
			throw new IllegalArgumentException();
		}
		this.comido = false;
		this.laberinto = laberinto;
	}

	public abstract boolean esOcupable(Fantasma unFantasma);
	
	public abstract boolean esOcupablePorPacman();

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
	
	@Override
	public int getX() {
		return this.posicion.getX();
	}

	@Override
	public int getY() {
		return this.posicion.getY();
	}

}
