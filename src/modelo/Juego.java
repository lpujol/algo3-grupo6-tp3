package modelo;

public class Juego {


	private static final int VALOR_BONUS = 1000;
	private static final int VALOR_PUNTO = 10;
	private boolean puntoDePoderActivo;
	private Laberinto laberinto;
	private double puntosAcumulados;
	
	private int cantidadVidas;

	
	
	public Juego(){
	
		this.puntoDePoderActivo=false;
		this.puntosAcumulados=0;
		
		this.crearLaberinto();
	}
	
	
	public void crearLaberinto(){
		laberinto= new Laberinto(this);
	}
	
	  
	
	public void pasarNivel(){
		
			Nivel nivel=this.laberinto.pasarNivel();
			laberinto= new Laberinto(this);
			
		
	}
	
	
	public boolean perdido(){
		if(this.cantidadVidas>0)
			return false;
		else return true;
	}
	
			
	public boolean puntoDePoderActivo(){
		return this.puntoDePoderActivo;
	}
	
	
	public Laberinto getLaberinto(){
		return this.laberinto;
	}
	
	
	public double getPuntosAcumulados(){
		return this.puntosAcumulados;
	}
	
	
	
			
	public void setPuntosAcumulados(int puntosAcumulados){
		if (puntosAcumulados<0)
			throw new IllegalArgumentException();
		this.puntosAcumulados=puntosAcumulados;
	}

	public void fantasmaComido(Fantasma fantasma) {
		fantasma.setEstrategiaActual(new EstrategiaIrACasa(fantasma));
		
	}

	


	public void puntoDePoderComido() {
		this.puntoDePoderActivo=true;
		
	}


	public void pacmanComido() {
		this.cantidadVidas --;
		
	}


	public void puntoComido() {
		puntosAcumulados=puntosAcumulados+VALOR_PUNTO*laberinto.getNivel().getNumero();
		
	}

	public void bonusComido() {
		puntosAcumulados=puntosAcumulados+VALOR_BONUS*laberinto.getNivel().getNumero();
		
	}

}