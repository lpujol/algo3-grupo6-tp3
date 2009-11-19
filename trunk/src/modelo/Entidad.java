package modelo;

import java.awt.Point;

public abstract class Entidad {
	
	private Direccion direccion;
	private int velocidad;
	private Point posicion;
	
	
	public Direccion getDireccion()	{
		return direccion;
	}
	
	public Point getPosicion(){
		return posicion;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public boolean irHaciaLaDerecha(){
		return false;
	}
	
	public boolean irHaciaLaIzquierda(){
		return false;
	}
	public boolean irHaciaArriba(){
		return false;
	}
	
	public boolean irHaciaAbajo(){
		return false;
	}

	public void mover() {
		switch(direccion){
		case Arriba:
			irHaciaArriba();
			break;
		case Abajo:
			irHaciaAbajo();
			break;
		case Derecha:
			irHaciaLaDerecha();
			break;
		case Izquierda:
			irHaciaLaIzquierda();
			break;
		}
				
	}
}
