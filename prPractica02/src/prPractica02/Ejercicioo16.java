package prPractica02;

/**
 * 16.¿Cuántas veces se ejecutará la Acción 1?
		cont = 0
			repetir-mientras (cont < 10)
				cont = cont + 1
			si (cont == 10) entonces
				Acción 1
			fin-si
		fin-repetir

 */

public class Ejercicioo16 {

	public static void main(String[] args) {

//		No se ejecuta ni una sola vez.
		
		for (int cont=0;cont<10;cont++) {
			if (cont==10) {
				System.out.println("Acción 1");
			}
		}
	}

}
