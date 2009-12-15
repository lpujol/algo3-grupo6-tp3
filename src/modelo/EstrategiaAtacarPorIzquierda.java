package modelo;

public class EstrategiaAtacarPorIzquierda implements IEstrategia {

	Laberinto laberinto;
	
	public EstrategiaAtacarPorIzquierda(Laberinto laberinto) {
		this.laberinto=laberinto;
	}

	@Override
	public Posicion getDestino() {
		Posicion posicionPacman=laberinto.getPacman().getPosicion();
		Posicion posible=posicionPacman.getPosicionAnteriorHorizontal(3*Laberinto.getTamanoDelBloque());
		Bloque bloque=laberinto.getBloqueEnPosicion(posible);
		while(bloque==null){
			posible=posible.getPosicionSiguienteHorizontal(1*Laberinto.getTamanoDelBloque());
			bloque=laberinto.getBloqueEnPosicion(posible);
		}
		return posible;
	}

}
