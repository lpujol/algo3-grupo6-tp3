package modelo;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;





public class Juego{

	private static final int VALOR_BONUS = 1000;
	private static final int VALOR_PUNTO = 10;
	private Laberinto laberinto;
	private double puntosAcumulados;
	private int cantidadVidas;
	private boolean jugando;
	private int valorBonus;
	private int puntosDePoderActivos;
	
	public Juego(){
		this.puntosAcumulados=0;
		this.laberinto = new Laberinto(this);
		this.cantidadVidas=laberinto.getNivel().getPacman().getCantidadVidas();
		this.jugando=false;
		valorBonus=VALOR_BONUS;
		puntosDePoderActivos=0;
	}	
	

	/*
	 * Devuelve true si se perdio el juego, false en caso contrario.
	 * 
	 * */
	public boolean perdido(){
		if(this.cantidadVidas>0)
			return false;
		else return true;
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

	/*
	 * Realiza los cambios de estado correspondientes a cuando
	 * comienza el efecto del punto de poder.
	 * 
	 * */
	public void puntoDePoderComido() {
		
		this.puntosDePoderActivos++;
		ArrayList<Fantasma> fantasmas=this.laberinto.getFantasmas();
		for(Fantasma fantasma:fantasmas){
			if(fantasma.getEstado().ordinal()!=EstadoFantasma.Muerto.ordinal()&&(fantasma.estaEnCasa()==false)){
				fantasma.setEstrategiaActual(new EstrategiaEscapar(fantasma));
				fantasma.estaHuyendo();
			}
		}
		
		int duracionPuntoDePoder=11-this.getLaberinto().getNivel().getNumero();
				
		if(duracionPuntoDePoder<0) efectoPuntoDePoderTerminado();
		else{
			Timer t=new Timer();
			t.schedule(new TimerTask(){
				@Override
				public void run() {
					
					efectoPuntoDePoderTerminado();				
				}			
			}
			, duracionPuntoDePoder*1000);
		}
	}
		
	/*
	 * Realiza los cambios de estado correspondientes a cuando
	 * termina el efecto del punto de poder.
	 * 
	 * */
	public void efectoPuntoDePoderTerminado(){
		
		this.puntosDePoderActivos--;
		if(puntosDePoderActivos==0){
	
			ArrayList<Fantasma> fantasmas=this.laberinto.getFantasmas();
			for(Fantasma fantasma:fantasmas){
				if(fantasma.getEstado().ordinal()!=EstadoFantasma.Muerto.ordinal()){
					fantasma.restablecerEstrategiaNativa();
					fantasma.recuperarVelocidadInicial();
					fantasma.estaVivo();
				}
			}
		}
	}
		

	/*
	 * Reinicia los estados y posiciones de los objetos vivos y
	 * disminuye la vida de pacman.
	 * */
	public void pacmanComido() {
		laberinto.getNivel().reiniciarPosicionesYEstados();
		if(this.cantidadVidas>0){
			this.laberinto.getNivel().getPacman().disminuirVida();
			this.cantidadVidas=laberinto.getPacman().getCantidadVidas();
		}
		else{
			this.jugando=false;
		}
	}
	
	public int vidasPacman(){
		return this.laberinto.getNivel().getPacman().getCantidadVidas();
	}

	//Incrementa el puntaje de acuerdo al valor del punto.
	public void puntoComido() {		
		puntosAcumulados=puntosAcumulados+VALOR_PUNTO*laberinto.getNivel().getNumero();		
	}
	
	//Incrementa el puntaje de acuerdo al valor del bonus.
	public void bonusComido() {		
		puntosAcumulados=puntosAcumulados+valorBonus*laberinto.getNivel().getNumero();
		
	}
	
	public boolean estaJugando(){
		return this.jugando;
	}

	/*
	 * Resetea los estados adecuadamente para el comienzo del juego.
	 * 
	 * */
	public void comenzar() {
		if(this.jugando==false){
			this.jugando=true;
			laberinto.getNivel().reiniciarPosicionesYEstados();
			laberinto.getNivel().resetearBloques();
			laberinto.getNivel().setNumero(1);
			laberinto.getPacman().setCantidadVidas(3);
			this.cantidadVidas=laberinto.getPacman().getCantidadVidas();
			this.puntosAcumulados=0;
			this.valorBonus=VALOR_BONUS;
			this.puntosDePoderActivos=0;
		}
	}


	public void desactivarPuntoDePoder() {
		this.puntosDePoderActivos=0;		
	}

	public int getCantidadVidas() {
		return this.cantidadVidas;
	}


	public void incrementarValorBonus(int incremento) {
		valorBonus=valorBonus+incremento;		
	}

	public void activarPuntoDePoder() {
		this.puntosDePoderActivos=1;		
	}

	public int getPuntosDePoderActivos() {
		return this.puntosDePoderActivos;
	}







}