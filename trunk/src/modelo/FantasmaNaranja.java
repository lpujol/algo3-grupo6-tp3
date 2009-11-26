package modelo;

public class FantasmaNaranja extends Fantasma {

	public FantasmaNaranja(IEstrategia estrategia, Laberinto laberinto,
			int velocidad) {		
		this.laberinto=laberinto;
		this.estrategiaActual=new EstrategiaClyde(this);
		this.estrategiaNativa=estrategiaActual;
		this.posicion=this.laberinto.getPosicionFantasma(this);
		this.velocidad=velocidad;
	}

}
