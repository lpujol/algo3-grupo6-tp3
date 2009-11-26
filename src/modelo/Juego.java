package modelo;

public class Juego {


	private static final int VALOR_BONUS = 1000;
	private static final int VALOR_PUNTO = 10;
	private boolean puntoDePoderActivo;
	private Laberinto laberinto;
	private double puntosAcumulados;
	private Nivel nivel;
	
	private CargadorDeNiveles cargadorDeNiveles;
	private int cantidadVidas;

	
	
	public Juego(){
		this.cargadorDeNiveles = new CargadorDeNiveles(this, this.laberinto);
		this.nivel= cargadorDeNiveles.getSiguiente();
		this.puntoDePoderActivo=false;
		this.puntosAcumulados=0;
		
		this.crearLaberinto();
	}
	
	
	public void crearLaberinto(){
		laberinto= new Laberinto(this.nivel, this);
	}
	
	  
	
	public void pasarNivel(){
		
			nivel=this.cargadorDeNiveles.getSiguiente();
			laberinto= new Laberinto(this.nivel, this);
			
		
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
	
	
	public Nivel getNivel(){
		return this.nivel;
	}
	
			
	public void setPuntosAcumulados(int puntosAcumulados){
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
		puntosAcumulados=puntosAcumulados+VALOR_PUNTO*nivel.getNumero();
		
	}

	public void bonusComido() {
		puntosAcumulados=puntosAcumulados+VALOR_BONUS*nivel.getNumero();
		
	}

}
