package interfaces;

public interface InterfazA {

	// Definición de una constante, por defecto en las interfaces
	// son public static final
	int varIA = 100;

	// Definir un m�todo de esta interfaz
	void metodoInterfazA();

	default void metodoInterfazANuevo() {

	}

	default public void metodoInterfazA2() {
		System.out.println("Hola");
	}

}
