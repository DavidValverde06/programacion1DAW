package ejemplos;

import java.util.*;

public class Ejemplo1 {

	public static void main(String[] args) {

		// Lista Números
		LinkedList<Integer> listaNum = new LinkedList<>();
		listaNum.add(9);
		listaNum.add(12);

		System.out.println(listaNum);

		// Lista Objetos
		List<Object> listaObjetos = new ArrayList<>();
		listaObjetos.add(19);
		listaObjetos.add("Hola que tal");
		listaObjetos.add(12.98);
		listaObjetos.add('A');
		listaObjetos.add(new Cuenta(23345, "Pepe Garcia", 8000, 1234));
		listaObjetos.add(99);

		System.out.println(listaObjetos);

		System.out.println("\n");

		System.out.println("Lista recorrida con foreach: ");
		for (Object object : listaObjetos) {
			if (object instanceof Cuenta) 
				System.out.println(((Cuenta) object).getNumCuenta());
			else
				System.out.println(object);
		}

		System.out.println("\nLista recorrida con iterator: ");
		Iterator<Object> it = listaObjetos.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
