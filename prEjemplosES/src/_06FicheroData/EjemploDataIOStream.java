package _06FicheroData;

/**
 * Este ejemplo muestra el uso de las clases DataOutputStream
 * DataInputStream, para almacenar datos que no son de tipo
 * texto.
 */

import java.io.*;
public class EjemploDataIOStream {

	public static void main(String[] args) {
		
		// ----------------------------------------------------------		
		// Escritura en el fichero
		// ----------------------------------------------------------
		String [] nombreEmpleados = {"Marina", "José Luis", "Pedro", "María"};
		long [] salarios = {12345, 45453, 45323, 66788};
		
		DataOutputStream flujoEscr = null;
		try{
			
			flujoEscr  = new DataOutputStream(
							new FileOutputStream("./src/_06FicheroData/empleados.txt"));
			
			for (int i=0; i<nombreEmpleados.length; i++) {
				flujoEscr.writeUTF(nombreEmpleados[i]);  // Escribir el nombre
				flujoEscr.writeLong(salarios[i]);	// Escribir el salario
			}
		}
	    catch (IOException e) {
		   System.out.println("Error al escribir en fichero");
	    }
		finally {
			try {
				if (flujoEscr!=null) flujoEscr.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el archivo de escritura");
			}
		}
	
		
		// ----------------------------------------------------------		
		// Lectura del fichero
		// ----------------------------------------------------------
		try {  // try 1
			File archivo = null;
			DataInputStream flujoLectura = null;

			try{  // try 2
				archivo = new File("./src/_06FicheroData/empleados.txt");
				if (archivo.exists()) {
					
					flujoLectura  = new DataInputStream(
										new FileInputStream(archivo));
					
					String nom;
					long sal;
					while (true) { 
						nom = flujoLectura.readUTF();
						System.out.print(nom+" --> ");
						sal = flujoLectura.readLong();
						System.out.println(sal);
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
				 if (flujoLectura!=null) {
				    flujoLectura.close();
				 }
			}
		} // end try 1
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
