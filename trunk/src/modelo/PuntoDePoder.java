package modelo;



public class PuntoDePoder extends Punto {
	
	private Juego juego;
	
	PuntoDePoder(Posicion posicion, Juego juego) {
		super(posicion);
		this.juego = juego;
	}
	
	public boolean comer() {
		this.comido = true;
		juego.puntoDePoderComido();
		return true;
	}
}
