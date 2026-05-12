package prPractica02;

/**
 * 2. ¿Cómo se podría mejorar el siguiente fragmento de algoritmo?
			si b entonces
			x = verdadero
			si-no
			x = falso
			fin-si
		Es lo mismo poner si b entonces que si (b==verdadero) entonces, es decir, si no ponemos nada se supone que
		comprueba si es verdadero el resultado de evaluar la expresión lógica.
 */

public class Ejercicio2 {

	public static void main(String[] args) {

		boolean b=true,x;
		
//		if (b==true) {
//			x=true;
//		}
//		else {
//			x=false;
//		}
		
		x=b;
		
		System.out.println(b);
		System.out.println(x);
	}

}
