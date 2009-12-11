package vista;

import java.util.ArrayList;

import modelo.Punto;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class VistaPuntos implements Dibujable {
	
	ArrayList<Punto> puntos;
	VistaPunto vistaPunto;

	
	public VistaPuntos(){
		puntos=new ArrayList<Punto>();
		vistaPunto=new VistaPunto(null);
	}
	@Override
	public void dibujar(SuperficieDeDibujo superfice) {
		for(Punto punto:puntos){
			vistaPunto.setPosicionable(punto);
			vistaPunto.dibujar(superfice);
		}

	}
	
	public void add(Punto punto){
		puntos.add(punto);
	}

	@Override
	public Posicionable getPosicionable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPosicionable(Posicionable posicionable) {
		// TODO Auto-generated method stub

	}

}
