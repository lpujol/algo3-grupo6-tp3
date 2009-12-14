package vista;

import java.awt.Color;

import titiriteroModificado.Imagen;

import modelo.Posicion;


import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Cuadrado;

public class VistaEstadoJuego extends Cuadrado {
	
	Imagen pacman;
	Imagen inicial;
	Texto2D puntaje;
	Texto2D nivel;
	private EstadoJuego estadoJuego;

	public VistaEstadoJuego(EstadoJuego estado) {
		super(estado.getAncho(),estado.getAlto());
		this.setColor(Color.black);
		this.setPosicionable(estado);
		
		pacman=new Imagen();
		pacman.setNombreArchivoImagen("/vista/pacmanFrame2_24.png");
		this.estadoJuego=estado;
		
		puntaje=new Texto2D();
		Posicion pos=new Posicion(estado.getAncho()-50,estado.getY()+10);
		puntaje.setPosicionable(pos);
		
		nivel=new Texto2D();
		Posicion pos2=new Posicion(estado.getAncho()-60,estado.getY()+40);
		nivel.setPosicionable(pos2);
		
		inicial=new Imagen();
		inicial.setNombreArchivoImagen("/vista/inicial.JPG");
		inicial.setPosicionable(new Posicion(0,0));
		
		// TODO Auto-generated constructor stub
	}	
	
	public void dibujar(SuperficieDeDibujo superfice){
		super.dibujar(superfice);
		if(estadoJuego.jugando()){
		Posicion pos=new Posicion(this.estadoJuego.getX()+10,this.estadoJuego.getY()+10);
		if(estadoJuego.vidas()>0){
			pacman.setPosicionable(pos);
			pacman.dibujar(superfice);
		}
		if(estadoJuego.vidas()>1){
			pos.avanzarHorizontal(25);
			pacman.dibujar(superfice);
		}
		if(estadoJuego.vidas()>2){
			pos.avanzarHorizontal(25);
			pacman.dibujar(superfice);
		}
		puntaje.setTexto(this.estadoJuego.puntos());
		puntaje.dibujar(superfice);
		
		nivel.setTexto("Nivel "+this.estadoJuego.numeroNivel());
		nivel.dibujar(superfice);
		}
		else{
			Posicion pos=new Posicion(0,0);
			Cuadrado cuadrado=new Cuadrado(460,563);
			cuadrado.setColor(Color.black);
			cuadrado.setPosicionable(pos);
			cuadrado.dibujar(superfice);
			inicial.dibujar(superfice);
		}
	}


}
