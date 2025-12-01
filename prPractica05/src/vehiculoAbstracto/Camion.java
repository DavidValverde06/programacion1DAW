package vehiculoAbstracto;

import java.awt.Color;

/**
 * La clase derivada Camión establecerá una nueva propiedad que indique el número de ejes que posee el
 * camión (byte), junto a los siguientes constructores: 
 * 	uno al que le llegue sólo el número de ruedas;
 * 	otro al que le llegue el color y número de ruedas;
 * 	otro al que le llegue el color, número de ruedas y cilindrada;
 * 	otro al que le llegue color, número de ruedas, cilindrada y potencia;
 * 	y otro al que lleguen las cinco propiedades de un camión.
 * 
 * Además, ofrecerá los siguientes métodos:
 * ✓ Métodos get, set y toString.
 * 
 * ✓ impuesto: suponemos que el impuesto que pagan los camiones se calcula realizando el sumatorio
 * de los términos: cilindrada/30, potencia*20, número de ruedas*20 y número de ejes*50.
 */

public class Camion extends VehiculoAbstracto {

	/**
	 * Variables de instancia
	 */
	private byte numEjes;

	/**
	 * CONSTRUCTORES
	 * Uno al que le llegue sólo el número de ruedas.
	 * @param numRuedas
	 */
	public Camion(byte numRuedas) {
		super(numRuedas);
	}

	/**
	 * Otro al que le llegue el color y número de ruedas.
	 * @param colorVehiculo
	 * @param numRuedas
	 */
	public Camion(Color colorVehiculo, byte numRuedas) {
		super(colorVehiculo, numRuedas);
	}

	/**
	 * Otro al que le llegue el color, número de ruedas y cilindrada.
	 */
	public Camion(Color colorVehiculo,byte numRuedas, short cilindrada) {
		super (colorVehiculo,numRuedas,cilindrada);
	}

	/**
	 * Otro al que le llegue color, número de ruedas, cilindrada y potencia.
	 */
	public Camion(Color colorVehiculo,byte numRuedas, short cilindrada, short potencia) {
		super (colorVehiculo,numRuedas,cilindrada,potencia);
	}

	/**
	 * Y otro al que lleguen las cinco propiedades de un camión.
	 */
	public Camion(Color colorVehiculo,byte numRuedas, short cilindrada, short potencia, byte numEjes) {
		super (colorVehiculo,numRuedas,cilindrada,potencia);
		this.numEjes = numEjes;
	}

	/**
	 * Getter's y setter's
	 */
	public byte getNumEjes() {
		return numEjes;
	}

	public void setNumEjes(byte numEjes) {
		this.numEjes = numEjes;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return super.toString() +
				"\nNúmero de ejes: " + this.numEjes;
	}

	/**
	 * impuesto: suponemos que el impuesto que pagan los camiones se calcula realizando el sumatorio
	 * de los términos: cilindrada/30, potencia*20, número de ruedas*20 y número de ejes*50.
	 */
	@Override
	public float impuesto() {
		return (getCilindrada()/30f + getPotencia()*20f + getNumRuedas()*20f + this.numEjes*50);
	}

}
