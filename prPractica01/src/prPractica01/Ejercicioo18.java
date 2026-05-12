package prPractica01;

import java.util.Scanner;

/**
 * 18.- Diseñar un programa que, a partir de los tres puntos extremos (P1, P2 y P3) de un triángulo, calcule el
		área del mismo, de acuerdo con la siguiente fórmula:

 */

public class Ejercicioo18 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		double S1,S2,S3,T,area;
		
		int p1x=12;
		int p1y=10;
		int p2x=9;
		int p2y=15;
		int p3x=5;
		int p3y=2;
		
		S1= (Math.sqrt( Math.pow(p1x-p2x,2) + Math.pow(p1y-p2y,2)));
		S2= (Math.sqrt( Math.pow(p2x-p3x,2) + Math.pow(p2y-p3y,2)));
		S3= (Math.sqrt( Math.pow(p3x-p1x,2) + Math.pow(p3y-p1y,2)));
		
		T=(S1+S2+S3)/2;
		
		area=Math.sqrt(T*(T-S1)*(T-S2)*(T-S3));
		
		System.out.println("El area es: " + area);
		
		sc.close();
		
	}

}
