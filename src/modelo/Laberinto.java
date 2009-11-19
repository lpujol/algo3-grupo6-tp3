package modelo;

import java.util.ArrayList;

public class Laberinto {

	private int ancho;
	private int alto;
	private ArrayList<Bloque> bloques;
	private ArrayList<Entidad> entidades;
	private Nivel nivel;
	
	public Laberinto(int ancho, int alto, Nivel nivel) {
		this.ancho = ancho;
		this.alto = alto;
		this.bloques = new ArrayList<Bloque>();
		// TODO: Inicializar array entidades.
	}
}
