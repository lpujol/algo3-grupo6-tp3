package modelo;

import java.util.ArrayList;

public class Nivel {

	private static final int INCREMENTO_VELOCIDAD_POR_NIVEL = 1;
	private static final int INCREMENTO_BONUS_POR_NIVEL = 200;
	//Numero de nivel.
	private int numero;
	private ArrayList<Bloque> bloques;
	private ArrayList<Fantasma> fantasmas;
	private Pacman pacman;
	private CargadorDeNiveles cargadorDeNiveles;
	private Posicion pocisionInicial;
	private int puntosComidos;
	private int cantidadPuntos;
	private boolean finNivel;
	private ArrayList<Portal> portales;
	
	
	
	public Nivel(String rutaNivel, Juego juego, Laberinto laberinto) {
		this.cargadorDeNiveles = new CargadorDeNiveles(juego, laberinto);
		bloques = new ArrayList<Bloque>();
		portales = new ArrayList<Portal>();
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
        int incremento=INCREMENTO_VELOCIDAD_POR_NIVEL;
        this.pacman.incrementarVelocidad(incremento);
        for(Fantasma fantasma:fantasmas){
			fantasma.incrementarVelocidad(incremento);
		}
        this.cargadorDeNiveles.getJuego().desactivarPuntoDePoder();
        this.cargadorDeNiveles.getJuego().incrementarValorBonus(INCREMENTO_BONUS_POR_NIVEL);
        resetearBloques();
        reiniciarPosicionesYEstados();
	}
	
	public void reiniciarPosicionesYEstados(){
		this.enviarPacmanAPosicionInicial();
		this.pacman.setEstrategia(new EstrategiaIrALaDerecha(pacman));
		for(Fantasma fantasma:fantasmas){
			fantasma.moverAPosicionInicial();
			fantasma.setEstrategiaActual(new EstrategiaSalirDeCasa(fantasma));
			fantasma.estaVivo();
		}
	}
	
	//Devuelve todos los bloques a su estado inicial.
	
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
		if(cantidadPuntos-puntosComidos<=20) this.fantasmas.get(0).setEstrategiaActual(new EstrategiaColaborativa(this.fantasmas.get(0)));
		if(puntosComidos==100) this.pacman.laberinto.activarBonus();
		if(puntosComidos>=cantidadPuntos)
		this.pasarDeNivel();
	}

	public void sumarPuntos() {
		this.cantidadPuntos++;
		
	}

	public boolean isFinNivel() {
		return finNivel;
	}

	public ArrayList<Portal> getPortales() {
		return this.portales;
	}


	public void agregarPortal(Portal portal) {
		portales.add(portal);		
	}


	public void setNumero(int i) {
		this.numero=i;
		
	}
	


}
