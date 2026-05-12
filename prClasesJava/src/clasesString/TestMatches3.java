package clasesString;

public class TestMatches3 {

	public static void main(String[] args) {

		// -----------------------------------------------------------------
		// Validadción de un teléfono
		// -----------------------------------------------------------------
		String telefono = "678123456";

		// Expresión regular para validar un número de teléfono español de 9 
		// dígitos que empiece por 6 o 7
		String regex = "[67][0-9]{8}";

		if (telefono.matches(regex)) {
			System.out.println("El número de teléfono es válido.");
		} else {
			System.out.println("El número de teléfono no es válido.");
		}
	
		
		// -----------------------------------------------------------------
		// Validación de un email
		// -----------------------------------------------------------------
		String correo = "ejemplo@email.com";

		// Expresión regular simplificada para validar un correo electrónico
		String regex2 = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

		if (correo.matches(regex2)) {
			System.out.println("El correo electrónico es válido.");
		} else {
			System.out.println("El correo electrónico no es válido.");
		}
		
		
		
		// -----------------------------------------------------------------
		// Comprobación de si una cadena contiene sólo letras mayúsculas
		// -----------------------------------------------------------------
		String texto = "JAVA";
        
        // Expresión regular para validar solo letras mayúsculas
        String regex3 = "[A-Z]+";
        
        if (texto.matches(regex3)) {
            System.out.println("La cadena contiene solo letras mayúsculas.");
        } else {
            System.out.println("La cadena no contiene solo letras mayúsculas.");
        }
	}

	
	
}
