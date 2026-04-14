package _11Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Ejemplo5Escribir {

	public static void main(String[] args) {
		try {
            Files.write(Paths.get("./src/_11Files/archivo.txt"), 
            		    Arrays.asList("Primera línea", "Segunda línea","Tercera línea"));
        } 
		catch (IOException e) {
            e.printStackTrace();
        }


	}

}
