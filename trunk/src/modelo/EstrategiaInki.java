package modelo;


public class EstrategiaInki implements IEstrategia {

	Fantasma fantasma;
	public EstrategiaInki(Fantasma fantasma)
	{
		this.fantasma=fantasma; 
	}
	/*
	 * segun la direccion en la que este llendo el pacman, se trata de interceptar por diferentes lados
	 * @see modelo.IEstrategia#getDestino()
	 */
	
	@Override
	public Posicion getDestino() {
		Laberinto laberinto=fantasma.getLaberinto();
		Direccion direccionPacman=laberinto.getPacman().getDireccion();
			switch(direccionPacman)
			{
			case Arriba:
				return interceptarDesdeAbajo();//new Posicion(posicionPacman.getX()-4*factor,posicionPacman.getY()-4*factor);
			case Abajo:
				return interceptarDesdeArriba();//new Posicion(posicionPacman.getX(),posicionPacman.getY()+4*factor);
			case Derecha:
				return interceptarDesdeIzquierda();//new Posicion(posicionPacman.getX()+4*factor,posicionPacman.getY());
			case Izquierda:
				return interceptarDesdeDerecha();//new Posicion(posicionPacman.getX()-4*factor,posicionPacman.getY());
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
