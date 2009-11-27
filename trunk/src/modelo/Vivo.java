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
	
	public void cambiarDireccion(Direccion unaDireccion){
		
		this.direccion=unaDireccion;
	}
	
	
	
	
	public void setLaberinto(Laberinto nuevoLaberinto){
		this.laberinto=nuevoLaberinto;
		
		
	};
				
	

}
