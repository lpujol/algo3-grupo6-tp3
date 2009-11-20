package modelo;


public class Pacman extends Vivo{
	
	private int vidas;
	private IEstrategia estrategia;
	
	public Pacman(Posicion posicion){
		
		this.vidas=3;
		
	}
	
	public boolean mover(Posicion posicion){
	/**	
		this.setPosicion(new Point(this.getPosicion().getX()+posicion.getX(),
				this.getPosicion().getY()+posicion.getY()));
		**/	
		return false;
	}
	
	public int getCantidadVidas(){
		return this.vidas; 
	}
	
	public void vivir(){
		mover(this.getEstrategia().getDestino());
		
	}

	private IEstrategia getEstrategia() {
		// TODO Auto-generated method stub
		return null;
	};

}
