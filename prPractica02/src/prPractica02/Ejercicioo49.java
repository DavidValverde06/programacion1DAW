package prPractica02;

import java.util.Scanner;

/**
 * 49. Hacer un algoritmo que simule el funcionamiento de un reloj digital y que nos permita ponerlo en hora, 
	   es decir, al comenzar a ejecutar el programa nos preguntará si deseamos ponerlo en hora, si 
	   respondemos sí, nos pedirá la hora, minutos y segundos de partida, si respondemos no, comenzaremos 
	   en la 00:00:00. Este algoritmo nunca finalizará. 
 */

public class Ejercicioo49 {

	public static void main(String[] args) throws InterruptedException {

		Scanner sc = new Scanner(System.in);

		char validacion;
		int horas=0,minutos=0,segundos=0;

		System.out.print("¿Desea poner el reloj en hora (S/N)? ");
		validacion=sc.nextLine().charAt(0);
		if (validacion=='s') {
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
						for(int cont=0;cont>=0;cont++) {
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
		}
		else if (validacion=='n') {
			horas=00;
			minutos=00;
			segundos=00;

			for(int cont=0;cont>=0;cont++) {
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
		else {
			System.out.print("ERROR");
		}

		sc.close();
	}

}
