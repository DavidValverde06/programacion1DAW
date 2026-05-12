package interfaces;


public interface InterfazB {

	// Métodos de la interfazB, tendrán que ser redefinidos
	// en las clases que la implementen
	public void metodoInterfazB1();
	public void metodoInterfazB2();
	default void metodoInterfazB3() {
		System.out.println("Método nuevo añadido");
	}
}
