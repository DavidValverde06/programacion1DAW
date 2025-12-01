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

		Urna urnaPrueba = new Urna(1, 4);

		while (urnaPrueba.quedaMasDeUnaBola()) {

			System.out.println(urnaPrueba);

			bola1=urnaPrueba.sacaBola();
			bola2=urnaPrueba.sacaBola();

			System.out.println("Se han sacado de la urna una bola " + bola1 + " y una bola " + bola2);

			if (bola1==bola2) {
				System.out.println("Las bolas son del mismo color, se ha introducido una bola negra.");
				urnaPrueba.meteBola('N');
			}
			else {
				System.out.println("Las bolas son de distinto color, se ha introducido una bola blanca.");
				urnaPrueba.meteBola('B');
			}
		}

		System.out.println(urnaPrueba);

		if (urnaPrueba.getBolasBlancas()==1) {
			System.out.println("Queda una bola blanca");
		}
		else {
			System.out.println("Queda una bola negra");
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
