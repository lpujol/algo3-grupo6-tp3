package modelo;

public class FantasmaCeleste extends Fantasma {

	public FantasmaCeleste(int coordenadaX,int coordenadaY,Laberinto laberinto,
			int velocidad) {
		super(laberinto,velocidad,new Posicion(coordenadaX,coordenadaY));
		this.laberinto=laberinto;
		this.estrategiaActual=new EstrategiaSalirDeCasa(this);
		this.estrategiaNativa=new EstrategiaPerseguidor(this);
		this.velocidad=velocidad;
		this.direccion=Direccion.Abajo;
		}

	public FantasmaCeleste(Laberinto laberinto,int velocidad) {
		super(laberinto,velocidad,laberinto.getPosicionFantasma(3));
		this.estrategiaActual=new EstrategiaSalirDeCasa(this);	
		this.estrategiaNativa=new EstrategiaPerseguidor(this);
	}

}
