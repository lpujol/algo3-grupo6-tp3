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
		Posicion posicionPacman=laberinto.getPacman().getPosicion();
		Direccion direccionPacman=laberinto.getPacman().getDireccion();
		
		switch(direccionPacman)
		{
		case Arriba:
			return new Posicion(posicionPacman.getX(),posicionPacman.getY()-4);
		case Abajo:
			return new Posicion(posicionPacman.getX(),posicionPacman.getY()+4);
		case Derecha:
			return new Posicion(posicionPacman.getX()+4,posicionPacman.getY());
		case Izquierda:
			return new Posicion(posicionPacman.getX()-4,posicionPacman.getY());
			
			
		}
		return null;
	}
	

}
