package juego7Media_Ejer16;

/**
 * Clase Jugador, de un jugador conoceré su nombre, los puntos que tiene acumulados, y si continua o no jugando
 */

public class Jugador {

	/**
	 * Variables de instancia
	 */
	private String nombre;
	private float puntos;
	private boolean continua; 
	
	/**
	 * Constructor
	 */
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.puntos = 0;
		this.continua = true;
	}
	
	public Jugador() {
		this("Anónimo");
	}
	
	/**
	 * Métodos get y set
	 */
	public String getNombre() {return nombre;}
	public float getPuntos() {return puntos;}
	public boolean isContinua() {return continua;}

	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setPuntos(float puntos) {this.puntos = puntos;}
	public void setContinua(boolean continua) {this.continua = continua;}

	/**
	 * Redefinición de toString
	 */
	@Override
	public String toString() {
		return this.nombre + " ("+this.puntos+")"+
	            (this.continua?", continua jugando":", NO continua jugando");
	}

	/**
	 * M�todo que permite a un jugador sacar una carta, siempre y cuando 
	 * el jugador haya decidido seguir jugando, y no se haya pasado
	 * 
	 * @return --> Cadena con información de la carta sacada
	 */
	public String jugar(Juego7Media obJuego) {
		
		
		
	}
	
	

	
}













