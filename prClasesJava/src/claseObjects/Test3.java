package claseObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Test3 {

	public static void main(String[] args) {
	    List<Persona> lista= new ArrayList<Persona>();
	    
	    lista.add(new Persona("Juan",19));
	    lista.add(new Persona("Ana",23));
	    lista.add(new Persona("Pepe",30));
	    lista.add(null);
	    lista.add(new Persona("Blanca",42));
	    lista.add(null);
	    lista.add(new Persona("David",21));
	    
	    for (Persona p:lista) {
	    	if (Objects.nonNull(p)) {
	    		System.out.println(p.getNombre());
	    	}
	    }
	}
}
