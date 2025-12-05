package gestionEspectaculos;

/**
 * Métodos de clase
 * @author David Valverde Barea
 */
public class Utilidades {

	/**
	 * formateaDuracion()
	 * 
	 * Método que recibe un número de minutos, y devuelve una cadena en la que se detalla a cuántas horas y minutos equivale
	 * 
	 * Ejemplo: 
	 * 		formateaDuracion(150) --> Devolverá: 2 horas y 30 minutos
	 * 		formateaDuracion(60) --> Devolverá: 1 horas
	 * 		formateaDuracion(50) --> Devolverá: 50 minutos
	 */
	public static String formateaDuracion(int minutosTotales) {
		int minutos=minutosTotales;
		int horas;

		horas=minutos/60;
		minutos=minutos%60;

		if (horas==0) {
			return minutos + " minutos";
		}
		if (minutos==0) {
			return horas + " horas";
		}
		return horas + " horas y " + minutos + " minutos";
	}

	/**
	 * calcularDescuento()
	 * 
	 * Calcula precio final tras aplicar un descuento
	 * 
	 * Ejemplo: calcularDescuento(1000, 15) --> devolverá 850
	 */
	public static float calcularDescuento(double precioBase, double porcentajeDescuento) {
		return (float) (precioBase=precioBase*((100-porcentajeDescuento)/100));
	}

	/**
	 * convertirMoneda()
	 * 
	 * Convierte una cantidad de euros a otra divisa usando una tasa de conversion
	 * 
	 * Ejemplo: convertirMoneda(200,1.09) --> devolverá 218.0
	 */
	public static float convertirMoneda(double cantidadEuros, double tasaConversion) {
		return (float) (cantidadEuros*tasaConversion);
	}
}
