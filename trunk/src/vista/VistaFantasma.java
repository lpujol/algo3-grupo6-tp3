package vista;

import titiriteroModificado.Imagen;

import modelo.Fantasma;
import modelo.Pacman;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class VistaFantasma implements Dibujable {
	
	private Imagen derecha;
	private Imagen izquierda;
	private Imagen arriba;
	private Imagen abajo;
	private Imagen huyendo;
	private Imagen muerto;
	Fantasma fantasma;
	
	public VistaFantasma(Fantasma fantasma){
		this.fantasma = fantasma;
		this.derecha = new Imagen();
		this.derecha.setPosicionable(fantasma);
		// En algun momento hay que hacer que detecte el color del fantasma
		this.derecha.setNombreArchivoImagen("/vista/fcDerecha.png");
		this.izquierda = new Imagen();
		this.izquierda.setPosicionable(fantasma);
		this.izquierda.setNombreArchivoImagen("/vista/fcIzquierda.png");
		this.arriba = new Imagen();
		this.arriba.setPosicionable(fantasma);
		this.arriba.setNombreArchivoImagen("/vista/fcArriba.png");
		this.abajo = new Imagen();
		this.abajo.setPosicionable(fantasma);
		this.abajo.setNombreArchivoImagen("/vista/fcAbajo.png");
		this.huyendo = new Imagen();
		this.huyendo.setPosicionable(fantasma);
		this.huyendo.setNombreArchivoImagen("/vista/fcHuyendo.png");
		this.muerto = new Imagen();
		this.muerto.setPosicionable(fantasma);
		this.muerto.setNombreArchivoImagen("/vista/fcMuerto.png");
	}
	
	public void dibujar(SuperficieDeDibujo superficie){
		switch(fantasma.getEstado()){
		case Huyendo:
			this.huyendo.dibujar(superficie);
//			this.setColor(Color.BLUE);
			break;
		case Vivo:	
//			this.setColor(Color.cyan);
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
			/*this.setColor(Color.white);*/
			this.muerto.dibujar(superficie);
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
