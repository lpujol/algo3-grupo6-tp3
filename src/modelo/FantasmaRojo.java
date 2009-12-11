package modelo;

public class FantasmaRojo extends Fantasma {

	public FantasmaRojo(IEstrategia estrategia, Laberinto laberinto,
			int velocidad) {

		
		this.laberinto=laberinto;
		this.estrategiaActual=new EstrategiaSalirDeCasa(this);	
		this.estrategiaNativa=new EstrategiaInki(this);
		this.posicion=this.laberinto.getPosicionFantasma(1);
		this.velocidad=velocidad;
		this.direccion=Direccion.Arriba;
	}

	
	
	
}
