package modelo;

import java.util.ArrayList;

public class Laberinto {

	private int altoEnBloques;
	private int anchoEnBloques;
	private static final int TAMANO_DEL_BLOQUE = 16;
	private ArrayList<Bloque> bloques;
	private ArrayList<Fantasma> fantasmas;
	private Pacman pacman;
	private Nivel nivel;
	private Juego juego;
	private Posicion posicionCasa;

	public Laberinto(Juego juego) {
	
		this.posicionCasa=new Posicion(1,1);
		this.nivel = new Nivel("nivel.txt", juego, this);
		this.pacman = nivel.getPacman();
		this.bloques = this.nivel.getBloques();
		this.juego = juego;
		this.fantasmas=nivel.getFantasmas();
		
	
	}

	public static int getTamanoDelBloque() {
		return TAMANO_DEL_BLOQUE;
	}

	public Juego getJuego() {
		return this.juego;
	}

	public Pacman getPacman() {
		return this.pacman;
	}
	
	public ArrayList<Bloque> getBloques(){
		return this.bloques;
	}

	// Devuelve true si la posicion pasada por parametro esta en el centro del
	// bloque al que pertenece. Devuelve false en cualquier otro caso.
	public boolean cambioDeDireccionPermitido(Posicion posicionEntidad) {
		
		Posicion posicionBloque = aCoordenadasDeBloque(posicionEntidad);
		if (posicionBloque.equals(posicionEntidad)==false) {			
			return false;
		}
		return true;
	}

	public Posicion getInterseccionMasCercana(Posicion posicionPacman,
			Direccion direccion) {
		return null;

	}

	public Bloque getBloqueEnPosicion(Posicion posicion) {
		return buscarBloque(aCoordenadasDeBloque(posicion));
	}

	// Al pasarle una coordenada global del laberinto, devuelve la posicion del
	// bloque en esa posicion
	public Posicion aCoordenadasDeBloque(Posicion posicionGlobal) {
		// Al castear a int trunca el numero. Le sumo 1 porque nuestras
		// coordenadas empiezan en (1,1)
		int xBloque = ((int) (posicionGlobal.getX() / TAMANO_DEL_BLOQUE) + 1)
				 * TAMANO_DEL_BLOQUE - TAMANO_DEL_BLOQUE / 2;
		int yBloque = ((int) (posicionGlobal.getY() / TAMANO_DEL_BLOQUE) + 1)
				 * TAMANO_DEL_BLOQUE - TAMANO_DEL_BLOQUE / 2;
		Posicion posicionBloque = new Posicion(xBloque, yBloque);
		return posicionBloque;
	}
	
	public Posicion centroDelBloque(Posicion posicion){
		return new Posicion(
				((int)posicion.getX()/TAMANO_DEL_BLOQUE)+TAMANO_DEL_BLOQUE/2,
				((int)posicion.getY()/TAMANO_DEL_BLOQUE)+TAMANO_DEL_BLOQUE/2
		);
	}
	
	public Posicion aCoordenadasReales(Posicion posicion){
		return new Posicion(
				posicion.getX()*TAMANO_DEL_BLOQUE+TAMANO_DEL_BLOQUE/2,
				posicion.getY()*TAMANO_DEL_BLOQUE+TAMANO_DEL_BLOQUE/2
				);
	}

	public Bloque buscarBloque(Posicion posicionBuscada) {
		Bloque bloque;
		for (int i = 0; i < this.bloques.size(); i++) {
			bloque = bloques.get(i);
			if ((bloque.getPosicion().getX() == posicionBuscada.getX())
					&& (bloque.getPosicion().getY() == posicionBuscada.getY())) {
				return bloque;
			}
		}
		return null;
	}

	public double distancia(Bloque bloque1,Bloque bloque2){
		int coordenadaXBloque1=bloque1.getPosicion().getX();
		int coordenadaYBloque1=bloque1.getPosicion().getY();
		int coordenadaXBloque2=bloque2.getPosicion().getX();
		int coordenadaYBloque2=bloque2.getPosicion().getY();
		
		return Math.hypot(coordenadaXBloque2-coordenadaXBloque1,coordenadaYBloque2 -coordenadaYBloque1);
	}
	
	public double distancia(Posicion posicion1,Posicion posicion2){
		int coordenadaXBloque1=posicion1.getX();
		int coordenadaYBloque1=posicion1.getY();
		int coordenadaXBloque2=posicion2.getX();
		int coordenadaYBloque2=posicion2.getY();
		
		return Math.hypot(coordenadaXBloque2-coordenadaXBloque1,coordenadaYBloque2 -coordenadaYBloque1);
	
	}
	
	
	
	public Posicion getPosicionFantasma(Fantasma fantasma) {
		return new Posicion(200,56);
	}

	public Posicion obtenerPosicionCasa() {
		return new Posicion(posicionCasa.getX(),posicionCasa.getY());
	}

	public boolean mismoBloque(Posicion posicion, Posicion posicion2) {
		Posicion posicionDeBloque1=this.aCoordenadasDeBloque(posicion);
		Posicion posicionDeBloque2=this.aCoordenadasDeBloque(posicion2);
		return((posicionDeBloque1.getX()==posicionDeBloque2.getX())&(posicionDeBloque1.getY()==posicionDeBloque2.getY()));
			
	}

	public ArrayList<Fantasma> buscarFantasmasEn(Posicion posicionBuscada) {
		ArrayList<Fantasma> fantasmas=new ArrayList<Fantasma>();
		
		for (int i = 0; i < this.fantasmas.size(); i++) {
			Fantasma fantasmaActual = this.fantasmas.get(i);
			if ((fantasmaActual.getPosicion().getX() == posicionBuscada.getX())
					&& (fantasmaActual.getPosicion().getY() == posicionBuscada.getY())) {
				fantasmas.add(fantasmaActual);
			}
		}
		return fantasmas;
	}
	
	public ArrayList<Fantasma> getFantasmas() {
	return this.fantasmas;
	}

	public Posicion getPosicionBloqueAnteriorHorizontal(Posicion posicion) {
		return aCoordenadasDeBloque(posicion.getPosicionAnteriorHorizontal(16));
		
	}

	public Posicion getPosicionBloqueAnteriorVertical(Posicion posicion) {
		return aCoordenadasDeBloque(posicion.getPosicionAnteriorVertical(16));
		
	}

	public Posicion getPosicionBloqueSiguienteHorizontal(Posicion posicion) {
		
		return aCoordenadasDeBloque(posicion.getPosicionSiguienteHorizontal(16));
	
	}

	public Posicion getPosicionBloqueSiguienteVertical(Posicion posicion) {
		return aCoordenadasDeBloque(posicion.getPosicionSiguienteVertical(16));

	}
	
	public int getAltoEnBloques() {
		return altoEnBloques;
	}

	public int getAnchoEnBloques() {
		return anchoEnBloques;
	}

	public void setAltoEnBloques(int altoEnBloques) {
		this.altoEnBloques = altoEnBloques;
	}

	public void setAnchoEnBloques(int anchoEnBloques) {
		this.anchoEnBloques = anchoEnBloques;
	}

	public Nivel getNivel() {
		return this.nivel;
	}

	public void puntoComido(Punto punto) {
		this.nivel.puntoComido();
		this.juego.puntoComido(punto);
		
	}

	public void puntoDePoderComido(PuntoDePoder puntoDePoder) {
		this.juego.puntoDePoderComido(puntoDePoder);
		
	}

	public void setPosicionCasa(Posicion posicion) {
		this.posicionCasa=posicion;
		
	}
	
	public boolean posicionSiguienteOcupable(Posicion posicionActual,Direccion direccion) {
		Boolean esOcupable=false;
		switch(direccion){
		case Arriba:{
			Posicion posicionPosibleArriba=posicionActual.getPosicionSiguienteVertical(TAMANO_DEL_BLOQUE/2+1);
			esOcupable=(this.getBloqueEnPosicion(posicionPosibleArriba).esOcupablePorPacman());
			};
			break;
		case Abajo:{
			Posicion posicionPosibleAbajo=posicionActual.getPosicionAnteriorVertical(TAMANO_DEL_BLOQUE/2);
			esOcupable=(this.getBloqueEnPosicion(posicionPosibleAbajo).esOcupablePorPacman());
			};
			break;
		case Derecha:{
			Posicion posicionPosibleDerecha=posicionActual.getPosicionSiguienteHorizontal(TAMANO_DEL_BLOQUE/2);
			esOcupable=(this.getBloqueEnPosicion(posicionPosibleDerecha).esOcupablePorPacman());
			};
			break;
		case Izquierda:{
			Posicion posicionPosibleIzquierda=posicionActual.getPosicionAnteriorHorizontal(TAMANO_DEL_BLOQUE/2+1);
			esOcupable=(this.getBloqueEnPosicion(posicionPosibleIzquierda).esOcupablePorPacman());
			};
			break;
		}
		return esOcupable;
	}

	
}
