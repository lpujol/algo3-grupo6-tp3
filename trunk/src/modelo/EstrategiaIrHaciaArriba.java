package modelo;

import modelo.IEstrategiaPacman;

public class EstrategiaIrHaciaArriba implements IEstrategiaPacman {
	
	private Pacman pacman;
	
	public EstrategiaIrHaciaArriba(Pacman pacman) {
		this.pacman=pacman;
	}
	
	/*
	 * Estrategia para cambiarle la direccion a Pacman hacia 
	 * arriba siempre que este permitido el cambio.
	 * 
	 * */
	public void cambiarDireccion() {
		Direccion nuevaDireccion=Direccion.Arriba;
		if (pacman.getLaberinto().posicionSiguienteOcupable(pacman.posicion,nuevaDireccion)&& pacman.getLaberinto().cambioDeDireccionPermitido(pacman.posicion))
			pacman.cambiarDireccion(nuevaDireccion);
	}
	
	
}
