
package _11Files;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * En este ejemplo veremos como crear directorios
 *
 */

public class Ejemplo4Directorios {

	public static void main(String[] args) throws IOException {
		
		Files.createDirectory(Paths.get("./src", "subdir2"));
		
		DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("./src"));
		
		for(Path p : directoryStream)
			System.out.println(p.getFileName());
		
		directoryStream.close();
	}

}
