package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import modelo.EnumUbicaciones;

public class Vista extends JPanel {

	private static final long serialVersionUID = -5910892281204539744L;
	
	/**
	 * Variables de instancia
	 */
	private JComboBox<EnumUbicaciones> cbUbicaciones;
	
	private JComboBox<String> cbAlojamiento;
	private DefaultComboBoxModel<String> modeloCbAlojamiento;

	private JButton bDetalles;
	private JTextField tfFechaIni, tfFechaFin;
	private JLabel labelCoste;
	private JComboBox<Integer> cbNoches;
	private JTextField tfNombre, tfDNI, tfTel;
	
	private JButton bReservar, bLimpiar;

	private JTable tablaReservas;
	private DefaultTableModel datos;
	

	/**
	 * Constructor
	 */
	public Vista() {
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		panelPrincipal.setBackground(Color.white);
		panelPrincipal.setBorder(new EmptyBorder(15,15,15,15));
		
		JPanel pTitulo = new JPanel();
		pTitulo.setBackground(Color.white);
		JLabel titulo = new JLabel("Reserva de alojamientos rurales", JLabel.CENTER);
		titulo.setForeground(Color.blue);
		titulo.setFont(new Font("Comic Sans MS",Font.BOLD, 22));
		pTitulo.add(titulo);
				
		panelPrincipal.add(pTitulo);
		panelPrincipal.add(preparaPanelDatosReserva());
		panelPrincipal.add(preparaPanelBotones());
		panelPrincipal.add(preparaPanelReservas());
		
		this.setBackground(Color.white);
		this.add(panelPrincipal);
			
	}
	
	/**
	 * Método que prepara el panel para la recogida de los datos de la reserva
	 * @return
	 */
	private JPanel preparaPanelDatosReserva() {
		
		JPanel p = new JPanel();
		p.setBackground(Color.white);
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setBorder(new TitledBorder("Datos reserva"));
		
		// -----------------------------------------------------------
		// Prepara un panel para el combo de ubicaciones, alojamiento
		// y el botón detalles
		JPanel p1 = new JPanel();
		p1.setBackground(Color.white);
		
		cbUbicaciones  // FALTA SU CREACIÓN CON LAS UBICACIONES DE LA ENUMERACIÓN
		
		// El comboBox de alojamiento tiene un DefaultComboBoxModel en su interior
		// ya que este objeto nos va a permitir el uso de muchos más métodos
		// para modificar el combo durante la ejecución
		modeloCbAlojamiento = new DefaultComboBoxModel<>();
		cbAlojamiento = new JComboBox<String>(modeloCbAlojamiento);
		cbAlojamiento.setPreferredSize(new Dimension(200,25));
	
		bDetalles = new JButton("Ver detalles");
		
		p1.add(new JLabel("Ubicación "));
		p1.add(cbUbicaciones);
		p1.add(new JLabel("     Alojamiento "));
		p1.add(cbAlojamiento);
		p1.add(bDetalles);
	
		// ----------------------------------------------------------------
		// Prepara un panel con las fechas, el número de noches y el coste
		JPanel p2 = new JPanel();
		p2.setBackground(Color.white);
		
		tfFechaIni = new JTextField(7);
		tfFechaFin = new JTextField(7);
		tfFechaFin.setEditable(false);
		tfFechaFin.setBackground(Color.WHITE);
		
		labelCoste = new JLabel("0");
		labelCoste.setForeground(Color.blue);
		
		cbNoches = new JComboBox<Integer>();
		for (int cont=1; cont<=60; cont++) 
			cbNoches.addItem(Integer.valueOf(cont));
		
		p2.add(new JLabel("Fecha inicio "));
		p2.add(tfFechaIni);
		p2.add(new JLabel("    Número de noches "));
		p2.add(cbNoches);
		p2.add(new JLabel("    Fecha fin "));
		p2.add(tfFechaFin);
		p2.add(new JLabel("    Coste: "));
		p2.add(labelCoste);
		p2.add(new JLabel(""));
		
		// -----------------------------------------------------------
		// Prepara el panel con el nombre, dni y teléfono
		JPanel p3 = new JPanel();
		p3.setBackground(Color.white);
		
		tfNombre = new JTextField(20);
		tfDNI = new JTextField(10);
		tfTel = new JTextField(10);

		p3.add(new JLabel("Nombre "));
		p3.add(tfNombre);
		p3.add(new JLabel("    DNI "));
		p3.add(tfDNI);
		p3.add(new JLabel("    Teléfono de contácto "));
		p3.add(tfTel);
		
		p.add(p1);
		p.add(p2);
		p.add(p3);
		return p;
	}
	

	/**
	 * Método que prepara el panel con los botones
	 * @return
	 */
	private JPanel preparaPanelBotones() {
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER,30,30));
		p.setBackground(Color.WHITE);
		
		bReservar = new JButton("Realizar reserva");
		bLimpiar = new JButton("Limpiar formulario");
		
		p.add(bReservar);
		p.add(bLimpiar);
	
		return p;
	}
	
	
	/**
	 * Método que prepara el panel con las reservas realizadas
	 * @return
	 */
	private JPanel preparaPanelReservas() {
		
		JPanel p = new JPanel();
		p.setBackground(Color.white);
		p.setBorder(new TitledBorder("Reservas realizadas"));
		
		// Crear un objeto DefaultTableModel que estará dentro del JTable
		datos = new DefaultTableModel();
		tablaReservas = new JTable(datos);
		
		// Alinear los encabezados de las columnas a la izquierda
		JTableHeader header = tablaReservas.getTableHeader();
		DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
		headerRenderer.setHorizontalAlignment(SwingConstants.LEFT);

		// Definir las columnas y sus títulos
		String [] nombreColumnas = {"Alojamiento","F.Inicio","F.Fin","Noches","Nombre","DNI","Teléfono"};
		datos.setColumnIdentifiers(nombreColumnas);
		
		
		// Dar tamaños a las columnas
		TableColumnModel columnModel = tablaReservas.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(200);
		columnModel.getColumn(1).setPreferredWidth(80);
		columnModel.getColumn(2).setPreferredWidth(80);
		columnModel.getColumn(3).setPreferredWidth(50);
		columnModel.getColumn(4).setPreferredWidth(180);
		columnModel.getColumn(5).setPreferredWidth(80);
		columnModel.getColumn(6).setPreferredWidth(80);
		
		// Colocar el JTable en un scrollpane
		JScrollPane sp = new JScrollPane(tablaReservas);
		sp.setPreferredSize(new Dimension(750,200));
		p.add(sp);
		return p;
	}

	
	/**
	 * Método que añade control a los componentes
	 * @param ctr
	 */
	public void control(Controlador ctr) {
		
		// METODO A COMPLETAR POR EL ALUMNO
		
	}

	


	/**
	 * Métodos getters
	 */

	public JComboBox<EnumUbicaciones> getCbUbicaciones() {return cbUbicaciones;}

	public DefaultComboBoxModel<String> getModeloCbAlojamiento() {
		return modeloCbAlojamiento;
	}
	
	public JComboBox<String> getCbAlojamiento() {return cbAlojamiento;}

	public JComboBox<Integer> getCbNoches() {return cbNoches;}
	
	public JButton getbDetalles() {return bDetalles;}

	public JTextField getTfFechaIni() {return tfFechaIni;}
	public JTextField getTfFechaFin() {return tfFechaFin;}

	public JComboBox<Integer> getCbDias() {return cbNoches;}

	public JTextField getTfNombre() {return tfNombre;}
	public JTextField getTfDNI() {return tfDNI;}
	public JTextField getTfTel() {return tfTel;}

	public JButton getbReservar() {return bReservar;}
	public JButton getbLimpiar() {return bLimpiar;}

	public JTable getTablaReservas() {return tablaReservas;}
	public DefaultTableModel getDatos() {return datos;}

	public JLabel getLabelCoste() {return labelCoste;}



	
}
