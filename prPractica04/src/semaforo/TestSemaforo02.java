package semaforo;

public class TestSemaforo02 {

	public static void main(String[] args) {

		Semaforo miSemaforoVerde = new Semaforo("Verde");
		Semaforo miSemaforoAmarillo = new Semaforo("Amarillo");
		Semaforo miSemaforoRojo= new Semaforo("Rojo");
		
		System.out.println(miSemaforoVerde.getColor());
		System.out.println(miSemaforoVerde.puedoPasar()?"Puedes pasar":"No puedes pasar");

		System.out.println(); // Salto de línea
		
		System.out.println(miSemaforoAmarillo.getColor());
		System.out.println(miSemaforoAmarillo.puedoPasar()?"Puedes pasar":"No puedes pasar");

		System.out.println(); // Salto de línea
		
		System.out.println(miSemaforoRojo.getColor());
		System.out.println(miSemaforoRojo.puedoPasar()?"Puedes pasar":"No puedes pasar");
		
		System.out.println(); // Salto de línea
		
		System.out.println(miSemaforoVerde.toString());
		
		System.out.println(miSemaforoVerde.puedoPasar()?"Puedes pasar":"No puedes pasar");
		
		miSemaforoVerde.setColor("Rojo");
		
		System.out.println(); // Salto de línea
		
		System.out.println(miSemaforoVerde.toString());
		
		System.out.println(miSemaforoVerde.puedoPasar()?"Puedes pasar":"No puedes pasar");
	}

}
