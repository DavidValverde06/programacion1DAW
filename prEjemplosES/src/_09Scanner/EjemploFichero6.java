package _09Scanner;
import java.io.*;
import java.util.*;

/**
 * En este ejemplo vamos a leer un fichero de texto con los valores de los atributos
 * de una clase, de forma que la salida sea una coleccion de objetos creados a partir de esos
 * valores
 */


public class EjemploFichero6 {
	
	/**
	 * Este metodo List<Persona> con los objetos de tipo Persona, que estaran organizados 
	 * por filas en el fichero de texto, de forma que cada fila contiene los valores de los 
	 * atributos de un objeto tipo Persona separados por comas.
	 * 
	 * El fichero se ira leyendo línea a línea. Cada una de estas líneas contiene los valores
	 * de los atributos (nombre, DNI y edad) necesarios para construir un objeto Persona. Para
	 * separar estos valores se va a usar un metodo auxiliar que hemos denominado
     * separaElementos para a partir de otro objeto de tipo Scanner segmentar la línea en una 
     * List de String con los atributos. 
	 * 
	 * @param nomFich --> Nombre del fichero que contiene las personas
	 *            
	 * @return una coleccion tipo List, con los objetos tipo persona que haya extraido del fichero
	 */
	public static List<Persona> leePersonas(String nomFich) {
		
		List <Persona> lp = new LinkedList<Persona>();
		
		try (Scanner sc=new Scanner(new File("./src/_09Scanner/"+nomFich))) {
			
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				List<String> lisat= separaElementos(linea);
				Persona p=new Persona(
						lisat.get(0),lisat.get(1), Integer.valueOf(lisat.get(2)));
				lp.add(p);
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado ");
		}

		return lp;
	}

	/**
	 * El metodo separaElementos no depende de Persona o del tipo que estemos
     * construyendo. Es un metodo de proposito general que recibe un String s y devuelve
     * un List de String con los "trozos" de s que se encuentran separados por comas.
     *
     * Como se puede observar el tipo Scanner tambien es capaz de "leer" de una cadena
     * de caracteres, simplemente poniendola en el lugar del objeto de tipo File en la
     * invocacion al constructor.
     * 
	 * @param s --> Cadena unos datos separados por comas
	 * @return --> Una coleccion tipo String donde cada elemento sera uno de esos datos
	 */
	public static List<String> separaElementos(String s){

		List<String> lista = new LinkedList<String>();

		try (Scanner sc = new Scanner(s).useDelimiter(",")) {
			while (sc.hasNext()){
				lista.add(sc.next());
			}
		}

		return lista;
	}

	
	/**
	 * Metodo principal
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Persona> compañeros = leePersonas("personas.txt");
		
		for (Persona persona : compañeros) {
			System.out.println(persona);
		}
	}

}
