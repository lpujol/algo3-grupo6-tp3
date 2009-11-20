package modelo;

import java.util.ArrayList;

public class Nivel {

	private int numero;
	private ArrayList<Bloque> bloques;
	private ArrayList<Vivo> entidades;
	
	public Nivel(int numero) {
		this.numero = numero;
	}

	public void agregarBloque(Bloque bloque) {
		bloques.add(bloque);
	}
		
	public ArrayList<Bloque> getBloques() {
		return this.bloques;
	}
	
	public ArrayList<Vivo> getEntidades() {
		return this.entidades;
	}
	
	public int getNumero() {
		return this.numero;
	}

}
