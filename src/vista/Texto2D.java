package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class Texto2D implements Dibujable {

	String texto;
	Posicionable posicionable;
	Color color;
	Font fuente;
	
	public Texto2D(){
		color=Color.white;
		fuente=new Font("TimesRoman",Font.PLAIN,20);
		
	}
	
	public void setTexto(String texto){
		this.texto=texto;
	}
	
	public String getTexto(){
		return this.texto;
	}
	
	public void setColor(Color color){
		this.color=color;
	}
	
	public void setFuente(Font fuente){
		this.fuente=fuente;
	}
	@Override
	public void dibujar(SuperficieDeDibujo superfice) {
		Graphics grafico = (Graphics)superfice.getBuffer();
		grafico.setColor(this.color);
		grafico.setFont(this.fuente);
		grafico.drawString(this.texto, posicionable.getX(), posicionable.getY());	

	}

	@Override
	public Posicionable getPosicionable() {
		return this.posicionable;
	}

	@Override
	public void setPosicionable(Posicionable posicionable) {
		this.posicionable=posicionable;

	}

}
