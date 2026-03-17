package prPractica20;

import java.awt.*;
import javax.swing.*;

public class Ejer01v1 extends JFrame {

	private static final long serialVersionUID = 6798046005070034098L;

	// Variables de instancia


	// Constructor
	public Ejer01v1() {

		super("Pruebas KeyEvent");

		Container cp = this.getContentPane();
	}

	public static void main(String[] args) {

		Ejer01v1 ventana = new Ejer01v1();

		// ventana.setResizable(false);

		ventana.pack();

		ventana.setVisible(true);

		// ventana.setSize(300,250);

		ventana.setLocationRelativeTo(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
