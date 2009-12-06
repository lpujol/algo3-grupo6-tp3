package titiriteroModificado;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

/* En lugar de cargar archivos JPG, carga archivos PNG y GIF */
public class Imagen extends ar.uba.fi.algo3.titiritero.vista.Imagen implements Dibujable {

	private String nombreArchivoImagen;
    private BufferedImage imagen;
    private Posicionable posicionable;
    
    public Imagen() {
    	
    }
    
    public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
		grafico.drawImage(this.imagen, this.posicionable.getX(), this.posicionable.getY(), null);
	}
	    
	public String getNombreArchivoImagen() {
		return nombreArchivoImagen;
	}
    
    /**
	 * Estable la imagen con la que se dibujará el objeto.
	 * @param nombreArchivoImagen es el nombre del archivo que contiene l a imagen. Se espera que dicho archivo sea .jpg y esté ubicado en....
	 */
    public void setNombreArchivoImagen(String nombreArchivoImagen) {
		this.nombreArchivoImagen = nombreArchivoImagen;
		try {
			InputStream is = getClass().getResourceAsStream(this.nombreArchivoImagen);
			this.imagen = ImageIO.read(is);
	    } 
	    catch (IOException e) {
	    	
	    }			
	}
    
    public Posicionable getPosicionable() {
		return posicionable;
	}
    
    public void setPosicionable(Posicionable posicionable) {
		this.posicionable = posicionable;
	}
    
}
