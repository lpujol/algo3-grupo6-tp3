package modelo;

import java.util.ArrayList;

public class Laberinto {

	private int altoEnBloques;
	private int anchoEnBloques;
	private int tamanoDelBloque;
	private ArrayList<Bloque> bloques;
	private ArrayList<Vivo> entidades;
	private Pacman pacman;
	private Nivel nivel;
	private Juego juego;

	public Laberinto(Nivel nivel, Juego juego) {
		this.anchoEnBloques = 28;
		this.altoEnBloques = 31;
		this.tamanoDelBloque = 16;
		this.nivel = nivel;
		this.bloques = this.nivel.getBloques();
		actualizarPosicionesDeBloques();
		this.juego = juego;
	}

	// A las posiciones de los bloques creadas por nivel les actualiza la
	// posicion considerando el tamano de los bloques
	private void actualizarPosicionesDeBloques() {
		Bloque bloque;
		Posicion posicionVieja;
		Posicion posicionNueva;
		int x;
		int y;
		for (int i = 0; i < this.bloques.size(); i++) {
			bloque = bloques.get(i);
			posicionVieja = bloque.getPosicion();
			x = posicionVieja.getX() * this.tamanoDelBloque
					- this.tamanoDelBloque / 2;
			y = posicionVieja.getY() * this.tamanoDelBloque
					- this.tamanoDelBloque / 2;
			posicionNueva = new Posicion(x, y);
			bloque.setPosicion(posicionNueva);
		}
	}

	public Juego getJuego() {
		return this.juego;
	}

	public Pacman getPacman() {
		return this.pacman;
	}

	// Devuelve true si la posicion pasada por parametro esta en el centro del
	// bloque al que pertenece. Devuelve false en cualquier otro caso.
	public boolean cambioDeDireccionPermitido(Posicion posicionEntidad) {
		Posicion posicionBloque = aCoordenadasDeBloque(posicionEntidad);
		if (posicionBloque != posicionEntidad) {
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
	private Posicion aCoordenadasDeBloque(Posicion posicionGlobal) {
		// Al castear a int trunca el numero. Le sumo 1 porque nuestras
		// coordenadas empiezan en (1,1)
		int xBloque = ((int) (posicionGlobal.getX() / this.tamanoDelBloque) + 1)
				* this.tamanoDelBloque - this.tamanoDelBloque / 2;
		int yBloque = ((int) (posicionGlobal.getY() / this.tamanoDelBloque) + 1)
				* this.tamanoDelBloque - this.tamanoDelBloque / 2;
		Posicion posicionBloque = new Posicion(xBloque, yBloque);
		return posicionBloque;
	}

	private Bloque buscarBloque(Posicion posicionBuscada) {
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

	public Posicion getPosicionFantasma(Fantasma fantasma) {
		// TODO Auto-generated method stub
		return null;
	}

	public Posicion obtenerPosicionCasa() {
		// TODO Auto-generated method stub
		return null;
	}
}
