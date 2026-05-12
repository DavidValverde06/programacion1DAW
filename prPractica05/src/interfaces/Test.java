package interfaces;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(InterfazA.varIA);

		// Prueba ClaseA
		ClaseA obCA = new ClaseA();
		System.out.println(obCA.toString());
		obCA.metodoClaseA();

		// Prueba ClaseB
		ClaseB obCB = new ClaseB();
		obCB.metodoClaseA();
		obCB.metodoClaseB();
		obCB.metodoInterfazA();

		// Si definimos un objeto de claseB, pero su referencia es de
		// claseA, sólo podremos usar con ese objeto los métodos de la
		// ClaseA, es decir, los de la referencia. Esto es el 
		// POLIMORFISMO DINÁMICO (durante la ejecución).
		ClaseA ob = new ClaseB();
		ob.metodoClaseA();


		// Prueba ClaseC
		ClaseC obCC = new ClaseC();
		obCC.metodoClaseA();
		obCC.metodoClaseB();
		obCC.metodoClaseC();
		obCC.metodoInterfazA();
		obCC.metodoInterfazB1();
		obCC.metodoInterfazB2();
		obCC.metodoInterfazC();
		obCC.metodoInterfazD();

		System.out.println(InterfazE.IVA_TIPO1);
	}
}






