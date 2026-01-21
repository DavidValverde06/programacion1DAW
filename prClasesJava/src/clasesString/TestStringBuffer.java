package clasesString;

public class TestStringBuffer {

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer("Hola");
		sb.append(" Mundo");  // Modifica el mismo objeto
		System.out.println(sb);  // Imprime "Hola Mundo"
		
		sb.reverse(); // Invierte la cadena, modificándola sobre el mismo objeto
		System.out.println(sb); 

		
		
	}

}
