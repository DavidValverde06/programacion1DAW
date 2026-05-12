package vista;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import controlador.Controlador;


public class Vista extends JPanel{
	
	private static final long serialVersionUID = -968892632994221823L;
	
	/**
	 * Variables de instancia
	 */
	private JTextField tfCodigo, tfAutor, tfTitulo, tfFechaPubli, tfPrecio;
	private JButton bNuevo, bGuardar, bModificar, bEliminar, bCancelar;
	private JButton bPrimero, bAnterior, bSiguiente, bUltimo;

	private JMenuBar barraMenu;
    private JMenu mConsultas;
	private JMenuItem iConsulta1;
	
	/**
	 * Constructor
	 */
	public Vista() {
		
		// Preparar un panel intermedio con todo el contenido
		JPanel p = new JPanel(new BorderLayout(20,20));
		p.add(preparaPanelDatos(),       BorderLayout.CENTER);
		p.add(preparaPanelOperaciones(), BorderLayout.EAST);
		p.add(preparaPanelNavegacion(),  BorderLayout.SOUTH);
		
		// Añadir el panel anterior al panel implícito
		this.add(p);
		
		// Preparar la barra de menús
		preparaMenu();
				
		// Para ver los Look and Feel disponibles en mi S.0.
		System.out.println("LOOK AND FEEL DISPONIBLES EN ESTE S.O.");
		LookAndFeelInfo[] lista = UIManager.getInstalledLookAndFeels();
		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i].getClassName());
		}
		
		// Cambiar el Look and Feel
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		//	UIManager.setLookAndFeel(new MetalLookAndFeel());
		} 
		catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(this);
		

	}
	
	
	/**
	 * Método que prepara el panel con los datos del disco
	 * @return
	 */
	private JPanel preparaPanelDatos() {
		
		// Pedir memoria para el panel y ponerle un borde
		JPanel panelDatos = new JPanel(new GridLayout(5,2,10,10));
		panelDatos.setBorder(new TitledBorder("Datos disco"));
		
		// Pedir memoria para los JTextField
		tfCodigo = new JTextField();
		tfAutor  = new JTextField();
		tfTitulo = new JTextField(18);  // 18 sera el tamaño de todos los JTextField
		tfFechaPubli = new JTextField();
		tfPrecio = new JTextField();
		
		// Poner no editables los JTextField 
		tfCodigo.setEditable(false);
		tfAutor.setEditable(false);
		tfTitulo.setEditable(false);
		tfFechaPubli.setEditable(false);
		tfPrecio.setEditable(false);
		
		// Al poner los campos no editables le cambia el color a gris, por
		// tanto se lo volveremos a poner en blanco
		tfCodigo.setBackground(Color.white);
		tfAutor.setBackground(Color.white);
		tfTitulo.setBackground(Color.white);
		tfFechaPubli.setBackground(Color.white);
		tfPrecio.setBackground(Color.white);
		
		// A�adir los campos de texto y los JLabel que los preceden
		// al panel
		panelDatos.add(new JLabel("Codigo",JLabel.RIGHT));
		panelDatos.add(tfCodigo);
		panelDatos.add(new JLabel("Titulo",JLabel.RIGHT));
		panelDatos.add(tfTitulo);
		panelDatos.add(new JLabel("Autor",JLabel.RIGHT));
		panelDatos.add(tfAutor);
		panelDatos.add(new JLabel("Fecha de publicación",JLabel.RIGHT));
		panelDatos.add(tfFechaPubli);
		panelDatos.add(new JLabel("Precio venta",JLabel.RIGHT));
		panelDatos.add(tfPrecio);
		
		return panelDatos;
	}
	
	
	/**
	 * Método que prepara un panel con todos los botones de 
	 * operaciones permitidas sobre la BD
	 */
	private JPanel preparaPanelOperaciones() {
		
		JPanel p = new JPanel(new GridLayout(5,1,10,10));
		
		// Pedir memoria para los botones
		bNuevo = new JButton("Nuevo");
		bGuardar = new JButton("Guardar");
		bModificar = new JButton("         Modificar         ");
		bEliminar = new JButton("Eliminar");
		bCancelar = new JButton("Cancelar");
		
		// Poner un borde resaltado a los botones
		bNuevo.setBorder(new BevelBorder(BevelBorder.RAISED));
		bGuardar.setBorder(new BevelBorder(BevelBorder.RAISED));
		bModificar.setBorder(new BevelBorder(BevelBorder.RAISED));
		bEliminar.setBorder(new BevelBorder(BevelBorder.RAISED));
		bCancelar.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		// Deshabilitar el bot�n Guardar
		bGuardar.setEnabled(false);
		
		// Añadir los botones al panel
		p.add(bNuevo);
		p.add(bGuardar);
		p.add(bModificar);
		p.add(bEliminar);
		p.add(bCancelar);
		
		return p;
	}
	
	/**
	 * Prepara el panel que contendra los botones de "navegacion" por
	 * los distintos registros (tuplas) de la tabla
	 */
	private JPanel preparaPanelNavegacion() {
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,10));
		
		// Pedir memoria para los botones
		bPrimero = new JButton(new ImageIcon("./img/principio.png"));
		bAnterior = new JButton(new ImageIcon("./img/anterior.png"));
		bSiguiente = new JButton(new ImageIcon("./img/siguiente.png"));
		bUltimo = new JButton(new ImageIcon("./img/fin.png"));
		
		// Establecer un alias para los botones
		bPrimero.setActionCommand("Primero");
		bAnterior.setActionCommand("Anterior");
		bSiguiente.setActionCommand("Siguiente");
		bUltimo.setActionCommand("Ultimo");
		
		// Poner bordes resaltados a los botones
		bPrimero.setBorder(new BevelBorder(BevelBorder.RAISED));
		bAnterior.setBorder(new BevelBorder(BevelBorder.RAISED));
		bSiguiente.setBorder(new BevelBorder(BevelBorder.RAISED));
		bUltimo.setBorder(new BevelBorder(BevelBorder.RAISED));

		// Establecer un tamaño para los botones
		Dimension d = new Dimension(50,25);
		bPrimero.setPreferredSize(d);
		bAnterior.setPreferredSize(d);
		bSiguiente.setPreferredSize(d);
		bUltimo.setPreferredSize(d);
		
		// A�adir los botones al panel
		p.add(bPrimero);
		p.add(bAnterior);
		p.add(bSiguiente);
		p.add(bUltimo);
		
		return p;
	}
	
	
	/**
	 * Preparacion de la barra de menus
	 */
	private void preparaMenu() 	{
		
		barraMenu = new JMenuBar();
		
	    mConsultas = new JMenu("Consultas");
			
		iConsulta1 = new JMenuItem("Discos publicados en este año");
		
		mConsultas.add(iConsulta1);
		barraMenu.add(mConsultas);
	}
	
	
	/**
	 * Método que da control a los botones
	 *    - A los botones de navegacion les añadiremos el control de raton
	 *    - A los bototes de mantenimiento (nuevo, eliminar, ...) les añadiremos
	 *      control de accion
	 */
	public void control(Controlador ctr) {

		// Control de los botones de avance
		bPrimero.addMouseListener(ctr);
		bAnterior.addMouseListener(ctr);
		bSiguiente.addMouseListener(ctr);
		bUltimo.addMouseListener(ctr);
		
		// Control de los botones de operaciones
		bNuevo.addActionListener(ctr);
		bGuardar.addActionListener(ctr);
		bModificar.addActionListener(ctr);
		bCancelar.addActionListener(ctr);
		bEliminar.addActionListener(ctr);
		
		// Control de las opciones del men�
		iConsulta1.addActionListener(ctr);
	}


	/** 
	 * M�todos get de todas la variables de instancia
	 */
	public JTextField getTfCodigo() {return tfCodigo;}
	public JTextField getTfAutor()  {return tfAutor;}
	public JTextField getTfTitulo() {return tfTitulo;}
	public JTextField gettfFechaPubli()    {return tfFechaPubli;}
	public JTextField getTfPrecio() {return tfPrecio;}

	public JButton getbNuevo()     {return bNuevo;}
	public JButton getbGuardar()   {return bGuardar;}
	public JButton getbModificar() {return bModificar;}
	public JButton getbEliminar()  {return bEliminar;}
	public JButton getbCancelar()  {return bCancelar;	}
 	public JButton getbAnterior()  {return bAnterior;}
	public JButton getbSiguiente() {return bSiguiente;}
	public JButton getbUltimo()    {return bUltimo;}
	public JButton getbPrimero()   {return bPrimero;}
	public JMenuBar getBarraMenu() {return barraMenu;}
}













