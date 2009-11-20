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
		File nivelFile = new File("nivel"+nivelSiguiente+"txt");
		try {
			input = new BufferedReader(new FileReader(nivelFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (y = 1; y <= 31; y++) {
			for (x = 1; x <= 28; x++) {
				try {
					caracter = input.read();
					agregarObjeto(caracter, nivel, x, y);
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
		int cantidad = 0;
		File nivelFile = new File("nivel"+cantidad+1+"txt");
		while (nivelFile.exists()) {
			cantidad++;
			nivelFile = new File("nivel"+cantidad+1+"txt");
		}
		return cantidad;
	}

	private void agregarObjeto(int caracter, Nivel nivel, int x, int y) {
		Bloque bloque = null;
		switch (caracter) {
			case 35:
				bloque = new Pared(x, y);
				break;
			case 111:
				bloque = new Punto(x, y);
				break;
			case 79:
				bloque = new PuntoDePoder(x, y, juego);
				break;
			case 45:
				bloque = new Puerta(x, y);
				break;
		}
		nivel.agregarBloque(bloque);		
	}
	
}
