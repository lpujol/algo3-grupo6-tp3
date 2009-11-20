package modelo;



public class PuntoDePoder extends Punto {
	
	private Juego juego;
	
	PuntoDePoder(int x, int y) {
		super(x, y);
	}
	
	public boolean comer() {
		this.comido = true;
		juego.puntoDePoderComido();
		return true;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}
}
