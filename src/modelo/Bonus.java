package modelo;

import java.util.Timer;
import java.util.TimerTask;

public class Bonus extends Comestible {

	
	public Bonus(Posicion posicion, Laberinto laberinto) {
		super(posicion, laberinto);
		this.comido=true;
	}
	
	@Override
	public void comer() {
		this.comido = true;
		this.laberinto.getJuego().bonusComido();
	}

	@Override
	public boolean esOcupablePorPacman() {
		return true;
	}
	
	public void mostrar(){
		this.comido=false;
		Timer t=new Timer();
		t.schedule(new TimerTask(){
			@Override
			public void run() {				
				tiempoTranscurrido();				
			}			
		}
		, 8000);
	}
	
	public void tiempoTranscurrido(){
		this.comido=true;	
	}
	
	public void resetear(){
		this.comido=true;
	}
	

}
