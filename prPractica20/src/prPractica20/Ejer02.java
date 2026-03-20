package prPractica20;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class Ejer02 extends JFrame implements ItemListener, ListSelectionListener {

	private static final long serialVersionUID = 5910160919994252374L;

	// Variables de instancia
	private JCheckBox chDiesel;
	private JCheckBox chAsientosDeportivos;
	private JCheckBox chTapiceria;
	private JCheckBox chLLantasAleacion;
	private JCheckBox chPintura;

	private JComboBox<String> comboNumLlantas;
	private JList<String> listaColores;

	private JLabel etiquetaInfo;

	// Constructor
	public Ejer02() {

		super("Prueba de eventos");

		Container cp = this.getContentPane();
		cp.setLayout(new FlowLayout());

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout((new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS)));

		// Panel Extras
		JPanel panelExtras = new JPanel(new GridLayout(5,1));
		panelExtras.setBorder(new CompoundBorder(
				new TitledBorder("Elija extras"),null));

		chDiesel = new JCheckBox("Diesel",true);
		chAsientosDeportivos = new JCheckBox("Asientos deportivos",true);
		chTapiceria = new JCheckBox("Tapicería de cuero",true);

		chTapiceria.setEnabled(false);

		chLLantasAleacion = new JCheckBox("Llantas de aleación");
		chPintura = new JCheckBox("Pintura metalizada",true);

		// Añadir ItemListener
		chDiesel.addItemListener(this);
		chAsientosDeportivos.addItemListener(this);
		chTapiceria.addItemListener(this);
		chLLantasAleacion.addItemListener(this);
		chPintura.addItemListener(this);

		panelExtras.add(chDiesel);
		panelExtras.add(chAsientosDeportivos);
		panelExtras.add(chTapiceria);
		panelExtras.add(chLLantasAleacion);
		panelExtras.add(chPintura);

		// Panel Número Llantas
		JPanel panelLlantas = new JPanel();
		panelLlantas.setPreferredSize(new Dimension(270,60));
		panelLlantas.setBorder(new CompoundBorder(
				new TitledBorder("Elija número de llantas"),null));

		String [] arrayLlantas = {"Tres radios","Cinco radios","Siete radios","Nueve radios"};
		comboNumLlantas = new JComboBox<String>(arrayLlantas);
		comboNumLlantas.setEnabled(false);

		panelLlantas.add(comboNumLlantas);

		// Panel Color
		JPanel panelColor = new JPanel();
		panelColor.setBorder(new CompoundBorder(
				new TitledBorder("Elija color"),null));

		String[] arrayColores = {"Rojo","Verde","Azul"};
		listaColores = new JList<String>(arrayColores);

		JScrollPane scrollColor = new JScrollPane(listaColores);
		scrollColor.setPreferredSize(new Dimension(80,40));

		panelColor.add(scrollColor);

		// Panel Información
		JPanel panelInfo = new JPanel();
		panelInfo.setBorder(new CompoundBorder(
				new TitledBorder("Acciones realizadas"),null));

		etiquetaInfo = new JLabel("Información",JLabel.CENTER);
		etiquetaInfo.setForeground(Color.BLUE);

		panelInfo.add(etiquetaInfo);

		panelPrincipal.add(panelExtras,TOP_ALIGNMENT);
		panelPrincipal.add(panelLlantas,TOP_ALIGNMENT);
		panelPrincipal.add(panelColor,BOTTOM_ALIGNMENT);
		panelPrincipal.add(panelInfo,BOTTOM_ALIGNMENT);

		cp.add(panelPrincipal);

	}

	public static void main(String[] args) {

		Ejer02 ventana = new Ejer02();

		// ventana.setResizable(false);

		ventana.pack();

		ventana.setVisible(true);

		// ventana.setSize(300,200);

		ventana.setLocationRelativeTo(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}

	/**
	 * En cuanto al funcionamiento será el siguiente:
	 * - Si el elemento que ha generado el evento es “Llantas de aleación”, el combo se habilita en caso de
	 * que la caja de verificación esté seleccionada, o se deshabilita en caso de que la caja de verificación no
	 * esté seleccionada.
	 * 
	 * - La misma lógica se aplica con la caja de verificación “Pintura metalizada”, a través de la cual se
	 * controla si la lista desplegable con los colores se hace visible o no.
	 * 
	 * - La activación de la caja de verificación “Asientos Deportivos” controla el estado y la disponibilidad de
	 * la caja de verificación “Tapicería de cuero”, de esta manera, si la primera se selecciona, la segunda se
	 * selecciona automáticamente y se limita su disponibilidad.
	 * 
	 * - La etiqueta “Seleccionado” muestra en cada instante un texto relativo al elemento que ha sido
	 * seleccionado más recientemente, si lo que se ha seleccionado es un tipo de llanta o un color,
	 * también dará información al respecto
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JCheckBox checkPulsado = (JCheckBox) e.getSource();

		arreglar
		
		if (checkPulsado.getText().equals(chLLantasAleacion.getText()) && (checkPulsado.isEnabled())) {
			comboNumLlantas.setEnabled(true);
		}
		else {
			comboNumLlantas.setEnabled(false);
		}
	}

}
