package edificio;

/*
 * 
 */
public class Direccion {

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
