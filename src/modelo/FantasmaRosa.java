package modelo;

public class FantasmaRosa extends Fantasma {

	public FantasmaRosa(IEstrategia estrategia, Laberinto laberinto,
			int velocidad) {	
		this.laberinto=laberinto;
		this.estrategiaActual=new EstrategiaSalirDeCasa(this);	
		this.estrategiaNativa=new EstrategiaPinky(this);
		this.posicion=this.laberinto.getPosicionFantasma(2);
		this.velocidad=velocidad;
		this.direccion=Direccion.Derecha;
	}

}
