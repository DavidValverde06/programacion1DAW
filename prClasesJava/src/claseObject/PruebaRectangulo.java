package claseObject;

public class PruebaRectangulo {

	public static void main(String[] args) {
		
	
		Rectangulo r1 = new Rectangulo(5,7);
	//	Rectangulo r2 = (Rectangulo) r1.clone();
		Rectangulo r2 = r1.clone();
		Rectangulo r3 = r1;
		
		r2.incrementaAncho();
		r2.incrementaAlto();
		
		r1.setNombre("Pequeño");
		r2.setNombre("Grande");
		
		System.out.println("R1 "+ r1.toString());
		System.out.println("R2 "+ r2.toString());
		

		System.out.println("R3 "+ r3.toString());
		r3.setNombre("XXXX");
		System.out.println("R1 "+ r1.toString());
		
	}

}
