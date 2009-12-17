package modelo;

public class Puerta extends NoComestible {

	public Puerta(Posicion posicion, Laberinto laberinto) {
		super(posicion, laberinto);
	}
	
	public boolean esOcupablePorFantasma(Fantasma unFantasma) {
		if(((unFantasma.getDireccion().ordinal()==Direccion.Arriba.ordinal())
				&&(unFantasma.getEstado().ordinal()==EstadoFantasma.Vivo.ordinal())
				)||(unFantasma.getEstado().ordinal()==EstadoFantasma.Muerto.ordinal()))
		return true;
		
		return false;
	}

	@Override
	public boolean esOcupablePorPacman() {
		return false;
	}
}
