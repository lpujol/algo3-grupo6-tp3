package modelo;

public class EstrategiaIrALaIzquierda implements IEstrategiaPacman {
	private Pacman pacman;
	
	public EstrategiaIrALaIzquierda(Pacman pacman) {
		this.pacman=pacman;
	}
	
	/*
	 * Estrategia para cambiarle la direccion a Pacman hacia 
	 * la izquierda siempre que este permitido el cambio.
	 * 
	 * */
	
	public void cambiarDireccion() {
		Direccion nuevaDireccion=Direccion.Izquierda;
		if (pacman.getLaberinto().posicionSiguienteOcupable(pacman.posicion,nuevaDireccion)&& pacman.getLaberinto().cambioDeDireccionPermitido(pacman.posicion))
			pacman.cambiarDireccion(nuevaDireccion);
	}
}
