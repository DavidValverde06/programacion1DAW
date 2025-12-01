package urna;

/**
 * Una vez desarrollada esta clase, para su testeo realizaremos un programa que haga lo siguiente:
 * mientras en la urna quede más de una bola, sacar dos bolas de la
 * misma. 
 * Si ambas son blancas, introducir una bola roja en la urna.
 * Si ambas son iguales, menos blancas, introducir una bola del mismo color en la urna.
 * Y si son distintas se mete una bola blanca.
 * Finalmente se extrae la última bola que queda y se indica su color.
 */

public class TestUrnaDeTresColores {

	public static void main(String[] args) {

		char bola1,bola2;

		UrnaDeTresColores urnaPrueba = new UrnaDeTresColores(1,4,6);

		while (urnaPrueba.quedaMasDeUnaBola()) {

			System.out.println(urnaPrueba);

			bola1=urnaPrueba.sacaBola();
			bola2=urnaPrueba.sacaBola();

			System.out.println("Se han sacado de la urna una bola " + bola1 + " y una bola " + bola2);

			if (bola1=='B' && bola2=='B') {
				System.out.println("Las dos bolas son blancas. Se ha introducido una bola roja.");
				urnaPrueba.meteBola('R');
			}
			else if (bola1==bola2){
				System.out.println("Las bolas son iguales. Se ha introducido una bola del mismo color.");
				urnaPrueba.meteBola(bola1);
			}
			else {
				System.out.println("Las bolas son distintas. Se ha introducido una bola blanca.");
				urnaPrueba.meteBola('B');
			}
		}

		System.out.println(urnaPrueba);

		if (urnaPrueba.getBolasBlancas()==1) {
			System.out.println("Queda una bola blanca");
		}
		else if (urnaPrueba.getBolasRojas()==1){
			System.out.println("Queda una bola roja");
		}
		else {
			System.out.println("Queda una bola negra");
		}
	}
}
