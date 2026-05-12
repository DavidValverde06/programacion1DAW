package claseMath;

public class Test2 {

	public static void main(String[] args) {
		
		// Redondeos
		double num = 5.8;
		System.out.println("Math.round(5.8): " + Math.round(num));   // 6
		System.out.println("Math.ceil(5.8): " + Math.ceil(num));     // 6.0
		System.out.println("Math.floor(5.8): " + Math.floor(num));   // 5.0
		
		// Potencias y raices
		System.out.println("Math.pow(2, 3): " + Math.pow(2, 3));   // 8.0
		System.out.println("Math.sqrt(16): " + Math.sqrt(16));     // 4.0
		
		// Otros métodos
		System.out.println("Valor absoluto de -5: " + Math.abs(-5));      // 5
        System.out.println("Máximo entre 3 y 7: " + Math.max(3, 7));      // 7
        System.out.println("Mínimo entre 3 y 7: " + Math.min(3, 7));      // 3
        System.out.println("Logaritmo natural de 10: " + Math.log(10));   // 2.302...
        System.out.println("Logaritmo decimal de 10: " + Math.log10(10)); // 1.0
	}

}
