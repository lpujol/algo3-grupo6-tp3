package modelo;

public class FantasmaNaranja extends Fantasma {

	public FantasmaNaranja(IEstrategia estrategia, Laberinto laberinto,
			int velocidad) {		
		this.laberinto=laberinto;
		this.estrategiaActual=new EstrategiaSalirDeCasa(this);		
		this.estrategiaNativa=new EstrategiaClyde(this);
		this.posicion=this.laberinto.getPosicionFantasma(0);
		this.velocidad=velocidad;
		this.direccion=Direccion.Derecha;
	}

}
