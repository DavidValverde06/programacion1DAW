package prEnumeraciones;

public enum Transporte2 {
	
	COCHE(60), CAMION(50), AVION(600), TREN(70), BARCO(20);
	
	/**
	 * Variable de instancia de cada constante
	 */
	private int velocidad; //velocidad t�pica de cada transporte
	
	/**
	 * Constructor, se ejecutar� por cada constante definida
	 * en la enumreaci�n
	 * @param s
	 */
	Transporte2(int s){
		velocidad=s;}
	
	/**
	 * M�todo que se ejecuta en funci�n de una de las constantes
	 * @return
	 */
	int getVelocidad(){return velocidad;}
}






