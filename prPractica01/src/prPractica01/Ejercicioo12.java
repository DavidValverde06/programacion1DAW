package prPractica01;

import java.util.Scanner;

/**
 * 12.- Escribir un programa que calcule el salario semanal de un trabajador, dada la tarifa horaria por horas y
		el número de horas trabajadas. Además, hay que tener en cuenta que se le practica una retención del
		4% para la S.S. y del 7% para el IRPF. Es decir, solicitaremos por teclado, cuánto cobra por hora (tarifa
		horaria), así como las horas trabajadas, y mostraremos por pantalla el sueldo semanal del trabajador
		según los datos proporcionados.
 */

public class Ejercicioo12 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		final float SS = 0.04f;
		final float IRPF = 0.07f;
		float salarioSemanal,tarifaHoraria,porcentajeSS,porcentajeIRPF;
		int numHoras;
		
		System.out.print("Tarifa horaria: ");
		tarifaHoraria=sc.nextFloat();
		
		System.out.print("Horas trabajadas: ");
		numHoras=sc.nextInt();
		
		salarioSemanal=tarifaHoraria*numHoras;
		
		System.out.println("Salario semanal: " + salarioSemanal + " €.");
		
		porcentajeSS=salarioSemanal*SS;
		
		porcentajeIRPF=salarioSemanal*IRPF;
		
		salarioSemanal= salarioSemanal-(porcentajeIRPF + porcentajeSS);
		
		System.out.println("Salario semanal restando porcentajes: " + salarioSemanal + " €.");
		
		sc.close();
		
	}

}
