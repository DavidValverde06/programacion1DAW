package fraccion;

public class TestFraccion {

	public static void main(String[] args) {

		// Crear fracciones
		Fraccion f1 = new Fraccion(8, 12);
		Fraccion f2 = new Fraccion(3, 4);
		Fraccion f3 = new Fraccion(5, 2);
		Fraccion f4 = new Fraccion(10, 15);

		// Mostrar fracciones originales
		System.out.println("Fracción f1: " + f1);
		System.out.println("Fracción f2: " + f2);
		System.out.println("Fracción f3: " + f3);
		System.out.println("Fracción f4: " + f4);
		System.out.println();

		// Probar método equals
		System.out.println("¿f1 es igual a f4? " + (f1.equals(f4) ? "Sí" : "No"));
		System.out.println();

		// Probar método invierte
		System.out.println("Invertimos f2...");
		f2.invierte();
		System.out.println("f2 invertida: " + f2);
		System.out.println();

		// Probar método simplifica
		System.out.println("Simplificamos f1...");
		f1.simplifica();
		System.out.println("f1 simplificada: " + f1);
		System.out.println();

		// Probar método multiplica
		System.out.println("Multiplicamos f1 por f3...");
		Fraccion producto = f1.multiplica(f3);
		System.out.println("Resultado: " + producto);
		producto.simplifica();
		System.out.println("Resultado simplificado: " + producto);
		System.out.println();

		// Probar método divide
		System.out.println("Dividimos f3 entre f4...");
		Fraccion cociente = f3.divide(f4);
		System.out.println("Resultado: " + cociente);
		cociente.simplifica();
		System.out.println("Resultado simplificado: " + cociente);
		System.out.println();

		// Probar setters
		System.out.println("Modificamos f4 a 20/30...");
		f4.setNumerador(20);
		f4.setDenominador(30);
		System.out.println("f4 modificada: " + f4);
		f4.simplifica();
		System.out.println("f4 simplificada: " + f4);
	}

}
