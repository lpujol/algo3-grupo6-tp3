package vista;


import modelo.Punto;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaPunto implements Dibujable{

	Imagen vivo;
	Imagen comido;
	Punto punto;
	public VistaPunto(Punto punto) {
		this.punto=punto;
		vivo=new Imagen();
		vivo.setNombreArchivoImagen("/vista/punto.jpg");
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
		this.punto=(Punto)posicionable;
		
	}

}
