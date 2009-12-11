package vista;


import java.awt.Color;

import modelo.Punto;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Cuadrado;
import titiriteroModificado.Imagen;

public class VistaPunto implements Dibujable{

	Imagen vivo;
	//Imagen comido;
	Cuadrado comido;
	Punto punto;
	public VistaPunto(Punto punto) {
		this.punto=punto;
		vivo=new Imagen();
		vivo.setNombreArchivoImagen("/vista/punto.gif");
		vivo.setPosicionable(punto);
		/*comido=new Imagen();
		comido.setNombreArchivoImagen("/vista/negro.jpg");*/
		comido=new Cuadrado(16,16);
		comido.setColor(Color.black);
		comido.setPosicionable(punto);
	}

	@Override
	public void dibujar(SuperficieDeDibujo superfice) {
		if(this.punto.comido());
			//comido.dibujar(superfice);
		else
			vivo.dibujar(superfice);
		
		
	}

	@Override
	public Posicionable getPosicionable() {
		return (Posicionable)this.punto;
	}

	@Override
	public void setPosicionable(Posicionable posicionable) {
		this.punto=(Punto)posicionable;
		this.vivo.setPosicionable(this.punto);
		this.comido.setPosicionable(this.punto);
		
	}

}
