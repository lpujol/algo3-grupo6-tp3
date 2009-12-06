package titiriteroModificado;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import ar.uba.fi.algo3.titiritero.ControladorJuego;

public class Panel extends ar.uba.fi.algo3.titiritero.vista.Panel {
	
	private static final long serialVersionUID = 8280773989795545016L;
	private Image imagen;
	
	public Panel(int ancho, int alto, ControladorJuego unControlador) {
		super(ancho, alto, unControlador);
	}

	public void paint(Graphics g) {
		g.drawImage(this.imagen, 0, 0, null);
	}

	public void limpiar() {
		if(this.imagen == null)
			this.imagen = this.createImage(getSize().width, getSize().height);
		Graphics superficieParaDibujar =  this.imagen.getGraphics();
		superficieParaDibujar.setColor(Color.BLACK);// 
		superficieParaDibujar.fillRect(0, 0, this.getSize().width, this.getSize().height);
		this.setBackground(Color.RED);
	}
	
	public Object getBuffer(){
		return this.imagen.getGraphics();
	}
	
}
