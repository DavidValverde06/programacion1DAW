package ejemplos;

public class EjemploCondicionalBinario {

	public static void main(String[] args) {
		
		int num=10;
		
		if (num==100) {
			System.out.println("El número es 100");
		}
		else {
			System.out.println("El número NO es 100");
		}
		
		if (num==100)
			System.out.println("El número es 100");
		else
			System.out.println("\nEl número NO es 100");
		
		if (num==100) {
			System.out.println("El número es 100");
			System.out.println("Hasta luego");
		}
		else {
			System.out.println("\nEl número NO es 100");
			System.out.println("El número es " + num);
			System.out.println("Adios");
		}
		
		System.out.println("Fin de programa");
	}

}
