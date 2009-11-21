package modelo;

import java.util.ArrayList;

public class Laberinto {

	private  int alto;
	private  int ancho;
	private ArrayList<Bloque> bloques;
	private ArrayList<Vivo> entidades;
	private Pacman pacman;
	private Nivel nivel;
	private Juego juego;

	public Laberinto(Nivel nivel, Juego juego) {
		this.ancho = 28;
		this.alto = 31;
		this.nivel = nivel;
		this.bloques = this.nivel.getBloques();
		this.juego = juego;
	}

	public Juego getJuego() {
		return this.juego;
	}

	//Este metodo debe ser adaptado a la coleccion de entidades
	public Pacman getPacman() {
		return this.pacman;
	}

	public Posicion getPosicionPacman() {
		pacman.getPosicion();
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

	public Posicion obtenerPosicionCasa() {
		// TODO Auto-generated method stub
		return null;
	}
}
