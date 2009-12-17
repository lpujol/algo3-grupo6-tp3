package modelo;

import modelo.IEstrategiaPacman;

public class EstrategiaIrHaciaAbajo implements IEstrategiaPacman {
	private Pacman pacman;
	
	public EstrategiaIrHaciaAbajo(Pacman pacman) {
		this.pacman=pacman;
	}
	
	/*
	 * Estrategia para cambiarle la direccion a Pacman hacia 
	 *abajo siempre que este permitido el cambio.
	 * 
	 * */
	
	public void cambiarDireccion() {
		Direccion nuevaDireccion=Direccion.Abajo;
		if (pacman.getLaberinto().posicionSiguienteOcupable(pacman.posicion,nuevaDireccion)&& pacman.getLaberinto().cambioDeDireccionPermitido(pacman.posicion))
			pacman.cambiarDireccion(nuevaDireccion);
	}

}
