package modelo;

public class EstrategiaIrALaDerecha implements IEstrategiaPacman {
	private Pacman pacman;
	
	public EstrategiaIrALaDerecha(Pacman pacman) {
		this.pacman=pacman;
	}
	
	/*
	 * Estrategia para cambiarle la direccion a Pacman hacia 
	 * la derecha siempre que este permitido el cambio.
	 * 
	 * */
	public void cambiarDireccion() {
		Direccion nuevaDireccion=Direccion.Derecha;
		if (pacman.getLaberinto().posicionSiguienteOcupable(pacman.posicion,nuevaDireccion)&& pacman.getLaberinto().cambioDeDireccionPermitido(pacman.posicion))
			pacman.cambiarDireccion(nuevaDireccion);
	}

}
