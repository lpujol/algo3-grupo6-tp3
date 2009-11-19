package modelo;

import java.awt.Point;

public class Fantasma extends Entidad {

	private Estrategia estrategiaNativa;
	private Estrategia estrategiaActual;

	public Fantasma(Estrategia estrategia,Laberinto laberinto,int velocidad){
		this.laberinto=laberinto;
		this.estrategiaActual=estrategia;
		this.estrategiaNativa=estrategia;
		this.posicion=this.laberinto.getPosicionFantasma(this);
		this.velocidad=velocidad;
	};
	
	public void setEstrategiaActual(Estrategia unaEstrategia){
		this.estrategiaActual=unaEstrategia;
	}
	
	public Estrategia getEstrategiaActual(){
		return estrategiaActual;
		
	}
	
	public void restablecerEstrategiaNativa(){
		this.estrategiaActual=estrategiaNativa;
				
	}
	
	public void comer(){
		Juego juegoActual=this.laberinto.getJuego();
		juegoActual.fantasmaComido(this);
		
	}

	public Laberinto getLaberinto() {
		return this.laberinto;
	}

	public void mover(Point nuevaPosicion) {
		while(this.getPosicion().distance(nuevaPosicion)!=0){
			this.acercarHorizontalmente(nuevaPosicion.getX());
			this.acercarVerticalmente(nuevaPosicion.getY());
		
		};
				
	};
	
	private void acercarHorizontalmente(double posicionHorizontal){
		double nuevaCoordenadaX;
		if (this.getPosicion().getX()<posicionHorizontal){ 
			nuevaCoordenadaX = this.getPosicion().getX()+1;}
			else 
				nuevaCoordenadaX=this.getPosicion().getX()-1;

		if (laberinto.getBloqueEnPosicion(nuevaCoordenadaX,this.getPosicion().getY()).ocupable())
				this.getPosicion().setLocation(nuevaCoordenadaX,this.getPosicion().getY());
	
	};
	
	
	private void acercarVerticalmente(double posicionVertical){
		double nuevaCoordenadaY;
		if (this.getPosicion().getY()<posicionVertical){ 
			nuevaCoordenadaY = this.getPosicion().getY()+1;}
			else 
				nuevaCoordenadaY=this.getPosicion().getY()-1;

		if (laberinto.getBloqueEnPosicion(this.getPosicion().getX(),nuevaCoordenadaY).ocupable())
				this.getPosicion().setLocation(this.getPosicion().getX(),nuevaCoordenadaY);
	
	};
	

}
	

