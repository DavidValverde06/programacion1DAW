package ejer02MVC;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class Vista extends JPanel {

	private static final long serialVersionUID = -8530435701843607586L;

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

	/**
	 * Getter's y setter's
	 */
	public JCheckBox getChDiesel() {
		return chDiesel;
	}

	public JCheckBox getChAsientosDeportivos() {
		return chAsientosDeportivos;
	}

	public JCheckBox getChTapiceria() {
		return chTapiceria;
	}

	public JCheckBox getChLLantasAleacion() {
		return chLLantasAleacion;
	}

	public JCheckBox getChPintura() {
		return chPintura;
	}

	public JComboBox<String> getComboNumLlantas() {
		return comboNumLlantas;
	}

	public JList<String> getListaColores() {
		return listaColores;
	}

	public JLabel getEtiquetaInfo() {
		return etiquetaInfo;
	}

	public Map<String, Color> getMapaColores() {
		return mapaColores;
	}

	public JScrollPane getScrollColor() {
		return scrollColor;
	}


	/**
	 * Constructor
	 */
	public Vista() {

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

		this.add(panelPrincipal);

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

		panelExtras.add(chDiesel);
		panelExtras.add(chAsientosDeportivos);
		panelExtras.add(chTapiceria);
		panelExtras.add(chLLantasAleacion);
		panelExtras.add(chPintura);

		return panelExtras;
	}

	/**
	 * Método que añade control a los componentes
	 */
	public void control(Controlador ctr) {

		this.listaColores.addListSelectionListener(ctr);		
		this.chDiesel.addItemListener(ctr);
		this.chAsientosDeportivos.addItemListener(ctr);
		this.chTapiceria.addItemListener(ctr);
		this.chLLantasAleacion.addItemListener(ctr);
		this.chPintura.addItemListener(ctr);
		this.comboNumLlantas.addItemListener(ctr);
	}
}
