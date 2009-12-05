package modelo;

public class FantasmaRosa extends Fantasma {

	public FantasmaRosa(IEstrategia estrategia, Laberinto laberinto,
			int velocidad) {	
		this.laberinto=laberinto;
		this.estrategiaActual=new EstrategiaPinky(this);
		this.estrategiaNativa=new EstrategiaPinky(this);
		this.posicion=this.laberinto.getPosicionFantasma(3);
		this.velocidad=velocidad;
	}

}
