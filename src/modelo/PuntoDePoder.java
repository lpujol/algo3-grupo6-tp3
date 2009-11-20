package modelo;



public class PuntoDePoder extends Punto {
	
	private Juego juego;
	
	PuntoDePoder(int x, int y, Juego juego) {
		super(x, y);
		this.juego = juego;
	}
	
	public boolean comer() {
		this.comido = true;
		juego.puntoDePoderComido();
		return true;
	}
}
