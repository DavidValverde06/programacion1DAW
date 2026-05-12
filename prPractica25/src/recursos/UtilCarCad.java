package recursos;

/**
 * Clase con m�todos varios para trabajar con caracteres, valores ascii, y 
 * encriptado/desencriptado tanto de cadenas como de caracteres
 * 
 * @author Profesora
 *
 */
public class UtilCarCad {

	/**
	 * Metodo de clase que devuelve el valor ordinal de un caracter
	 * Por ejemplo ordinal(A) --> 65
	 * @param c
	 * @return
	 */
	public static int ordinal(char c) {
		return (int)c;
	}
	
	/**
	 * Metodo de clase que devuelve el caracter correspondiente 
	 * al valor numerico que llega como parametro 
	 * Por ejemplo ascii('A') --> 65
	 * @param c
	 * @return
	 */
	public static char ascii(int c) {
		return (char)c;
	}
	
	/**
     *  Encripta un caracter, sumando 3 al caracter recibido
     */
	public static char encriptaCaracter(int caracter) {
		return UtilCarCad.ascii(caracter+3);
	}

	
	/**
	 *  Desencripta un caracter, restando 3 al carcter recibido
	 */
	public static char desencriptaCaracter(int caracter) {
		return UtilCarCad.ascii(caracter-3);
	}

	/**
     * Devuelve una nueva cadena cuyo contenido es la cadena original pero encriptada
     * La forma en la que estamos encriptando es sumando 3 a cada caracter de la cadena
     * 
     * @param cad --> Cadena original
	 * @return -----> Cadena encriptada
     */
	public static String encriptaCadena(String cad) {
		StringBuffer cadena = new StringBuffer(cad);
		for (int i=0; i<cadena.length(); i++)
			cadena.setCharAt(i,encriptaCaracter(ordinal(cadena.charAt(i))));
		return cadena.toString();
	}

	
	/**
     * Devuelve una nueva cadena cuyo contenido es la cadena original pero desencriptada
     * La forma en la que estamos desencriptando es restando 3 a cada caracter de la cadena
     * 
     * @param cad --> Cadena original encriptada
	 * @return -----> Cadena sin encriptar
     */
	public static String desencriptaCadena(String cad) {
		StringBuffer cadena = new StringBuffer(cad);
		for (int i=0; i<cadena.length(); i++)
		   	cadena.setCharAt(i,desencriptaCaracter(ordinal(cadena.charAt(i))));
		return cadena.toString();
	}
}
