package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import controlador.*;
import modelo.*;

public class Vista extends JPanel {

	private static final long serialVersionUID = -646384259955590475L;

	/**
	 * Variables de instancia
	 */
	private JComboBox<TipoPropiedad> miComboTipoPropiedad;
	private JComboBox<TipoVivienda> miComboTipoVivienda;
	private JComboBox<TipoTerreno> miComboTipoTerreno;
	private JComboBox<Integer> miComboNumBanios, miComboNumDormitorios;
	private JTextField tfCodigo, tfPrecio, tfSuperficie, tfDireccion;
	private JTextArea taDescripcion;
	private JRadioButton rbSuministroElecSi, rbSuministroElecNo, rbSuministroAguaSi, rbSuministroAguaNo, rbDisponeViviendaSi, rbDisponeViviendaNo;
	private JButton bGuardar, bConsultar, bBorrar, bLimpiar;

	/**
	 * Constructor
	 */
	public Vista() {
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

		// Panel Datos Generales
		JPanel panelDatosGenerales = prepararPanelDatosGeneral();

		// Panel Datos Especificos Para Vivienda
		JPanel panelDatosEspecificosVivienda = prepararPanelDatosEspecificosViv();

		// Panel Datos Especificos Para Finca
		JPanel panelDatosEspecificosFinca = prepararDatosEspecificosFinca();

		// Operaciones Disponibles Sobre Propiedades
		JPanel panelOperacionesDisponibles = prepararPanelOperacionesDisponibles();

		// Añadir Paneles Al Panel Principal
		panelPrincipal.add(panelDatosGenerales);
		panelPrincipal.add(panelDatosEspecificosVivienda);
		panelPrincipal.add(panelDatosEspecificosFinca);
		panelPrincipal.add(panelOperacionesDisponibles);

		this.add(panelPrincipal);
	}

	// ------------------------------------------------ //
	// Preparar Panel Operaciones Disponibles (Botones) //
	// ------------------------------------------------ //
	private JPanel prepararPanelOperacionesDisponibles() {
		JPanel panelOperacionesDisponibles = new JPanel(new GridLayout(1,4,5,5));
		ponerBordePanel(panelOperacionesDisponibles, "Operaciones disponibles sobre propiedades");

		bGuardar = new JButton("Guardar");
		bConsultar = new JButton("Consultar");
		bBorrar = new JButton("Borrar");
		bLimpiar = new JButton("Limpiar");

		panelOperacionesDisponibles.add(bGuardar);
		panelOperacionesDisponibles.add(bConsultar);
		panelOperacionesDisponibles.add(bBorrar);
		panelOperacionesDisponibles.add(bLimpiar);

		return panelOperacionesDisponibles;
	}

	// -------------------------------------- //
	// Preparar Panel Datos Especificos Finca //
	// -------------------------------------- //
	private JPanel prepararDatosEspecificosFinca() {
		// Panel Principal
		JPanel panelDatosEspecificosFinca = new JPanel();
		panelDatosEspecificosFinca.setLayout(new BoxLayout(panelDatosEspecificosFinca, BoxLayout.Y_AXIS));
		ponerBordePanel(panelDatosEspecificosFinca, "Datos específicos para fincas rústicas");

		// Primer Panel (Tipo Terreno)
		JPanel panelFinca1 = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JLabel etiquetaTipoTerreno = new JLabel("Tipo terreno:");
		miComboTipoTerreno = new JComboBox<TipoTerreno>(TipoTerreno.values());

		panelFinca1.add(etiquetaTipoTerreno);
		panelFinca1.add(miComboTipoTerreno);

		// Segundo Panel (Suministro Eléctrico)
		JPanel panelFinca2 = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JLabel etiquetaSuministroElec = new JLabel("Suministro eléctrico:");
		rbSuministroElecSi = new JRadioButton("Si",true);
		rbSuministroElecNo = new JRadioButton("No");

		ButtonGroup grupoElec = new ButtonGroup();
		grupoElec.add(rbSuministroElecSi);
		grupoElec.add(rbSuministroElecNo);

		panelFinca2.add(etiquetaSuministroElec);
		panelFinca2.add(rbSuministroElecSi);
		panelFinca2.add(rbSuministroElecNo);

		// Tercer Panel (Suministro Agua)
		JPanel panelFinca3 = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JLabel etiquetaSuministroAgua = new JLabel("Suministro de agua:  ");
		rbSuministroAguaSi = new JRadioButton("Si",true);
		rbSuministroAguaNo = new JRadioButton("No");

		ButtonGroup grupoAgua = new ButtonGroup();
		grupoAgua.add(rbSuministroAguaSi);
		grupoAgua.add(rbSuministroAguaNo);

		panelFinca3.add(etiquetaSuministroAgua);
		panelFinca3.add(rbSuministroAguaSi);
		panelFinca3.add(rbSuministroAguaNo);

		// Cuarto Panel (Dispone de Vivienda)
		JPanel panelFinca4 = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JLabel etiquetaDisponeViv = new JLabel("Dispone de vivienda:");
		rbDisponeViviendaSi = new JRadioButton("Si",true);
		rbDisponeViviendaNo = new JRadioButton("No");

		ButtonGroup grupoViv = new ButtonGroup();
		grupoViv.add(rbDisponeViviendaSi);
		grupoViv.add(rbDisponeViviendaNo);

		panelFinca4.add(etiquetaDisponeViv);
		panelFinca4.add(rbDisponeViviendaSi);
		panelFinca4.add(rbDisponeViviendaNo);

		// Añadir todos los Subpaneles al Panel Principal
		panelDatosEspecificosFinca.add(panelFinca1);
		panelDatosEspecificosFinca.add(panelFinca2);
		panelDatosEspecificosFinca.add(panelFinca3);
		panelDatosEspecificosFinca.add(panelFinca4);

		return panelDatosEspecificosFinca;
	}

	// ----------------------------------------- //
	// Preparar Panel Datos Especificos Vivienda //
	// ----------------------------------------- //
	private JPanel prepararPanelDatosEspecificosViv() {
		JPanel panelDatosEspecificosVivienda = new JPanel(new FlowLayout());
		ponerBordePanel(panelDatosEspecificosVivienda, "Datos específicos para vivienda");

		JLabel etiquetaTipoViv = new JLabel("Tipo de vivienda:");

		miComboTipoVivienda = new JComboBox<TipoVivienda>(TipoVivienda.values());
		miComboTipoVivienda.setEnabled(false); // Deshabilitar al inicio del programa

		JLabel etiquetaNumDorm = new JLabel("Número de dormitorios:");

		Integer[] arrayNumDorm = {1,2,3,4,5,6,7,8};
		miComboNumDormitorios = new JComboBox<Integer>(arrayNumDorm);
		miComboNumDormitorios.setEnabled(false); // Deshabilitar al inicio del programa

		JLabel etiquetaNumBanios = new JLabel("Número de baños:");

		Integer[] arrayNumBanios = {1,2,3,4,5,6};
		miComboNumBanios = new JComboBox<Integer>(arrayNumBanios);
		miComboNumBanios.setEnabled(false); // Deshabilitar al inicio del programa

		panelDatosEspecificosVivienda.add(etiquetaTipoViv);
		panelDatosEspecificosVivienda.add(miComboTipoVivienda);
		panelDatosEspecificosVivienda.add(etiquetaNumDorm);
		panelDatosEspecificosVivienda.add(miComboNumDormitorios);
		panelDatosEspecificosVivienda.add(etiquetaNumBanios);
		panelDatosEspecificosVivienda.add(miComboNumBanios);

		return panelDatosEspecificosVivienda;
	}

	// ------------------------------ //
	// Preparar Panel Datos Generales //
	// ------------------------------ //
	private JPanel prepararPanelDatosGeneral() {
		JPanel panelDatosGenerales = new JPanel();
		panelDatosGenerales.setLayout(new BoxLayout(panelDatosGenerales, BoxLayout.Y_AXIS));
		ponerBordePanel(panelDatosGenerales, "Datos generales");

		// Primer Panel
		JPanel panelGeneral1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel etiquetaCod = new JLabel("Código:");
		tfCodigo = new JTextField(3);

		JLabel etiquetaTipoPropiedad = new JLabel("Tipo propiedad:");

		miComboTipoPropiedad = new JComboBox<TipoPropiedad>(TipoPropiedad.values());
		miComboTipoPropiedad.setSelectedIndex(3); // Seleccionar FINCA por defecto al inicio del programa

		JLabel etiquetaPrecio = new JLabel("Precio:");
		tfPrecio = new JTextField(7);
		tfPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		tfPrecio.setText("0");

		JLabel etiquetaSuperficie = new JLabel("Superficie:");
		tfSuperficie = new JTextField(3);
		tfSuperficie.setHorizontalAlignment(SwingConstants.RIGHT);
		tfSuperficie.setText("0");

		panelGeneral1.add(etiquetaCod);
		panelGeneral1.add(tfCodigo);
		panelGeneral1.add(etiquetaTipoPropiedad);
		panelGeneral1.add(miComboTipoPropiedad);
		panelGeneral1.add(etiquetaPrecio);
		panelGeneral1.add(tfPrecio);
		panelGeneral1.add(etiquetaSuperficie);
		panelGeneral1.add(tfSuperficie);

		// Segundo Panel
		JPanel panelGeneral2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel etiquetaDireccion = new JLabel("Dirección:");
		tfDireccion = new JTextField(37);
		panelGeneral2.add(etiquetaDireccion);
		panelGeneral2.add(tfDireccion);

		// Tercer Panel
		JPanel panelGeneral3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel etiquetaDescripcion = new JLabel("Descripción:");
		taDescripcion = new JTextArea(3,40);
		taDescripcion.setBorder(new LineBorder(Color.GRAY));
		panelGeneral3.add(etiquetaDescripcion);
		panelGeneral3.add(taDescripcion);


		panelDatosGenerales.add(panelGeneral1);
		panelDatosGenerales.add(panelGeneral2);
		panelDatosGenerales.add(panelGeneral3);

		return panelDatosGenerales;
	}

	/**
	 * Método Para Poner Bordes Paneles
	 */
	public void ponerBordePanel(JPanel panel, String textoDelBorde) {
		panel.setBorder(new CompoundBorder(
				new EmptyBorder(5,5,5,5),
				new TitledBorder(new LineBorder(Color.gray,1,true),textoDelBorde))
				);
	}

	/**
	 * Métodos Getter
	 */
	public JComboBox<TipoPropiedad> getMiComboTipoPropiedad() {
		return miComboTipoPropiedad;
	}

	public JComboBox<TipoVivienda> getMiComboTipoVivienda() {
		return miComboTipoVivienda;
	}

	public JComboBox<TipoTerreno> getMiComboTipoTerreno() {
		return miComboTipoTerreno;
	}

	public JComboBox<Integer> getMiComboNumBanios() {
		return miComboNumBanios;
	}

	public JComboBox<Integer> getMiComboNumDormitorios() {
		return miComboNumDormitorios;
	}

	public JTextField getTfCodigo() {
		return tfCodigo;
	}

	public JTextField getTfPrecio() {
		return tfPrecio;
	}

	public JTextField getTfSuperficie() {
		return tfSuperficie;
	}

	public JTextField getTfDireccion() {
		return tfDireccion;
	}

	public JTextArea getTaDescripcion() {
		return taDescripcion;
	}

	public JRadioButton getRbSuministroElecSi() {
		return rbSuministroElecSi;
	}

	public JRadioButton getRbSuministroElecNo() {
		return rbSuministroElecNo;
	}

	public JRadioButton getRbSuministroAguaSi() {
		return rbSuministroAguaSi;
	}

	public JRadioButton getRbSuministroAguaNo() {
		return rbSuministroAguaNo;
	}

	public JRadioButton getRbDisponeViviendaSi() {
		return rbDisponeViviendaSi;
	}

	public JRadioButton getRbDisponeViviendaNo() {
		return rbDisponeViviendaNo;
	}

	public JButton getbGuardar() {
		return bGuardar;
	}

	public JButton getbConsultar() {
		return bConsultar;
	}

	public JButton getbBorrar() {
		return bBorrar;
	}

	public JButton getbLimpiar() {
		return bLimpiar;
	}

	/**
	 * Método se encarga de añadir el control de los 
	 * eventos a los componentes
	 */
	public void control(Controlador ctr) {
		// JComboBox
		this.miComboTipoPropiedad.addItemListener(ctr);

		this.miComboTipoVivienda.addItemListener(ctr);
		this.miComboNumDormitorios.addItemListener(ctr);
		this.miComboNumBanios.addItemListener(ctr);

		this.miComboTipoTerreno.addItemListener(ctr);

		// JRadioButton
		this.rbSuministroElecSi.addActionListener(ctr);
		this.rbSuministroElecNo.addActionListener(ctr);

		this.rbSuministroAguaSi.addActionListener(ctr);
		this.rbSuministroAguaNo.addActionListener(ctr);

		this.rbDisponeViviendaSi.addActionListener(ctr);
		this.rbDisponeViviendaNo.addActionListener(ctr);

		// JButton
		this.bGuardar.addActionListener(ctr);
		this.bConsultar.addActionListener(ctr);
		this.bBorrar.addActionListener(ctr);
		this.bLimpiar.addActionListener(ctr);

	}
}
