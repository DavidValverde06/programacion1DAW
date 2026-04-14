package _08AccesoAleatorio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * ACCESO ALEATORIO O DIRECTO
 * 
 * Veamos a continuacion un ejemplo de este tipo de acceso con un fichero de texto previamente
 * creado. El ejemplo pide por teclado una palabra, la busca el fichero de texto texto.txt y 
 * la modifica escribiendola en mayusculas cada vez que aparece en el fichero. Para hacer el 
 * cambio de la palabra por su equivalente en mayusculas, el programa lee el fichero por lineas. 
 * 
 * Para cada linea leida se comprueba si contiene la palabra buscada y si es asi se modifica y 
 * se sobrescribe la linea completa modificada.
 * 
 *
 */
public class AccesoAleatorio {

    public static void main(String[] args) {
 
     	Scanner sc = new Scanner(System.in);

     	RandomAccessFile fichero = null;
        String palabra, cadena;
        StringBuilder auxBuilder;
        long pos = 0;
        int indice;
 
        try {
            //se abre el fichero para lectura/escritura
            fichero = new RandomAccessFile("./src/_08AccesoAleatorio/texto.txt", "rw");

            //Se pide la palabra a buscar
            System.out.print("Introduce palabra: ");
            palabra = sc.nextLine();
           
            //lectura del fichero
            cadena = fichero.readLine(); //leemos la primera linea
            while(cadena!=null){         //mientras no lleguemos al final del fichero
                indice = cadena.indexOf(palabra); //buscamos la palabra en la linea leida
                while(indice!=-1){ //mientras la linea contenga esa palabra (por si esta repetida)
                   
                    //paso la linea a un StringBuilder para modificarlo
                    auxBuilder = new StringBuilder(cadena); 
                    auxBuilder.replace(indice, indice+palabra.length(), palabra.toUpperCase());
                    cadena = auxBuilder.toString();
                    
                    // Nos posicionamos al principio de la linea actual y se sobrescribe la linea completa
                    // La posicion donde empieza la linea actual la estoy guardando en la variable pos
                    fichero.seek(pos);
                    fichero.writeBytes(cadena);
                   
                    //compruebo si se repite la misma palabra en la linea
                    indice = cadena.indexOf(palabra);
                }
                pos = fichero.getFilePointer(); //posicion de la linea actual que voy a leer
                cadena = fichero.readLine();    //lectura de la linea
            }
            System.out.println("Fichero actualizado");
        } 
        catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } 
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


