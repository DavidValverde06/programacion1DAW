package clasesWrappers;

public class Prueba1 {

	public static void main(String[] args) {

		Integer obInteger8 = new Integer(67);  // Modo obsoleto
		System.out.println(obInteger8);
		
		// Creación de un objeto Integer, a partir de un tipo primitivo
		Integer obInteger = Integer.valueOf(67);
		
		System.out.println(obInteger);
		
		System.out.println(obInteger+7);
		
		System.out.println(obInteger.MIN_VALUE);
		System.out.println(obInteger.MAX_VALUE);
		
		// Creaci�n de un objeto Integer, a partir de un String
		Integer obInteger2 = Integer.valueOf("98");
		System.out.println(obInteger2+10);
		
		// Convertir un objeto Integer a tipo primitivo int
		int num = obInteger.intValue();
		
		// Convertir un String en un tipo primitivo int
		int num2 = Integer.parseInt("987");
		System.out.println(num2+2);
		
		// Convertir la variable de tipo primitivo en String
		String numCadena = String.valueOf(num2);
		
		String numCadena2 = Integer.toString(num2);
		
		// Crear un objeto a partir de un número directamente
		Integer obInteger4 = 18;
		System.out.println("Objeto Integer: " + obInteger4);
		System.out.println("Tipo primitivo del objeto Integer: " + obInteger4.intValue());
		System.out.println("Objeto Integer como cadena: " + Integer.toString(obInteger4));
	
		
		// Crear un objeto a partir de un n�mero directamente
		Integer obInteger6 = 180;
		System.out.println("Objeto Integer: " + obInteger6);
		System.out.println("Tipo primitivo del objeto Integer: " + obInteger6.intValue());
		System.out.println("Objeto Integer como cadena: " + Integer.toString(obInteger6));
		System.out.println("Objeto Integer como cadena: " + obInteger6.toString());
		
		Integer n1 = 6, n2 = 10;
		System.out.println(n1+n2);
		
		
	}

}






