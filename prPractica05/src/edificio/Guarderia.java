package edificio;

public class Guarderia extends Colegio{

	//	Guardería: contendrá la misma información que un colegio,
	//	pero también necesitaremos conocer la superficie dedicada al área de juegos.

	/**
	 * Variables de instancia
	 */
	private int areaZonaJuegos;

	/**
	 * Constructor
	 */
	public Guarderia(Direccion dirEdificio, int numHabitaciones, int numPlantas, float areaEdificio, int numClases,
			int numOficinas, int areaZonaJuegos) {
		super(dirEdificio, numHabitaciones, numPlantas, areaEdificio, numClases, numOficinas);

		this.areaZonaJuegos = areaZonaJuegos;
	}

	/**
	 * Getter's y setter's
	 */
	public int getAreaZonaJuegos() {
		return areaZonaJuegos;
	}

	public void setAreaZonaJuegos(int areaZonaJuegos) {
		this.areaZonaJuegos = areaZonaJuegos;
	}

	/**
	 * Método calcula IBI redefinido
	 * 
	 * En el caso de las guarderias, estas no pagan nada.
	 */
	@Override
	public float calculaIBI() {
		return 0;
	}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return super.toString() +
				"\n\tÁrea zona de juegos: " + this.areaZonaJuegos;
	}
}
