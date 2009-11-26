package modelo;

public class Posicion {
	
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

	public void setLocation(double d, double posicionVertical) {
		// TODO Auto-generated method stub
		
	}

	
	public Posicion getPosicionSiguienteHorizontal() {
		Posicion nuevaPosicion=this;
		nuevaPosicion.avanzarHorizontal(1);
		return nuevaPosicion;
	}

	public Posicion getPosicionAnteriorHorizontal() {
		Posicion nuevaPosicion=this;
		nuevaPosicion.retrocederHorizontal(1);
		return nuevaPosicion;
	}
	public Posicion getPosicionSiguienteVertical() {
		Posicion nuevaPosicion=this;
		nuevaPosicion.avanzarVertical(1);
		return nuevaPosicion;
	}
	public Posicion getPosicionAnteriorVertical() {
		Posicion nuevaPosicion=this;
		nuevaPosicion.retrocederVertical(1);
		return nuevaPosicion;
	}
	
}
