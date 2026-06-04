package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import controlador.Controlador;

public class Vista extends JPanel{

	private static final long serialVersionUID = -5752211613049689258L;

	/**
	 * Variables de instancia
	 */
	private JComboBox<String> cbPlantas;
	private DefaultComboBoxModel<String> modeloCbPlantas;

	private JButton bInfo, bAñadirCarrito;
	private JComboBox<Integer> cbUnidades;

	private JTable tablaCompras;
	private DefaultTableModel modeloTablaCompras;

	private JButton bCancelarCompra, bFinalizarCompra;

	private JRadioButton rbTodas, rbPlantaEstandar, rbBonsai;

	private JTable tablaCatalogo;
	private DefaultTableModel modeloTablaCatalogo;

	/**
	 * Constructor
	 */
	public Vista() {

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		panelPrincipal.setBackground(Color.white);
		panelPrincipal.setBorder(new EmptyBorder(15,15,15,15));

		panelPrincipal.add(preparaPanelTitulo());
		panelPrincipal.add(preparaPanelCompras());
		panelPrincipal.add(preparaPanelCatalogo());

		this.setBackground(Color.white);
		this.add(panelPrincipal);
	}

	/**
	 * Método que se encarga de prepara el panel con el título y el logo
	 * @return
	 */
	private JPanel preparaPanelTitulo() {
		JPanel pTitulo = new JPanel();
		pTitulo.setBackground(Color.white);

		JLabel titulo = new JLabel("Viveros Naturaleza & Bonsáis", JLabel.CENTER);
		titulo.setForeground(Color.decode("#2A732E"));
		titulo.setFont(new Font("Comic Sans MS",Font.BOLD, 28));

		pTitulo.add(new JLabel(new ImageIcon("./img/logo.png")));
		pTitulo.add(titulo);

		return pTitulo;
	}

	/**
	 * Método que se encarga de prepara el panel de Compras
	 * @return
	 */
	private JPanel preparaPanelCompras() {

		JPanel p = new JPanel(new BorderLayout());
		p.setBackground(Color.white);
		p.setBorder(new TitledBorder("Área de compras de clientes"));

		p.add(preparaPNorte(), BorderLayout.NORTH);
		p.add(preparaPCentro(), BorderLayout.CENTER);

		// ---------------------------------------------
		// Prepara la parte sur de este panel de Compras
		// ---------------------------------------------
		JPanel pSur = new JPanel();
		pSur.setBackground(Color.white);
		bCancelarCompra = new JButton("Cancelar Compra");
		bFinalizarCompra = new JButton("Finalizar Compra");

		bCancelarCompra.setPreferredSize(new Dimension(150,25));
		bFinalizarCompra.setPreferredSize(new Dimension(150,25));

		pSur.add(bCancelarCompra);
		pSur.add(bFinalizarCompra);

		p.add(pSur, BorderLayout.SOUTH);

		return p;
	}

	/**
	 * Preparación del panel de la parte superior del panel de Compras
	 * @return
	 */
	private JPanel preparaPNorte() {

		JPanel pNorte = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		pNorte.setBackground(Color.white);

		// El comboBox de plantas tiene un DefaultComboBoxModel en su interior, ya que este objeto nos
		// va a permitir el uso de muchos más métodos para modificar el combo durante la ejecución
		modeloCbPlantas = new DefaultComboBoxModel<>();
		cbPlantas = new JComboBox<String>(modeloCbPlantas);
		cbPlantas.setPreferredSize(new Dimension(200,25));

		bInfo = new JButton("Información");

		cbUnidades = new JComboBox<Integer>();
		for (int i=1; i<=20; i++)
			cbUnidades.addItem(i);

		bAñadirCarrito = new JButton("Añadir al carrito");

		// Añadir todos los componentes al panel del norte
		pNorte.add(new JLabel("Planta"));
		pNorte.add(cbPlantas);
		pNorte.add(bInfo);
		pNorte.add(new JLabel("Unidades"));
		pNorte.add(cbUnidades);
		pNorte.add(bAñadirCarrito);

		return pNorte;
	}

	/**
	 * Preparación del panel de la parte central del panel de compras - JTable
	 * @return
	 */
	private JPanel preparaPCentro() {

		JPanel p = new JPanel();
		p.setBackground(Color.white);

		// Crear un objeto DefaultTableModel que estará dentro del JTable
		modeloTablaCompras = new DefaultTableModel();
		tablaCompras = new JTable(modeloTablaCompras);

		// Alinear los encabezados de las columnas a la izquierda
		JTableHeader header = tablaCompras.getTableHeader();
		DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
		headerRenderer.setHorizontalAlignment(SwingConstants.LEFT);

		// Definir las columnas y sus títulos
		String [] nombreColumnas = {"Ident.","Nombre","Uds.","Precio Ud.","Precio Total"};
		modeloTablaCompras.setColumnIdentifiers(nombreColumnas);

		// Dar tamaños a las columnas
		TableColumnModel columnModel = tablaCompras.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(250);
		columnModel.getColumn(2).setPreferredWidth(50);
		columnModel.getColumn(3).setPreferredWidth(100);
		columnModel.getColumn(4).setPreferredWidth(100);

		// Colocar el JTable en un scrollpane
		JScrollPane sp = new JScrollPane(tablaCompras);
		sp.setPreferredSize(new Dimension(550,100));
		p.add(sp);

		return p;		
	}

	/**
	 * Método que prepara el panel con el catálogo de plantas a mostrar
	 * @return
	 */
	private JPanel preparaPanelCatalogo() {

		JPanel p = new JPanel(new BorderLayout());
		p.setBackground(Color.white);
		p.setBorder(new TitledBorder("Catálogo de plantas"));

		p.add(preparaPNorteCatalogo(), BorderLayout.NORTH);
		p.add(preparaPCentroCatalogo(), BorderLayout.SOUTH);

		return p;
	}

	/**
	 * Prepara el panel norte de la parte del catalogo con los JRadioButtons
	 * @return
	 */
	private JPanel preparaPNorteCatalogo() {

		// Prepara el grupo de radio buttons
		ButtonGroup bgTipo = new ButtonGroup();
		rbTodas = new JRadioButton("Todas",true);
		rbPlantaEstandar = new JRadioButton("Plantas estándar",false);
		rbBonsai = new JRadioButton("Bonsáis");

		rbTodas.setBackground(Color.white);
		rbPlantaEstandar.setBackground(Color.white);
		rbBonsai.setBackground(Color.white);

		bgTipo.add(rbTodas);
		bgTipo.add(rbPlantaEstandar);
		bgTipo.add(rbBonsai);

		JPanel pNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pNorte.setBackground(Color.white);

		pNorte.add(rbTodas);
		pNorte.add(rbPlantaEstandar);
		pNorte.add(rbBonsai);

		return pNorte;
	}

	/**
	 * Método que prepara el JTable del panel del catálogo
	 * @return
	 */
	private JScrollPane preparaPCentroCatalogo() {

		// Crear un objeto DefaultTableModel que estará dentro del JTable
		modeloTablaCatalogo = new DefaultTableModel();
		tablaCatalogo = new JTable(modeloTablaCatalogo);

		// Alinear los encabezados de las columnas a la izquierda
		JTableHeader header = tablaCatalogo.getTableHeader();
		DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
		headerRenderer.setHorizontalAlignment(SwingConstants.LEFT);

		// Definir las columnas y sus títulos
		String [] nombreColumnas = {"Ident.","Nombre","Stock","Precio base","Precio venta"};
		modeloTablaCatalogo.setColumnIdentifiers(nombreColumnas);

		// Dar tamaños a las columnas
		TableColumnModel columnModel = tablaCatalogo.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(250);
		columnModel.getColumn(2).setPreferredWidth(50);
		columnModel.getColumn(3).setPreferredWidth(100);
		columnModel.getColumn(4).setPreferredWidth(100);

		// Colocar el JTable en un scrollpane
		JScrollPane sp = new JScrollPane(tablaCatalogo);
		sp.setPreferredSize(new Dimension(550,100));

		return sp;
	}

	/**
	 * Métodos getter
	 */
	public JComboBox<String> getCbPlantas() {return cbPlantas;}
	public DefaultComboBoxModel<String> getModeloCbPlantas() {return modeloCbPlantas;}

	public JButton getbInfo() {return bInfo;}
	public JButton getbAñadirCarrito() {return bAñadirCarrito;}

	public JComboBox<Integer> getCbUnidades() {return cbUnidades;}

	public JTable getTablaCompras() {return tablaCompras;}
	public DefaultTableModel getModeloTablaCompras() {return modeloTablaCompras;	}

	public JButton getbCancelarCompra() {return bCancelarCompra;}
	public JButton getbFinalizarCompra() {return bFinalizarCompra;}

	public JRadioButton getRbTodas() {return rbTodas;}
	public JRadioButton getRbPlantaEstandar() {return rbPlantaEstandar;}
	public JRadioButton getRbBonsai() {return rbBonsai;}

	public JTable getTablaCatalogo() {return tablaCatalogo;}
	public DefaultTableModel getModeloTablaCatalogo() {	return modeloTablaCatalogo;}


	/**
	 * Método que añade el control de eventos a los diferentes componentes
	 * @param ctr
	 */
	public void control(Controlador ctr) {
		cbPlantas.addActionListener(ctr);
		bInfo.addActionListener(ctr);
		cbUnidades.addActionListener(ctr);
		bAñadirCarrito.addActionListener(ctr);
		bCancelarCompra.addActionListener(ctr);
		bFinalizarCompra.addActionListener(ctr);
		rbTodas.addActionListener(ctr);
		rbPlantaEstandar.addActionListener(ctr);
		rbBonsai.addActionListener(ctr);
	}
}
