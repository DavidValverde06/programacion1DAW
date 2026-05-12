package prPracticaRepaso01;

import java.util.Scanner;

/**
 * 20. Escribe un programa que incremente la hora de un reloj. Se pedirán por teclado la hora, minutos y
		segundos, así como cuántos segundos se desea incrementar la hora introducida. La aplicación
		mostrará la nueva hora. Por ejemplo, si las 13:59:51 se incrementan en 10 segundos, resultan las
		14:00:01.
 */

public class Ejercicioo20 {

	public static void main(String[] args) throws InterruptedException {

		Scanner sc = new Scanner(System.in);

		int horas,minutos,segundos,segundosIncrementados;

		System.out.print("Hora: ");
		horas=sc.nextInt();
		if (horas<0||horas>23) {
			System.out.println("ERROR. INTRODUCE UNA HORA VÁLIDA");
		}
		else {
			System.out.print("Minutos: ");
			minutos=sc.nextInt();	
			if (minutos<0||minutos>59) {
				System.out.println("ERROR. INTRODUCE UNOS MINUTOS VÁLIDOS");
			}
			else {
				System.out.print("Segundos: ");
				segundos=sc.nextInt();
				if (segundos<0||segundos>59) {
					System.out.println("ERROR. INTRODUCE UNOS SEGUNDOS VÁLIDOS");
				}
				else {

					// Incrementar segundos a la hora
					System.out.print("\nIntroduce cuántos segundos quieres incrementar: ");
					segundosIncrementados=sc.nextInt();
										
					segundos += segundosIncrementados;

					minutos += segundos / 60;
					segundos = segundos % 60;

					horas += minutos / 60;
					minutos = minutos % 60;

					horas = horas % 24;
					// Fin de incrementar segundos a la hora

					for (int cont=0;cont>=0;cont++) {
						Thread.sleep(500);
						System.out.printf("%02d:%02d:%02d%n", horas, minutos, segundos);
						segundos++;

						if (segundos>59) {
							minutos++;
							segundos=0;

							if (minutos>59) {
								minutos=0;
								horas++;

								if (horas>23) {
									horas=0;
								}
							}
						}
					}
				}
			}
		}

		sc.close();

	}
}
