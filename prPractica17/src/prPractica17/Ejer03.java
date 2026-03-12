package prPractica17;

import java.awt.*;
import javax.swing.*;

public class Ejer03 extends JFrame {

	private static final long serialVersionUID = -3693294239360638393L;

	public Ejer03() {

		super("Ejer03");
	}

	public static void main(String[] args) {
		Ejer03 ventana = new Ejer03();

		// ventana.setResizable(false);

		ventana.pack();

		ventana.setVisible(true);

		ventana.setSize(400,200);

		ventana.setLocationRelativeTo(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
