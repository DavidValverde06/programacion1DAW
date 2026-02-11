package ejemplo3;

/**
 *  Clase para probar la clase ExPropiaClase
 */

public class Test {

	public static void main (String[] args) {


		System.out.println("Inicio de programa");

		ExPropiaClase objeto = new ExPropiaClase();
		// 		objeto.metodo();  // Este llamada dará error ya que no estamos gestionando el control
		// de la excepción que el método lanza

		try {
			objeto.metodo();  // Método que lanza excepciones, me obliga a controlarlas
			System.out.println("Tras llamada a método");  // Esta sentencia no se ejecutará 
			// si salta la excepción
		}
		catch(ExPropia e) {
			System.out.println(e);
		}

		System.out.println("Fin de programa");
	}
}
