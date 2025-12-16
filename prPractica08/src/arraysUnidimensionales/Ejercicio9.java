package arraysUnidimensionales;

/**
 * 9.- Hacer un programa que genere un array de 15 números enteros de forma aleatoria, y a continuación
 * invierta internamente los números del array, no se puede utilizar un array auxiliar.
 */

public class Ejercicio9 {

	public static void main(String[] args) {

		ni idea
		
		int contador = 0;
		int miArray[] = new int[15];

//		System.out.println("Array con 15 números aleatorios: ");
//		for (int cont=0;cont<miArray.length;cont++) {
//			miArray[cont]=(int)(Math.random()*100)+1;
//			System.out.print(miArray[cont] + " ");
//		}

		// Rellenar con números del 0 al 14
		System.out.println("\n\nArray con números del 0 al 14: ");
		for (int cont=0;cont<miArray.length;cont++) {
			miArray[cont]=contador++;
			System.out.print(miArray[cont] + " ");
		}

		contador=0;

		System.out.println("\n\nArray invertido internamente: ");
//		for (int cont2=miArray.length-1;cont2>0;cont2--) {
//			miArray[contador]=miArray[cont2];
//			System.out.print(miArray[contador] + " ");
//			contador++;
//
//		}
		
		for (int cont=0;cont<miArray.length;cont++) {
			for (int cont2=0;cont2<miArray.length;cont2++) {
				for (int cont3=0;cont3<miArray.length;cont3++) {
					
				}	
			}
			
			System.out.print(miArray[cont] + " ");
		}
	}

}
