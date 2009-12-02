package Pacman;

import java.awt.Color;
import java.awt.Event;
import java.util.ArrayList;

import vista.*;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import modelo.*;

public class Programa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Juego juego=new Juego();
		ControladorJuego controlador=new ControladorJuego();
		VentanaPrincipal ventana=new VentanaPrincipal(controlador,juego.getLaberinto().getPacman());
		controlador.setSuperficieDeDibujo(ventana.getSuperficieDeDibujo());
		ventana.setVisible(true);
		
		ArrayList<VistaBloque> vistaBloques=new ArrayList<VistaBloque>();
		ArrayList<Bloque> bloques=juego.getLaberinto().getBloques();
		for(Bloque b:bloques)
		{
			if(b instanceof Pared){
			VistaBloque vistaB=new VistaBloque();
			vistaB.setPosicionable(b);
			vistaBloques.add(vistaB);
			controlador.agregarDibujable(vistaB);
			}
		}
		
		juego.getLaberinto().getNivel().agregarFantasma(new FantasmaCeleste(200,56,juego.getLaberinto(),1));
		ArrayList<VistaFantasma> vistaFantasmas=new ArrayList<VistaFantasma>();
		ArrayList<Fantasma> fantasmas=juego.getLaberinto().getFantasmas();
		for(Fantasma f:fantasmas){
			VistaFantasma vf=new VistaFantasma();
			vf.setColor(Color.cyan);
			vf.setPosicionable(f);
			vistaFantasmas.add(vf);
			controlador.agregarDibujable(vf);
			controlador.agregarObjetoVivo(f);
		}
		VistaPacman pacman=new VistaPacman();
		pacman.setPosicionable(juego.getLaberinto().getPacman());
		controlador.agregarDibujable(pacman);
		controlador.agregarObjetoVivo(juego.getLaberinto().getPacman());
		
		
	
		controlador.setIntervaloSimulacion(20);
		controlador.comenzarJuego();
	}	


}
