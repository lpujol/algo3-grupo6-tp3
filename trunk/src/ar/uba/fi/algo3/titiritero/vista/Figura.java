package ar.uba.fi.algo3.titiritero.vista;

import java.awt.Color;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.MouseClickObservador;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public abstract class Figura implements Dibujable, MouseClickObservador {

	private Color color;
	private Posicionable posicionable;
	
	public abstract void dibujar(SuperficieDeDibujo superfice) ;

	public void setColor(Color unColor){
		this.color =unColor; 
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public Posicionable getPosicionable() {
		return this.posicionable;
	}

	public void setPosicionable(Posicionable posicionable) {
		this.posicionable = posicionable;		
	}

	public void MouseClick(int x, int y){
		System.out.println("Click;" + x + "," + y);
	}
		
}
