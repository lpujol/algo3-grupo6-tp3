package modelo;

public class Puerta extends NoComestible {

	public Puerta(Posicion posicion, Laberinto laberinto) {
		super(posicion, laberinto);
	}
	
	public boolean esOcupable(Fantasma unFantasma) {
		if((
				(unFantasma.getDireccion().ordinal()==Direccion.Arriba.ordinal())
				&&(unFantasma.getEstado().ordinal()==EstadoFantasma.Vivo.ordinal())
				)||
				(
						unFantasma.getEstado().ordinal()==EstadoFantasma.Muerto.ordinal()))
		return true;
		//if((unFantasma.getDireccion()==Direccion.Abajo)&&(unFantasma.getEstado()==EstadoFantasma.Muerto))
		//	return true;
		return false;
	}

	@Override
	public boolean esOcupablePorPacman() {
		return false;
	}
}
