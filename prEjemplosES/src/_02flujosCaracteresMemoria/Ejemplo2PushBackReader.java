package _02flujosCaracteresMemoria;

/**
 * En este ejemplo nuestro flujo de entrada sera un PushBackReader, a partir de un
 * StringReader, lo cual nos va a permitir leer caracteres de la memoria
 * 
 * Este ejemplo muestra un caso practico de la utilizacion de un objeto 
 * PushBackReader. En el siguiente programa se sustituyen el operador 
 * de incrementos (b++) por una asignacion y una suma (b=b+1), teniendo
 * en cuenta que las variables estan definidas con una letra. 
 * 
 * Cuando el programa se encuetra con un car�cter +, mira en el flujo si 
 * hay otro car�cter + y, si no es as�, lo devuelve al flujo mediante 
 * el m�todo unread().
 *
 */

import java.io.*;
public class Ejemplo2PushBackReader {
	
	public static void main(String[] args) throws IOException{
		
	//	String sentencias = "a=a+1;c++;b+=5;c=a+b;b++;";
	//	StringReader sr = new StringReader(sentencias);
	//	PushbackReader pbr = new PushbackReader(sr);
		
		// Apertura de un flujo PushBackReader, a partir de un StringReader
		PushbackReader pbr = new PushbackReader(
								new StringReader("a=a+1;c++;b+=5;c=a+b;b++;"));
		
		int penultimo = 0;
		int ultimo = pbr.read();  // Lectura del primer car�cter
		
		while (ultimo!=-1) {  // El m�todo "read" devuelve -1 cuando ya no queden mas 
			                  // caracteres para leer
			switch (ultimo){
			   case '+': if ((ultimo = pbr.read())=='+') {  // Si el siguiente caracter tambien es '+'
						    System.out.print("="+(char)penultimo+"+1");
						  }
					     else {  // El siguiente car�cter no era '+', por tanto lo dejamos otra
					    	     // vez donde estaba, es decir, en el PushbackReader
						    pbr.unread(ultimo);
						    System.out.print('+');
					      }
			   			 break;
			   case ';': System.out.println((char)ultimo);  
			             break;
			   default:  System.out.print((char)ultimo);
			}  // end switch
			penultimo = ultimo;
			ultimo = pbr.read();  // Lectura de otro car�cter
		} // end while
		
		// Cierre del flujo 
		pbr.close();
	}
}
