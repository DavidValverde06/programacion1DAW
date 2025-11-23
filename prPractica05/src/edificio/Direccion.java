package edificio;

/*
 * 3.- Construir las siguientes clases:
 * 	▪ Dirección
 * 	▪ Edificio
 * 	▪ Casa
 * 	▪ Colegio
 * 	▪ Guardería
 * 
 * 	Todas las clases deben disponer, al menos, de un constructor,
 * 	los métodos set y get y el método toString.
 *  
 * 	En el caso de los edificios (edificio, colegio, casa, ...), el método toString, deberá mostrar
 * 	además de la información que tenga sobre cada edificio, lo que se paga de IBI en ese edificio, el cálculo
 * 	del IBI se explica a continuación.
 * 
 * 	Tendremos un método que nos calcule el IBI de cada tipo de edificio, el cual se calcula sumando el
 * 	área del edificio multiplicado por 1.2 y el número de plantas multiplicado por 100. En el caso de las
 * 	casas el IBI se ve incrementado en 10€ por cada baño, los colegios por su parte tienen un descuento de
 * 	500€, y por último las guarderías no pagan nada.
 */
public class Direccion {

	//	Dirección: sobre una dirección conocemos el nombre de la calle, el número y el código postal.

	/**
	 * Variables de instancia
	 */
	private String nombreCalle; // Nombre de la calle
	private int numero; // Numero del edificio
	private int codPostal; // Codigo postal

	/**
	 * Constructor
	 */
	public Direccion(String nombreCalle, int numero, int codPostal) {
		this.nombreCalle = nombreCalle;
		this.numero = numero;
		this.codPostal = codPostal;
	}

	/**
	 * Getter's y setter's
	 */
	public String getNombreCalle() {
		return nombreCalle;
	}

	public void setNombreCalle(String nombreCalle) {
		this.nombreCalle = nombreCalle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}

	/*
	 * toString
	 */
	@Override
	public String toString() {
		return this.nombreCalle + ", " + this.numero + " (" + this.codPostal + ")";
	}
}
