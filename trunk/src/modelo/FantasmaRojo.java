package modelo;

public class FantasmaRojo extends Fantasma {

	public FantasmaRojo(Laberinto laberinto,int velocidad) {
		super(laberinto,velocidad,laberinto.getPosicionFantasma(1));
		this.estrategiaActual=new EstrategiaSalirDeCasa(this);	
		this.estrategiaNativa=new EstrategiaInki(this);
	}

	
	
	
}
