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
			case 35:
				nivel.agregarBloque(new Pared(posicion, laberinto));
				break;
			case 40:
				nivel.agregarBloque(new ParedVerticalIzquierda(posicion, laberinto));
				break;
			case 41:
				nivel.agregarBloque(new ParedVerticalDerecha(posicion, laberinto));
				break;
			case 45:
				nivel.agregarBloque(new ParedHorizontalArriba(posicion, laberinto));
				break;
			case 95:
				nivel.agregarBloque(new ParedHorizontalAbajo(posicion, laberinto));
				break;
			case 106:
				nivel.agregarBloque(new ParedVerticalDerechaHorizontalAbajo(posicion, laberinto));
				break;
			case 76:
				nivel.agregarBloque(new ParedVerticalIzquierdaHorizontalAbajo(posicion, laberinto));
				break;
			case 114:
				nivel.agregarBloque(new ParedVerticalIzquierdaHorizontalArriba(posicion, laberinto));
				break;
			case 113:
				nivel.agregarBloque(new ParedVerticalDerechaHorizontalArriba(posicion, laberinto));
				break;
			case 111:
				nivel.agregarBloque(new Punto(posicion, laberinto));
				nivel.sumarPuntos();
				break;
			case 112:
				nivel.agregarBloque(new EspacioVacio(posicion,laberinto));
				nivel.setPosicionInicialPacman(posicion);
				break;
			case 79:
				nivel.agregarBloque(new PuntoDePoder(posicion, laberinto));
				break;
			case 46:
				nivel.agregarBloque(new Puerta(posicion, laberinto));
				break;
			case 32:
				// Es un espacio vacio pero por ahora hago esto
				nivel.agregarBloque(new EspacioVacio(posicion, laberinto));
				break;
				//en Texto hay 1 2 3 4
			default:
				nivel.agregarBloque(new Punto(posicion,laberinto));
		}		
	}
	
}
