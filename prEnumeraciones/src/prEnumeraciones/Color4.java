package prEnumeraciones;

public enum Color4 {
	ROJO, VERDE, AZUL;
	
	// enum constructor llamado por separado para cada constante
	private Color4() {
		System.out.println("Constructor llamado para : " +
				this.toString());
	}
	
	// Solo métodos concretos (no abstractos) permitidos
	public void colorInfo() {
		System.out.println("Color Universal");
	}
}
