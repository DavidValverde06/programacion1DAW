package ejemplos;

public class PruebaDivision {

	public static void main(String[] args) {

		int dividendo=18;
		int divisor=0;
		
//		System.out.println("División: " + (divisor==0?"Error":dividendo/divisor));
		
//		if (divisor==0) {
//			System.out.println("Error, no se puede dividir por cero");
//		}
//		else {
//			System.out.println("División: " + (divisor==0?"Error":dividendo/divisor));
//		}
		
		// Control de excepciones
		try {
			System.out.println("Buenas tardes");
			
			System.out.println("División: " + (dividendo/divisor));
			
			System.out.println("Fin del bloque try");
		}
		catch(ArithmeticException e) {
			System.out.println("Error, no se puede dividir por cero");
		}
		finally {
			System.out.println("Este código siempre se va a ejecutar");
		}
		
		System.out.println("Fin del programa");
	}

}
