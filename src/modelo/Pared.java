package modelo;

import java.awt.Point;

public class Pared implements Bloque {

	private Point posicion;
	
	public Pared(Point posicion) {
		this.posicion = posicion;
	}
	
	public boolean comer() {
		return false;
	}

	public boolean ocupar() {
		return false;
	}
	
}
