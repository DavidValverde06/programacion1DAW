package _02flujosCaracteresMemoria;

/**
 * Este ejemplo muestra la utilizacion de la Subclase StringReader y de la clase CharArrayWriter, 
 * vamos a trabajar sobre la memoria
 * 
 * El programa anterior crea un String con los datos que se quieren procesar y un array con la misma longitud 
 * que el String anterior. 
 * 
 * Se utilizara un flujo de entrada de la clase StringReader para leer el String caracter a caracter. 
 * 
 * Los caracteres leidos se van almacenando en un flujo de salida, de la clase CharArrayWrite, uno a 
 * uno hasta que se lee el car�cter -1 que indica el final del String. 
 * 
 * Una vez se han leido todos los caracteres se copian al array miArrayChar, mediante el metodo toCharArray()
 * del objeto del flujo de salida de la clase CharArrayWriter. 
 * 
 * Por ultimo, y no menos importante se cierran los flujos abiertos.
 * 
 */
import java.io.*;
import java.util.Arrays;

public class Ejemplo1Flujos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Crear una cadena de texto con las primeras frase de "El Quijote"
		String s = "En un lugar de la Mancha de cuyo nombre no quiero acordarme, " +
				"no ha mucho tiempo que vivía un hidalgo de los de lanza en " +
				"astillero, adarga antigua, rocín flaco y galgo corredor...";

		// Pedir memoria para una array de caracteres, cuya longitud sera igual a la cadena anterior
		char [] miArrayChar = new char[s.length()];

		// Variable auxiliar en la que ir guardando el caracter leido del flujo de entrada 
		int car=0;

		// Apertura de los flujos
		StringReader flujoInput = new StringReader(s);   // Definir el flujo de entrada (lectura)
		CharArrayWriter flujoOutput = new CharArrayWriter();  // Definir el flujo de salida (escritura)

		try {

			// Primer planteamiento, el primer caractr se lee fuera del bucle, y el resto de 
			// caracteres hasta finalizar (la lectura retorna -1) antes del final del bucle
			/*		car = flujoInput.read();  // Leer el primer caracter del flujo de entrada 
			while (car != -1) {
				flujoOutput.write(car);  // Escribir un caracter en el flujo de salida
				car = flujoInput.read(); // Leer otro caracter del flujo de entrada 
			}
			 */	


			// Segundo planteamiento en la condicion del bucle se lee y se va comprobando 
			// si hemos alcanzado el final de fichero (caracter -1)
			while ((car = flujoInput.read()) != -1) {
				flujoOutput.write(car);
			}


			// Convertimos el flujo en un array
			miArrayChar = flujoOutput.toCharArray(); 

			// Mostramos el array de diferentes formas
			System.out.println(Arrays.toString(miArrayChar));  
			System.out.println(miArrayChar);  

			// Mostramos el flujo de entrada
			System.out.println("Flujo entrada (StringReader):  " + flujoInput);

			// Mostramos el flujo de salida
			System.out.println("Flujo salida (CharArrayWriter): " + flujoOutput);

			// Accedemos al segundo caracter del array creado a partir del flujo de salid
			System.out.println("Segundo caracter de array: "+miArrayChar[1]);

			// Intentamos acceder al segundo caracter del flujo de salida, da error, no es un array
			//		System.out.println(flujoOutput[1]);  
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			// Cierre de los flujos de entrada y salida
			flujoInput.close();   
			flujoOutput.close();
		}


		// El siguiente planteamiento, evidentemente, es mucho mas simple, no necesitamos
		// un flujo para convertir una cadena en array
		// En el codigo anterior lo que se planteaba es como poder hacerlo a traves de flujos
		// para ir familiarizandonos con ellos
		char [] miArray = "Hola como te llamas".toCharArray();
		System.out.println(miArray);
		System.out.println(Arrays.toString(miArray));

	}
}





