package modelo;


public class EstrategiaInki implements IEstrategia {

	Fantasma fantasma;
	public EstrategiaInki(Fantasma fantasma)
	{
		this.fantasma=fantasma; 
	}
	/*
	 * segun la direccion en la que este llendo el pacman, se trata de interceptar por diferentes lados
	 * 
	 */
	
	@Override
	public Posicion getDestino() {
		Laberinto laberinto=fantasma.getLaberinto();
		Direccion direccionPacman=laberinto.getPacman().getDireccion();
			switch(direccionPacman)
			{
			case Arriba:
				return interceptarDesdeAbajo();
			case Abajo:
				return interceptarDesdeArriba();
			case Derecha:
				return interceptarDesdeIzquierda();
			case Izquierda:
				return interceptarDesdeDerecha();
			}

		return null;
	}
	private Posicion interceptarDesdeIzquierda() {
		int factor=2*Laberinto.getTamanoDelBloque();
		Posicion posicionPacman=fantasma.getLaberinto().getPacman().getPosicion();
		Posicion nueva=new Posicion(posicionPacman.getX()-factor,posicionPacman.getY());
		Bloque destino=fantasma.getLaberinto().getBloqueEnPosicion(nueva);	
		if(destino!=null) return nueva;
		return interceptarDesdeAbajo();
	}
	private Posicion interceptarDesdeDerecha() {
		int factor=2*Laberinto.getTamanoDelBloque();
		Posicion posicionPacman=fantasma.getLaberinto().getPacman().getPosicion();
		Posicion nueva=new Posicion(posicionPacman.getX()+factor,posicionPacman.getY());
		Bloque destino=fantasma.getLaberinto().getBloqueEnPosicion(nueva);		
		if(destino!=null) return nueva;
		return interceptarDesdeArriba();
	}
	private Posicion interceptarDesdeAbajo() {
		int factor=2*Laberinto.getTamanoDelBloque();
		Posicion posicionPacman=fantasma.getLaberinto().getPacman().getPosicion();
		Posicion nueva=new Posicion(posicionPacman.getX(),posicionPacman.getY()+factor);
		Bloque destino=fantasma.getLaberinto().getBloqueEnPosicion(nueva);	
		if(destino!=null) return nueva;
		return interceptarDesdeDerecha();
	}
	private Posicion interceptarDesdeArriba() {
		int factor=2*Laberinto.getTamanoDelBloque();
		Posicion posicionPacman=fantasma.getLaberinto().getPacman().getPosicion();
		Posicion nueva=new Posicion(posicionPacman.getX(),posicionPacman.getY()-factor);
		Bloque destino=fantasma.getLaberinto().getBloqueEnPosicion(nueva);
		if(destino!=null) return nueva;
		return interceptarDesdeIzquierda();
	}

}
