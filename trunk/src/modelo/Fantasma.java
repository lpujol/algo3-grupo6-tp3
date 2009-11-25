package modelo;



public class Fantasma extends Vivo {

	private IEstrategia estrategiaNativa;
	private IEstrategia estrategiaActual;

	public Fantasma(IEstrategia estrategia,Laberinto laberinto,int velocidad){
		this.laberinto=laberinto;
		this.estrategiaActual=estrategia;
		this.estrategiaNativa=estrategia;
		this.posicion=this.laberinto.getPosicionFantasma(this);
		this.velocidad=velocidad;
	};
	
	public void setEstrategiaActual(IEstrategia unaEstrategia){
		this.estrategiaActual=unaEstrategia;
	}
	
	public IEstrategia getEstrategiaActual(){
		return estrategiaActual;
		
	}
	
	public void restablecerEstrategiaNativa(){
		this.estrategiaActual=estrategiaNativa;
				
	}
	
	public void vivir(){
		this.estrategiaActual.getDestino();
	};
	
	public void comer(){
		Juego juegoActual=this.laberinto.getJuego();
		juegoActual.fantasmaComido(this);
		
	}

	public Laberinto getLaberinto() {
		return this.laberinto;
	}
	
	

	/*public void mover(Posicion posicion) {
	
			this.acercarHorizontalmente(posicion.getX());
			this.acercarVerticalmente(posicion.getY());
		
	
				
	};
	
	private void acercarHorizontalmente(double posicionHorizontal){
		double nuevaCoordenadaX;
		if (this.getPosicion().getX()<posicionHorizontal){ 
			nuevaCoordenadaX = this.getPosicion().getX()+1;}
			else 
				nuevaCoordenadaX=this.getPosicion().getX()-1;

		if (laberinto.getBloqueEnPosicion(nuevaCoordenadaX,this.getPosicion().getY()).esOcupable())
				this.getPosicion().setLocation(nuevaCoordenadaX,this.getPosicion().getY());
	
	};
	
	
	private void acercarVerticalmente(double posicionVertical){
		double nuevaCoordenadaY;
		if (this.getPosicion().getY()<posicionVertical){ 
			nuevaCoordenadaY = this.getPosicion().getY()+1;}
			else 
				nuevaCoordenadaY=this.getPosicion().getY()-1;

		if (laberinto.getBloqueEnPosicion(this.getPosicion().getX(),nuevaCoordenadaY).esOcupable())
				this.getPosicion().setLocation(this.getPosicion().getX(),nuevaCoordenadaY);
	
	};
	*/

}
	

