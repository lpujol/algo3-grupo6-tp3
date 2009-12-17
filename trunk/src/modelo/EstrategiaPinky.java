package modelo;

public class EstrategiaPinky implements IEstrategia {

	Fantasma fantasma;
	
	public EstrategiaPinky(Fantasma fantasma)
	{
		this.fantasma=fantasma;
	}
	
	/*
	 * trata de ubicarse 4 bloques mas adelante en la direccion
	 * hacia donde se dirige el pacman
	 * @see modelo.IEstrategia#getDestino()
	 */
	@Override
	public Posicion getDestino() {
		Laberinto laberinto=fantasma.getLaberinto();
		Direccion direccionPacman=laberinto.getPacman().getDireccion();
		
		switch(direccionPacman)
		{
		case Arriba:
			return cuatroBloquesArriba();
		case Abajo:
			return cuatroBloquesAbajo();
		case Derecha:
			return cuatroBloquesDerecha();
		case Izquierda:
			return cuatroBloquesIzquierda();
			
			
		}
		return null;
	}

	private Posicion cuatroBloquesIzquierda() {
		int factor=4*Laberinto.getTamanoDelBloque();
		Posicion posicionPacman=fantasma.getLaberinto().getPacman().getPosicion();
		Posicion nueva=new Posicion(posicionPacman.getX()-factor,posicionPacman.getY());
		Bloque destino=fantasma.getLaberinto().getBloqueEnPosicion(nueva);	
		if(destino!=null) return nueva;
		return cuatroBloquesAbajo();
	}

	private Posicion cuatroBloquesDerecha() {
		int factor=2*Laberinto.getTamanoDelBloque();
		Posicion posicionPacman=fantasma.getLaberinto().getPacman().getPosicion();
		Posicion nueva=new Posicion(posicionPacman.getX()+factor,posicionPacman.getY());
		Bloque destino=fantasma.getLaberinto().getBloqueEnPosicion(nueva);		
		if(destino!=null) return nueva;
		return cuatroBloquesArriba();
	}

	private Posicion cuatroBloquesAbajo() {
		int factor=2*Laberinto.getTamanoDelBloque();
		Posicion posicionPacman=fantasma.getLaberinto().getPacman().getPosicion();
		Posicion nueva=new Posicion(posicionPacman.getX(),posicionPacman.getY()+factor);
		Bloque destino=fantasma.getLaberinto().getBloqueEnPosicion(nueva);	
		if(destino!=null) return nueva;
		return cuatroBloquesDerecha();
	}

	private Posicion cuatroBloquesArriba() {
		int factor=2*Laberinto.getTamanoDelBloque();
		Posicion posicionPacman=fantasma.getLaberinto().getPacman().getPosicion();
		Posicion nueva=new Posicion(posicionPacman.getX(),posicionPacman.getY()-factor);
		Bloque destino=fantasma.getLaberinto().getBloqueEnPosicion(nueva);
		if(destino!=null) return nueva;
		return cuatroBloquesIzquierda();
	}
	

}
