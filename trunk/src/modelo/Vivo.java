package modelo;


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
		posicion.avanzarHorizontal(velocidad);
		return false;
	}
	
	public boolean irHaciaLaIzquierda(){
		posicion.retrocederHorizontal(velocidad);
		return false;
	}
	public boolean irHaciaArriba(){
		posicion.retrocederVertical(velocidad);
		return false;
	}
		
	public boolean irHaciaAbajo(){
		posicion.avanzarVertical(velocidad);
		return false;
	}

	abstract public void vivir();

	public void mover() {
		Posicion siguientePosicion=this.posicion;
		switch(direccion){
		case Arriba:{
			siguientePosicion.avanzarVertical(velocidad);
			if (this.laberinto.getBloqueEnPosicion(siguientePosicion).esOcupable())
			irHaciaArriba();};
			break;
		case Abajo:{
			siguientePosicion.retrocederVertical(velocidad);
			if (this.laberinto.getBloqueEnPosicion(siguientePosicion).esOcupable())
			irHaciaArriba();};
			break;
		case Derecha:{
			siguientePosicion.avanzarHorizontal(velocidad);
			if (this.laberinto.getBloqueEnPosicion(siguientePosicion).esOcupable())
			irHaciaArriba();};
			break;
		case Izquierda:{
			siguientePosicion.retrocederHorizontal(velocidad);
			if (this.laberinto.getBloqueEnPosicion(siguientePosicion).esOcupable())
			irHaciaArriba();};
			break;
		}
				
	}
				
	

}
