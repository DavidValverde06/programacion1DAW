package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Vista extends JPanel {

	private static final long serialVersionUID = -1642392824861419308L;

	/**
	 * Variables de instancia
	 */
	private JComboBox<String> miComboTipoPropiedad, miComboTipoVivienda, miComboTipoTerreno;
	private JComboBox<Integer> miComboNumBanios, miComboNumDormitorios;
	private JTextField tfCodigo, tfPrecio, tfSuperficie, tfDireccion;
	private JTextArea taDescripcion;
	private JRadioButton rbSuministroElec, rbSuministroAgua, rbDisponeVivienda;
	private JButton bGuardar, bConsultar, bBorrar, bLimpiar;

	/**
	 * Constructor
	 */
	public Vista() {
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

		// Panel Datos Generales
		JPanel panelDatosGenerales = new JPanel();


		// Panel Datos Especificos Para Vivienda
		JPanel panelDatosEspecificosVivienda = new JPanel(new FlowLayout());


		// Panel Datos Especificos Para Finca
		JPanel panelDatosEspecificosFinca = new JPanel();


		// Operaciones Disponibles Sobre Propiedades
		JPanel panelOperacionesDisponibles = new JPanel(new FlowLayout());
		ponerBordePanel(panelOperacionesDisponibles, "Operaciones disponibles sobre propiedades");

		bGuardar = new JButton("Guardar");
		bConsultar = new JButton("Consultar");
		bBorrar = new JButton("Borrar");
		bLimpiar = new JButton("Limpiar");

		panelOperacionesDisponibles.add(bGuardar);
		panelOperacionesDisponibles.add(bConsultar);
		panelOperacionesDisponibles.add(bBorrar);
		panelOperacionesDisponibles.add(bLimpiar);

		// Añadir Paneles Al Panel Principal
		panelPrincipal.add(panelOperacionesDisponibles);

		this.add(panelPrincipal);
	}

	/**
	 * Método Para Poner Bordes Paneles
	 */
	public void ponerBordePanel(JPanel panel, String textoDelBorde) {
		panel.setBorder(new CompoundBorder(new TitledBorder(textoDelBorde),null));
	}

	/**
	 * Métodos Getter
	 */

	/**
	 * Método se encarga de añadir el control de los 
	 * eventos a los componentes
	 */
	//	public void control(Controlador ctr) {
	//
	//	}
}
