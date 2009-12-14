package modelo;

import java.util.ArrayList;

public class Nivel {

	private int numero;
	private ArrayList<Bloque> bloques;
	private ArrayList<Fantasma> fantasmas;
	private Pacman pacman;
	private CargadorDeNiveles cargadorDeNiveles;
	private Posicion pocisionInicial;
	private int puntosComidos;
	private int cantidadPuntos;
	private boolean finNivel;
	
	
	
	public Nivel(String rutaNivel, Juego juego, Laberinto laberinto) {
		this.cargadorDeNiveles = new CargadorDeNiveles(juego, laberinto);
		bloques = new ArrayList<Bloque>();
		this.pocisionInicial=null;
		cargadorDeNiveles.cargar(this, rutaNivel);
		this.numero = 1;		
		fantasmas = new ArrayList<Fantasma>();		
		this.pacman=new Pacman(this.posicionInicialPacman().getX(),this.posicionInicialPacman().getY(),laberinto);
	}
	
	public Posicion posicionInicialPacman(){
		return this.pocisionInicial;
	}
	
	public void enviarPacmanAPosicionInicial(){
		this.pacman.setPosicion(new Posicion(this.pocisionInicial.getX(),this.pocisionInicial.getY()));
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
        resetearBloques();
        reiniciarPosicionesYEstados();
	}
	
	public void reiniciarPosicionesYEstados(){
		this.enviarPacmanAPosicionInicial();
		this.pacman.cambiarDireccion(Direccion.Derecha);
		for(Fantasma fantasma:fantasmas){
			fantasma.moverAPosicionInicial();
			fantasma.setEstrategiaActual(new EstrategiaSalirDeCasa(fantasma));
			fantasma.estaVivo();
		}
	}
	
	public void resetearBloques(){
		for(Bloque bloque:bloques){
			bloque.resetear();
		}
		this.puntosComidos=0;
	}

	public void setPosicionInicialPacman(Posicion posicion) {
		this.pocisionInicial=posicion;
		
	}

	public void puntoComido() {
		this.puntosComidos++;
		if(puntosComidos>=cantidadPuntos)
		this.pasarDeNivel();
	}

	public void sumarPuntos() {
		this.cantidadPuntos++;
		
	}

	public boolean isFinNivel() {
		return finNivel;
	}

	public void setNumero(int i) {
		this.numero=i;
		
	}
	

}