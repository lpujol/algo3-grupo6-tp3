package modelo;

public class FantasmaRojo extends Fantasma {

	public FantasmaRojo(Laberinto laberinto,int velocidad) {
		super(laberinto,velocidad);
		this.estrategiaActual=new EstrategiaSalirDeCasa(this);	
		this.estrategiaNativa=new EstrategiaInki(this);
		this.posicion=this.laberinto.getPosicionFantasma(1);		
	}

	
	
	
}
