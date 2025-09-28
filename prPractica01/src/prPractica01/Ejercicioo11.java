package prPractica01;

/**
 * 11.- Al igual que ocurría con los long, puede ocurrir con los decimales (float y double). En el siguiente
		ejemplo establecemos el precio de una pieza de pan en 0.87 euros y el del Kilo de queso en 5.93 euros,
		la letra “f” con la que terminamos las declaraciones le indica al compilador que los literales numéricos
		(0.87 y 5.93) son de tipo float; si no pusiéramos esta indicación, el compilador los tomaría (por defecto)
		como double, con lo que la asignación float = double resultaría fallida. En el ejemplo estamos calculando
		el precio de un bocadillo de 150 gramos de queso. Hacer la prueba.
 */

public class Ejercicioo11 {

	public static void main(String[] args) {

		float piezaPan = 0.87f;
		float kiloQueso = 5.93f;
		float bocadillo = piezaPan + (kiloQueso * 0.15f);
		System.out.println("El bocadillo vale: " + bocadillo + " euros");
		
		/*
		  Para definir e inicializar variables que contienen números realmente grandes (por ejemplo, 6 elevado a
		  100) y números realmente pequeños (por ejemplo, 2.45 elevado a –95), se puede utilizar el tipo double
		  de la siguiente forma:
		*/
				double var1 = 6E+100;
				double var2 = 2.45E-95;
				
				System.out.println(var1);
				System.out.println(var2);
				
//			No obstante, a pesar de lo explicado en los ejercicios 2 y 3, siempre se pueden realizar transformaciones
//			tipo Casting (se verá en el apartado 11 del tema 4). Como avance veamos los siguientes ejemplos:
				
//			▪ (byte) 1 → convierte el 1 (int) a byte.
//			▪ (double) miVariableDeTipoFloat → convierte a double una variable de tipo float.
//			▪ (short) (variableDeTipoByte + variableDeTipoByte) → convierte a short el resultado de
//			sumar dos variables de tipo byte. Observar, que al sumar dos variables de tipo byte, el resultado
//			puede que no “quepa” en otra variable de tipo byte.

	}

}
