package _09Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * En este ejemplo vamos a diseñar un metodo que nos permita obtener datos de un fichero,
 * sin importarnos el tipo, solo sabemos que estan separados por el delimitador
 * que nos indiquen y queremos guardarlos en un List de String.
 * 
 *  
 *
 */

public class EjemploFichero5 {

	/**
	 * M�todo que leer un fichero de cualquier tipo, y con cualquier separador
	 * 
	 * @param fileName --> nombre del fichero a leer
	 * @param del -------> cadena con el caracter separador
	 * @return --> devuelve una lista de String independientemente de cuales
	 *             sean los datos contenidos en el fichero.
	 */
	public static List<String> leeFichero(String fileName, String del) {

		List<String> listaleida= new LinkedList<String>();
		
		try (Scanner sc = new Scanner(new File(fileName)).useDelimiter("\\s*"+del+"\\s*");) {
			  
			  // La invocacion al metodo useDelimiter se hace concatenando el caracter separador
			  // con cualquier combinacion de blancos, tabuladores o saltos de linea delante o
			  // detras. Esa combinacion es indicada por la expresion regular "\\s*".
			
			   // .useDelimiter("\\s+"); si hubiesemos utilizado este delimitador simplemente,
			   // estariamos indicando cualquier combinacion de al menos un blanco, un tabulador
			   // o un salto de linea
			
			while (sc.hasNext()) {
				listaleida.add(sc.next());
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado "+fileName);
		}
		
		return listaleida;
	}



	/**
	 * M�todo principal
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("LISTA DE FRASES, SEPARADAS POR COMAS");
		List<String> listaFrases = leeFichero("./src/_09Scanner/datos1.txt",",");
		for (String cadena : listaFrases) {
			System.out.println(cadena);
		}
		
		System.out.println("LISTA DE NUMEROS CON ESPACIOS EN BLANCO");
		List<String> listaNumeros = leeFichero("./src/_09Scanner/numeros.txt"," ");
		for (String cadena : listaNumeros) {
			System.out.println(cadena);
		}
		
		System.out.println("\nLISTA DE NUMEROS CON COMAS");
		List<String> listaNumeros2 = leeFichero("./src/_09Scanner/numeros2.txt",",");
		for (String cadena : listaNumeros2) {
			System.out.println(cadena);
		}
		
		System.out.println("\nLISTA DE NUMEROS CON GUIONES");
		List<String> listaNumeros3 = leeFichero("./src/_09Scanner/numeros3.txt","-");
		for (String cadena : listaNumeros3) {
			System.out.println(cadena);
		}
	}
}
