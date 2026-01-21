package clasesString;

public class TestStringBuilder {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("Hola");
		sb.append(" Mundo");  // Modifica el mismo objeto
		System.out.println(sb);  // Imprime "Hola Mundo"
		
		sb.reverse(); // Invierte la cadena, modificándola sobre el mismo objeto
		System.out.println(sb); 
	}

}
