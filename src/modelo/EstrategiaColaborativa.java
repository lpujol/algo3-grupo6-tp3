package modelo;

import java.util.ArrayList;

public class EstrategiaColaborativa implements IEstrategia {
	
	private Fantasma fantasma;
	
	/*
	 * estrategia colaborativa, obtiene los demas fantasmas
	 * y les asigna diferentes estrategias
	 */
	public EstrategiaColaborativa(Fantasma fantasma){
		this.fantasma=fantasma;
		ArrayList<Fantasma> fantasmas=fantasma.getLaberinto().getFantasmas();
		ArrayList<IEstrategia> estrategias=new ArrayList<IEstrategia>();
		estrategias.add(new EstrategiaAtacarPorDerecha(fantasma.getLaberinto()));
		estrategias.add(new EstrategiaAtacarPorIzquierda(fantasma.getLaberinto()));
		estrategias.add(new EstrategiaAtacarPorArriba(fantasma.getLaberinto()));
		
		int i=0;
		for(Fantasma otroFantasma:fantasmas){
			if(otroFantasma!=fantasma){
				if(i>=estrategias.size()) i=0;
				otroFantasma.setEstrategiaActual(estrategias.get(i));
			}
		}
	}

	/*
	 * 
	 * Estrategia atacar por abajo, es utilizada por la estrategia colaborativa
	 * se trata de ubicar el bloque que este
	 * 3 posiciones mas a la derecha del pacman, y utilizar ese como destino
	 * @see modelo.IEstrategia#getDestino()
	 */
	@Override
	public Posicion getDestino() {
		Posicion posicionPacman=fantasma.getLaberinto().getPacman().getPosicion();
		Posicion posible=posicionPacman.getPosicionSiguienteVertical(3*Laberinto.getTamanoDelBloque());
		Bloque bloque=fantasma.getLaberinto().getBloqueEnPosicion(posible);
		while(bloque==null){
			posible=posible.getPosicionAnteriorVertical(1*Laberinto.getTamanoDelBloque());
			bloque=fantasma.getLaberinto().getBloqueEnPosicion(posible);
		}
		return posible;
		
	}

}
