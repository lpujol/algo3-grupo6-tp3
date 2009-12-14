package modelo;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CargadorDeNiveles {
	
	Juego juego;
	Laberinto laberinto;
	
	public CargadorDeNiveles(Juego juego, Laberinto laberinto) {
		this.juego = juego;
		this.laberinto = laberinto;
	}
	
	private Posicion pasarAPosicionGlobal(Posicion posicionVieja) {
		Posicion posicionGlobal;
		int x;
		int y;
		x = posicionVieja.getX() * Laberinto.getTamanoDelBloque()
					- Laberinto.getTamanoDelBloque() / 2;
		y = posicionVieja.getY() * Laberinto.getTamanoDelBloque()
					- Laberinto.getTamanoDelBloque() / 2;
		posicionGlobal = new Posicion(x, y);
		return posicionGlobal;
	}
	
	public Nivel cargar(Nivel nivel, String rutaNivel) {
		int x;
		int y;
		int caracter;
		BufferedReader input = null;
		File nivelFile = new File(rutaNivel);
		try {
			input = new BufferedReader(new FileReader(nivelFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			laberinto.setAnchoEnBloques(Integer.parseInt(input.readLine()));
			laberinto.setAltoEnBloques(Integer.parseInt(input.readLine()));
			for (y = 1; y <= laberinto.getAltoEnBloques(); y++) {
				for (x = 1; x <= laberinto.getAnchoEnBloques(); x++) {
					caracter = input.read();
					agregarObjeto(caracter, nivel, pasarAPosicionGlobal(new Posicion(x, y)));
				}
				input.readLine();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
        return nivel;
        
	}

	private void agregarObjeto(int caracter, Nivel nivel, Posicion posicion) {
		switch (caracter) {
			case 35:// #
				nivel.agregarBloque(new Pared(posicion, laberinto));
				break;
			case 124:// |
				nivel.agregarBloque(new ParedVertical(posicion, laberinto));
				break;
			/*case 41:// )
				nivel.agregarBloque(new ParedVerticalDerecha(posicion, laberinto));
				break;*/
			case 45:// -
				nivel.agregarBloque(new ParedHorizontal(posicion, laberinto));
				break;
			case 106:// j
				nivel.agregarBloque(new ParedVerticalDerechaHorizontalAbajo(posicion, laberinto));
				break;
			case 76:// L
				nivel.agregarBloque(new ParedVerticalIzquierdaHorizontalAbajo(posicion, laberinto));
				break;
			case 114:// r
				nivel.agregarBloque(new ParedVerticalIzquierdaHorizontalArriba(posicion, laberinto));
				break;
			case 113:// q
				nivel.agregarBloque(new ParedVerticalDerechaHorizontalArriba(posicion, laberinto));
				break;
			case 111:// o
				nivel.agregarBloque(new Punto(posicion, laberinto));
				nivel.sumarPuntos();
				break;
			case 112:// p
				nivel.agregarBloque(new EspacioVacio(posicion,laberinto));
				nivel.setPosicionInicialPacman(posicion);
				break;
			case 79:// O
				nivel.agregarBloque(new PuntoDePoder(posicion, laberinto));
				break;
			case 46:// .
				nivel.agregarBloque(new Puerta(posicion, laberinto));
				
				laberinto.setPosicionPuerta(posicion);
				break;
			case 32://  " "
				nivel.agregarBloque(new EspacioVacio(posicion, laberinto));
				break;
			case 67:// C
				nivel.agregarBloque(new EspacioVacio(posicion,laberinto));
				
				laberinto.setPosicionCasa(posicion);
				break;
				//en Texto hay 1 2 3 4
			case 49: //1
				nivel.agregarBloque(new EspacioVacio(posicion,laberinto));
				
				laberinto.setPosicionFantasmaInicial(1,posicion);				
				break;
			case 50: //2
				nivel.agregarBloque(new EspacioVacio(posicion,laberinto));
				
				laberinto.setPosicionFantasmaInicial(2,posicion);				
				break;
			case 51: //3
				nivel.agregarBloque(new EspacioVacio(posicion,laberinto));
				
				laberinto.setPosicionFantasmaInicial(3,posicion);				
				break;
			case 52: //4
				nivel.agregarBloque(new EspacioVacio(posicion,laberinto));
				
				laberinto.setPosicionFantasmaInicial(4,posicion);				
				break;
	/*		case 42: //*
				nivel.agregarPortal(new Portal(posicion,laberinto));
								
				break;*/
				
			default:
				nivel.agregarBloque(new EspacioVacio(posicion,laberinto));
		}		
	}
	
}
