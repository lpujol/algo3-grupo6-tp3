package vista;

import java.awt.Color;

import modelo.Laberinto;

import ar.uba.fi.algo3.titiritero.vista.Circulo;

public class VistaPacman extends Circulo{
	
	public VistaPacman(){
		super(Laberinto.getTamanoDelBloque());
		this.setColor(Color.yellow);
	}

}
