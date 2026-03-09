package awt;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ejer04v1 {

	public static void main(String[] args) {

		JFrame f = new JFrame("Ejercicio 04v1");

		Container contenPane = f.getContentPane();

		ButtonGroup grupoBotones = new ButtonGroup();
		
		JRadioButton radioBoton1 = new JRadioButton("Hombre");
		JRadioButton radioBoton2 = new JRadioButton("Mujer");
		
		grupoBotones.add(radioBoton1);
		grupoBotones.add(radioBoton2);
		
		JButton botonSur = new JButton("Sur");

		JPanel p = new JPanel(new GridLayout(2,1));
		p.add(radioBoton1);
		p.add(radioBoton2);

		contenPane.add(new JButton("Norte"),BorderLayout.NORTH);
		contenPane.add(botonSur,BorderLayout.SOUTH);
		contenPane.add(new JButton("Este"),BorderLayout.EAST);
		contenPane.add(new JButton("Centro"),BorderLayout.CENTER);
		contenPane.add(p,BorderLayout.WEST);

		f.pack();

		f.setVisible(true);

		f.setLocationRelativeTo(null);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
