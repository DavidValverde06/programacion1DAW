package juego7Media_Ejer18;

import java.util.Objects;

/**
 * Clase que guardará la información de un objeto de tipo Carta
 * 	- Valor de carta --> 1 a 10 (1 a 7, cartas de 1 a 7, 8-Sota, 9-Caballo, 10-Rey)
 * 	- Palo de la carta --> Oros, Copas, Bastos, Espadas
 */
public class Carta {

	/**
	 * Variables de instancia
	 */
	private EnumPalo palo;
	private byte valor;

	/**
	 * Constructor
	 * @param palo
	 * @param valor
	 */
	public Carta(EnumPalo palo, byte valor) {
		this.palo = palo;
		this.valor = valor;
	}

	/**
	 * Getter's y setter's
	 */
	public EnumPalo getPalo() {
		return palo;
	}

	public byte getValor() {
		return valor;
	}

	public void setPalo(EnumPalo palo) {
		this.palo = palo;
	}

	public void setValor(byte valor) {
		this.valor = valor;
	}

	/*
	 * toString redefinido
	 */
	@Override
	public String toString() {

		String cad = switch (this.valor) {
		case 1,2,3,4,5,6,7 -> {yield this.valor + " de " + this.palo;}
		case 8 -> {yield "Sota de " + this.palo;}
		case 9 -> {yield "Caballo de " + this.palo;}
		case 10 -> {yield "Rey de " + this.palo;}
		default -> {yield "Carta no válida";}
		};

		return cad;
	}

	/**
	 * Método que devuelve la puntuación real de la carta para el juego de las 7 y media
	 * @return
	 */
	public float getPuntos7Media() {
		if (this.valor>7) {
			return 0.5f;
		}
		return this.valor;
	}

	/**
	 * equals y hashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(palo, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		return palo == other.palo && valor == other.valor;
	}
}
