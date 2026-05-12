package _03ESFicheroBytes;

import java.io.*;

/**
 * El siguiente programa lee un fichero secuencial y lo visualiza por pantalla.
 * El fichero que leeremos será el propio código de la clase: Ejemplo3FileInputStream
 * 
 * Para la lectura utilizaremos un buffer de 64 bytes, por tanto cada vez que leemos, nos
 * traeremos al buffer (que en realidad es un array 64 bytes, en lugar de 1)
 *
 */
public class Ejemplo3FileInputStream {

   public static void main(String[]  argumentos) {
	   
       final int TAMANIO_BUFFER = 64;   // El tamaño del buffer se ha asignado arbitrariamente
       byte buffer[] = new byte[TAMANIO_BUFFER]; // Array que recoge lo que leemos
       int numBytes; 

       FileInputStream ficheroOrigen = null; 
       
       try {
    	   ficheroOrigen = new FileInputStream("./src/_03ESFicheroBytes/Ejemplo3FileInputStream.java");

    	   do {  
    		   // Este bucle va leyendo grupos de datos de hasta 64 bytes, y termina
    		   // cuando en una lectura nos encontramos menos de TAMANIO_BUFFER bytes.

    		   numBytes = ficheroOrigen.read(buffer);  // Leer datos del fichero
    		   System.out.print(new String(buffer,0,numBytes)); //Mostrar por pantalla
    				
    	   } 
    	   while (numBytes == TAMANIO_BUFFER);
    	       // Estaremos leyendo, hasta que en una lectura lea menos del tamaño
    	       // del buffer, lo que indicará que no hay m�s datos para leer, es decir,
    	       // habremos leído los últimos bytes del archivo

       } 
       catch (FileNotFoundException e) {
    	   System.out.println("Fichero no encontrado");
       }
       catch (IOException e){  
		   System.out.println("Error leyendo los datos o cerrando el fichero");   
	   }
       finally {
    	   try {
    		   if (ficheroOrigen!=null) ficheroOrigen.close();
    	   } 
    	   catch (IOException e) {
    		   System.out.println("Problema al cerrar el fichero");
    	   }
       }
   }
}
