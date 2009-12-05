package vista;

import java.awt.Color;


import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Cuadrado;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaEstadoJuego extends Cuadrado {
	
	Imagen pacman;

	public VistaEstadoJuego(EstadoJuego estado) {
		super(estado.getAncho(),estado.getAlto());
		this.setColor(Color.black);
		this.setPosicionable(estado);
		
		pacman=new Imagen();
		pacman.setNombreArchivoImagen("/vista/pacmanFrame1.jpg");
		
		
		// TODO Auto-generated constructor stub
	}	
	
	public void dibujar(SuperficieDeDibujo superfice){
		super.dibujar(superfice);		
	}


}
