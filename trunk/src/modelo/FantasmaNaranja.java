package modelo;

public class FantasmaNaranja extends Fantasma {

	public FantasmaNaranja(Laberinto laberinto,	int velocidad) {
		super(laberinto,velocidad);
		this.estrategiaActual=new EstrategiaSalirDeCasa(this);		
		this.estrategiaNativa=new EstrategiaClyde(this);
		this.posicion=this.laberinto.getPosicionFantasma(0);		
	}

}
