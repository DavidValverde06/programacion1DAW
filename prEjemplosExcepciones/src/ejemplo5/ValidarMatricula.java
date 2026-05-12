package ejemplo5;

/**
 * Clase que permite validar matrículas
 * 
 */

public class ValidarMatricula {

	/**
	 * Aisla el primer caracter y comprueba que es una letra empleando 
	 * el método matches de expresiones regulares
	 * 
	 * @param Matricula
	 * @return true o false
	 */
	private boolean unaLetra(String Matricula) {
		return Matricula.substring(0,1).matches("[A-Za-z]");
	}


	/**
	 * Método que valida si una matricula es correcta
	 * 
	 * Vamos a considerar que una matrícula es correcta, si el primer carácter es
	 * un letra, y su longitud es de 8 caracteres
	 * 
	 * Ejemplo: Matrículas correctas: A1234567, abc98765
	 *          Matrículas incorrectas: 12345678, abc, ABC123456789, Asdfasfasf
	 *          
	 * @param Matricula
	 * @throws ExMatricula - "Relanza" excepciones tipo ExMatricula
	 */
	public void validar(String matricula) throws ExMatricula {

		if (matricula.length()!=8) 
			throw new ExMatricula(ExMatricula.MAL_TAMANIO);
		else
			if (!unaLetra(matricula))
				throw new ExMatricula(ExMatricula.MAL_LETRA);

		System.out.println("Matrícula correcta");
	}

}







