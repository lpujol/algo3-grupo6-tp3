package modelo;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;



import vista.Audio;


public class Juego{

//agregadoAudio
	//private Audio audio;
	//---
	private static final int VALOR_BONUS = 1000;
	private static final int VALOR_PUNTO = 10;
	private boolean puntoDePoderActivo;
	private Laberinto laberinto;
	private double puntosAcumulados;
	private int cantidadVidas;

	
	
	public Juego(){
		//agregadoAudio
		/*if (true){
	 		audio = new Audio("inicio.au");
	 		audio.play(false);
	    }*/
		//---

		this.puntoDePoderActivo=false;
		this.puntosAcumulados=0;
		this.laberinto = new Laberinto(this);
		this.cantidadVidas=laberinto.getNivel().getPacman().getCantidadVidas();
	}	
	
	public void pasarNivel(){
			this.laberinto.getNivel().pasarDeNivel();
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
		
	//-----agregado para audio
		
		/*if (true){
	 		audio = new Audio("muerteFantasma.au");
	 		audio.play(false);
	    }*/
		//-----
		fantasma.setEstrategiaActual(new EstrategiaIrACasa(fantasma));
		
	}

	


	public void puntoDePoderComido() {
		this.puntoDePoderActivo=true;
		
		//agregado para audio
		/*if (puntoDePoderActivo){
	 		audio = new Audio("comePoder.wav");
	 		audio.play(false);
	    }*/
		//--
		
		
		ArrayList<Fantasma> fantasmas=this.laberinto.getFantasmas();
		for(Fantasma fantasma:fantasmas){
			fantasma.setEstrategiaActual(new EstrategiaEscapar(fantasma));
			fantasma.estaHuyendo();
		}
		
		
		Timer t=new Timer();
		t.schedule(new TimerTask(){
			@Override
			public void run() {
				efectoPuntoDePoderTerminado();				
			}			
		}
		, 5000);
		
	}
		
	
	public void efectoPuntoDePoderTerminado(){
		this.puntoDePoderActivo=false;
		ArrayList<Fantasma> fantasmas=this.laberinto.getFantasmas();
		for(Fantasma fantasma:fantasmas){
			if(fantasma.getEstado()!=EstadoFantasma.Muerto){
			fantasma.restablecerEstrategiaNativa();
			fantasma.estaVivo();
			}
		}
	}


	public void pacmanComido() {
		this.cantidadVidas --;
		
		
		//agregadoAudio
		/*if (this.cantidadVidas>0){
	 		audio = new Audio("muerte.wav");
	 		audio.play(false);
	    }*/
		//-----
		
		
		if(this.cantidadVidas>0){
			this.laberinto.getNivel().getPacman().disminuirVida();
			this.laberinto.getNivel().enviarPacmanAPosicionInicial();
		}
	}
	
	public int vidasPacman(){
		return this.laberinto.getNivel().getPacman().getCantidadVidas();
	}


	public void puntoComido() {
		
		
		puntosAcumulados=puntosAcumulados+VALOR_PUNTO*laberinto.getNivel().getNumero();
		
	}
	

	public void bonusComido() {
		
		//agregado para audio
		/*if (true){
	 		audio = new Audio("comePoder.wav");
	 		audio.play(false);
	    }*/
		//--
		
		puntosAcumulados=puntosAcumulados+VALOR_BONUS*laberinto.getNivel().getNumero();
		
	}




}