package vista;

import modelo.Pacman;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class VistaPacman implements Dibujable{
	ImagenAnimada derecha;
	ImagenAnimada izquierda;
	ImagenAnimada arriba;
	ImagenAnimada abajo;
	Pacman pacman;
	
	public VistaPacman(Pacman pos){
		this.pacman=pos;
		derecha=new ImagenAnimada(pos);
		derecha.add("/vista/pacmanFrame1_24.png");
		derecha.add("/vista/pacmanFrame2_24.png");
		derecha.setDelay(10);
		izquierda=new ImagenAnimada(pos);
		izquierda.add("/vista/pacmanFrame1_24.png");
		izquierda.add("/vista/pacmanFrame2Izq_24.png");
		izquierda.setDelay(10);
		arriba=new ImagenAnimada(pos);
		arriba.add("/vista/pacmanFrame1_24.png");
		arriba.add("/vista/pacmanFrame2Arriba_24.png");
		arriba.setDelay(10);
		abajo=new ImagenAnimada(pos);
		abajo.add("/vista/pacmanFrame1_24.png");
		abajo.add("/vista/pacmanFrame2Abajo_24.png");
		abajo.setDelay(10);
	}
	@Override
	public void dibujar(SuperficieDeDibujo superfice) {
		switch (this.pacman.getDireccion()){
		case Derecha:
			derecha.dibujar(superfice);
			break;
		case Izquierda:
			izquierda.dibujar(superfice);
			break;
		case Arriba:
			arriba.dibujar(superfice);
			break;
		case Abajo:
			abajo.dibujar(superfice);
			break;
			
		
		}
		
	}
	@Override
	public Posicionable getPosicionable() {
		return pacman;
	}
	@Override
	public void setPosicionable(Posicionable posicionable) {
		this.pacman=(Pacman)posicionable;
		
	}
}
