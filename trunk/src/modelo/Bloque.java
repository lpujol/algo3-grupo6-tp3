package modelo;

public abstract class Bloque {
	
	Posicion posicion;
	protected boolean comido;
	
	public Bloque(Posicion posicion) throws IllegalArgumentException {
		if ((posicion.getX() > 0) && (posicion.getY() > 0)) {
			this.posicion = posicion;
		} else {
			throw new IllegalArgumentException();
		}
		this.comido = false;
	}

	
	
	public boolean esOcupable() {
		return true;
	}

	public Posicion getPosicion() {
		return this.posicion;
	}

	public void setPosicion(Posicion posicionNueva) {
		this.posicion = posicionNueva;
	}



	public boolean ocupar() {
		return comido;
	}
	
}
