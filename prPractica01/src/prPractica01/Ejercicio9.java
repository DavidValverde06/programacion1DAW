package prPractica01;

/**
 * 9.- a) Observar el siguiente programa, que guarda en dos variables de tipo byte, las edades de dos
		  personas, y en otras dos de tipo short su sueldo base. 
 */

public class Ejercicio9 {

	public static void main(String[] args) {

		byte edadJuan = 20;
		byte edadPedro = 42;
		short sueldoBase = 1980;
		short complementos = 400;
		System.out.println(sueldoBase);
		
//		Sabiendo que el sueldo real se obtiene de sumar al sueldo base los complementos, y 30 euros si su
//		edad es inferior a 25, 60 euros si su edad es inferior a 35, y 100 euros si su edad es inferior o igual a
//		65, y después deducirle un 15% de IRPF y un 9% de Seguridad Social. 
		
		double sueldoTotalJuan=sueldoBase+complementos+30;
		double sueldoTotalPedro=sueldoBase+complementos+100;
		
		final float SS = 0.09f;
		final float IRPF = 0.15f;
		
		int porcentajeIRPFJuan,porcentajeSSJuan,porcentajeIRPFPedro,porcentajeSSPedro;
		
		porcentajeIRPFJuan = (int) (sueldoTotalJuan*IRPF);
		porcentajeSSJuan = (int) (sueldoTotalJuan*SS);
		
		porcentajeIRPFPedro = (int) (sueldoTotalPedro*IRPF);
		porcentajeSSPedro = (int) (sueldoTotalPedro*SS);
		
		System.out.println("El sueldo real del empleado de " + edadJuan +" años es: " + (sueldoTotalJuan-(porcentajeIRPFJuan+porcentajeSSJuan)) + " euros.");
		System.out.println("El sueldo real del empleado de " + edadPedro +" años es: " + (sueldoTotalPedro-(porcentajeIRPFPedro+porcentajeSSPedro)) + " euros.");

	}

}

// b) ¿Por qué aparecen warnings?

// Porque las variables están inicializadas pero no se están usando.

//c) Probar a cambiar los valores de inicialización, de forma que se pase del rango permitido, ¿qué
//ocurre?

// Da un error ya que el número no cabe.

//d) Modificar el programa para que muestre por pantalla un mensaje similar al siguiente:

//		El sueldo real del empleado de XX años es: XXXX euros.
//		El sueldo real del empleado de XX años es: XXXX euros.
