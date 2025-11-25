package urna;

/**
 *  Utilizando un objeto de la clase anteriormente creada, realizar un programa para probarla que haga
 *  lo siguiente: 
 *  
 *  Mientras en la urna quede más de una bola, sacar dos bolas de la misma. 
 *  
 *  Si ambas son del mismo color, introducir una bola negra en la urna. 
 *  
 *  Si ambas son de distinto color, introducir una bola blanca en la urna.
 *  
 *  Extraer la última bola que queda y determinar su color.
 */

public class TestUrna {

	public static void main(String[] args) {
		
		char bola1,bola2;
		
		Urna urnaPrueba = new Urna(5, 4);
		
		while (urnaPrueba.quedaMasDeUnaBola()) {
			bola1=urnaPrueba.sacaBola();
			bola2=urnaPrueba.sacaBola();
			if (bola1==bola2) {
				urnaPrueba.meteBola('N');
			}
			else {
				urnaPrueba.meteBola('B');
			}
			
			System.out.println(urnaPrueba);
		}
		
//		Urna miUrna = new Urna(10, 10);
//		
//		System.out.println("Urna creada con 10 bolas blancas y 10 bolas negras");
//		System.out.println(miUrna);
//		
//		miUrna.sacaBola();
//		
//		System.out.println("Quitamos una bola al azar");
//		System.out.println(miUrna);
//		
//		miUrna.meteBola('N');
//		
//		System.out.println("Metemos una bola negra");
//		System.out.println(miUrna);
//		
//		miUrna.meteBola('B');
//		
//		System.out.println("Metemos una bola blanca");
//		System.out.println(miUrna);
	}

}
