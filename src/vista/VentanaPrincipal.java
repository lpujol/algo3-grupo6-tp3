package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Event;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import modelo.EstrategiaIrALaDerecha;
import modelo.EstrategiaIrALaIzquierda;
import modelo.EstrategiaIrHaciaAbajo;
import modelo.EstrategiaIrHaciaArriba;
import modelo.Pacman;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import titiriteroModificado.Panel;

public class VentanaPrincipal extends Frame {

	public VentanaPrincipal(ControladorJuego unControladorJuego,final Pacman pacman) {
		this.controladorJuego = unControladorJuego;
		this.setTitle("Pacman");
		this.setSize(470, 590);
		
		this.setResizable(false);
		panel = new Panel(448,536,controladorJuego);
		this.add(panel,BorderLayout.CENTER);
		
		this.setBackground(Color.black);
		panel.setBackground(Color.black);
		
				
		this.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.print(arg0.getKeyCode());
				int tecla=arg0.getKeyCode();
				switch(tecla)
				{
				case 10://enter
					pacman.getLaberinto().getJuego().comenzar();
					break;
				case 38:
					pacman.setEstrategia(new EstrategiaIrHaciaArriba(pacman));
					
					break;
				case 40:
					pacman.setEstrategia(new EstrategiaIrHaciaAbajo(pacman));					
					break;
				case 37:
					pacman.setEstrategia(new EstrategiaIrALaIzquierda(pacman));
					break;
				case 39:
					pacman.setEstrategia(new EstrategiaIrALaDerecha(pacman));					
					break;
				}

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}			
		});
	}

	private ControladorJuego controladorJuego;
	private static final long serialVersionUID = 1L;
	private Panel panel;
	
	public SuperficieDeDibujo getSuperficieDeDibujo() {
		return this.panel;
	}
	
	public boolean keydown(Event evt, int x){
		System.out.print("tecla");
		return true;
	}
}
