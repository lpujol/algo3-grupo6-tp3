package modelo;

public abstract class Bloque {
	
	protected int x;
	protected int y;
	protected boolean comido;
	
	public Bloque(int x, int y) throws IllegalArgumentException {
		if ((x > 0) && (y > 0)) {
			this.x = x;
			this.y = y;
		} else {
			throw new IllegalArgumentException();
		}
		this.comido = false;
	}

	
	
	public boolean esOcupable() {
		return true;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}



	public boolean ocupar() {
		return comido;
		// TODO Auto-generated method stub
		
	}
	
}
