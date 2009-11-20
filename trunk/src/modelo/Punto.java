package modelo;

public class Punto extends Bloque {

	protected boolean comido;
	
	public Punto(int x, int y) {
		super(x, y);
		this.comido = false;
	}
	
	public boolean comer() {
		this.comido = true;
		return true;
	}
	
	public boolean comido() {
		return this.comido;
	}

	public boolean ocupar() {
		return true;
	}
	
}