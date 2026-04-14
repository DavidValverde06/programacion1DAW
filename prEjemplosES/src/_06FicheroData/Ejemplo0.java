package _06FicheroData;

import java.io.*;

public class Ejemplo0 {

	public static void main(String[] args) {
		
		// Escritura de tipos primitivos
		try (DataOutputStream dos = new DataOutputStream(
									    new FileOutputStream("./src/_06FicheroData/datos.dat"))) {
            dos.writeInt(123);
            dos.writeDouble(45.67);
            dos.writeBoolean(true);
        } 
		catch (IOException e) {
            e.printStackTrace();
        }

		// Lectura de tipos primitivos
		try (DataInputStream dis = new DataInputStream(
				                       new FileInputStream("./src/_06FicheroData/datos.dat"))) {
            int numero = dis.readInt();
            double decimal = dis.readDouble();
            boolean logico = dis.readBoolean();
            System.out.println("Número: " + numero + ", Decimal: " + decimal + ", Booleano: " + logico);
        } 
		catch (IOException e) {
            e.printStackTrace();
        }
	}
}
