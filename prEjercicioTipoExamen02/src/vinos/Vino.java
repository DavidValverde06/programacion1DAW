package vinos;

/**
 * C) Clase Vino, sobre el cual queremos conocer la siguiente información:
 * 	- Nombre
 * 	- Cosecha de la que procede
 * 	- Enólogo responsable de su elaboración
 * 	- Maduración (en meses)
 * 	- El tipo de vino (blanco, rosado o tinto)
 * 	- Graduación alcohólica que tiene
 */

public class Vino {

	/**
	 * Variables de instancia
	 */
	private String nombreVino;
	private Cosecha cosecha;
	private Enologo enologo;
	private int maduracionMeses;
	private String tipoVino;
	private int graduacionAlcholica;

	/**
	 * También sabemos que el IVA que se aplica a las bebidas alcohólicas es del 21%, y que en función de su
	 * graduación se le aplica otro impuesto que actualmente es de 38.48€ por hectolitro, para las bebidas de
	 * menos de 15% de graduación, y de 64.13€ por hectolitro para las de más del 15%.
	 */

	/**
	 * Variables de clase
	 */
	static final int IVA=21;
	static float impuesto;

	/**
	 * Constructor
	 */
	public Vino(String nombreVino, Cosecha cosecha, Enologo enologo, int maduracionMeses, String tipoVino,
			int graduacionAlcholica) {
		this.nombreVino = nombreVino;
		this.cosecha = cosecha;
		this.enologo = enologo;
		this.maduracionMeses = maduracionMeses;
		this.tipoVino = tipoVino;
		this.graduacionAlcholica = graduacionAlcholica;
	}

	/**
	 * Getter's y setter's
	 */
	public String getNombreVino() {
		return nombreVino;
	}

	public void setNombreVino(String nombreVino) {
		this.nombreVino = nombreVino;
	}

	public Cosecha getCosecha() {
		return cosecha;
	}

	public void setCosecha(Cosecha cosecha) {
		this.cosecha = cosecha;
	}

	public Enologo getEnologo() {
		return enologo;
	}

	public void setEnologo(Enologo enologo) {
		this.enologo = enologo;
	}

	public int getMaduracionMeses() {
		return maduracionMeses;
	}

	public void setMaduracionMeses(int maduracionMeses) {
		this.maduracionMeses = maduracionMeses;
	}

	public String getTipoVino() {
		return tipoVino;
	}

	public void setTipoVino(String tipoVino) {
		this.tipoVino = tipoVino;
	}

	public int getGraduacionAlcholica() {
		return graduacionAlcholica;
	}

	public void setGraduacionAlcholica(int graduacionAlcholica) {
		this.graduacionAlcholica = graduacionAlcholica;
	}

	/**
	 * - Método que clasifique el vino en función de su maduración y del tipo de vino, siguiendo la siguiente
	 * tabla:
	 * 		Aquellos vinos que tengan una maduración inferior se considerarán vinos Jóvenes, es decir, un vino
	 * 		rosado con 12 meses de curación se considerará vino Joven. Por tanto las clasificaciones posibles
	 * 		son: Joven, Crianza, Reserva y Gran Reserva.
	 */
	public void clasificaVino(int maduracionMeses,String tipoVino) {

	}

	/**
	 * - Método que calcule el precio bruto del vino (sin impuestos), el cual estará en función de los
	 * siguientes datos:
	 * 		o El periodo de maduración, 10 céntimos por mes de maduración.
	 * 		o Si la uva es blanca se le suma 1.20€, pero si es negra se le suman 1.50€.
	 * 		o Si la recogida de la uva es manual, su coste se incrementa en 3€, pero si es mecánica, solo se
	 * 		incrementa en 50 céntimos.
	 * 		o También habrá que sumar un 3% de la minuta por hora que cobra el enólogo responsable.
	 */
	public float precioBruto() {

	}

	/**
	 * - Método que calcule el precio de venta del vino, es decir, tras aplicarle los impuestos anteriormente
	 * explicados.
	 */
	public float precioVenta() {

	}

	/**
	 * - Método toString redefindo
	 * 
	 * VINO: Los verdiales - Blanco Joven
	 * 		Cosecha: Finca La Soledad, otoño 2016, recogida de forma Mecánica. Uva Blanca
	 * 		Enologo: Juan García
	 * 		Maduración en meses: 15
	 * 		Graduación: 9 grados
	 * 		Precio bruto: 4 euros y 7 céntimos
	 * 		Precio venta: 5 euros y 31 céntimos
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName().toUpperCase() + ": " + this.nombreVino + " - " + this.tipoVino +
				"\n\tCosecha: " + this.cosecha +
				"\n\tEnologo: " + this.enologo +
				"\n\tMaduración: " + this.maduracionMeses +
				"\n\tGraduación: " + this.graduacionAlcholica +
				"\n\tPrecio bruto: " + precioBruto() +
				"\n\tPrecio venta: " + precioVenta();
	}
}
