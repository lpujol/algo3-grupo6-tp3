package vista;

import java.util.ArrayList;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
/*import ar.uba.fi.algo3.titiritero.vista.Imagen;*/
import titiriteroModificado.Imagen;

public class ImagenAnimada implements Dibujable {

	private ArrayList<Imagen> imagenes;
	int contador;
	int contadorDelay;
	private Posicionable posicionable;
	private int delay;
	
	public ImagenAnimada(Posicionable pos){
		imagenes=new ArrayList<Imagen>();
		this.posicionable=pos;
		this.delay=1;
		this.contadorDelay=0;
	}
	
	public void setDelay(int n){
		this.delay=n;
	}
	
	public void add(String path){
		Imagen img=new Imagen();
		img.setNombreArchivoImagen(path);
		img.setPosicionable(posicionable);		
		imagenes.add(img);
	}
	
	@Override
	public void dibujar(SuperficieDeDibujo superfice) {
		if(contador>=imagenes.size())
			contador=0;
		if(contadorDelay>=delay){
			contadorDelay=0;			
			imagenes.get(contador).dibujar(superfice);
			contador++;
		}
		else
		{
			imagenes.get(contador).dibujar(superfice);
			contadorDelay++;
		}

	}

	@Override
	public Posicionable getPosicionable() {
		return this.posicionable;
	}

	@Override
	public void setPosicionable(Posicionable posicionable) {
		this.posicionable=posicionable;
		for(Imagen img:imagenes)
			img.setPosicionable(posicionable);

	}

}
