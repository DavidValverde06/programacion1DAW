package alquilerVehiculos;

/**
 * En el caso de los turismos también queremos saber su clasificación (compacto, sedán o SUV), y si 
 * es eléctrico o no.
 */

public class Turismo extends Vehiculo{

	/**
	 * Variables de instancia
	 */
	private String clasficacion; // (compacto, sedán o SUV)
	private boolean electrico;

	/**
	 * Constructor
	 */
	public Turismo(String matricula, String modelo, int numPlazas, float precioPorDia, float consumoPorKm,
			String clasficacion, boolean electrico) {
		super(matricula, modelo, numPlazas, precioPorDia, consumoPorKm);
		this.clasficacion = clasficacion;
		this.electrico = electrico;
	}

	/**
	 * Getter's y setter's
	 */
	public String getClasficacion() {
		return clasficacion;
	}

	public boolean isElectrico() {
		return electrico;
	}

	public void setClasficacion(String clasficacion) {
		this.clasficacion = clasficacion;
	}

	public void setElectrico(boolean electrico) {
		this.electrico = electrico;
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
	@Override
	public float pagoImpuestos() {
		float impuestosAnuales=super.pagoImpuestos();
		if (this.electrico) {
			impuestosAnuales-=20;
		}
		else {
			impuestosAnuales+=50;
		}

		if (this.clasficacion.equalsIgnoreCase("SUV")) {
			impuestosAnuales+=25;
		}
		return impuestosAnuales;
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
		return super.toString() +
				"\n" + (this.electrico?"Eléctrico - ":"") + "Tipo: " + this.clasficacion;
	}
}
