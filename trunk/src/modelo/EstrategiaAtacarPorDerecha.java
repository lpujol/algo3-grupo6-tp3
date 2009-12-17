package modelo;

public class EstrategiaAtacarPorDerecha implements IEstrategia {

	Laberinto laberinto;
	
	public EstrategiaAtacarPorDerecha(Laberinto laberinto) {
		this.laberinto=laberinto;
	}
	
	/*
	 * 
	 * Estrategia atacar por derecha, es utilizada por la estrategia colaborativa
	 * se trata de ubicar el bloque que este
	 * 3 posiciones mas a la derecha del pacman, y tutilizar ese como destino
	 * @see modelo.IEstrategia#getDestino()
	 */

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
