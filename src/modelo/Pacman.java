package modelo;

import java.util.ArrayList;


public class Pacman extends Vivo{
	
	private int vidas;
//	private IEstrategia estrategia;
	
	public Pacman(Posicion posicion, Laberinto laberinto){
		this.vidas=3;	
		this.posicion=posicion;
		this.laberinto=laberinto;
		this.direccion=Direccion.Derecha;
		
	}
	
	public Pacman(int coordenadaX,int coordenadaY, Laberinto laberinto){
		this.vidas=3;	
		this.posicion=new Posicion(coordenadaX,coordenadaY);
		this.laberinto=laberinto;
		this.direccion=Direccion.Derecha;
		this.velocidad=1;
	}
	
	
		
	public int getCantidadVidas(){
		return this.vidas; 
	}
	
	public void vivir(){
		moverse();
		ArrayList<Fantasma> fantasmasEnElMismoBloque=this.laberinto.buscarFantasmasEn(posicion);
		if (fantasmasEnElMismoBloque.isEmpty()==false)
			if(this.laberinto.getJuego().puntoDePoderActivo()){ 
				for (int i = 0; i < fantasmasEnElMismoBloque.size(); i++) {
					fantasmasEnElMismoBloque.get(i).comer();
				};
			}
			else{
				this.laberinto.getPacman().comer();
			}
	}

	public void moverse(){		
		if(posicionSiguienteOcupable()){
			mover();
			if(this.laberinto.getBloqueEnPosicion(posicion).comido()==false)
				this.laberinto.getBloqueEnPosicion(posicion).comer();
		}
			
	};
	
	public boolean posicionSiguienteOcupable() {
		Boolean esOcupable=false;
		switch(direccion){
		case Arriba:{
			Posicion posicionPosibleArriba=posicion.getPosicionSiguienteVertical(8);
			esOcupable=(laberinto.getBloqueEnPosicion(posicionPosibleArriba).esOcupablePorPacman());
			};
			break;
		case Abajo:{
			Posicion posicionPosibleAbajo=posicion.getPosicionAnteriorVertical(8);
			esOcupable=(laberinto.getBloqueEnPosicion(posicionPosibleAbajo).esOcupablePorPacman());
			};
			break;
		case Derecha:{
			Posicion posicionPosibleDerecha=posicion.getPosicionSiguienteHorizontal(8);
			esOcupable=(laberinto.getBloqueEnPosicion(posicionPosibleDerecha).esOcupablePorPacman());
			};
			break;
		case Izquierda:{
			Posicion posicionPosibleIzquierda=posicion.getPosicionAnteriorHorizontal(8);
			esOcupable=(laberinto.getBloqueEnPosicion(posicionPosibleIzquierda).esOcupablePorPacman());
			};
			break;
		}
		return esOcupable;
	}




	public void comer() {
		this.laberinto.getJuego().pacmanComido();
		
	}

	public void disminuirVida() {
		this.vidas--;
		
	}

	public void setPosicion(Posicion posicionInicialPacman) {
		this.posicion=posicionInicialPacman;
		
	};

}
