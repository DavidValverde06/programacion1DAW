package _01flujosESEstandar;


/**
 * Esta clase ofrece una serie de métodos que nos permiten a través de flujos
 * de la entrada estándar leer diferentes tipos de datos, algo similar a lo que
 * hace la clase Scanner
 */

import java.io.*;
public class Leer {
	/**
	 * Método que permite leer una cadena
	 * @return
	 */
	public static String leeCadena() {
		String sdato = "";
		try  {
			// Definir un flujo de caracteres de entrada: flujoE
			BufferedReader flujoE = new BufferedReader(
										new InputStreamReader(System.in));

			// La entrada finaliza al pulsar la tecla Entrar
			sdato = flujoE.readLine();
		}
		catch(IOException e) {
			System.err.println("Error: " + e.getMessage());
		}

		return sdato; // devolver el dato tecleado
	}


  /**
   * Lectura de un dato de tipo short
   * @return
   */
  public static short leeShort() {
	  try {
		  return Short.parseShort(leeCadena());
	  }
	  catch(NumberFormatException e) {
		  System.out.println("Error: " + e.getMessage());
		  return Short.MIN_VALUE; // valor más pequeño
	  }
  }

  
/**
 * Lectura de un dato de tipo short
 * @return
 */
  public static byte leeByte() {
	  try {
		  return Byte.parseByte(leeCadena());
	  }
	  catch(NumberFormatException e) {
		  System.out.println("Error: " + e.getMessage());
		  return Byte.MIN_VALUE; // valor más pequeño
	  }
  }

 
  /**
   * Lectura de un dato de tipo int
   * @return
   */
  public static int leeInt() {
	  try {
		  return Integer.parseInt(leeCadena());
	  }
	  catch(NumberFormatException e) {
		  System.out.println("Error: " + e.getMessage());
		  return Integer.MIN_VALUE; // valor más pequeño
	  }
  }

  /**
   * Lectura de un dato de tipo long
   * @return
   */
  public static long leeLong() {
    try {
      return Long.parseLong(leeCadena());
    }
    catch(NumberFormatException e) {
      System.out.println("Error: " + e.getMessage());
	  return Long.MIN_VALUE; // valor más pequeño
    }
  }
  
  /**
   * Lectura de un dato de tipo float
   * @return
   */
  public static float leeFloat() {
	  try {
		  Float f = Float.valueOf(leeCadena());
		  return f.floatValue();
	  }
	  catch(NumberFormatException e) {
		  System.out.println("Error: " + e.getMessage());
		  return Float.NaN; // No es un número; valor float.
	  }
  }

  
  
  /**
   * Lectura de un dato de tipo double
   */
  public static double leeDouble()
  {
	  try  {
		  Double d = Double.valueOf(leeCadena());
		  return d.doubleValue();
	  }
	  catch(NumberFormatException e) {
		  System.out.println("Error: " + e.getMessage());
		  return Double.NaN; // No es un número; valor double.
	  }
  }

  
/** 
 * M�todo para poder leer un char
 * @return
 */
  public static char leeChar()
  {
	  char c=' ';
	  try	{
		  c = (char)System.in.read();  // Lee el siguiente byte del canal
		  System.in.skip(3);  // Descarta del canal 3 bytes
	  }
	  catch (Exception ex) {
		  System.out.println("Error de lectura");
	  }
	  return Character.toUpperCase(c);
  }
}









