package gestionEspectaculos;

public class Conciertos extends Espectaculo{

	/**
	 * Variables de instancia
	 */
	private boolean giraInternacional;

	/**
	 * Constructor
	 */
	public Conciertos(String titulo, Organizador organizador, Lugar lugar, int duracion, boolean giraInternacional) {
		super(titulo, organizador, lugar, duracion);
		this.giraInternacional = giraInternacional;
	}

	/**
	 * Getter's y setter's
	 */
	public boolean isGiraInternacional() {
		return giraInternacional;
	}

	public void setGiraInternacional(boolean giraInternacional) {
		this.giraInternacional = giraInternacional;
	}

	/**
	 * Método impuestoLocal()
	 */
	@Override
	public float impuestoLocal() {
		return super.impuestoLocal()*1.20f;
	}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return super.toString() +
				"\n\tConcierto de gira internacional: " + (this.giraInternacional?"SI":"NO");
	}

	/**
	 * Método abstracto calcularPrecioBaseEntrada()
	 */
	@Override
	public float calcularPrecioBaseEntrada() {
		float total=0;
		if (super.getLugar().getCosteAlquiler()+impuestoLocal()>10000) {
			total+=25;
		}
		else {
			total+=20;
		}

		if (this.giraInternacional) {
			total+=5;
		}
		return total;
	}
}
