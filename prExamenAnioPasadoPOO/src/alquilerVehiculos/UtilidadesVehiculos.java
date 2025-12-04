package alquilerVehiculos;

/**
 * Una empresa de alquiler de vehículos necesita un sistema para gestionar su flota de vehículos (turismos y
 * furgonetas) y los clientes que los alquilan. Para ello vamos a ir desarrollando las siguientes clases:
 * 
 * A) Clase UtilidadesVehiculos con los siguientes métodos de clase que nos servirán posteriormente.
 * 
 * • Método que convierta kilómetros a millas (1 km = 0.621371 millas o 1 milla = 1,60934 km), es decir,
 * recibe una cantidad en kilómetros, y devuelve el equivalente en millas. Por ejemplo:
 * 2 kilómetros = 1.2427454732996135 millas
 * 
 * • Método que convierta millas a kilómetros. Por ejemplo: 2 millas = 3.21868 kilómetros
 * 
 * • Método que calcule el coste del combustible consumido, dados el número de kilómetros recorridos,
 * el consumo del vehículo en litros por kilómetro y el precio del combustible por litro.
 */

public class UtilidadesVehiculos {

	/**
	 * Método que convierta kilómetros a millas (1 km = 0.621371 millas o 1 milla = 1,60934 km), es decir,
	 * recibe una cantidad en kilómetros, y devuelve el equivalente en millas. Por ejemplo:
	 * 2 kilómetros = 1.2427454732996135 millas
	 */
	public static float conversorMillas(float kilometros) {
		return kilometros*0.621371f;
	}

	/**
	 * Método que convierta millas a kilómetros. Por ejemplo: 2 millas = 3.21868 kilómetros
	 */
	public static float conversorKilometros(float millas) {
		return millas*1.60934f;
	}

	/**
	 * Método que calcule el coste del combustible consumido, dados el número de kilómetros recorridos,
	 * el consumo del vehículo en litros por kilómetro y el precio del combustible por litro.
	 */
	public static float costeCombustible(float numKilometros, float litrosConsumidos, float precioCombustible) {
		return numKilometros*litrosConsumidos*precioCombustible;
	}
}
