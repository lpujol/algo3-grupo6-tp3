package modelo;



public class Portal extends Comestible {

	private boolean activado;
	
	public Portal(Posicion posicion, Laberinto laberinto) {
		super(posicion, laberinto);
		this.activado=false;
	}

	public boolean esOcupablePorFantasma(Fantasma unFantasma){
		this.portalActivado();
		this.laberinto.activarPortal(this);
		return true;
	}
	

	public boolean esOcupablePorPacman() {		
		
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
	}

	@Override
	public void comer() {
		this.portalActivado();
		this.laberinto.activarPortal(this);
		
	}


}
