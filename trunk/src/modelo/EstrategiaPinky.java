package modelo;

public class EstrategiaPinky implements IEstrategia {

	Fantasma fantasma;
	
	public EstrategiaPinky(Fantasma fantasma)
	{
		this.fantasma=fantasma;
	}
	
	@Override
	public Posicion getDestino() {
		Laberinto laberinto=fantasma.getLaberinto();
		//Posicion posicionPacman=laberinto.getPacman().getPosicion();
		Direccion direccionPacman=laberinto.getPacman().getDireccion();
		
		switch(direccionPacman)
		{
		case Arriba:
			return cuatroBloquesArriba();//new Posicion(posicionPacman.getX(),posicionPacman.getY()-4);
		case Abajo:
			return cuatroBloquesAbajo();//new Posicion(posicionPacman.getX(),posicionPacman.getY()+4);
		case Derecha:
			return cuatroBloquesDerecha();//new Posicion(posicionPacman.getX()+4,posicionPacman.getY());
		case Izquierda:
			return cuatroBloquesIzquierda();//new Posicion(posicionPacman.getX()-4,posicionPacman.getY());
			
			
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
