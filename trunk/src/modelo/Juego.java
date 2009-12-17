package modelo;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;





public class Juego{

	private static final int VALOR_BONUS = 1000;
	private static final int VALOR_PUNTO = 10;
	private boolean puntoDePoderActivo;
	private Laberinto laberinto;
	private double puntosAcumulados;
	private int cantidadVidas;
	private boolean jugando;
	private int valorBonus;
	private int puntosDePoderActivos;
	
	public Juego(){
		this.puntoDePoderActivo=false;
		this.puntosAcumulados=0;
		this.laberinto = new Laberinto(this);
		this.cantidadVidas=laberinto.getNivel().getPacman().getCantidadVidas();
		this.jugando=false;
		valorBonus=VALOR_BONUS;
		puntosDePoderActivos=0;
	}	
	
	public void pasarNivel(){
			this.laberinto.getNivel().pasarDeNivel();
			this.puntoDePoderActivo=false;
			this.valorBonus=valorBonus+200;
			
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
		this.puntosDePoderActivos++;
		ArrayList<Fantasma> fantasmas=this.laberinto.getFantasmas();
		for(Fantasma fantasma:fantasmas){
			if(fantasma.getEstado().ordinal()!=EstadoFantasma.Muerto.ordinal()&&(fantasma.estaEnCasa()==false)){
				fantasma.setEstrategiaActual(new EstrategiaEscapar(fantasma));
				fantasma.estaHuyendo();
			}
		}
		
		int duracionPuntoDePoder=11-this.getLaberinto().getNivel().getNumero();
		
		System.out.print(duracionPuntoDePoder);
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
		
	
	public void efectoPuntoDePoderTerminado(){
		
		this.puntosDePoderActivos--;
		if(puntosDePoderActivos==0){
			this.puntoDePoderActivo=false;
			ArrayList<Fantasma> fantasmas=this.laberinto.getFantasmas();
			for(Fantasma fantasma:fantasmas){
				/**/		if(fantasma.getEstado().ordinal()!=EstadoFantasma.Muerto.ordinal()){
					fantasma.restablecerEstrategiaNativa();
					fantasma.recuperarVelocidadInicial();
					fantasma.estaVivo();
				}
			}
		}
	}
		


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


	public void puntoComido() {		
		puntosAcumulados=puntosAcumulados+VALOR_PUNTO*laberinto.getNivel().getNumero();		
	}
	

	public void bonusComido() {		
		puntosAcumulados=puntosAcumulados+VALOR_BONUS*laberinto.getNivel().getNumero();
		
	}
	
	public boolean estaJugando(){
		return this.jugando;
	}

	public void comenzar() {
		if(this.jugando==false){
			this.jugando=true;
			laberinto.getNivel().reiniciarPosicionesYEstados();
			laberinto.getNivel().resetearBloques();
			laberinto.getNivel().setNumero(1);
			laberinto.getPacman().setCantidadVidas(3);
			this.cantidadVidas=laberinto.getPacman().getCantidadVidas();
			this.puntosAcumulados=0;
		}
	}


	public void desactivarPuntoDePoder() {
		this.puntoDePoderActivo=false;		
	}

	public int getCantidadVidas() {
		return this.cantidadVidas;
	}


	public void incrementarValorBonus(int incremento) {
		valorBonus=valorBonus+incremento;		
	}

	public void activarPuntoDePoder() {
		this.puntoDePoderActivo=true;		
	}







}