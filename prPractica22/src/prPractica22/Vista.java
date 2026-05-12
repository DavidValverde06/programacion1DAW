package prPractica22;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Vista extends JPanel {

	private static final long serialVersionUID = -501942644074193286L;

	// Variables de instancia
	private JTextField tfCalculadora;
	private JButton b1, b2, b3, b4, b5, b6, b7,
	b8, b9, bPuntoDecimal, b0, bIgual, bMas, bMenos, bMult, bDiv;

	// Getter's y setter's
	public JTextField getEtiquetaCalculadora() {return tfCalculadora;}
	public JButton getbUno() {return b1;}
	public JButton getbDos() {return b2;}
	public JButton getbTres() {return b3;}
	public JButton getbCuatro() {return b4;}
	public JButton getbCinco() {return b5;}
	public JButton getbSeis() {return b6;}
	public JButton getbSiete() {return b7;}
	public JButton getbOcho() {return b8;}
	public JButton getbNueve() {return b9;}
	public JButton getbPuntoDecimal() {return bPuntoDecimal;}
	public JButton getbCero() {return b0;}
	public JButton getbIgual() {return bIgual;}
	public JButton getbMas() {return bMas;}
	public JButton getbMenos() {return bMenos;}
	public JButton getbMult() {return bMult;}
	public JButton getbDiv() {return bDiv;}

	// Constructor
	public Vista() {
		// Panel Principal
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		panelPrincipal.setBorder(new EmptyBorder(0,50,50,50));

		// Panel Numerico
		JPanel panelNumerico = prepararPanelNumerico();

		// Panel Operaciones
		JPanel panelOperaciones = prepararPanelOperaciones();

		// Panel Sur
		JPanel panelSur = new JPanel();

		panelSur.add(panelNumerico,BorderLayout.EAST);
		panelSur.add(panelOperaciones,BorderLayout.WEST);

		// Panel Norte
		JPanel panelNorte = new JPanel();

		tfCalculadora = new JTextField(10);
		// tfCalculadora.setEditable(false);
		// tfCalculadora.setBackground(Color.WHITE);
		panelNorte.setBorder(new TitledBorder("Resultado"));

		panelNorte.add(tfCalculadora);

		// Añadir todo al Panel Principal
		panelPrincipal.add(panelNorte);
		panelPrincipal.add(panelSur);

		this.add(panelPrincipal);
	}

	private JPanel prepararPanelOperaciones() {
		JPanel panelOperaciones = new JPanel(new GridLayout(4,1));
		bMas = new JButton("+");
		bMenos = new JButton("-");
		bMult = new JButton("*");
		bDiv = new JButton("/");

		panelOperaciones.add(bMas);
		panelOperaciones.add(bMenos);
		panelOperaciones.add(bMult);
		panelOperaciones.add(bDiv);
		return panelOperaciones;
	}

	private JPanel prepararPanelNumerico() {
		JPanel panelNumerico = new JPanel(new GridLayout(4,3));
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");

		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");

		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");

		bPuntoDecimal = new JButton(".");
		b0 = new JButton("0");
		bIgual = new JButton("=");

		panelNumerico.add(b1);
		panelNumerico.add(b2);
		panelNumerico.add(b3);

		panelNumerico.add(b4);
		panelNumerico.add(b5);
		panelNumerico.add(b6);

		panelNumerico.add(b7);
		panelNumerico.add(b8);
		panelNumerico.add(b9);

		panelNumerico.add(bPuntoDecimal);
		panelNumerico.add(b0);
		panelNumerico.add(bIgual);

		// Color a los botones
		b0.setBackground(Color.CYAN);
		b1.setBackground(Color.CYAN);
		b2.setBackground(Color.CYAN);
		b3.setBackground(Color.CYAN);
		b4.setBackground(Color.CYAN);
		b5.setBackground(Color.CYAN);
		b6.setBackground(Color.CYAN);
		b7.setBackground(Color.CYAN);
		b8.setBackground(Color.CYAN);
		b9.setBackground(Color.CYAN);
		return panelNumerico;
	}

}
