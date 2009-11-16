package modelo;

import java.util.ArrayList;

public class Laberinto {

	private int ancho;
	private int alto;
	private ArrayList<Bloque> bloques;
	private ArrayList<Entidad> entidades;
	
	public Laberinto(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
		this.bloques = new ArrayList<Bloque>();
		// TODO: Inicializar array entidades.
	}
}
