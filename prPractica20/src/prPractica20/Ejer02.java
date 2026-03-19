package prPractica20;

import java.awt.*;
import javax.swing.*;

public class Ejer02 extends JFrame {

	private static final long serialVersionUID = 5910160919994252374L;

	// Variables de instancia

	// Constructor
	public Ejer02() {

		super("Prueba de eventos");


	}

	public static void main(String[] args) {

		Ejer02 ventana = new Ejer02();

		// ventana.setResizable(false);

		ventana.pack();

		ventana.setVisible(true);

		ventana.setSize(300,200);

		ventana.setLocationRelativeTo(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}

}
