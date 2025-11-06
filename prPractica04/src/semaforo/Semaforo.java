package semaforo;

/**
 * 1. Crear la clase Semaforo, cuyo color se guarde en una propiedad (variable de instancia) llamado
 * colorSemaforo de tipo String que pueda tomar los valores “Verde”, “Amarillo” y “Rojo”, y que
 * inicialmente tomará el valor “Rojo”. Como métodos de acceso a la propiedad podríamos definir:
 * 	✓ void setColor(String nuevoColor). Cambia el color de la propiedad colorSemaforo.
 * 	✓ String getColor(). Devuelve el valor de la propiedad.
 * 
 * Además podemos definir los siguientes métodos:
 * 	✓ booelan puedoPasar(). Devolverá verdadero o falso, en función de si un coche puede pasar o no.
 * 	✓ Redefinición del método toString que nos devuelva una información detallada del semáforo.
 * Una vez creada la clase Semaforo, haremos otra clase llamada TestSemaforo, para probar el
 * funcionamiento de la misma, esta nueva clase podría ser como la que se muestra a continuación: ...
 * 
 * Modificar la clase Semaforo y añadirle un constructor que inicialice el estado del semáforo al color que se
 * especifique al crear un objeto de esa clase. Hacer otra clase de prueba, para comprobar el buen
 * funcionamiento de la nueva clase semáforo.
 */

public class Semaforo {

	/*
	 * Variables de instancia
	 */
	private String colorSemaforo="Rojo";

	/*
	 * Constructor
	 */
	public Semaforo(String colorSemaforo) {
		this.colorSemaforo = colorSemaforo;
	}
	
	public Semaforo() {
		
	}

	/*
	 * Getter's y setter's
	 */
	public String getColor() {
		return colorSemaforo;
	}

	public void setColor(String colorSemaforo) {
		this.colorSemaforo = colorSemaforo;
	}

	/**
	 * Método puedoPasar()
	 * Devolverá verdadero o falso, en función de si un coche puede pasar o no.
	 * @return
	 */
	public boolean puedoPasar() {
		if (this.colorSemaforo=="Rojo") {
			return false;
		}
		else {
			return true;
		}
	}

	/**
	 * Método toString() redefinido
	 */
	@Override
	public String toString() {
		return "Semaforo en: " + this.colorSemaforo;
	}


}
