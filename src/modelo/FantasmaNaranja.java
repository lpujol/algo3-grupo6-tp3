package modelo;

public class FantasmaNaranja extends Fantasma {

	public FantasmaNaranja(Laberinto laberinto,	int velocidad) {
		super(laberinto,velocidad,laberinto.getPosicionFantasma(0));
		this.estrategiaActual=new EstrategiaSalirDeCasa(this);		
		this.estrategiaNativa=new EstrategiaClyde(this);
	}

}
