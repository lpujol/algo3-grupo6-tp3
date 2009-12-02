package modelo;

import java.util.ArrayList;

public class Nivel {

	private int numero;
	private ArrayList<Bloque> bloques;
	private ArrayList<Fantasma> fantasmas;
	private Pacman pacman;
	private CargadorDeNiveles cargadorDeNiveles;
	
	public Nivel(String rutaNivel, Juego juego, Laberinto laberinto) {
		this.cargadorDeNiveles = new CargadorDeNiveles(juego, laberinto);
		bloques = new ArrayList<Bloque>();
		cargadorDeNiveles.cargar(this, rutaNivel);
		this.numero = 1;		
		fantasmas = new ArrayList<Fantasma>();		
		this.pacman=new Pacman(240,343,laberinto);
	}

	public void agregarBloque(Bloque bloque) {
		bloques.add(bloque);
	}
		
	public void agregarFantasma(Fantasma fantasma) {
		fantasmas.add(fantasma);
	}
	
	public ArrayList<Bloque> getBloques() {
		return this.bloques;
	}
	
	public ArrayList<Fantasma> getFantasmas() {
		return this.fantasmas;
	}
	
	public void setPacman(Pacman nuevoPacman){
		this.pacman=nuevoPacman;
		
	}
	
	public int getNumero() {
		return this.numero;
	}

	public Pacman getPacman() {
		return pacman;
	}
	
	public void pasarDeNivel() {
		this.numero++;
	}	
	

}
