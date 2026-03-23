package prPractica20;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
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

	private Map<String,Color> mapaColores;
	private JScrollPane scrollColor;

	// Constructor
	public Ejer02() {

		super("Prueba de eventos");

		Container cp = this.getContentPane();
		cp.setLayout(new FlowLayout());

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout((new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS)));

		// Panel Extras
		JPanel panelExtras = preparaPanelExtras();

		// Panel Número Llantas
		JPanel panelLlantas = preparaPanelLlantas();

		// Panel Color
		JPanel panelColor = preparaPanelColor();

		// Panel Información
		JPanel panelInfo = preparaPanelInfo();

		panelPrincipal.add(panelExtras);
		panelPrincipal.add(panelLlantas);
		panelPrincipal.add(panelColor);
		panelPrincipal.add(panelInfo);

		cp.add(panelPrincipal);

	}

	// Panel Información
	private JPanel preparaPanelInfo() {
		JPanel panelInfo = new JPanel();
		panelInfo.setBorder(new CompoundBorder(
				new TitledBorder("Acciones realizadas"),null));

		etiquetaInfo = new JLabel("Información",JLabel.CENTER);
		etiquetaInfo.setForeground(Color.BLUE);

		panelInfo.add(etiquetaInfo);

		return panelInfo;
	}

	// Panel Color
	private JPanel preparaPanelColor() {
		JPanel panelColor = new JPanel();
		panelColor.setPreferredSize(new Dimension(80,80));
		panelColor.setBorder(new CompoundBorder(
				new TitledBorder("Elija color"),null));

		// Primera forma -- Array de colores
		/**
		 * String[] arrayColores = {"Rojo","Verde","Azul"};
		 * listaColores = new JList<String>(arrayColores);
		 */

		// Segunda forma - Mapa de colores
		mapaColores = new HashMap<String,Color>();

		mapaColores.put("Rojo", Color.RED);
		mapaColores.put("Verde", Color.GREEN);
		mapaColores.put("Negro", Color.BLACK);
		mapaColores.put("Azul", Color.BLUE);
		mapaColores.put("Amarillo", Color.YELLOW);
		mapaColores.put("Naranja", Color.ORANGE);

		// Extraer las claves del mapa anterior y guardarlas en una coleccion tipo Vector
		Vector<String> listaClaves = new Vector<>(mapaColores.keySet());
		listaColores = new JList<String>(listaClaves);

		// Añadir ListSelectionListener
		listaColores.addListSelectionListener(this);

		scrollColor = new JScrollPane(listaColores);
		scrollColor.setPreferredSize(new Dimension(80,40));

		panelColor.add(scrollColor);

		return panelColor;
	}

	// Panel Número Llantas
	private JPanel preparaPanelLlantas() {
		JPanel panelLlantas = new JPanel();
		panelLlantas.setPreferredSize(new Dimension(270,60));
		panelLlantas.setBorder(new CompoundBorder(
				new TitledBorder("Elija número de llantas"),null));

		String[] arrayLlantas = {"Tres radios","Cinco radios","Siete radios","Nueve radios"};
		comboNumLlantas = new JComboBox<String>(arrayLlantas);
		comboNumLlantas.setEnabled(false);

		// Añadir ItemListener
		comboNumLlantas.addItemListener(this);

		panelLlantas.add(comboNumLlantas);

		return panelLlantas;
	}

	// Panel Extras
	private JPanel preparaPanelExtras() {
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

		return panelExtras;
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
		etiquetaInfo.setForeground(
				mapaColores.get(
						listaColores.getSelectedValue()));

		etiquetaInfo.setText("Color pintura: " + listaColores.getSelectedValue());
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		JCheckBox checkMarcado = (JCheckBox)e.getSource();

		etiquetaInfo.setForeground(Color.BLUE);

		// ComboBox Llantas
		if (e.getSource() == comboNumLlantas) {
			String llanta = (String)comboNumLlantas.getSelectedItem();
			etiquetaInfo.setText("Llantas: " + llanta);
			return;
		}

		/**
		 * Si el elemento que ha generado el evento es “Llantas de aleación”, el combo se habilita en caso de
		 * que la caja de verificación esté seleccionada, o se deshabilita en caso de que la caja de verificación no
		 * esté seleccionada.
		 */

		// Llantas de aleacion
		if (e.getStateChange() == ItemEvent.SELECTED && checkMarcado == chLLantasAleacion) {
			comboNumLlantas.setEnabled(true);
			etiquetaInfo.setText("LLantas de aleación");
		}
		else if (e.getStateChange() == ItemEvent.DESELECTED && checkMarcado == chLLantasAleacion) {
			comboNumLlantas.setEnabled(false);
			etiquetaInfo.setText("LLantas de aleación");
		}

		/**
		 * La misma lógica se aplica con la caja de verificación “Pintura metalizada”, a través de la cual se
		 * controla si la lista desplegable con los colores se hace visible o no.
		 */

		// Pintura metalizada
		if (e.getStateChange() == ItemEvent.SELECTED && checkMarcado == chPintura) {
			scrollColor.setVisible(true);
			etiquetaInfo.setText("Pintura metalizada");
		}
		else if (e.getStateChange() == ItemEvent.DESELECTED && checkMarcado == chPintura) {
			scrollColor.setVisible(false);
			etiquetaInfo.setText("Pintura metalizada");
		}

		/**
		 * La activación de la caja de verificación “Asientos Deportivos” controla el estado y la disponibilidad de
		 * la caja de verificación “Tapicería de cuero”, de esta manera, si la primera se selecciona, la segunda se
		 * selecciona automáticamente y se limita su disponibilidad.
		 */

		// Asientos deportivos
		if (e.getStateChange() == ItemEvent.SELECTED && checkMarcado == chAsientosDeportivos) {
			chTapiceria.setEnabled(false);
			chTapiceria.setSelected(true);
			etiquetaInfo.setText("Asientos deportivos");
		}
		else if (e.getStateChange() == ItemEvent.DESELECTED && checkMarcado == chAsientosDeportivos) {
			chTapiceria.setEnabled(true);
			chTapiceria.setSelected(false);
			etiquetaInfo.setText("Asientos deportivos");
		}

		/**
		 * La etiqueta “Seleccionado” muestra en cada instante un texto relativo al elemento que ha sido
		 * seleccionado más recientemente, si lo que se ha seleccionado es un tipo de llanta o un color,
		 * también dará información al respecto.
		 */

		// Diesel
		if (e.getStateChange() == ItemEvent.SELECTED && checkMarcado == chDiesel) {
			etiquetaInfo.setText("Diesel");
		}
		else if (e.getStateChange() == ItemEvent.DESELECTED && checkMarcado == chDiesel) {
			etiquetaInfo.setText("Diesel");
		}

		// Tapiceria de cuero
		if (e.getStateChange() == ItemEvent.SELECTED && checkMarcado == chTapiceria) {
			etiquetaInfo.setText("Tapicería de cuero");
		}
		else if (e.getStateChange() == ItemEvent.DESELECTED && checkMarcado == chTapiceria) {
			etiquetaInfo.setText("Tapicería de cuero");
		}

	}

}
