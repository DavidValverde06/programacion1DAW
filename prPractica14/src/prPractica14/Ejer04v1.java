package prPractica14;

import java.awt.*;
import javax.swing.*;

public class Ejer04v1 {

	public static void main(String[] args) {

		JFrame f = new JFrame("Ejercicio 04v1");

		Container contenPane = f.getContentPane();
		ButtonGroup grupoBotones = new ButtonGroup();

		JRadioButton radioBoton1 = new JRadioButton("Hombre",false);
		JRadioButton radioBoton2 = new JRadioButton("Mujer",true);

		grupoBotones.add(radioBoton1);
		grupoBotones.add(radioBoton2);

		JButton botonNorte = new JButton("Norte");
		JButton botonSur = new JButton("Sur");
		JButton botonCentro = new JButton("Centro");
		JButton botonEste = new JButton("Este");

		JPanel radioButtons = new JPanel(new GridLayout(2,1));
		radioButtons.add(radioBoton1);
		radioButtons.add(radioBoton2);

		contenPane.add(botonNorte,BorderLayout.NORTH);
		contenPane.add(botonSur,BorderLayout.SOUTH);
		contenPane.add(botonEste,BorderLayout.EAST);
		contenPane.add(botonCentro,BorderLayout.CENTER);
		contenPane.add(radioButtons,BorderLayout.WEST);

		f.pack();

		f.setVisible(true);

		f.setLocationRelativeTo(null);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
