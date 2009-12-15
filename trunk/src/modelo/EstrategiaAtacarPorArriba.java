package modelo;

public class EstrategiaAtacarPorArriba implements IEstrategia {

	Laberinto laberinto;
	
	public EstrategiaAtacarPorArriba(Laberinto laberinto) {
		this.laberinto=laberinto;
	}

	@Override
	public Posicion getDestino() {
		Posicion posicionPacman=laberinto.getPacman().getPosicion();
		Posicion posible=posicionPacman.getPosicionAnteriorVertical(3*Laberinto.getTamanoDelBloque());
		Bloque bloque=laberinto.getBloqueEnPosicion(posible);
		while(bloque==null){
			posible=posible.getPosicionSiguienteVertical(1*Laberinto.getTamanoDelBloque());
			bloque=laberinto.getBloqueEnPosicion(posible);
		}
		return posible;
	}

}
