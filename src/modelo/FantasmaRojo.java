package modelo;

public class FantasmaRojo extends Fantasma {

	public FantasmaRojo(IEstrategia estrategia, Laberinto laberinto,
			int velocidad) {

		
		this.laberinto=laberinto;
		this.estrategiaActual=new EstrategiaInki(this);
		this.estrategiaNativa=estrategiaActual;
		this.posicion=this.laberinto.getPosicionFantasma(this);
		this.velocidad=velocidad;
		this.direccion=Direccion.Arriba;
	}

	
	
	
}
