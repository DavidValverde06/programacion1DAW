package _11Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Ejemplo0Leer {

	public static void main(String[] args) {
		try {
            List<String> lineas = Files.readAllLines(Paths.get("./src/_11Files/quijote.txt"));
            lineas.forEach(System.out::println);
        } 
		catch (IOException e) {
            e.printStackTrace();
        }


	}

}
