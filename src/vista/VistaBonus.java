package vista;

import modelo.Bonus;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaBonus extends Imagen {

	Bonus bonus;
	
	public VistaBonus(Bonus bonus){
		this.bonus=bonus;
		this.setNombreArchivoImagen("/vista/cherry.jpg");
	}
	
	public void dibujar(SuperficieDeDibujo superfice){
		if(!bonus.comido()){
			super.dibujar(superfice);
		}
	}
}
