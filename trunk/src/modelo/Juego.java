package modelo;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;

import vista.VistaPunto;
import vista.VistaPuntoPoder;


public class Juego implements ObjetoVivo{


	private static final int VALOR_BONUS = 1000;
	private static final int VALOR_PUNTO = 10;
	private boolean puntoDePoderActivo;
	private Laberinto laberinto;
	private double puntosAcumulados;
	private int cantidadVidas;
	private ArrayList<VistaPunto> vistaPuntos;
	private ArrayList<VistaPuntoPoder> vistaPuntosPoder;
	private int contadorticks;

	
	
	public Juego(){

		this.puntoDePoderActivo=false;
		this.puntosAcumulados=0;
		this.laberinto = new Laberinto(this);
		this.cantidadVidas=laberinto.getNivel().getPacman().getCantidadVidas();
		vistaPuntos=new ArrayList<VistaPunto>();
		vistaPuntosPoder=new ArrayList<VistaPuntoPoder>();
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
		fantasma.setEstrategiaActual(new EstrategiaIrACasa(fantasma));
		
	}

	


	public void puntoDePoderComido(PuntoDePoder punto) {
		this.puntoDePoderActivo=true;
		for(VistaPuntoPoder p:vistaPuntosPoder){
			if(p.getPosicionable()==punto){
				p.setNombreArchivoImagen("negro.jpg");
			}
		}
		ArrayList<Fantasma> fantasmas=this.laberinto.getFantasmas();
		for(Fantasma fantasma:fantasmas){
			fantasma.setEstrategiaActual(new EstrategiaEscapar(fantasma));
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
		ArrayList<Fantasma> fantasmas=this.laberinto.getFantasmas();
		for(Fantasma fantasma:fantasmas){
			if(!(fantasma.getEstrategiaActual() instanceof EstrategiaIrACasa))
			fantasma.restablecerEstrategiaNativa();
		}
	}


	public void pacmanComido() {
		this.cantidadVidas --;
		if(this.cantidadVidas>0){
			this.laberinto.getNivel().getPacman().disminuirVida();
			this.laberinto.getNivel().enviarPacmanAPosicionInicial();
		}
	}
	
	public int vidasPacman(){
		return this.laberinto.getNivel().getPacman().getCantidadVidas();
	}


	public void puntoComido(Punto punto) {
		puntosAcumulados=puntosAcumulados+VALOR_PUNTO*laberinto.getNivel().getNumero();
		for(VistaPunto p:vistaPuntos)
		{
			if(p.getPosicionable()==punto)
			{
				p.setNombreArchivoImagen("negro.jpg");
			}
		}
	}
	

	public void bonusComido() {
		puntosAcumulados=puntosAcumulados+VALOR_BONUS*laberinto.getNivel().getNumero();
		
	}

	public void vistaPuntos(ArrayList<VistaPunto> vistaPuntos) {
		this.vistaPuntos=vistaPuntos;
	}

	public void vistaPuntosPoder(ArrayList<VistaPuntoPoder> vistaPuntosPoder) {
		this.vistaPuntosPoder=vistaPuntosPoder;
		
	}

	@Override
	public void vivir() {
		// TODO Auto-generated method stub
		this.contadorticks++;
	}

}