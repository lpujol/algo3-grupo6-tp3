package ar.uba.fi.algo3.titiritero.vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class Panel extends java.awt.Panel implements SuperficieDeDibujo {


	private static final long serialVersionUID = -5159188497592488407L;
	private Image imagen;

	// es llamado internamente por el metodo repaint() de la clase Frame
	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics g) {
		g.drawImage(this.imagen, 0, 0, null);
	}
	
	@Override
	public void actualizar() {
		this.repaint();
	}

	@Override
	public void limpiar() {
		if(this.imagen == null)
			this.imagen = this.createImage(getSize().width, getSize().height);
		Graphics superficieParaDibujar =  this.imagen.getGraphics();
		superficieParaDibujar.setColor(Color.YELLOW);// 
		superficieParaDibujar.fillRect(0, 0, this.getSize().width, this.getSize().height);
		this.setBackground(Color.RED);
	}

	public Object getBuffer(){
		return this.imagen.getGraphics();
	}
	
	public Panel(int ancho,int alto, ControladorJuego unControlador){
		this.addMouseListener(new MouseClickController(unControlador));
		this.setSize(ancho, alto);
		this.setVisible(true);
	}
	

}
