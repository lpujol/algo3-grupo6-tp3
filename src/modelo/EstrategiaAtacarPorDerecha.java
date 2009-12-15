package modelo;

public class EstrategiaAtacarPorDerecha implements IEstrategia {

	Laberinto laberinto;
	
	public EstrategiaAtacarPorDerecha(Laberinto laberinto) {
		this.laberinto=laberinto;
	}

	@Override
	public Posicion getDestino() {
		Posicion posicionPacman=laberinto.getPacman().getPosicion();
		Posicion posible=posicionPacman.getPosicionSiguienteHorizontal(3*Laberinto.getTamanoDelBloque());
		Bloque bloque=laberinto.getBloqueEnPosicion(posible);
		while(bloque==null){
			posible=posible.getPosicionAnteriorHorizontal(1*Laberinto.getTamanoDelBloque());
			bloque=laberinto.getBloqueEnPosicion(posible);
		}
		return posible;
	}

}
