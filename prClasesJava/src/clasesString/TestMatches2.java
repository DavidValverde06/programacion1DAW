package clasesString;

public class TestMatches2 {

	public static void main(String[] args) {

		String cadena="Solo se que no se nada";

		// ejemplo1: devolvera false, ya que la cadena tiene mas caracteres
		System.out.println("ejemplo1: "+cadena.matches("Solo"));

		// ejemplo2: devolvera true, siempre y cuando no cambiemos la cadena Solo
		System.out.println("ejemplo2: "+cadena.matches("Solo.*"));

		// ejemplo3: devolvera true, siempre que uno de los caracteres se cumpla
		System.out.println("ejemplo3: "+cadena.matches(".*[qnd].*"));

		// ejemplo3: devolvera false, ya que ninguno de esos caracteres estan
		System.out.println("ejemplo4: "+cadena.matches(".*[xyz].*"));

		// ejemplo4: devolvera true, ya que le indicamos que no incluya esos caracteres
		System.out.println("ejemplo4: "+cadena.matches(".*[^xyz].*"));

		// ejemplo5: devolvera true, si quitamos los caracteres delante de ? del String 
		// original seguira devolviendo true
		System.out.println("ejemplo5: "+cadena.matches("So?lo se qu?e no se na?da"));

		// ejemplo6: devolvera false, ya que tenemos una S mayuscula empieza en el String
		System.out.println("ejemplo6: "+cadena.matches("[a-z].*"));

		// ejemplo7: devolvera true, ya que tenemos una S mayuscula empieza en el String
		System.out.println("ejemplo7: "+cadena.matches("[A-Z].*"));

		String cadena2="abc1234";

		// ejemplo8: devolvera true, ya que minimo debe repetirse alguno de los caracteres 
		// al menos una vez
		System.out.println("ejemplo8: "+cadena2.matches("[abc]+.*"));

		// ejemplo9: devolvera true, ya que, ademas del ejemplo anterior, indicamos que 
		//debe repetirse un valor numerico 4 veces
		System.out.println("ejemplo9: "+cadena2.matches("[abc]+\\d{4}"));

		// ejemplo10: devolvera true, ya que, ademas del ejemplo anterior, indicamos que 
		//debe repetirse un valor numerico entre 1 y 10 veces
		System.out.println("ejemplo10: "+cadena2.matches("[abc]+\\d{1,10}"));

	}

}
