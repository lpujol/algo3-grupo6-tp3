package vista;

import java.awt.Color;

import modelo.Laberinto;

import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.vista.Circulo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;
/*
public class VistaPacman extends Circulo{
	
	public VistaPacman(){
		super(Laberinto.getTamanoDelBloque());
		this.setColor(Color.yellow);
	}

}*/

public class VistaPacman extends ImagenAnimada{
	public VistaPacman(Posicionable pos){
		super(pos);
		Imagen img=new Imagen();
		img.setNombreArchivoImagen("/vista/pacmanFrame1.jpg");
		img.setPosicionable(pos);
		this.add(img);
		img=new Imagen();
		img.setNombreArchivoImagen("/vista/pacmanFrame2.jpg");
		img.setPosicionable(pos);
		this.add(img);
		this.setDelay(10);
	}
}
