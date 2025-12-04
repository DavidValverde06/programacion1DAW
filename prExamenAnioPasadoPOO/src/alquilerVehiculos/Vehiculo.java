package alquilerVehiculos;

import java.util.Objects;

/**
 * C) Clase Vehiculo, del que nos interesa conocer su matrícula, modelo, número de plazas, el precio por día
 * de alquiler, y el consumo por kilómetro.	
 * En el caso de los turismos también queremos saber su clasificación (compacto, sedán o SUV), y si 
 * es eléctrico o no. Y en el caso de las furgonetas, queremos conocer también el volumen de carga 
 * en metros cúbicos.
 * 
 * Los métodos que se deben proporcionar serán:
 * • Constructor y métodos get y set.
 * 
 * • Método que calcule lo que el vehículo paga de impuestos anualmente, lo cual estará en función de:
 * 		o Un coste fijo de 10€ por cada plaza del vehículo.
 * 
 * 		o En el caso de turismos, si el coche es eléctrico se le hace un descuento de 20€, y si no lo es hay que
 * 		sumarle otros 50€. Además, si es un turismo tipo SUV su coste se incrementa en otros 25€
 * 
 * 		o En el caso de las furgonetas, si el volumen de carga supera los 5 metros cúbicos, el importe a pagar
 * 		se incrementa en 100€, y sino los supera en 50€.
 * 
 * 		o Ejemplos:
 * 			▪ Turismo de 5 plazas tipo SUV eléctrico pagaría:
 * 				5 x 10 (coste fijo) – 20 (dto. eléctrico) + 25 (tipo SUV) = 55€
 * 			▪ Turismo de 7 plazas tipo compacto:
 * 				7 x 10 (coste fijo) + 50 (no es eléctrico) = 120€
 * 			▪ Furgoneta de 3 plazas con 6 metros cúbicos de carga:
 * 				3 x 10 (coste fijo) + 100 (carga superior de 5 metros cúbicos) = 130€
 * 
 * • Método que calcule, a partir del precio del combustible proporcionado al método, el consumo a los
 * 100 kilómetros de este vehículo, debéis utilizar el método de la clase UtilidadesVehiculos para el
 * cálculo.
 * 
 * • Método toString, con un formato similar a los siguientes ejemplos:
 * 
 * • Método para comparar vehículos, consideraremos que dos vehículos son iguales, si coincide su
 * matrícula.
 */

public class Vehiculo {

	/**
	 * Variables de instancia
	 */
	private String matricula;
	private String modelo;
	private int numPlazas;
	private float precioPorDia;
	private float consumoPorKm;

	/**
	 * Constructor
	 */
	public Vehiculo(String matricula, String modelo, int numPlazas, float precioPorDia, float consumoPorKm) {
		this.matricula = matricula;
		this.modelo = modelo;
		this.numPlazas = numPlazas;
		this.precioPorDia = precioPorDia;
		this.consumoPorKm = consumoPorKm;
	}

	/**
	 * Getter's y setter's
	 */
	public String getMatricula() {
		return matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public float getPrecioPorDia() {
		return precioPorDia;
	}

	public float getConsumoPorKm() {
		return consumoPorKm;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}

	public void setPrecioPorDia(float precioPorDia) {
		this.precioPorDia = precioPorDia;
	}

	public void setConsumoPorKm(float consumoPorKm) {
		this.consumoPorKm = consumoPorKm;
	}

	/**
	 *	Método que calcule lo que el vehículo paga de impuestos anualmente, lo cual estará en función de:
	 * 		o Un coste fijo de 10€ por cada plaza del vehículo.
	 * 
	 * 		o En el caso de turismos, si el coche es eléctrico se le hace un descuento de 20€, y si no lo es hay que
	 * 		sumarle otros 50€. Además, si es un turismo tipo SUV su coste se incrementa en otros 25€
	 * 
	 * 		o En el caso de las furgonetas, si el volumen de carga supera los 5 metros cúbicos, el importe a pagar
	 * 		se incrementa en 100€, y sino los supera en 50€.
	 * 
	 * 		o Ejemplos:
	 * 			▪ Turismo de 5 plazas tipo SUV eléctrico pagaría:
	 * 				5 x 10 (coste fijo) – 20 (dto. eléctrico) + 25 (tipo SUV) = 55€
	 * 			▪ Turismo de 7 plazas tipo compacto:
	 * 				7 x 10 (coste fijo) + 50 (no es eléctrico) = 120€
	 * 			▪ Furgoneta de 3 plazas con 6 metros cúbicos de carga:
	 * 				3 x 10 (coste fijo) + 100 (carga superior de 5 metros cúbicos) = 130€
	 */
	public float pagoImpuestos() {
		return this.numPlazas*10;
	}

	/**
	 * Método que calcule, a partir del precio del combustible proporcionado al método, el consumo a los
	 * 100 kilómetros de este vehículo, debéis utilizar el método de la clase UtilidadesVehiculos para el
	 * cálculo.
	 */
	public float calculoConsumo100Km(float precioCombustible) {
		// Calculamos el coste de recorrer 100 km
		return UtilidadesVehiculos.costeCombustible(100, this.consumoPorKm, precioCombustible);
	}

	/**
	 * Método toString, con un formato similar a los siguientes ejemplos:
	 * 
	 * 		TURISMO: ABC1234 - Hyundai Tucson
	 * 		Impuestos anuales: 55.0€
	 * 		Precio alquiler diario: 50.0€
	 * 		Número de plazas: 5
	 * 		Eléctrico - Tipo: SUV
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName().toUpperCase() + ": " + this.matricula + " - " + this.modelo +
				"\nImpuestos anuales: " + pagoImpuestos() +
				"\nPrecio alquiler diario: " + this.precioPorDia + "€" +
				"\nNúmero de plazas: " + this.numPlazas;
	}

	/**
	 * Método para comparar vehículos, consideraremos que dos vehículos son iguales, si coincide su
	 * matrícula.
	 */
	@Override
	public boolean equals(Object obj) {
		Vehiculo otroVehiculo = (Vehiculo) obj;
		return Objects.equals(matricula, otroVehiculo.matricula);
	}

}
