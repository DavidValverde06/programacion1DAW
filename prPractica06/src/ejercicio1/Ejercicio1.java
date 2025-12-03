package ejercicio1;

/**
 * 1. Realizar un programa que muestre por pantalla todos los números entre 1 y 100, que tengan el mismo
 * número de divisores pares e impares. Una posible solución es la siguiente:
 */

public class Ejercicio1 {
	// Variables de instancia
	private int numero;
	private int contPares;
	private int contImpares;

	// Constructor
	public Ejercicio1(int num){
		this.numero = num;
		contPares=0;
		contImpares=0;
	}

	// Método que averigua si un número es par o impar
	private boolean par(int n){return (n%2==0);}

	// Método que cuenta los divisores pares y los impares
	public void cuentaDivisores() {
		for (int i=1;i<=numero;i++)
			if ((numero%i)==0) // Es divisor
				if (par(i)) contPares++;
				else contImpares++;
	}

	// Métodos get
	public int getNumero() {return numero;}
	public int getContPares() {return contPares;}
	public int getContImpares() {return contImpares;}


	// Programa principal
	public static void main(String[] args) {
		Ejercicio1 ob = new Ejercicio1(5);

		ob.cuentaDivisores();

		System.out.println("El número " + ob.getNumero() +
				" tiene " + ob.getContPares() + " divisores pares y " +
				ob.getContImpares() + " divisores impares.");

		System.out.println("Los números entre 1 y 100, con el mismo número de divisores pares e impares son:");

		for (int i=1; i<=100; i++){
			Ejercicio1 ob2 = new Ejercicio1(i);
			ob2.cuentaDivisores();
			if (ob2.getContPares()==ob2.getContImpares())
				System.out.print(i+ " ");
		}
	}
}