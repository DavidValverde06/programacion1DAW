package jamones;

import java.util.Objects;

/**
 * C) En cuanto a los animales de los que proceden los jamones (cerdos), queremos conocer
 * - su número identificativo (será un String),
 * - la granja de la que procede,
 * - su peso en arrobas,
 * - la raza (blanca o ibérica),
 * y por último su sexo (‘M’ – Macho, ‘H’ – Hembra).
 * 
 * Además si se trata de un cerdo ibérico, también nos interesa conocer su 
 * tipo (Cebo, Cebo campo, Recebo o Bellota). Debéis proporcionar, al menos, los
 * siguientes métodos:
 * 
 * - Constructor.
 * 
 * - Métodos get y set.
 * 
 * - Método que calcule el precio al que se cotiza la arroba de este cerdo en concreto, y que estará en
 * función de lo siguiente:
 * o El precio que fija la granja, de la procede el animal, por arroba se verá incrementado en:
 * 		- 2 € si se trata de una hembra.
 * 		- 7 si la granja posee denominación de origen.
 * 		- En el caso de los ibéricos si se trata de “Cebo” en 5€, si es “Cebo campo” en 10€, si es
 * 		“Recebo” en 15€ y si es “Bellota”, en 20€.
 * 
 * 	o Se puede dar el caso de que se cumplan varios de los aspectos anteriores o ninguno.
 * 
 * - Método toString, que devuelva la información como se aprecia en los siguientes 4 ejemplos:
 * 
 * - Método equals para saber si dos cerdos son iguales, consideraremos que son iguales si coincide su
 * identificación y su sexo.
 */

public class Cerdos {

	/**
	 * Variables de instancia
	 */
	private String numIdentificativo;
	private Granja granjaProcedencia;
	private float peso;
	private boolean raza;
	private char sexo;
	private String tipo;

	/**
	 * Constructor
	 * @throws Exception 
	 */
	public Cerdos(String numIdentificativo, Granja granjaProcedencia, float peso, boolean raza, char sexo, String tipo) throws Exception {
		this.numIdentificativo = numIdentificativo;
		this.granjaProcedencia = granjaProcedencia;
		this.peso = peso;
		this.raza = raza;

		if (sexo=='H') {
			this.sexo=sexo;
		}
		else if (sexo=='M') {
			this.sexo=sexo;
		}
		else {
			throw new Exception("Sexo no permitido");
		}

		if (this.raza=false) {
			switch (tipo) {
			case "Cebo" -> this.tipo=tipo;
			case "Cebo campo" -> this.tipo=tipo;
			case "Recebo" -> this.tipo=tipo;
			case "Bellota" -> this.tipo=tipo;			
			default ->
			throw new IllegalArgumentException("Tipo no válido");
			}
		}
		else {
			this.tipo = "Sin tipo";
		}
	}

	/**
	 * Getter's y setter's
	 */
	public String getNumIdentificativo() {
		return numIdentificativo;
	}

	public void setNumIdentificativo(String numIdentificativo) {
		this.numIdentificativo = numIdentificativo;
	}

	public Granja getGranjaProcedencia() {
		return granjaProcedencia;
	}

	public void setGranjaProcedencia(Granja granjaProcedencia) {
		this.granjaProcedencia = granjaProcedencia;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public boolean isRaza() {
		return raza;
	}

	public void setRaza(boolean raza) {
		this.raza = raza;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Método que calcule el precio al que se cotiza la arroba de este cerdo en concreto, y que estará en
	 * función de lo siguiente:
	 * o El precio que fija la granja, de la procede el animal, por arroba se verá incrementado en:
	 * 		- 2 € si se trata de una hembra.
	 * 		- 7 si la granja posee denominación de origen.
	 * 		- En el caso de los ibéricos si se trata de “Cebo” en 5€, si es “Cebo campo” en 10€, si es
	 * 		“Recebo” en 15€ y si es “Bellota”, en 20€.
	 * 
	 * 	o Se puede dar el caso de que se cumplan varios de los aspectos anteriores o ninguno.
	 */
	public float calculaPrecio() {
		return 1;
	}

	/**
	 * toString redefinido
	 * 
	 * Datos cerdo:
	 * 		Identificación: L8772
	 * 		Procedencia: Hermanos García, S.L, sin denominación de origen - Precio base @: 17.0€
	 * 		Peso: 14.0@ (158.746 kilos)
	 * 		Precio por arroba: 34.0€
	 * 		Sexo: Hembra
	 * 		Raza: Ibérico
	 * 		Tipo de ibérico: Recebo
	 */
	@Override
	public String toString() {
		return "Datos cerdo: " +
				"\n\tIdentificación: " + this.numIdentificativo +
				"\n\tProcedencia: " + this.granjaProcedencia +
				"\n\tPeso: " + this.peso +
				"\n\tPrecio por arroba: " + this.calculaPrecio() +
				"\n\tSexo: " + this.sexo +
				"\n\tRaza: " + (this.raza?"Blanco":"Iberico") +
				"\n\tTipo de ibérico: " + this.tipo;
	}

	/**
	 * equals
	 */
	@Override
	public boolean equals(Object obj) {
		Cerdos otroCerdo = (Cerdos) obj;
		return Objects.equals(numIdentificativo, otroCerdo.numIdentificativo) && sexo == otroCerdo.sexo;
	}
}
