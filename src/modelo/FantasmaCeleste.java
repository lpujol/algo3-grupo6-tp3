package modelo;

public class FantasmaCeleste extends Fantasma {

	public FantasmaCeleste(int coordenadaX,int coordenadaY,Laberinto laberinto,
			int velocidad) {
		super(laberinto,velocidad);
		this.laberinto=laberinto;
		this.estrategiaActual=new EstrategiaSalirDeCasa(this);
		this.estrategiaNativa=new EstrategiaPerseguidor(this);
		this.posicion=new Posicion(coordenadaX,coordenadaY);
		this.velocidad=velocidad;
		this.direccion=Direccion.Abajo;
		}

	public FantasmaCeleste(Laberinto laberinto,int velocidad) {
		super(laberinto,velocidad);
		this.estrategiaActual=new EstrategiaSalirDeCasa(this);	
		this.estrategiaNativa=new EstrategiaPerseguidor(this);
		this.posicion=this.laberinto.getPosicionFantasma(3);		
	}

}
