package modelo;

import java.awt.Point;

public abstract class Vivo {
	
	protected Direccion direccion;
	protected int velocidad;
	protected Posicion posicion;
	protected Laberinto laberinto;
	
	public Direccion getDireccion()	{
		return direccion;
	}
	
	public Posicion getPosicion(){
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

	abstract public void vivir();

				
	

}
