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
		derecha.add("/vista/pacmanFrame1.png");
		derecha.add("/vista/pacmanFrame2.png");
		derecha.setDelay(10);
		izquierda=new ImagenAnimada(pos);
		izquierda.add("/vista/pacmanFrame1.png");
		izquierda.add("/vista/pacmanFrame2Izq.png");
		izquierda.setDelay(10);
		arriba=new ImagenAnimada(pos);
		arriba.add("/vista/pacmanFrame1.png");
		arriba.add("/vista/pacmanFrame2Ar.png");
		arriba.setDelay(10);
		abajo=new ImagenAnimada(pos);
		abajo.add("/vista/pacmanFrame1.png");
		abajo.add("/vista/pacmanFrame2Ab.png");
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
