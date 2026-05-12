package ejemplos;

public class EjemploBucleFor {

	public static void main(String[] args) {

		// Mostrar 5 "Hola" en consola
		for (int cont=1;cont<=5;cont++) {
			System.out.println("Hola " + cont);
		}
		
		System.out.println();
		
		// Mostrar los 10 primeros números naturales
		for (int cont=1;cont<=10;cont++) {
			System.out.print(cont + " ");
		}
		
		System.out.println();
		
		// Mostrar los números pares que existen entre 1 y 20
		for (int cont=2;cont<=20;cont++) {
			if (cont%2==0) {
				System.out.print(cont + " ");
			}
		}
		
		System.out.println();
		
		for (int cont=2;cont<=20;cont=cont+2 /*cont+=2*/) {
			System.out.print(cont + " ");
		}
		
		System.out.println();
		
		// Mostrar los primeros 20 números pares
		
		for (int cont=2;cont<=40;cont++) {
			if (cont%2==0) {
				System.out.print(cont + " ");
			}
		}
		
		System.out.println();
		
		for (int cont=1;cont<=20;cont++) {
			System.out.print(cont * 2 + " ");
		}
		
		System.out.println();
		
		System.out.println("\nMostrar los 20 primeros números pares: ");
        for (int cont=2, contPares=2; contPares<20; cont=cont+2, contPares++) {
            System.out.print(cont+ " ");
        }
        
        System.out.println();
        
        // Mostrar los números del 50 al 40 en orden descendente;
        System.out.println("\nMostrar los números del 50 al 40 en orden descendente: ");
        for (int cont=50;cont>=40;cont--) {
        	System.out.print(cont + " ");
        }
        
		
	}

}
