package test;

import modelo.CuadradoMagico;

public class TestCuadradoMagico {

	public static void main(String[] args) {

		int dim = 3;
		CuadradoMagico miCuadrado = new CuadradoMagico();
		miCuadrado.muestraCuadrado(miCuadrado.generaCuadrado(dim));

	}

}
