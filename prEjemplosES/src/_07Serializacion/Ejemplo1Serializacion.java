
/**
 * En este ejemplo se graban y leen objetos de tipo Empleado en un fichero.
 */

package _07Serializacion;

import java.io.*;

public class Ejemplo1Serializacion {

	public static void main(String[] args) {
		// ----------------------------------------------------------		
		// Escritura en el fichero
		// ----------------------------------------------------------
		String [] nombreEmpleados = {"Marina", "José Luis", "Pedro", "María"};
		long [] salarios = {12345, 45453, 45323, 66788};
		
		ObjectOutputStream oos = null;
		try{
			oos  = new ObjectOutputStream(
						new FileOutputStream(
							new File("./src/_07Serializacion/empleadosOB.txt")));
							
			for (int i=0; i<nombreEmpleados.length; i++) {
				oos.writeObject(new Empleado(nombreEmpleados[i], salarios[i]));
			}
		}
	    catch (IOException e) {
		   e.printStackTrace();
	    }
		finally {
			try {
				if (oos!=null) oos.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero de escritura");
			}
		}

		
		// ----------------------------------------------------------		
		// Lectura del fichero
		// ----------------------------------------------------------
		try {  // try 1
			File f = null;
			ObjectInputStream ois = null;
			Empleado empl = null;
			
			try{  // try 2
				f = new File("./src/_07Serializacion/empleadosOB.txt");
				if (f.exists()) {
					ois  = new ObjectInputStream(new FileInputStream(f));
					while (true) { 
						empl = (Empleado)ois.readObject();
						System.out.println(empl.toString());
					}  // end while
				} // end if
			}  // end try 2
			catch (EOFException eof) {
				System.out.println(" ....................... ");
			}
			catch (FileNotFoundException fnf) {
				System.err.println("Fichero no encontrado "+ fnf);
			}
			catch (IOException e) {
				System.err.println("Se ha producido una IOException");
				e.printStackTrace();
			}
			catch (Throwable e) {
				System.err.println("Error de programa");
				e.printStackTrace();
			}
			finally {
				 if (ois!=null) {ois.close();}
			}
		} // end try 1
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
