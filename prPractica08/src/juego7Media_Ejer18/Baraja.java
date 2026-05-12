package juego7Media_Ejer18;

/**
 * Clase Baraja
 * 
 * La baraja la simularemos mediante un array de objetos de tipo Carta,
 * en un principio guardaremos las 40 cartas de forma ordenada,
 * y despúes las mezclaremos (desordenar el array o mezclar)
 */
public class Baraja {

	private static final int NUMCARTASBARAJA = 40;

	/**
	 * Variables de instancia
	 */
	private Carta[] miBaraja; // Array con las 40 cartas
	private byte posProximaCarta; // Indicará la posición en el array de la siguiente carta a sacar
	int contador=0; // Variable

	/**
	 * Constructor
	 */
	public Baraja() {
		this.miBaraja = new Carta[NUMCARTASBARAJA];
		this.posProximaCarta = 0;

		// Crear un array con los valores de la enumeración
		EnumPalo[] arrayPalos = EnumPalo.values();

		// Ir generando las 40 cartas
		for (byte contPalos=0;contPalos<arrayPalos.length;contPalos++) { // Palos
			for (byte contValor=1;contValor<=10;contValor++) { // Valor
				this.miBaraja[contador] = new Carta(arrayPalos[contPalos], contValor);

				contador++;
			}
		}

		mezclar(); // Mezcla las cartas de la baraja
	}

	public void mezclar() {
		Carta cartaAux;
		int aux1,aux2;

		for (int cont=1;cont<=100;cont++) {
			aux1 = (int)(Math.random()*NUMCARTASBARAJA); // Genero un valor entre 0 y 39
			aux2 = (int)(Math.random()*NUMCARTASBARAJA); // Genero un valor entre 0 y 39

			cartaAux = this.miBaraja[aux1];
			this.miBaraja[aux1] = this.miBaraja[aux2];
			this.miBaraja[aux2] = cartaAux;
		}
	}

	/**
	 * Método que saca una carta de la baraja
	 */
	public Carta sacaCarta() {
		Carta cartaSacada = this.miBaraja[this.posProximaCarta];
		this.posProximaCarta++;
		return cartaSacada;
	}

	/**
	 * Método que comprueba si nos quedan cartas en la baraja por sacar
	 */
	public boolean quedanCartas() {
		return this.posProximaCarta < NUMCARTASBARAJA;
	}

	/**
	 * Gette's y setter's
	 */
	public Carta[] getMiBaraja() {
		return miBaraja;
	}

	public byte getPosProximaCarta() {
		return posProximaCarta;
	}

	public void setMiBaraja(Carta[] miBaraja) {
		this.miBaraja = miBaraja;
	}

	public void setPosProximaCarta(byte posProximaCarta) {
		this.posProximaCarta = posProximaCarta;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		String cad = "Quedan " + (NUMCARTASBARAJA - this.posProximaCarta) + " cartas";
		for (int cont=this.posProximaCarta;cont<this.miBaraja.length;cont++) {
			cad += "\n" + this.miBaraja[cont].toString();
		}
		return cad;
	}
}
