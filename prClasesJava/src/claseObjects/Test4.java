package claseObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Test4 {

	public static void main(String[] args) {
	    List<Persona> lista= new ArrayList<Persona>();
	    
	    lista.add(new Persona("Juan",19));
	    lista.add(new Persona("Ana",23));
	    lista.add(new Persona("Pepe",30));
	    lista.add(null);
	    lista.add(new Persona("Blanca",42));
	    lista.add(null);
	    lista.add(new Persona("David",21));
	    
	    lista.stream()
	    			.filter(Objects::nonNull)
	    				.map(Persona::getNombre)
	    					.forEach(System.out::println);
	}
}
