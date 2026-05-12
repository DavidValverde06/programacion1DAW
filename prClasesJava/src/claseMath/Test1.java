// Prueba de algunas de las funciones de la clase Math
package claseMath;

public class Test1
{
	public static void main(String[] args) 
	{
		System.out.println("Valor absoluto: "+Math.abs(-5));
		
		// Los métodos de coseno, seno, tangente, ... realizan los calculos 
		// en radianes, luego si queremos el calculo en grados habrá que convertirlo
		double aux=Math.toRadians(90);
		
		System.out.println("Coseno de 90: "+Math.cos(aux));
		System.out.println("Coseno de 90: "+Math.cos(Math.toRadians(90)));
		
		System.out.println("Coseno de 90 en radianes: "+Math.cos(90));
		System.out.println("Seno de 90: "+Math.sin(aux));
		System.out.println("Tangente de 90: "+Math.tan(aux));
		System.out.println("Función ceil: "+Math.ceil(5.2));
		System.out.println("Función floor: "+Math.floor(5.9));
		System.out.println("Función random: "+Math.random());
		System.out.println("Función pow: "+Math.pow(2,4));
		System.out.println("Función sqrt: "+Math.sqrt(36));
		System.out.println("90 grados = "+Math.toRadians(90)+" radianes");
		System.out.println("1.57 radianes = "+Math.toDegrees(1.57)+" grados");
		System.out.println("Logaritmo neperiano de 100: "+Math.log(100));
		System.out.println("Función mínimo: "+Math.min(10,5));
		System.out.println("Función máximo: "+Math.max(10,5));
		System.out.println("Redondeo: "+Math.round(6.7));
		System.out.println("Resto de la división: "+ Math.IEEEremainder(8.3,3));
		System.out.println(8.3%3);
	}
}







