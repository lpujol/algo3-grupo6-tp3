package modelo;

public class EstrategiaSiempreALaDerecha implements Estrategia {

	private Entidad entidad;

	public EstrategiaSiempreALaDerecha(Entidad entidad)
	{
		this.entidad=entidad;
	}
	
	@Override	
	public void vivir() {

		switch(entidad.getDireccion())
		{
		case Abajo:
			if(!entidad.irHaciaLaIzquierda()) entidad.mover();
			break;
		case Arriba:
			if(!entidad.irHaciaLaDerecha()) entidad.mover();
			break;
		case Derecha:
			if(!entidad.irHaciaAbajo()) entidad.mover();
			break;
		case Izquierda:
			if(!entidad.irHaciaArriba()) entidad.mover();
			
		}
	}

}
