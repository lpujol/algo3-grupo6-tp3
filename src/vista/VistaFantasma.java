package vista;

import java.awt.Color;

import modelo.EstadoFantasma;
import modelo.Fantasma;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Cuadrado;

public class VistaFantasma extends Cuadrado {
	
	Fantasma fantasma;
	
	public VistaFantasma(Fantasma fantasma){
		super(16,16);
		this.fantasma=fantasma;
		this.setColor(new Color(0, 255, 255));
	}
	
	public void dibujar(SuperficieDeDibujo superfice){
		if(fantasma.getEstado()==EstadoFantasma.Huyendo)
			this.setColor(Color.BLUE);
		else
			this.setColor(Color.cyan);
		super.dibujar(superfice);
	}

}
