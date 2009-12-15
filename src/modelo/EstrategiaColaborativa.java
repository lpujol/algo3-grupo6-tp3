package modelo;

import java.util.ArrayList;

public class EstrategiaColaborativa implements IEstrategia {
	
	private Fantasma fantasma;
	
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

	//este ataca por abajo
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
