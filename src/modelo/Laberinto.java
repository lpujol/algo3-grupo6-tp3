package modelo;

import java.util.ArrayList;

public class Laberinto {

	private  int alto;
	private  int ancho;
	private ArrayList<Bloque> bloques;
	private ArrayList<Vivo> entidades;

	private Pacman pacman;

	private Nivel nivel;

	public Laberinto(Nivel nivel) {
		this.ancho = 10;
		this.alto = 10;
		this.bloques = new ArrayList<Bloque>();
		// TODO: Inicializar array entidades.
	}

	public Juego getJuego() {
		// TODO Auto-generated method stub
		return null;
	}

	//Este metodo debe ser adaptado a la coleccion de entidades
	public Pacman getPacman() {
		return this.pacman;
	}

	public Posicion getPosicionPacman() {
		// TODO Auto-generated method stub
		return null;
	}

	public Posicion getInterseccionMasCercana(Posicion posicionPacman,Direccion direccion) {
				return null;
				
	}

	public Bloque getBloqueEnPosicion(double nuevaCoordenadaX, double y) {
		// TODO Auto-generated method stub
		return null;
	}

	public Posicion getPosicionFantasma(Fantasma fantasma) {
		// TODO Auto-generated method stub
		return null;
	}
}
