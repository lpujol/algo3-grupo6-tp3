package modelo;

import java.awt.Point;

public abstract class Entidad {
	
	//protected Direccion direccion;
	protected int velocidad;
	protected Point posicion;
	protected Laberinto laberinto;
	
	/**public Direccion getDireccion()	{
		return direccion;
	}**/
	
	public Point getPosicion(){
		return posicion;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public boolean irHaciaLaDerecha(){
		double posicionVertical=this.posicion.getY();
		double posicionHorizontal=this.posicion.getX();
		this.posicion.setLocation(posicionHorizontal+1,posicionVertical);
		return false;
	}
	
	public boolean irHaciaLaIzquierda(){
		double posicionVertical=this.posicion.getY();
		double posicionHorizontal=this.posicion.getX();
		this.posicion.setLocation(posicionHorizontal-1,posicionVertical);
		return false;
	}
	public boolean irHaciaArriba(){
		double posicionVertical=this.posicion.getY();
		double posicionHorizontal=this.posicion.getX();
		this.posicion.setLocation(posicionHorizontal,posicionVertical+1);
		return false;
	}
	
	public boolean irHaciaAbajo(){
		double posicionVertical=this.posicion.getY();
		double posicionHorizontal=this.posicion.getX();
		this.posicion.setLocation(posicionHorizontal,posicionVertical-1);
		return false;
	}



/**
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
**/
}
