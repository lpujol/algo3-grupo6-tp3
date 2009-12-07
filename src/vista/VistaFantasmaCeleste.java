package vista;

import modelo.FantasmaCeleste;
import modelo.Pacman;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

import titiriteroModificado.Imagen;

public class VistaFantasmaCeleste extends VistaFantasma {
	
	public VistaFantasmaCeleste(FantasmaCeleste fantasma){
		super(fantasma);
		this.cargarImagenes("celeste");
	}


}
