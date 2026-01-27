package ejercicio6;

/**
 * Crear la clase Cadena de forma que nos permita almacenar una cadena de caracteres, con al menos la
 * siguiente interface:
 * 
 * 	• inviertecadena(). Invierte la cadena miembro.
 * 	• encriptaCadena(). Encripta la cadena miembro.
 * 	• desencriptaCadena(). Desencripta la cadena miembro.
 * 	• visualizaCadena(). Visualiza la cadena miembro
 */
public class Cadena {

	/**
	 * Variable de instancia
	 */
	private String cadena;

	/**
	 * Constructor
	 */
	public Cadena(String cadena) {
		this.cadena = cadena;
	}

	/**
	 * Getter's y setter's 
	 */
	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	/**
	 * Método invierteCadena()
	 */
	public void invierteCadena() {
		String cadena;
		StringBuffer cadenaInversa = new StringBuffer(this.cadena);
		cadenaInversa=cadenaInversa.reverse();
		cadena=cadenaInversa.toString();
		this.cadena = cadena;
	}

	/**
	 * encriptaCadena().
	 * 
	 * Encripta la cadena miembro.
	 */
	public void encriptaCadena() {
		String cadenaEncriptada="";
		char[] arrayCaracteres = new char[this.cadena.length()];

		arrayCaracteres=this.cadena.toCharArray();

		for (int cont=0;cont<arrayCaracteres.length;cont++) {
			cadenaEncriptada+=Caracter.ordinal(arrayCaracteres[cont]);
		}

		this.cadena = cadenaEncriptada;
	}

	/**
	 * desencriptaCadena().
	 * 
	 * Desencripta la cadena miembro.
	 */
	public void desencriptaCadena() {
		
	}

	/**
	 * visualizaCadena().
	 * 
	 * Visualiza la cadena miembro
	 */
	public String visualizaCadena() {
		return cadena;
	}
}
