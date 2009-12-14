package vista;

import titiriteroModificado.Imagen;

import modelo.Fantasma;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class VistaFantasma implements Dibujable {
	
	private Imagen derecha;
	private Imagen izquierda;
	private Imagen arriba;
	private Imagen abajo;
	private Imagen huyendo;
	private Imagen muertoDer;
	private Imagen muertoIzq;
	private Imagen muertoArr;
	private Imagen muertoAba;
	Fantasma fantasma;
	
	public VistaFantasma(Fantasma fantasma){
		this.fantasma = fantasma;
		this.derecha = new Imagen();
		this.derecha.setPosicionable(fantasma);		
	}
	
	protected void cargarImagenes(String tipoDeFantasma) {
		this.derecha.setNombreArchivoImagen("/vista/fant_"+tipoDeFantasma+"_der_24.png");
		this.izquierda = new Imagen();
		this.izquierda.setPosicionable(fantasma);
		this.izquierda.setNombreArchivoImagen("/vista/fant_"+tipoDeFantasma+"_izq_24.png");
		this.arriba = new Imagen();
		this.arriba.setPosicionable(fantasma);
		this.arriba.setNombreArchivoImagen("/vista/fant_"+tipoDeFantasma+"_arr_24.png");
		this.abajo = new Imagen();
		this.abajo.setPosicionable(fantasma);
		this.abajo.setNombreArchivoImagen("/vista/fant_"+tipoDeFantasma+"_aba_24.png");
		this.huyendo = new Imagen();
		this.huyendo.setPosicionable(fantasma);
		this.huyendo.setNombreArchivoImagen("/vista/fant_huyendo_24.png");
		this.muertoDer = new Imagen();
		this.muertoDer.setPosicionable(fantasma);
		this.muertoDer.setNombreArchivoImagen("/vista/fant_muerto_der_24.png");
		this.muertoIzq = new Imagen();
		this.muertoIzq.setPosicionable(fantasma);
		this.muertoIzq.setNombreArchivoImagen("/vista/fant_muerto_izq_24.png");
		this.muertoArr = new Imagen();
		this.muertoArr.setPosicionable(fantasma);
		this.muertoArr.setNombreArchivoImagen("/vista/fant_muerto_arr_24.png");
		this.muertoAba = new Imagen();
		this.muertoAba.setPosicionable(fantasma);
		this.muertoAba.setNombreArchivoImagen("/vista/fant_muerto_aba_24.png");
	}


	public void dibujar(SuperficieDeDibujo superficie){
		switch(fantasma.getEstado()){
		case Huyendo:
			this.huyendo.dibujar(superficie);
			break;
		case Vivo:	
			switch (this.fantasma.getDireccion()) {
			case Derecha:
				derecha.dibujar(superficie);
				break;
			case Izquierda:
				izquierda.dibujar(superficie);
				break;
			case Arriba:
				arriba.dibujar(superficie);
				break;
			case Abajo:
				abajo.dibujar(superficie);
				break;
			}
			break;
		case Muerto:
			switch (this.fantasma.getDireccion()) {
			case Derecha:
				muertoDer.dibujar(superficie);
				break;
			case Izquierda:
				muertoIzq.dibujar(superficie);
				break;
			case Arriba:
				muertoArr.dibujar(superficie);
				break;
			case Abajo:
				muertoAba.dibujar(superficie);
				break;
			}
			break;
		}
	}

	@Override
	public Posicionable getPosicionable() {
		return fantasma;
	}

	@Override
	public void setPosicionable(Posicionable posicionable) {
		this.fantasma=(Fantasma)posicionable;
	}

}
