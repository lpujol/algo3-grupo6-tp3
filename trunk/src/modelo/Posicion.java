package modelo;

import ar.uba.fi.algo3.titiritero.Posicionable;

public class Posicion implements Posicionable{
	
	private int x;
	private int y;
	
	public Posicion(int x,int y){
		this.x=x;
		this.y=y;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}
	
	public void avanzarHorizontal(int cantidad){
		x+=cantidad;
	}
	
	public void retrocederHorizontal(int cantidad){
		x-=cantidad;
	}
	
	public void avanzarVertical(int cantidad){
		y+=cantidad;
	}
	
	public void retrocederVertical(int cantidad){
		y-=cantidad;
	}

	
	public Posicion getPosicionSiguienteHorizontal(int cantidad) {
		Posicion nuevaPosicion= new Posicion(this.x,this.y);
		nuevaPosicion.avanzarHorizontal(cantidad);
		return nuevaPosicion;
	}

	public Posicion getPosicionAnteriorHorizontal(int cantidad) {
		Posicion nuevaPosicion= new Posicion(this.x,this.y);
		nuevaPosicion.retrocederHorizontal(cantidad);
		return nuevaPosicion;
	}
	public Posicion getPosicionSiguienteVertical(int cantidad) {
		Posicion nuevaPosicion= new Posicion(this.x,this.y);
		nuevaPosicion.retrocederVertical(cantidad);
		return nuevaPosicion;
	}
	public Posicion getPosicionAnteriorVertical(int cantidad) {
		Posicion nuevaPosicion= new Posicion(this.x,this.y);
		nuevaPosicion.avanzarVertical(cantidad);
		return nuevaPosicion;
	}
	
	public boolean equals(Posicion posicion){
		return((this.x==posicion.getX())&& (this.y==posicion.getY()));
	}
	
	public Posicion clone(){
		return new Posicion(this.x,this.y);
	}
	
}
