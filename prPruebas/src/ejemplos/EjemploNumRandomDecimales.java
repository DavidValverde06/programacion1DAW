package ejemplos;

public class EjemploNumRandomDecimales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double numAleatorio;
		
		numAleatorio=(Math.random()*30)+1;
		
		// Generar un num aleatorio con decimales entre 1 y 30
		System.out.println("Número aleatorio entre 1 y 30 con decimales: " + numAleatorio);
		
		System.out.println("Número aleatorio entre 1 y 30 sin decimales: " + Math.round(numAleatorio));
		
		System.out.println("Número aleatorio entre 1 y 30 sin decimales: " + (int)(numAleatorio));

	}

}
