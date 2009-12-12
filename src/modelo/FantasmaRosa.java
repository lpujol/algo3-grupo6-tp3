package modelo;

public class FantasmaRosa extends Fantasma {

	public FantasmaRosa(Laberinto laberinto,int velocidad) {
		super(laberinto,velocidad);
		this.estrategiaActual=new EstrategiaSalirDeCasa(this);	
		this.estrategiaNativa=new EstrategiaPinky(this);
		this.posicion=this.laberinto.getPosicionFantasma(2);		
	}

}
