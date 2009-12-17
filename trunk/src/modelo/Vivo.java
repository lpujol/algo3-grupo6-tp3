package modelo;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;


public abstract class Vivo implements Posicionable,ObjetoVivo {
	
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
		posicion.avanzarHorizontal(1);
		return false;
	}
	
	public boolean irHaciaLaIzquierda(){
		posicion.retrocederHorizontal(1);
		return false;
	}
	
	public boolean irHaciaArriba(){
		posicion.retrocederVertical(1);
		return false;
	}
		
	public boolean irHaciaAbajo(){
		posicion.avanzarVertical(1);
		return false;
	}

	abstract public void vivir();

	
	protected void mover() {
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
	
	@Override
	public int getX() {
		// Para centrar las imagenes mas grandes que los casilleros
		// Los objetos son 50% mas grandes que los casilleros
		int x = this.posicion.getX();
		return x-Laberinto.getTamanoDelBloque()/4;
	}

	@Override
	public int getY() {
		// Para centrar las imagenes mas grandes que los casilleros
		// Los objetos son 50% mas grandes que los casilleros
		int y = this.posicion.getY();
		return y-Laberinto.getTamanoDelBloque()/4;
	}

	public void incrementarVelocidad(int incremento){
		velocidad=velocidad+incremento;
	};
}
