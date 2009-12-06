package vista;

import modelo.FantasmaCeleste;
import modelo.Pacman;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

import titiriteroModificado.Imagen;

public class VistaFantasmaCeleste {
	private Imagen derecha;
	private Imagen izquierda;
	private Imagen arriba;
	private Imagen abajo;
	private FantasmaCeleste fantasma;
	
	public VistaFantasmaCeleste(FantasmaCeleste fantasma){
		this.fantasma = fantasma;
		this.derecha = new Imagen();
		this.derecha.setNombreArchivoImagen("vista/fantasma_celeste_derecha.png");
		this.izquierda = new Imagen();
		this.izquierda.setNombreArchivoImagen("vista/fantasma_celeste_izquierda.png");
		this.arriba = new Imagen();
		this.arriba.setNombreArchivoImagen("vista/fantasma_celeste_arriba.png");
		this.abajo = new Imagen();
		this.abajo.setNombreArchivoImagen("vista/fantasma_celeste_abajo.png");
	}

	public void dibujar(SuperficieDeDibujo superfice) {
		switch (this.fantasma.getDireccion()){
		case Derecha:
			derecha.dibujar(superfice);
			break;
		case Izquierda:
			izquierda.dibujar(superfice);
			break;
		case Arriba:
			arriba.dibujar(superfice);
			break;
		case Abajo:
			abajo.dibujar(superfice);
			break;
			
		
		}
		
	}
	
	public Posicionable getPosicionable() {
		return fantasma;
	}
	
	public void setPosicionable(Posicionable posicionable) {
		this.fantasma = (FantasmaCeleste)posicionable;
		
	}
}
