package modelo;

import modelo.EstrategiaFantasma;
import modelo.EstrategiaXEscapar;
import modelo.EstrategiaXPerseguir;
import modelo.Laberinto;
import modelo.Nivel;

public class Juego {
	
	private boolean puntoDePoderActivo;
	private Laberinto laberinto;
	private int puntosAcumulados;
	private Nivel nivel;
	private EstrategiaFantasma estrategia;
	
	private int nivelActual=1;
	
	
	public Juego(){
		
		this.nivel= new Nivel(nivelActual);
		this.puntoDePoderActivo=false;
		this.puntosAcumulados=0;
		estrategia= new EstrategiaXPerseguir();
		this.crearLaberinto(this.nivel);
	}
	
	
	public void crearLaberinto(Nivel nivel,int ancho , int alto){
		laberinto= new Laberinto(ancho, alto);
	}
	
	
	public void crearLaberinto(Nivel nivel){
		laberinto=new Laberinto(nivel)
	}
	
	
     void cambiarEstrategia(){
    	 
    	 if(this.puntoDePoderActivo)
    		 estrategia=new EstrategiaXEscapar();
    		 
    	 else estrategia=new EstrategiaXPerseguir();
		
	}
     
	
	public void pasarNivel(){
		
		if((laberinto.estaSinPuntos())&&(laberinto.getPacMan().cantidadVidas()>0)){
			nivel=new Nivel(nivelActual++);
			laberinto= new Laberinto(this.nivel);
			this.nivelActual=nivelActual++;
		}
	}
	
	
	public boolean perdido(){
		if(laberinto.getPacMan().cantidadVidas()>0)
			return false;
		else return true;
	}
	
			
	public boolean puntoDePoderActivo(){
		return this.puntoDePoderActivo;
	}
	
	
	public Laberinto getLaberinto(){
		return this.laberinto;
	}
	
	
	public int getPuntosAcumulados(){
		return this.puntosAcumulados;
	}
	
	
	public Nivel getNivel(){
		return this.nivel;
	}
	
	
	public EstrategiaFantasma getEstrategia(){
		return this.estrategia;
	}
	
	
	/*------------------------metodos privados--------------*/
	
	
	public void setPuntosAcumulados(int PuntosAcumulados){
		this.puntosAcumulados=puntosAcumulados;
	}


	public void fantasmaComido(Fantasma fantasma) {
		// TODO Auto-generated method stub
		
	}

}
