package ejercicio7;

import java.util.*;

/**
 * También podéis hacer un algoritmo que compruebe 
 * si una cadena está correctamente balanceada en paréntesis
 */
public class Ejercicio7v2 {

	public static void main(String[] args) { 
		
		Deque<String> pila = new LinkedList<>();
		
		String cadena = "((2+4)*(9-2))";
		
		try {
			for (int cont=0;cont<cadena.length();cont++) {
				if (cadena.charAt(cont)=='(') {
					pila.push("(");
				}
				else if (cadena.charAt(cont)==')') {
					pila.pop();
				}
			}
			
			System.out.println("La cadena está correctamente balanceada");
		}
		catch (Exception e) {
			System.out.println("La cadena no está correctamente balanceada");
		}
	}

}
