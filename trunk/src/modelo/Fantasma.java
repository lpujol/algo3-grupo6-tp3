package modelo;




public abstract class Fantasma extends Vivo {

	protected IEstrategia estrategiaNativa;
	protected IEstrategia estrategiaActual;
	private EstadoFantasma estado=EstadoFantasma.Vivo;
	private int velocidadNativa;
	private Posicion posicionInicial;
	private boolean enCasa;
	
	public Fantasma(Laberinto laberinto, int velocidad,Posicion posicionInicial){
		this.laberinto=laberinto;
		this.velocidadNativa=velocidad;
		this.posicionInicial=posicionInicial;
		this.posicion=new Posicion(posicionInicial.getX(),posicionInicial.getY());
		this.velocidad=velocidad;
		this.direccion=Direccion.Derecha;
		this.enCasa=true;
	}

		
	public void setEstrategiaActual(IEstrategia unaEstrategia){
		if(unaEstrategia==null)
			throw new EstrategiaNulaException();
		this.estrategiaActual=unaEstrategia;
	}
	
	public IEstrategia getEstrategiaActual(){
		return estrategiaActual;
		
	}
	
	public void restablecerEstrategiaNativa(){
		this.estrategiaActual=estrategiaNativa;
				
	}


	public Laberinto getLaberinto() {
		return this.laberinto;
	}


	public void vivir(){
		for(int i=0;i<velocidad;i++){
			if (laberinto.cambioDeDireccionPermitido(this.posicion)){
				this.moverse(this.estrategiaActual.getDestino());			
			}
			else {
				mover();
			}
			if (this.laberinto.mismoBloque(this.posicion,this.laberinto.getPacman().getPosicion()))
				if((this.laberinto.getJuego().getPuntosDePoderActivos()>0)&&(this.getEstado().ordinal()==EstadoFantasma.Huyendo.ordinal())){ 
					this.comer();}
				else{
					if(this.estado==EstadoFantasma.Vivo)
						this.laberinto.getPacman().comer();
				}	
		}
	}
	
	
	


	/* Le informa al juego que el fantasma fue comido.
	  
	 */
	
	public void comer(){
		estado=EstadoFantasma.Muerto;
		velocidad=2*this.velocidadNativa;
		Juego juegoActual=this.laberinto.getJuego();
		juegoActual.fantasmaComido(this);
		
	}

	
	public EstadoFantasma getEstado(){
		return this.estado;
	}


	public void setVelocidad(int i) {
		if(i<0)
			throw new VelocidadInvalidaException();
		this.velocidad=i;
		
	}


	public void estaVivo() {
		estado=EstadoFantasma.Vivo;
		
	}


	public void estaHuyendo() {
		estado=EstadoFantasma.Huyendo;
	}


	public void recuperarVelocidadInicial() {
		this.velocidad=velocidadNativa;
		
	}


	public void moverAPosicionInicial(){
		this.posicion=this.posicionInicial.clone();
		this.estrategiaActual=new EstrategiaSalirDeCasa(this);
	}


	public void setPosicion(Posicion nuevaPosicion) {
		this.posicion=nuevaPosicion;		
	}


	public Posicion getPosicionInicial() {
		return this.posicionInicial.clone();
	}

	/*
	 * El fantasma se mueve hacia una posicion destino eligiendo el camino 
	 * mas corto.
	 * 
	 * 
	 * */
	private void moverse(Posicion destino){
		

		Posicion posicionPosibleIzquierda=laberinto.getPosicionBloqueAnteriorHorizontal(posicion);
		Posicion posicionPosibleAbajo=laberinto.getPosicionBloqueAnteriorVertical(posicion);
		Posicion posicionPosibleDerecha=laberinto.getPosicionBloqueSiguienteHorizontal(posicion);
		Posicion posicionPosibleArriba=laberinto.getPosicionBloqueSiguienteVertical(posicion);
		double distanciaMinima=1000;
		int numeroDeOrdenDireccionInicial=this.direccion.ordinal();
		if ((numeroDeOrdenDireccionInicial!=Direccion.Abajo.ordinal())&&(esAdecuadoMoverse(destino, posicionPosibleArriba, distanciaMinima))){
			distanciaMinima=laberinto.distancia(laberinto.getBloqueEnPosicion(posicionPosibleArriba),laberinto.getBloqueEnPosicion(destino));
			direccion=Direccion.Arriba;
		}
		if ((numeroDeOrdenDireccionInicial!=Direccion.Arriba.ordinal())&& esAdecuadoMoverse(destino, posicionPosibleAbajo, distanciaMinima)){
			distanciaMinima=laberinto.distancia(laberinto.getBloqueEnPosicion(posicionPosibleAbajo),laberinto.getBloqueEnPosicion(destino));
			direccion=Direccion.Abajo;			
		}
		if ((numeroDeOrdenDireccionInicial!=Direccion.Izquierda.ordinal())&& esAdecuadoMoverse(destino, posicionPosibleDerecha, distanciaMinima)){
			distanciaMinima=laberinto.distancia(laberinto.getBloqueEnPosicion(posicionPosibleDerecha),laberinto.getBloqueEnPosicion(destino));
			direccion=Direccion.Derecha;
		}
		if ((numeroDeOrdenDireccionInicial!=Direccion.Derecha.ordinal())&& esAdecuadoMoverse(destino, posicionPosibleIzquierda, distanciaMinima)){
			distanciaMinima=laberinto.distancia(laberinto.getBloqueEnPosicion(posicionPosibleIzquierda),laberinto.getBloqueEnPosicion(destino));
			direccion=Direccion.Izquierda;
		}
		this.mover();	
				
	}

	/*Determina si es conveniente moverse a un casillero comparando distancias y verificando que es ocupable.
	  
	 */
	
	private boolean esAdecuadoMoverse(Posicion destino,
			Posicion posicionPosible, double distanciaMinima) {
		
		return ((laberinto.getBloqueEnPosicion(posicionPosible).esOcupablePorFantasma(this))&& (laberinto.distancia(laberinto.getBloqueEnPosicion(posicionPosible),laberinto.getBloqueEnPosicion(destino))<distanciaMinima));
			
		
	}

	public boolean estaEnCasa(){
		return this.enCasa;
	}


	public void setEnCasa(boolean b) {
		this.enCasa=b;		
	}
	
	public void incrementarVelocidad(int incremento){
		velocidad=velocidad+incremento;
		velocidadNativa=velocidadNativa+incremento;
	}


	public int getVelocidadNativa() {
		return this.velocidadNativa;
	};
}

	