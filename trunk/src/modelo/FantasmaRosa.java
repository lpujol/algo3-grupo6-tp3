package modelo;

public class FantasmaRosa extends Fantasma {

	public FantasmaRosa(IEstrategia estrategia, Laberinto laberinto,
			int velocidad) {	
		this.laberinto=laberinto;
		this.estrategiaActual=new EstrategiaEmboscador(this);
		this.estrategiaNativa=new EstrategiaEmboscador(this);
		this.posicion=this.laberinto.getPosicionFantasma(this);
		this.velocidad=velocidad;
	}

}
