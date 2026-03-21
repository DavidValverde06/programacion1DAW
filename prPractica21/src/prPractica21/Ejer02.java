package prPractica21;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 2.- En este segundo ejercicio os propongo que hagáis una pequeña aplicación para convertir de euros a
 * dólares y viceversa, así como desglosar una cantidad en billetes y monedas de euro. Inicialmente os
 * debe de aparecer un pequeño diálogo en el que solicitéis a cuánto está el cambio, si se pulsa Cancelar
 * en esta ventana pondremos el cambio a 1, es decir, supondremos que un euro vale igual que un dólar.
 */
public class Ejer02 extends JFrame implements ActionListener {

	private static final long serialVersionUID = -73357411103721974L;

	// Variables de instancia
	private JLabel etiquetaVisorResultado;
	private JTextField tfVisorResultado;

	private JButton bEuros;
	private JButton bDolares;
	private JButton bDesglosar;

	private JTextArea taAreaDesglose;

	// Constructor
	public Ejer02() {

		super("Conversor de euros/dolares");

		Container cp = this.getContentPane();

		JPanel panelPrincipal = new JPanel(new BorderLayout());

		JPanel panelDesgloseNorte = preparaPanelDesgloseNorte();

		JPanel panelDesgloseSur = preparaPanelDesgloseSur();

		panelPrincipal.add(panelDesgloseNorte,BorderLayout.NORTH);
		panelPrincipal.add(panelDesgloseSur,BorderLayout.SOUTH);

		taAreaDesglose = new JTextArea(10,10);
		JScrollPane panelAreaDesglose = new JScrollPane(taAreaDesglose);

		cp.add(panelPrincipal,BorderLayout.NORTH);
		cp.add(panelAreaDesglose,BorderLayout.CENTER);
	}

	// Panel Desglose Sur
	private JPanel preparaPanelDesgloseSur() {
		JPanel panelDesgloseSur = new JPanel(new FlowLayout());

		bEuros = new JButton("A euros");
		bDolares = new JButton("A dolares");
		bDesglosar = new JButton("Desglosar");

		// Cambiar font a los botones
		bEuros.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 25));
		bEuros.setForeground(Color.BLUE);

		bDolares.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 25));
		bDolares.setForeground(Color.BLUE);

		bDesglosar.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 25));
		bDesglosar.setForeground(Color.BLUE);

		panelDesgloseSur.add(bEuros);
		panelDesgloseSur.add(bDolares);
		panelDesgloseSur.add(bDesglosar);
		return panelDesgloseSur;
	}

	// Panel Desglose Norte
	private JPanel preparaPanelDesgloseNorte() {
		JPanel panelDesgloseNorte = new JPanel(new FlowLayout());

		etiquetaVisorResultado = new JLabel("Visor de resultado");
		tfVisorResultado = new JTextField(15);

		panelDesgloseNorte.add(etiquetaVisorResultado);
		panelDesgloseNorte.add(tfVisorResultado);
		return panelDesgloseNorte;
	}

	public static void main(String[] args) {

		double cambioDivisa = Double.parseDouble(JOptionPane.showInputDialog("Indique cambio a dolar")); 

		Ejer02 ventana = new Ejer02();

		ventana.setResizable(false);

		ventana.pack();

		ventana.setVisible(true);

		// ventana.setSize(400,300);

		ventana.setLocationRelativeTo(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
