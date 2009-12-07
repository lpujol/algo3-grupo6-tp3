package Pacman;

import java.awt.Color;
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
		
		ArrayList<Bloque> bloques=juego.getLaberinto().getBloques();
		for(Bloque b:bloques)
		{
			if(b instanceof Pared) {
				VistaBloque vistaB=new VistaBloque();
				vistaB.setPosicionable(b);
				controlador.agregarDibujable(vistaB);
			}
			if (b instanceof ParedVertical) {
				VistaParedVertical vistaPV = new VistaParedVertical();
				vistaPV.setPosicionable(b);
				controlador.agregarDibujable(vistaPV);
			}
			if (b instanceof ParedHorizontal) {
				VistaParedHorizontal vistaPH = new VistaParedHorizontal();
				vistaPH.setPosicionable(b);
				controlador.agregarDibujable(vistaPH);
			}
			if (b instanceof ParedVerticalDerechaHorizontalArriba) {
				VistaParedVerticalDerechaHorizontalArriba vistaPVDHA = new VistaParedVerticalDerechaHorizontalArriba();
				vistaPVDHA.setPosicionable(b);
				controlador.agregarDibujable(vistaPVDHA);
			}
			if (b instanceof ParedVerticalIzquierdaHorizontalArriba) {
				VistaParedVerticalIzquierdaHorizontalArriba vistaPVIHA = new VistaParedVerticalIzquierdaHorizontalArriba();
				vistaPVIHA.setPosicionable(b);
				controlador.agregarDibujable(vistaPVIHA);
			}
			if (b instanceof ParedVerticalIzquierdaHorizontalAbajo) {
				VistaParedVerticalIzquierdaHorizontalAbajo vistaPVIHA = new VistaParedVerticalIzquierdaHorizontalAbajo();
				vistaPVIHA.setPosicionable(b);
				controlador.agregarDibujable(vistaPVIHA);
			}
			if (b instanceof ParedVerticalDerechaHorizontalAbajo) {
				VistaParedVerticalDerechaHorizontalAbajo vistaPVIHA = new VistaParedVerticalDerechaHorizontalAbajo();
				vistaPVIHA.setPosicionable(b);
				controlador.agregarDibujable(vistaPVIHA);
			}
			if(b instanceof EspacioVacio){
				VistaEspacioVacio vistaEV=new VistaEspacioVacio();
				vistaEV.setPosicionable(b);
				controlador.agregarDibujable(vistaEV);
			}
			if(b instanceof Punto){
				VistaPunto vistaP=new VistaPunto((Punto)b);
				controlador.agregarDibujable(vistaP);
			}
			if(b instanceof PuntoDePoder){
				VistaPuntoPoder vistaP=new VistaPuntoPoder((PuntoDePoder)b);
				controlador.agregarDibujable(vistaP);
			}
			if(b instanceof Puerta){
				VistaPuerta vistaP=new VistaPuerta();
				vistaP.setPosicionable(b);
				controlador.agregarDibujable(vistaP);
			}
		}
		
		FantasmaCeleste fantasmaCeleste=new FantasmaCeleste(200,56,juego.getLaberinto(),1);
		juego.getLaberinto().getNivel().agregarFantasma(fantasmaCeleste);
		VistaFantasmaCeleste vistaFantasmaCeleste=new VistaFantasmaCeleste(fantasmaCeleste);
		controlador.agregarDibujable(vistaFantasmaCeleste);
		controlador.agregarObjetoVivo(fantasmaCeleste);
		
		FantasmaRojo fantasmaRojo=new FantasmaRojo(null,juego.getLaberinto(),1);
		juego.getLaberinto().getNivel().agregarFantasma(fantasmaRojo);
		VistaFantasmaRojo vistaFantasmaRojo=new VistaFantasmaRojo(fantasmaRojo);
		controlador.agregarDibujable(vistaFantasmaRojo);
		controlador.agregarObjetoVivo(fantasmaRojo);
		
		FantasmaNaranja fantasmaNaranja=new FantasmaNaranja(null,juego.getLaberinto(),1);
		juego.getLaberinto().getNivel().agregarFantasma(fantasmaNaranja);
		VistaFantasmaNaranja vistaFantasmaNaranja=new VistaFantasmaNaranja(fantasmaNaranja);
		controlador.agregarDibujable(vistaFantasmaNaranja);
		controlador.agregarObjetoVivo(fantasmaNaranja);
		
		FantasmaRosa fantasmaRosa=new FantasmaRosa(null,juego.getLaberinto(),1);
		juego.getLaberinto().getNivel().agregarFantasma(fantasmaRosa);
		VistaFantasmaRosa vistaFantasmaRosa=new VistaFantasmaRosa(fantasmaRosa);
		controlador.agregarDibujable(vistaFantasmaRosa);
		controlador.agregarObjetoVivo(fantasmaRosa);
		
		/*juego.getLaberinto().getNivel().agregarFantasma(new FantasmaRojo(null,juego.getLaberinto(),1));
		ArrayList<VistaFantasma> vistaFantasmas=new ArrayList<VistaFantasma>();
		ArrayList<Fantasma> fantasmas=juego.getLaberinto().getFantasmas();
		for(Fantasma f:fantasmas){
			VistaFantasma vf=new VistaFantasma(f);
			//vf.setColor(Color.cyan);
			vf.setPosicionable(f);
			vistaFantasmas.add(vf);
			controlador.agregarDibujable(vf);
			controlador.agregarObjetoVivo(f);
		}*/
		VistaPacman pacman=new VistaPacman(juego.getLaberinto().getPacman());
		//pacman.setPosicionable(juego.getLaberinto().getPacman());
		controlador.agregarDibujable(pacman);
		controlador.agregarObjetoVivo(juego.getLaberinto().getPacman());
		
		EstadoJuego estadoJuego=new EstadoJuego(juego);
		VistaEstadoJuego vistaEstadoJuego=new VistaEstadoJuego(estadoJuego);
		controlador.agregarDibujable(vistaEstadoJuego);
		
	
		controlador.setIntervaloSimulacion(3);
		controlador.comenzarJuego();
	}	


}
