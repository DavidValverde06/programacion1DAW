package ejercicio1;

import java.io.BufferedOutputStream;

/**
 * 1.- Desarrollar un programa que os permita escribir bytes en un fichero con la ayuda de un objeto
 * BufferedOutputstream, realizaremos una única escritura a través de un array de tipo byte, que
 * previamente habremos rellenado con el valor “1”, este array también funcionará como una “especie de
 * buffer”, ya que nos va a permitir escribir más de una dato con una sola sentencia de escritura. El tamaño
 * del buffer vuestro (el array) no debe ser ni muy pequeño ni muy grande, por ejemplo de 32Kilobytes. El
 * archivo creado se llamará buffered.dat.
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		BufferedOutputStream bos = new BufferedOutputStream(null);
		
		byte[] arrayBytes = new byte[32];
	}

}
