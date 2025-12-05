package gestionEspectaculos;

public class Entrada {

	/**
	 * Variables de instancia
	 */
	private int numEntrada;
	private Espectaculo espectaculo;
	private String tipoEntrada; // (Normal, Reducida, VIP)

	/**
	 * Constructor
	 */
	public Entrada(int numEntrada, Espectaculo espectaculo, String tipoEntrada) {
		this.numEntrada = numEntrada;
		this.espectaculo = espectaculo;
		this.tipoEntrada = tipoEntrada;
	}

	/**
	 * Getter's y setter's
	 */
	public int getNumEntrada() {
		return numEntrada;
	}

	public Espectaculo getEspectaculo() {
		return espectaculo;
	}

	public String getTipoEntrada() {
		return tipoEntrada;
	}

	public void setNumEntrada(int numEntrada) {
		this.numEntrada = numEntrada;
	}

	public void setEspectaculo(Espectaculo espectaculo) {
		this.espectaculo = espectaculo;
	}

	public void setTipoEntrada(String tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}

	/**
	 * Método costoFinal sobrecargado
	 */
	public float costoFinal() {
		float totalFinal = this.espectaculo.calcularPrecioBaseEntrada();

		if (this.tipoEntrada.equalsIgnoreCase("Reducida")) {
			totalFinal=totalFinal*0.20f;
		}
		else if (this.tipoEntrada.equalsIgnoreCase("VIP") && this.espectaculo.getOrganizador().isDescuentoVip()) {
			totalFinal=totalFinal*0.90f;
		}

		return totalFinal;
	}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return "Entrada número: " + this.numEntrada +
				"\n\tEspectáculo: " + this.espectaculo.getTitulo() +
				"\n\tLugar: " + this.espectaculo.getLugar().getNombre() +
				"\n\tTipo espectáculo: " + this.espectaculo.getClass().getSimpleName() +
				"\n\tTipo entrada: " + this.tipoEntrada +
				"\n\tPrecio Base: " + this.espectaculo.calcularPrecioBaseEntrada() + "€" +
				"\n\tPrecio Final: " + costoFinal() + "€";
	}
}
