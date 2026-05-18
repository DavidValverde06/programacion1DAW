package ejercicioo10;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * 10.- Tenemos un fichero con una serie de números los cuales queremos ordenar de manera ascendente. El
 * objeto es que los números queden ordenador en el mismo fichero. Para la resolución del problema crea
 * una clase orden con un método ordena que haga la ordenación de los datos del fichero. Los números
 * están cada uno en una línea del fichero y el fichero cuenta con al menos 5 números.
 */
public class OrdenaNumerosAscendente {

	public static void main(String[] args) {

		Path ficheroEntrada = Path.of("./src/ejercicioo10/numeros.txt");

		ordenaNumeros(ficheroEntrada);
	}

	public static void ordenaNumeros(Path ficheroNumeros) {

		TreeSet<Integer> listaNumeros = new TreeSet<>();

		try (BufferedReader flujoLectura = Files.newBufferedReader(ficheroNumeros);
				BufferedWriter flujoEscritura = Files.newBufferedWriter(Path.of("./src/ejercicioo10/numerosOrdenados.txt"))) {

			String linea;

			while ((linea = flujoLectura.readLine()) != null) {
				listaNumeros.add(Integer.valueOf(linea));
			}

			for (Integer numero : listaNumeros) {
				flujoEscritura.write(numero.toString());
				flujoEscritura.newLine();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
