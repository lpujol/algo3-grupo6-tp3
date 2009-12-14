package modelo;



public class Portal extends NoComestible {

	private boolean activado;
	
	public Portal(Posicion posicion, Laberinto laberinto) {
		super(posicion, laberinto);
		this.activado=false;
	}
/*
	public boolean esOcupable(Fantasma unFantasma){
		this.portalActivado();
		this.laberinto.activarPortal(this);
		return true;
	}
	

	public boolean esOcupablePorPacman() {		
		this.laberinto.activarPortal(this);
		this.laberinto.getPacman().setPosicion(this.laberinto.getPosicionPuerta());
		return true;
	}

	public void portalDesactivado() {
		activado=false;		
	}
	
	public void portalActivado() {
		activado=true;		
	}

	public boolean estaActivo() {
		return this.activado;
	}*/

	@Override
	public boolean esOcupablePorPacman() {
		// TODO Auto-generated method stub
		return false;
	}
}
