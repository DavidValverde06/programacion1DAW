package rectangulo;

public class TestRectangulo {

	public static void main(String[] args) {

		System.out.println("=== TEST DE RECTÁNGULOS ===\n");

		// Test de constructores
		Rectangulo r1 = new Rectangulo(10, 5);
		Rectangulo r2 = new Rectangulo(7);
		Rectangulo r3 = new Rectangulo();

		System.out.println("Rectángulo r1 (10x5):");
		System.out.println(r1);
		System.out.println("Área: " + r1.area());
		System.out.println("Perímetro: " + r1.perimetro());
		System.out.println();

		System.out.println("Rectángulo r2 (cuadrado 7x7):");
		System.out.println(r2);
		System.out.println("Área: " + r2.area());
		System.out.println("Perímetro: " + r2.perimetro());
		System.out.println();

		System.out.println("Rectángulo r3 (vacío):");
		System.out.println(r3);
		System.out.println("Área: " + r3.area());
		System.out.println("Perímetro: " + r3.perimetro());
		System.out.println();

		// Test de agrandar por factor
		Rectangulo r4 = r1.agrandar(2);
		System.out.println("Rectángulo r1 agrandado por factor 2:");
		System.out.println(r4);
		System.out.println();

		// Test de agrandar por suma
		Rectangulo r5 = r1.agrandar(3, 4);
		System.out.println("Rectángulo r1 agrandado en +3 ancho y +4 alto:");
		System.out.println(r5);
		System.out.println();

		// Test de setters con validación
		System.out.println("Intentando asignar valores negativos:");
		r1.setAncho(-10);
		r1.setAlto(-5);
		System.out.println("Valores actuales de r1:");
		System.out.println("Ancho: " + r1.getAncho());
		System.out.println("Alto: " + r1.getAlto());
		System.out.println();

		// Test de comparación
		Rectangulo r6 = new Rectangulo(20, 10);
		System.out.println("¿r4 y r6 son iguales?");
		System.out.println(r4.equals(r6) ? "Sí, son iguales." : "No, son diferentes.");
	}

}
