package modelo;

public class FantasmaRosa extends Fantasma {

	public FantasmaRosa(Laberinto laberinto,int velocidad) {
		super(laberinto,velocidad,laberinto.getPosicionFantasma(2));
		this.estrategiaActual=new EstrategiaSalirDeCasa(this);	
		this.estrategiaNativa=new EstrategiaPinky(this);			
	}

}
