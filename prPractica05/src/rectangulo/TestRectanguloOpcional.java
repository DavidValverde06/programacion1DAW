package rectangulo;

public class TestRectanguloOpcional {

	public static void main(String[] args) {

		try {
            RectanguloOpcional r1 = new RectanguloOpcional(10, 5);
            System.out.println(r1);
            System.out.println("Área: " + r1.area());
            System.out.println("Perímetro: " + r1.perimetro());

            RectanguloOpcional r2 = r1.agrandar(2);
            System.out.println("Rectángulo agrandado:\n" + r2);

            System.out.println("¿Son iguales? " + r1.equals(r2));
            
            System.out.println(); // Salto de línea
            
            RectanguloOpcional r3 = new RectanguloOpcional(10);
            System.out.println(r3);
            System.out.println("Área: " + r3.area());
            System.out.println("Perímetro: " + r3.perimetro());

            RectanguloOpcional r4 = r3.agrandar(2);
            System.out.println("Rectángulo agrandado:\n" + r4);

            System.out.println("¿Son iguales? " + r1.equals(r4));
            
            System.out.println(); // Salto de línea
            
            RectanguloOpcional r5 = new RectanguloOpcional();
            System.out.println(r5);
            System.out.println("Área: " + r5.area());
            System.out.println("Perímetro: " + r5.perimetro());

            RectanguloOpcional r6 = r5.agrandar(-2);
            System.out.println("Rectángulo agrandado:\n" + r6);

            System.out.println("¿Son iguales? " + r1.equals(r6));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
	}

}
