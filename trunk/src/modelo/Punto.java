package modelo;

import java.awt.Point;

public class Punto implements Bloque {

	private Point posicion;
	private boolean comido;
	
	public Punto(Point posicion) {
		this.posicion = posicion;
		this.comido = false;
	}
	
	public boolean comer() {
		this.comido = true;
		return true;
	}

	public boolean ocupar() {
		return true;
	}
	
}