package claseOptional;

import java.util.Optional;

public class Test1 {

	public static void main(String[] args) {
		
		Optional<String> optional = Optional.of("Hola, mundo");

		Optional<String> optional2 = Optional.ofNullable(null); // Optional vacío
		
		Optional<String> optional3 = Optional.empty();
		
		if (optional.isPresent()) {
		    System.out.println(optional.get());
		}
		
		if (optional.isEmpty()) {
		    System.out.println("No hay valor presente");
		}
		
		if (optional2.isEmpty()) {
		    System.out.println("No hay valor presente");
		}
		
		if (optional3.isEmpty()) {
		    System.out.println("No hay valor presente");
		}
		
		String valor = optional.get();
		
		String valor2 = optional.orElse("Valor por defecto");
		
		String valor3 = optional.orElseGet(() -> "Generado dinámicamente");
		
		String valor4 = optional.orElseThrow(() -> new IllegalArgumentException("Valor ausente"));
		
		Optional<Integer> longitud = optional.map(String::length);
		
		Optional<String> resultado = optional.flatMap(valor5 -> Optional.of(valor5.toUpperCase()));
		
		Optional<String> filtrado = optional.filter(valor6 -> valor6.startsWith("H"));
	}

}
