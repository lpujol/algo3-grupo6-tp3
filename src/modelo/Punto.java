package modelo;

import vista.Audio;

public class Punto extends Comestible {
	
    
    
	public Punto(Posicion posicion, Laberinto laberinto) {
		super(posicion, laberinto);
		//agregadoParaAudio
		//audioActivo=true;
		//----
	}

	@Override
	public void comer() {
		
		//agregadoAudio
		/*if (audioActivo){
		 		audio = new Audio("comePunto.wav");
		 		audio.play(false);
    	}*/
		//----
		
		
		this.comido = true;
		this.laberinto.puntoComido();
	}

	@Override
	public boolean esOcupablePorPacman() {
		return true;
	}
	
}