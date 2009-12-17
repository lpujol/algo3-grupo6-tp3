package ar.uba.fi.algo3.titiritero;

/*
 * Esta abstraccion es solo a fin de poder abstraerse de la API grafica de Java
 * y poder testear la solucion facilmente
 */
public interface SuperficieDeDibujo {
	public void limpiar();
	public void actualizar();
	public Object getBuffer();
}
