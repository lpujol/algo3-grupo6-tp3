package modelo;

import java.awt.Point;

public class Pacman extends Entidad {
	
    private int vidas;
	
	
	public PacMan(Point posicion){
		
		super(posicion);
		this.vidas=3;
		
	}
	
	public boolean mover(Point versor){
		
		this.setPosicion(new Point(this.getPosicion().getX()+versor.getX(),
				this.getPosicion().getY()+versor.getY()));
				
	}
	
	public int getCantidadVidas(){
		return this.vidas; 
	}
	

}
