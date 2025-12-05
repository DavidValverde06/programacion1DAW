package gestionEspectaculos;

public class ObrasDeTeatro extends Espectaculo {

	/**
	 * Variables de instancia
	 */
	private String genero; // (Comedia, Drama, Musical)

	/**
	 * Constructor
	 */
	public ObrasDeTeatro(String titulo, Organizador organizador, Lugar lugar, int duracion, String genero) {
		super(titulo, organizador, lugar, duracion);
		this.genero = genero;
	}

	/**
	 * Getter's y setter's
	 */
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Método impuestoLocal()
	 */
	@Override
	public float impuestoLocal() {
		if (this.genero.equalsIgnoreCase("Musical")) {
			return super.impuestoLocal()*1.10f;
		}
		return super.impuestoLocal();
	}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return super.toString() +
				"\n\tGénero: " + this.genero;
	}

	/**
	 * Método abstracto calcularPrecioBaseEntrada()
	 */
	@Override
	public float calcularPrecioBaseEntrada() {
		float total=18;

		if (this.genero.equalsIgnoreCase("Musical")) {
			total+=12;
		}
		else if (this.genero.equalsIgnoreCase("Drama")) {
			total+=3;
		}
		else if (this.genero.equalsIgnoreCase("Comedia")) {
			total+=5;
		}
		else {
			total+=10;
		}

		//		switch (this.genero) {
		//		case "Musical" -> total+=12;
		//		case "Drama" -> total+=3;
		//		case "Comedia" -> total+=5;
		//		default -> total+=10;
		//		}

		return total;
	}
}
