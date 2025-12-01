package urna;

public class TestUrnaTrampa {

	public static void main(String[] args) {

		char bola1,bola2;

		UrnaTrampa urnaPrueba = new UrnaTrampa(4, 1);

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
	}

}
