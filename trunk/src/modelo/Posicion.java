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

	public int distancia(Posicion posicion) {
		// TODO Auto-generated method stub
		return 0;
	}

}
