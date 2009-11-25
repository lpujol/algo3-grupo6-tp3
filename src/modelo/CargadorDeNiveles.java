package modelo;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CargadorDeNiveles {
	
	Juego juego;
	int nivelSiguiente;
	int cantidadDeNiveles;
	
	public CargadorDeNiveles(Juego juego) {
		this.juego = juego;
		this.nivelSiguiente = 1;
		this.cantidadDeNiveles = getCantidadDeNiveles();
		
	}
	
	public Nivel getSiguiente() {
		int x;
		int y;
		int caracter;
		Nivel nivel = new Nivel(nivelSiguiente);
		BufferedReader input = null;
		File nivelFile = new File("nivel"+nivelSiguiente+".txt");
		try {
			input = new BufferedReader(new FileReader(nivelFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (y = 1; y <= 31; y++) {
			for (x = 1; x <= 28; x++) {
				try {
					caracter = input.read();
					agregarObjeto(caracter, nivel, new Posicion(x, y));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
        return nivel;
	}
	
	public boolean haySiguiente() {
		return this.nivelSiguiente <= this.cantidadDeNiveles; 
	}
	
	private int getCantidadDeNiveles() {
		int i = 1;
		File nivelFile = new File("nivel"+i+".txt");
		while (nivelFile.exists()) {
			i++;
			nivelFile = new File("nivel"+i+".txt");
		}
		return i-1;
	}

	private void agregarObjeto(int caracter, Nivel nivel, Posicion posicion) {
		switch (caracter) {
			case 35:
				nivel.agregarBloque(new Pared(posicion));
				break;
			case 111:
				nivel.agregarBloque(new Punto(posicion));
				break;
			case 79:
				nivel.agregarBloque(new PuntoDePoder(posicion, juego));
				break;
			case 45:
				nivel.agregarBloque(new Puerta(posicion));
				break;
		}		
	}
	
}
