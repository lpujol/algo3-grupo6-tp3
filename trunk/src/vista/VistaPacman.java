package vista;

import java.awt.Color;

import modelo.Laberinto;
import modelo.Pacman;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Circulo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;
/*
public class VistaPacman extends Circulo{
	
	public VistaPacman(){
		super(Laberinto.getTamanoDelBloque());
		this.setColor(Color.yellow);
	}

}*/

public class VistaPacman implements Dibujable{
	ImagenAnimada derecha;
	ImagenAnimada izquierda;
	ImagenAnimada arriba;
	ImagenAnimada abajo;
	Pacman pacman;
	
	public VistaPacman(Pacman pos){
		this.pacman=pos;
		derecha=new ImagenAnimada(pos);
		derecha.add("/vista/pacmanFrame1.jpg");
		derecha.add("/vista/pacmanFrame2.jpg");
		derecha.setDelay(10);
		izquierda=new ImagenAnimada(pos);
		izquierda.add("/vista/pacmanFrame1.jpg");
		izquierda.add("/vista/pacmanFrame2Izq.jpg");
		izquierda.setDelay(10);
		arriba=new ImagenAnimada(pos);
		arriba.add("/vista/pacmanFrame1.jpg");
		arriba.add("/vista/pacmanFrame2Arriba.jpg");
		arriba.setDelay(10);
		abajo=new ImagenAnimada(pos);
		abajo.add("/vista/pacmanFrame1.jpg");
		abajo.add("/vista/pacmanFrame2Abajo.jpg");
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
