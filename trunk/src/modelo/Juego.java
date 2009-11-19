package modelo;

import modelo.EstrategiaFantasma;
import modelo.EstrategiaXEscapar;
import modelo.EstrategiaXPerseguir;
import modelo.Laberinto;
import modelo.Nivel;

public class Juego {
	private boolean puntoDePoderActivo;
	private Laberinto laberinto;
	private double puntosAcumulados;
	private Nivel nivel;
	
	private CargadorDeNiveles cargadorDeNiveles;
	private int cantidadVidas;

	
	
	public Juego(){
		this.cargadorDeNiveles=new CargadorDeNiveles();
		this.nivel= cargadorDeNiveles.getSiguiente();
		this.puntoDePoderActivo=false;
		this.puntosAcumulados=0;
		
		this.crearLaberinto();
	}
	
	
	public void crearLaberinto(){
		laberinto= new Laberinto(this.nivel);
	}
	
	  
	
	public void pasarNivel(){
		
			nivel=this.cargadorDeNiveles.getSiguiente();
			laberinto= new Laberinto(this.nivel);
			
		
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
		// TODO Auto-generated method stub
		
	}

	


	public void puntoDePoderComido() {
		// TODO Auto-generated method stub
		
	}

	

}
