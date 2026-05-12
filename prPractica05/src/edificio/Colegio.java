package edificio;

public class Colegio extends Edificio {

	//	Colegio: contendrá la misma información que un edificio normal,
	//	además del número de clases y el número de oficinas.

	/**
	 * Variables de instancia
	 */
	private int numClases;
	private int numOficinas;

	/**
	 * Constructor
	 */
	public Colegio(Direccion dirEdificio, int numHabitaciones, int numPlantas, float areaEdificio, int numClases,
			int numOficinas) {
		super(dirEdificio, numHabitaciones, numPlantas, areaEdificio);

		this.numClases = numClases;
		this.numOficinas = numOficinas;
	}

	/**
	 * Getter's y setter's
	 */
	public int getNumClases() {
		return numClases;
	}

	public int getNumOficinas() {
		return numOficinas;
	}

	public void setNumClases(int numClases) {
		this.numClases = numClases;
	}

	public void setNumOficinas(int numOficinas) {
		this.numOficinas = numOficinas;
	}

	/**
	 * Método calcula IBI redefinido
	 * 
	 * En el caso de los colegios tienen un descuento de 500€.
	 */
	@Override
	public float calculaIBI() {
		return super.calculaIBI()-500;
	}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return super.toString() +
				"\n\tNúmero de clases: " + this.numClases +
				"\n\tNúmero de oficinas: " + this.numOficinas;
	}
}
