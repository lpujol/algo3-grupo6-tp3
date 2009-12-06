package vista;

import modelo.Punto;
import modelo.PuntoDePoder;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import titiriteroModificado.Imagen;

public class VistaPuntoPoder implements Dibujable {
	Imagen vivo;
	Imagen comido;
	PuntoDePoder punto;
	public VistaPuntoPoder(PuntoDePoder punto) {
		this.punto=punto;
		vivo=new Imagen();
		vivo.setNombreArchivoImagen("/vista/puntoPoder.gif");
		vivo.setPosicionable(punto);
		comido=new Imagen();
		comido.setNombreArchivoImagen("/vista/negro.jpg");
		comido.setPosicionable(punto);
	}

	@Override
	public void dibujar(SuperficieDeDibujo superfice) {
		if(this.punto.comido())
			comido.dibujar(superfice);
		else
			vivo.dibujar(superfice);
		
		
	}

	@Override
	public Posicionable getPosicionable() {
		return (Posicionable)this.punto;
	}

	@Override
	public void setPosicionable(Posicionable posicionable) {
		this.punto=(PuntoDePoder)posicionable;
		
	}
}
