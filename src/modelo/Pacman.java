package modelo;

import java.util.ArrayList;


public class Pacman extends Vivo{
	
	
	private int vidas;

	private IEstrategiaPacman estrategia;
	
	public Pacman(Posicion posicion, Laberinto laberinto){
		this.vidas=3;	
		this.posicion=posicion;
		this.laberinto=laberinto;
		this.estrategia=new EstrategiaIrALaDerecha(this);
		this.direccion=Direccion.Derecha;
		
	}
	
	public Pacman(int coordenadaX,int coordenadaY, Laberinto laberinto){
		this.vidas=3;	
		this.posicion=new Posicion(coordenadaX,coordenadaY);
		this.laberinto=laberinto;
		this.estrategia=new EstrategiaIrALaDerecha(this);
		this.direccion=Direccion.Derecha;
		this.velocidad=4;
	}
	
	
		
	public int getCantidadVidas(){
		return this.vidas; 
	}
	
	public void vivir(){
		for(int x=0;x<velocidad;x++){
		this.estrategia.cambiarDireccion();
		moverse();
		ArrayList<Fantasma> fantasmasEnElMismoBloque=this.laberinto.buscarFantasmasEn(posicion);
		if (fantasmasEnElMismoBloque.isEmpty()==false){
			if(this.laberinto.getJuego().puntoDePoderActivo()){ 
				for (int i = 0; i < fantasmasEnElMismoBloque.size(); i++) {
					if((fantasmasEnElMismoBloque.get(i).getEstado().ordinal()==EstadoFantasma.Huyendo.ordinal()))
						fantasmasEnElMismoBloque.get(i).comer();
				};
			}
			else{
				for(Fantasma fantasma:fantasmasEnElMismoBloque)
					if(fantasma.getEstado()==EstadoFantasma.Vivo)
						this.laberinto.getPacman().comer();
			}
		};
		}
	}

	
	/* El Pacman se mueve si el casillero siguiente es ocupable y come el 
	 * bloque de dicha posicion.
	  
	 */
	public void moverse(){		
		if(this.laberinto.posicionSiguienteOcupable(this.posicion,this.direccion)){
			mover();
			if(this.laberinto.getBloqueEnPosicion(posicion).comido()==false)
				this.laberinto.getBloqueEnPosicion(posicion).comer();
		}
			
	};
	


	/* Informa al juego que pacman fue comido.
	  
	 */

	public void comer() {
		this.laberinto.getJuego().pacmanComido();
		
	}

	public void disminuirVida() {
		this.vidas--;
		
	}

	public void setPosicion(Posicion posicionInicialPacman) {
		this.posicion=posicionInicialPacman;
		
	}

	public void setEstrategia(IEstrategiaPacman nuevaEstrategia) {
			this.estrategia=nuevaEstrategia;
	}

	public Laberinto getLaberinto() {
		return this.laberinto;
		
	}

	public void setCantidadVidas(int i) {
		this.vidas=i;
		
	};

}
