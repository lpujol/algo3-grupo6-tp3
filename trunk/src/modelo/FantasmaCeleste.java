package modelo;

public class FantasmaCeleste extends Fantasma {

	public FantasmaCeleste(int coordenadaX,int coordenadaY,Laberinto laberinto,
			int velocidad) {
		
		this.laberinto=laberinto;
		this.estrategiaActual=new EstrategiaSalirDeCasa(this);
		this.estrategiaNativa=new EstrategiaPerseguidor(this);
		this.posicion=new Posicion(coordenadaX,coordenadaY);
		this.velocidad=velocidad;
		this.direccion=Direccion.Abajo;
		}

	public FantasmaCeleste(IEstrategia estrategia, Laberinto laberinto,
			int velocidad) {	
		this.laberinto=laberinto;
		this.estrategiaActual=new EstrategiaSalirDeCasa(this);	
		this.estrategiaNativa=new EstrategiaPerseguidor(this);
		this.posicion=this.laberinto.getPosicionFantasma(3);
		this.velocidad=velocidad;
		this.direccion=Direccion.Derecha;
	}

}
