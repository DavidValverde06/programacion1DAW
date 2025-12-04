package jarra;

/**
 * 3.- Desarrollar la clase Jarra para simular algunas de las acciones que podemos realizar con una jarra.
 * 
 * Nuestras jarras van a poder contener cierto contenido de agua. Así, cada jarra tiene una determinada
 * capacidad (en litros) que será la misma (constante) durante la vida de la jarra, y su valor será
 * especificado en el momento de la construcción del objeto. En un momento determinado una jarra
 * dispondrá de una cantidad de agua que podrá variar en el tiempo. Las acciones que podremos realizar
 * sobre una jarra son:
 * 
 * • Llenar la jarra por completo desde un grifo, o en una determinada cantidad, o bien añadiendo el
 * 	 contenido de otro objeto Jarra.
 * • Vaciar la jarra completamente.
 * • Acceder a su representación textual (toString)
 */

public class Jarra {

	// SIN HACER
	
	/**
	 * Variables de instancia
	 */


	/**
	 * Desarrollaremos los siguientes constructores y métodos en nuestra clase, para poder llevar a cabo las
	 * operaciones que acabamos de describir:
	 */

	/**
	 *  • Constructor
	 *  
	 * Este método lo sobrecargaremos, de forma que vamos a poder crear objetos Jarra
	 * indicando su capacidad, o sin indicar nada, en este último caso la jarra tendrá una capacidad de 2
	 * litros.
	 * 
	 * Las jarras inicialmente estarán vacías. Si el valor recibido como parámetro es menor o igual a
	 * cero, entonces lanzará la excepción RuntimeException.
	 */


	/**
	 * • Métodos get.
	 * 
	 * • Método toString, devuelve un String con la representación textual del objeto jarra en el formato J(cap,cnt).
	 * 
	 * • Método equals, consideraremos que dos jarras son iguales si coincide su capacidad.
	 * 
	 * • Método llena, este método lo sobrecargaremos:
	 * o llena(): Llena el contenido del objeto jarra al máximo de su capacidad.
	 * o llena (int cantidad): añade al contenido del objeto jarra, la cantidad indicada, solo en el caso de
	 * que quepa todo, sino cabe la cantidad que queremos añadir, lanzaremos una RuntimeException.
	 * o llena (Jarra otraJarra): Llena el contenido de la jarra actual (receptora) con el contenido de la jarra
	 * que se recibe como parámetro (emisora), bien hasta que la jarra receptora quede llena o hasta
	 * que la jarra emisora se vacíe por completo. Si el objeto actual (this) es el mismo objeto que el
	 * objeto recibido como parámetro, entonces este método no realizará ninguna acción y lanzará la
	 * excepción RuntimeException.
	 * 
	 * • Método vacia. Vacía el contenido del objeto jarra completamente.
	 * 
	 * • Método estaLlena. Comprueba si una jarra está completamente llena.
	 * 
	 * • Método estaVacia. Comprueba si una jarra está completamente vacia.
	 */
}
