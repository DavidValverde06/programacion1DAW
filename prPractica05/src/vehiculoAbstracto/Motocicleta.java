package vehiculoAbstracto;

import java.awt.Color;

/**
 * La clase derivada Motocicleta contendrá una nueva propiedad que albergue el número de ocupantes
 * permitido que puede transportar cada motocicleta (byte), además sabemos que sólo tiene 2 ruedas.
 * 
 * Tendrá los siguientes constructores: 
 * - uno al que no le llegue ningún parámetro, y que llama al 
 * constructor de la clase VehiculoAbstracto indicando el número de ruedas; 
 * - otro al que le llegue sólo el número de plazas;
 * - otro al que le llegue sólo el color;
 * - otro al que le llegue el color y la cilindrada;
 * - y por ultimo uno al que le llegue el color, la cilindrada y la potencia.
 * 
 * Además, ofrecerá los siguientes métodos:
 * 	✓ Métodos get, set y toString.
 * 
 * 	✓ impuesto: suponemos que el impuesto que pagan las motocicletas se calcula aplicando la fórmula:
 * 	cilindrada/30 + potencia*30.
 */

public class Motocicleta extends VehiculoAbstracto {

	/**
	 * Variables de instancia
	 */
	private byte numOcupantes;

	/**
	 * CONSTRUCTORES
	 * Uno al que no le llegue ningún parámetro, y que llama al 
	 * constructor de la clase VehiculoAbstracto indicando el número de ruedas. 
	 */
	public Motocicleta() {
		super((byte)2);
	}

	/**
	 * Otro al que le llegue sólo el número de plazas.
	 */
	public Motocicleta(byte numOcupantes) {
		super((byte)2);
		this.numOcupantes = numOcupantes;
	}

	/**
	 * Otro al que le llegue sólo el color.
	 */
	public Motocicleta(Color colorVehiculo) {
		super(colorVehiculo, (byte)2);
	}

	/**
	 * Otro al que le llegue el color y la cilindrada.
	 */
	public Motocicleta(Color colorVehiculo, short cilindrada) {
		super(colorVehiculo, (byte)2, cilindrada);
	}

	/**
	 * Y por ultimo uno al que le llegue el color, la cilindrada y la potencia.
	 */
	public Motocicleta(Color colorVehiculo, short cilindrada, short potencia) {
		super(colorVehiculo, (byte)2, cilindrada, potencia);
	}

	/**
	 * Getter's y setter's
	 */
	public byte getNumOcupantes() {
		return numOcupantes;
	}

	public void setNumOcupantes(byte numOcupantes) {
		this.numOcupantes = numOcupantes;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return super.toString() +
				"\nNúmero de ocupantes: " + this.numOcupantes;
	}

	/**
	 * impuesto: suponemos que el impuesto que pagan las motocicletas se calcula aplicando la fórmula:
	 * cilindrada/30 + potencia*30.
	 */
	@Override
	public float impuesto() {
		return (getCilindrada()/30f + getPotencia()*30f);
	}

}
