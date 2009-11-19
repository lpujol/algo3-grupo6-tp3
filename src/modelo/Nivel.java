package modelo;

import java.util.ArrayList;

public class Nivel {

	private int numero;
	private ArrayList<Bloque> bloques;
	
	public Nivel(int numero) {
		this.numero = numero;
	}

	public void agregarBloque(Bloque bloque) {
		bloques.add(bloque);
	}
		
	public ArrayList<Bloque> getBloques() {
		return this.bloques;
	}
	
	public int getNumero() {
		return this.numero;
	}

}
