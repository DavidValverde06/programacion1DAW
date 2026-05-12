package vehiculoAbstracto;

import java.awt.Color;

/**
 * La clase VehículoAbstracto contendrá las propiedades necesarias para albergar el color del vehículo
 * (tipo Color), el número de ruedas que utiliza (byte), la cilindrada que tiene (short) y la potencia que
 * ofrece (short).
 * 
 * Se definirán al menos los siguientes 6 constructores: 
 * 3 que sólo reciban como parámetro una de las 3 primeras propiedades,
 * habrá uno por propiedad; otro al que le lleguen las propiedades color y número
 * de ruedas, otro al que le lleguen las propiedades color, número de ruedas y cilindrada; y por último uno
 * al que le lleguen las 4 propiedades.
 * 
 * Y los métodos siguientes:
 * ✓ Métodos get, set y toString.
 * ✓ impuesto: método abstracto que será definido en cada subclase derivada, devolverá un valor float.
 */

public abstract class VehiculoAbstracto {

	/**
	 * Variables de instancia
	 */
	private Color colorVehiculo;
	private byte numRuedas;
	private short cilindrada;
	private short potencia;

	/**
	 * Constructores
	 */
	public VehiculoAbstracto(Color colorVehiculo) {
		this.colorVehiculo = colorVehiculo;
	}

	public VehiculoAbstracto(byte numRuedas) {
		this.numRuedas = numRuedas;
	}

	public VehiculoAbstracto(short cilindrada) {
		this.cilindrada = cilindrada;

	}

	public VehiculoAbstracto(Color colorVehiculo, byte numRuedas) {
		this.colorVehiculo = colorVehiculo;
		this.numRuedas = numRuedas;
	}

	public VehiculoAbstracto(Color colorVehiculo, byte numRuedas, short cilindrada) {
		this.colorVehiculo = colorVehiculo;
		this.numRuedas = numRuedas;
		this.cilindrada = cilindrada;
	}

	public VehiculoAbstracto(Color colorVehiculo, byte numRuedas, short cilindrada, short potencia) {
		this.colorVehiculo = colorVehiculo;
		this.numRuedas = numRuedas;
		this.cilindrada = cilindrada;
		this.potencia = potencia;
	}

	/**
	 * Getter's y setter's
	 */
	public Color getColorVehiculo() {
		return colorVehiculo;
	}

	public byte getNumRuedas() {
		return numRuedas;
	}

	public short getCilindrada() {
		return cilindrada;
	}

	public short getPotencia() {
		return potencia;
	}

	public void setColorVehiculo(Color colorVehiculo) {
		this.colorVehiculo = colorVehiculo;
	}

	public void setNumRuedas(byte numRuedas) {
		this.numRuedas = numRuedas;
	}

	public void setCilindrada(short cilindrada) {
		this.cilindrada = cilindrada;
	}

	public void setPotencia(short potencia) {
		this.potencia = potencia;
	}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return "Color del vehículo: " + this.colorVehiculo +
				"\nNúmero de ruedas: " + this.numRuedas +
				"\nCilindrada: " + this.cilindrada +
				"\nPotencia: " + this.potencia;
	}

	/**
	 * Método abstracto (devolverá un valor float)
	 */
	public abstract float impuesto();

}
