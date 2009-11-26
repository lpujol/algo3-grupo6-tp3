package modelo;

public class FantasmaCeleste extends Fantasma {

	public FantasmaCeleste(int coordenadaX,int coordenadaY,Laberinto laberinto,
			int velocidad) {
		
		this.laberinto=laberinto;
		this.estrategiaActual=new EstrategiaPerseguidor(this);
		this.estrategiaNativa=new EstrategiaPerseguidor(this);
		this.posicion=new Posicion(coordenadaX,coordenadaY);
		this.velocidad=velocidad;	
		}

}
