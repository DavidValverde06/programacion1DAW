package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Vista extends JPanel {

	private static final long serialVersionUID = -5752211613049689258L;

	/**
	 * Variables de instancia
	 */
	private JTabbedPane tabbedPane;
	private JTextArea taAreaLibros;
	private JButton bActualizarLista;

	public Vista() {

		// Crear un objeto de la clase DialogoInicio
		DialogoInicio dialogo = new DialogoInicio();

		// Crear un TabbedPane (pestañas)
		tabbedPane = new JTabbedPane();
		tabbedPane.setBackground(Color.white);
		// A cada pestaña, se le especificará un texto, se le añadirá un panel,
		// y se le pondrá un ToolTip (es opcional) para que se visualice al acercar el ratón,
		// y por último se le ha establecido una imagen (también es opcional)
		// Las pestañas empiezan a numerarse desde 0, 1, 2, ...
		tabbedPane.addTab("Añadir libros", preparaPanelLibros());
		tabbedPane.setToolTipTextAt(0, "Permite añadir libros a la Biblioteca");
		tabbedPane.setIconAt(0, new ImageIcon("./src/recursos/imagenes/IconoLibros.png"));
		// Lo anterior lo repetiremos por cada pestaña
		tabbedPane.addTab("Añadir clientes", preparaPanelLibros());
		tabbedPane.setToolTipTextAt(1, "Permite añadir libros a la Biblioteca");
		tabbedPane.setIconAt(1, new ImageIcon("./src/recursos/imagenes/IconoClientes.png"));

		tabbedPane.addTab("Libros disponibles", preparaPanelLibros());
		tabbedPane.setToolTipTextAt(2, "Permite añadir libros a la Biblioteca");
		tabbedPane.setIconAt(2, new ImageIcon("./src/recursos/imagenes/MontonLibros2.png"));

		tabbedPane.addTab("Préstamo de libros", preparaPanelLibros());
		tabbedPane.setToolTipTextAt(3, "Permite añadir libros a la Biblioteca");
		tabbedPane.setIconAt(3, new ImageIcon("./src/recursos/imagenes/Lector4.png"));

		tabbedPane.addTab("Devolución de libross", preparaPanelLibros());
		tabbedPane.setToolTipTextAt(4, "Permite añadir libros a la Biblioteca");
		tabbedPane.setIconAt(4, new ImageIcon("./src/recursos/imagenes/MontonLibros4.png"));

		// Añadir el JTabbedPane al panel implícito (this) y cambiar el gestor de esquemas
		this.setLayout(new GridLayout(1, 1));
		// Hay que darle este gestor de esquemas sino pondrá una
		// pestaña debajo de otra en la distribución horizontal
		this.add(tabbedPane);

	}

	private JPanel preparaPanelLibros() {
		JPanel panelLibros = new JPanel(new BorderLayout());
		taAreaLibros = new JTextArea();
		JScrollPane panelScroll = new JScrollPane(taAreaLibros);
		taAreaLibros.setBorder(new CompoundBorder(
				new EmptyBorder(5,5,5,5),
				new TitledBorder("Libros disponibles en la biblioteca"))
				);

		panelLibros.add(panelScroll, BorderLayout.CENTER);

		JPanel panelBoton = new JPanel();
		bActualizarLista = new JButton("Actualizar lista");
		panelBoton.add(bActualizarLista);

		panelLibros.add(panelBoton, BorderLayout.SOUTH);

		return panelLibros;
	}

	/**
	 * Método Para Poner Bordes Paneles
	 */
	public void ponerBordePanel(JPanel panel, String textoDelBorde) {
		panel.setBorder(new CompoundBorder(
				new EmptyBorder(5,5,5,5),
				new TitledBorder(textoDelBorde))
				);
	}
}
