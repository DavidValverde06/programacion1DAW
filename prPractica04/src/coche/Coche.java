package coche;

import java.util.Objects;

/**
 * 3. Definir la clase Coche que guardará la siguiente información sobre los coches de una casa comercial:
 * 	Modelo: String (privada)
 * 	Fabricante: String (privada)
 * 	Precio sin iva: float (privada)
 * 	Porcentaje de iva: byte (publica)
 * 
 * Definir un interfaz a la clase Coche con los siguientes métodos:
 * 	✓ Constructor. Sobrecargaremos este método, de forma que tengamos tres constructores, uno al que no
 * 	le llegará ningún parámetro (constructor por defecto), otro al que le llegarán valores para las cuatro
 * 	variables de instancia, y por último uno al que le llegue el modelo, fabricante y precio.
 * 
 * 	✓ void consulta().Método que muestra el modelo de coche y su precio con iva.
 * 
 * 	✓ float precioReal(). Método que calcula el precio real del coche con iva incluido.
 * 
 * 	✓ actualizarPrecio(byte porcentaje). Este método permitirá subir o bajar el precio sin iva del
 * 	coche tanto como indique el porcentaje.
 * 
 * 	✓ Métodos get, set, equals y toString (deberá devolver información sobre el coche, incluyendo
 * 	su precioReal).
 * 
 * Todos los métodos serán públicos, excepto el último (precioReal) que será un método privado. Una vez
 * definido el interfaz, probarlo haciendo una clase de prueba, TestCoche.
 * 
 * 
 * Modifica la clase TestCoche y llama al método precioReal para alguno de los objetos, ¿qué ocurre?.
 * ¿Puedes cambiar el valor de las variables miembro modelo y precio desde la clase TestCoche? ¿Por qué
 * puedes cambiar el valor de la variable porcentaje de iva desde TestCoche?
 */

public class Coche {

	/*
	 * Variables de instancia
	 */
	private String modelo;
	private String fabricante;
	private float precioSinIva;
	public byte porcentajeDeIva;

	/*
	 * Constructor sobrecargado
	 */
	public Coche() {

	}

	public Coche(String modelo, String fabricante, float precioSinIva, byte porcentajeDeIva) {
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.precioSinIva = precioSinIva;
		this.porcentajeDeIva = porcentajeDeIva;
	}

	public Coche(String modelo, String fabricante, float precio) {
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.precioSinIva = precio;
	}

	/*
	 * void consulta().Método que muestra el modelo de coche y su precio con iva.
	 */
	public void consulta() {
		System.out.print("\tModelo: " + this.modelo +
				"\n\tPrecio con IVA: " + this.precioReal() + "€");
	}

	/*
	 * float precioReal(). Método que calcula el precio real del coche con iva incluido.
	 */
	private float precioReal() {
		float precioReal = this.precioSinIva;
		precioReal+=this.precioSinIva*porcentajeDeIva/100; 
		return precioReal;
	}

	/*
	 * actualizarPrecio(byte porcentaje). Este método permitirá subir o bajar el precio sin iva del 
	 * coche tanto como indique el porcentaje.
	 */
	public float actualizarPrecioSubir(byte porcentaje) {
		float precioActualizado = this.precioSinIva;
		precioActualizado+=this.precioSinIva*porcentaje/100;
		return precioActualizado;
	}
	public float actualizarPrecioBajar(byte porcentaje) {
		float precioActualizado = this.precioSinIva;
		precioActualizado-=this.precioSinIva*porcentaje/100;
		return precioActualizado;
	}

	/*
	 * Getter's y setter's
	 */
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public float getPrecioSinIva() {
		return precioSinIva;
	}

	public void setPrecioSinIva(float precioSinIva) {
		this.precioSinIva = precioSinIva;
	}

	public byte getPorcentajeDeIva() {
		return porcentajeDeIva;
	}

	public void setPorcentajeDeIva(byte porcentajeDeIva) {
		this.porcentajeDeIva = porcentajeDeIva;
	}

	/*
	 * Método toString 
	 */
	@Override
	public String toString() {
		return "\tModelo del coche: " + this.modelo +
				"\n\tFabricante: " + this.fabricante +
				"\n\tPrecio sin IVA: " + this.precioSinIva + "€" +
				"\n\tPorcentaje de IVA: " + this.porcentajeDeIva +
				"\n\n\tPrecio real: " + this.precioReal() + "€";
	}

	/*
	 * Método equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		return Objects.equals(fabricante, other.fabricante) && Objects.equals(modelo, other.modelo)
				&& porcentajeDeIva == other.porcentajeDeIva
				&& Float.floatToIntBits(precioSinIva) == Float.floatToIntBits(other.precioSinIva);
	}
}
