package ar.uba.fi.algo3.titiritero.vista;

import java.awt.Color;
import java.awt.Graphics;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

/* 
 * Esta clase dibuja un Cuadrado (de color gris por el momento)utilizando la API Java2D 
 */
public class Cuadrado extends Figura {

	private int alto;
	private int ancho;

	public Cuadrado(int ancho, int alto){
		this.alto = alto;
		this.ancho = ancho;
		setColor(Color.GRAY);
	}
	
	public void dibujar(SuperficieDeDibujo superfice) {
		Graphics grafico = (Graphics)superfice.getBuffer();
		grafico.setColor(this.getColor());
		grafico.fillRect(this.getPosicionable().getX(), this.getPosicionable().getY(), this.ancho, this.alto);
	}
}
