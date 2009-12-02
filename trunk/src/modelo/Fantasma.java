package modelo;




public abstract class Fantasma extends Vivo {

	protected IEstrategia estrategiaNativa;
	protected IEstrategia estrategiaActual;

		
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
		
		if (laberinto.cambioDeDireccionPermitido(this.posicion)){
			this.moverse(this.estrategiaActual.getDestino());			
		}
		else {
			mover();
		}
		if (this.laberinto.mismoBloque(this.posicion,this.laberinto.getPacman().getPosicion()))
				if(this.laberinto.getJuego().puntoDePoderActivo()){ 
					this.comer();}
				else{
					this.laberinto.getPacman().comer();
				}
					
					
	};
	
	public void comer(){
		Juego juegoActual=this.laberinto.getJuego();
		juegoActual.fantasmaComido(this);
		
	}

	public Laberinto getLaberinto() {
		return this.laberinto;
	}
	
	public void moverse(Posicion destino){		
		Posicion posicionPosibleIzquierda=laberinto.getPosicionBloqueAnteriorHorizontal(posicion);
		Posicion posicionPosibleAbajo=laberinto.getPosicionBloqueAnteriorVertical(posicion);
		Posicion posicionPosibleDerecha=laberinto.getPosicionBloqueSiguienteHorizontal(posicion);
		Posicion posicionPosibleArriba=laberinto.getPosicionBloqueSiguienteVertical(posicion);
		double distanciaMinima=1000;
		if (esAdecuadoMoverse(destino, posicionPosibleArriba, distanciaMinima)){
			distanciaMinima=laberinto.distancia(laberinto.getBloqueEnPosicion(posicionPosibleArriba),laberinto.getBloqueEnPosicion(destino));
			direccion=Direccion.Arriba;
		}
		if (esAdecuadoMoverse(destino, posicionPosibleAbajo, distanciaMinima)){
			distanciaMinima=laberinto.distancia(laberinto.getBloqueEnPosicion(posicionPosibleAbajo),laberinto.getBloqueEnPosicion(destino));
			direccion=Direccion.Abajo;
		}
		if (esAdecuadoMoverse(destino, posicionPosibleDerecha, distanciaMinima)){
			distanciaMinima=laberinto.distancia(laberinto.getBloqueEnPosicion(posicionPosibleDerecha),laberinto.getBloqueEnPosicion(destino));
			direccion=Direccion.Derecha;
		}
		if (esAdecuadoMoverse(destino, posicionPosibleIzquierda, distanciaMinima)){
			distanciaMinima=laberinto.distancia(laberinto.getBloqueEnPosicion(posicionPosibleIzquierda),laberinto.getBloqueEnPosicion(destino));
			direccion=Direccion.Izquierda;
		}
		this.mover();	
				
	}

	private boolean esAdecuadoMoverse(Posicion destino,
			Posicion posicionPosible, double distanciaMinima) {
		
		return ((laberinto.getBloqueEnPosicion(posicionPosible).esOcupable())&& (laberinto.distancia(laberinto.getBloqueEnPosicion(posicionPosible),laberinto.getBloqueEnPosicion(destino))<distanciaMinima));
			
		
	}
	
}

	