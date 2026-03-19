package prPractica19;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Ejer03 extends JFrame implements ItemListener {

	private static final long serialVersionUID = -4718360930946053300L;

	// Variables de instancia
	private JCheckBox chMelon;
	private JCheckBox chNaranja;
	private JCheckBox chPlatano;
	private JCheckBox chManzana;
	private JTextArea textoArea;

	// Constructor
	public Ejer03() {

		super("Prueba eventos del tipo ItemEvent");

		Container cp = this.getContentPane();

		JPanel panelPrincipal = new JPanel(new BorderLayout());

		JPanel panelCheckBox = new JPanel(new GridLayout(4,1));

		chMelon = new JCheckBox("Melón");
		chNaranja = new JCheckBox("Naranja");
		chPlatano = new JCheckBox("Plátano",true);
		chManzana = new JCheckBox("Manzana",true);

		panelCheckBox.add(chMelon);
		panelCheckBox.add(chNaranja);
		panelCheckBox.add(chPlatano);
		panelCheckBox.add(chManzana);

		chMelon.addItemListener(this);
		chNaranja.addItemListener(this);
		chPlatano.addItemListener(this);
		chManzana.addItemListener(this);

		textoArea = new JTextArea();
		textoArea.setEditable(false);

		JScrollPane panelTextArea = new JScrollPane(textoArea);

		panelPrincipal.setBorder(new EmptyBorder(20,20,20,20));

		// Añadir todo al Panel Principal
		panelPrincipal.add(panelCheckBox,BorderLayout.WEST);
		panelPrincipal.add(panelTextArea,BorderLayout.CENTER);

		cp.add(panelPrincipal,BorderLayout.CENTER);
	}

	public static void main(String[] args) {

		Ejer03 ventana = new Ejer03();

		// ventana.setResizable(false);

		ventana.pack();

		ventana.setVisible(true);

		ventana.setSize(300,250);

		ventana.setLocationRelativeTo(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		JCheckBox check = (JCheckBox)e.getSource();
		String estado = "";

		if (e.getStateChange() == ItemEvent.SELECTED) {
			estado = "Seleccionado";
		}
		else {
			estado = "No seleccionado";
		}

		textoArea.append("Componente: " + check.getText() +
				"\nEstado actual: " + check.isSelected() +
				"\nEstado actual: " + e.getStateChange() +
				"\n" + estado + "\n\n");
	}

}
