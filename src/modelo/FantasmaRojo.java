package modelo;

public class FantasmaRojo extends Fantasma {

	public FantasmaRojo(IEstrategia estrategia, Laberinto laberinto,
			int velocidad) {

		this.laberinto=laberinto;
		this.estrategiaActual=new EstrategiaEmboscador(this);
		this.estrategiaNativa=new EstrategiaEmboscador(this);
		this.posicion=this.laberinto.getPosicionFantasma(this);
		this.velocidad=velocidad;
	}

	
	
	
}
