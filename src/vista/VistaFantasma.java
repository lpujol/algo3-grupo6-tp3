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
		switch(fantasma.getEstado()){
		case Huyendo:
			this.setColor(Color.BLUE);
			break;
		case Vivo:	
			this.setColor(Color.cyan);
			break;
		case Muerto:
			this.setColor(Color.white);
			break;
		}
		super.dibujar(superfice);
	}

}
