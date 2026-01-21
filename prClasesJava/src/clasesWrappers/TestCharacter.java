package clasesWrappers;

public class TestCharacter {

	public static void main(String[] args) {

		Character caracter = new Character('A');  // Constructor (obsoleto en versiones recientes)
		Character ch2 = 'B';   // Autoboxing
		char c = ch2;           // Unboxing

		System.out.println(Character.isLetter('A'));  // true
		System.out.println(Character.isLetter('7'));  // false

		System.out.println(Character.isDigit('5'));   // true
		System.out.println(Character.isDigit('A'));   // false

		System.out.println(Character.isWhitespace(' '));  // true
		System.out.println(Character.isWhitespace('\n')); // true

		System.out.println(Character.toUpperCase('a'));  // A
		System.out.println(Character.toUpperCase('B'));  // B
		
		System.out.println(Character.toLowerCase('A'));  // a
		
		System.out.println(Character.isUpperCase('A'));  // true
		System.out.println(Character.isLowerCase('a'));  // true

		System.out.println(Character.isLetterOrDigit('A'));  // true
		System.out.println(Character.isLetterOrDigit('1'));  // true
		System.out.println(Character.isLetterOrDigit('%'));  // false

				

		// ------------------------------------------------------------
		// Contar letras, dígitos y espacios
		// ------------------------------------------------------------
        String texto = "Hola Mundo 123!";
        int letras = 0, digitos = 0, espacios = 0;

        for (int i = 0; i < texto.length(); i++) {
            char ch = texto.charAt(i);
            if (Character.isLetter(ch)) {
                letras++;
            } 
            else if (Character.isDigit(ch)) {
                digitos++;
            } 
            else if (Character.isWhitespace(ch)) {
                espacios++;
            }
        }

        System.out.println("Letras: " + letras);
        System.out.println("Dígitos: " + digitos);
        System.out.println("Espacios: " + espacios);

		
	}

}
