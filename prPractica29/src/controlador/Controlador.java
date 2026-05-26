package controlador;

import java.awt.*;
import java.util.List;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import modelo.*;
import vista.*;

/**
 * C) Una vez que tenemos el modelo (clases anteriores) definido y probado (probar en consola el
 * funcionamiento correcto del mismo), vamos a diseñar un interfaz gráfico de usuario siguiendo el
 * Modelo Vista Controlador, cuyo aspecto inicial será como el que se muestra en la imagen 1 de la
 * siguiente página, y cuyo funcionamiento será el siguiente:
 * 
 * a. Si pulsamos sobre el radio de Tipo de cita y seleccionamos Urgente, se habilitará el ComboBox de
 * Prioridades, en caso de cita Normal, dicho combo estará deshabilitado.
 * 
 * b. Si se pulsa el botón “Añadir cita”, se recogerán los datos del
 * paciente y se añadirá a nuestra agenda. Tras lo cual nos
 * mostrará un pequeño mensaje como el que se muestra en la
 * imagen.
 * 
 * c. Si se pulsa el botón “Cancelar”, se limpiará todo el formulario
 * y se dejará como al principio.
 * 
 * d. Si se pulsa el botón “Ver lista citas”, nos mostrará todos las citas de nuestra agenda en un
 * formato similar al que se muestra en la imagen 2 que tenéis un poco más abajo. Se facilita el
 * método que proporciona el JTable con todos los datos de las citas recogidas en vuestra colección
 * (puede que tengáis que ajustar los nombres de algún método a los de vuestro modelo).
 * Imagen 1: Aspecto inicial del GUI
 * Imagen 2: Formato del listado de citas
 * 
 * e. Por último al pulsar el botón de cierre de nuestra
 * aplicación, debemos preguntar si desea volcar los datos
 * que actualmente se encuentran en la colección a un
 * fichero. En caso afirmativo los iremos añadiendo al
 * fichero Citas.txt, primero se añadirá la fecha actual y a
 * continuación las citas (podéis usar el formato de toString
 * para guardar las citas, cada cita en una fila nueva).
 */
public class Controlador implements ActionListener {

	/**
	 * Variables de instancia
	 */
	private Vista miVista;
	private JFrame f;
	private CitaMedica miCita;
	private AgendaCitas miAgenda;

	/**
	 * Constructor
	 */
	public Controlador(Vista miVista, JFrame f) {
		this.miVista = miVista;
		this.f = f;
		this.miAgenda = new AgendaCitas();

		miVista.getCbEspecialidad().setModel(new DefaultComboBoxModel<>(cargarEspecialidades()));

		DefaultListModel<String> modeloMotivos = new DefaultListModel<>();
		for (String motivo : cargarMotivosConsulta()) {
			modeloMotivos.addElement(motivo);
		}
		miVista.getListMotivoCita().setModel(modeloMotivos);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * a. Si pulsamos sobre el radio de Tipo de cita y seleccionamos Urgente, se habilitará el ComboBox de
		 * Prioridades, en caso de cita Normal, dicho combo estará deshabilitado.
		 */
		if (e.getSource()==miVista.getRbUrgente()) {
			miVista.getCbPrioridad().setEnabled(true);
		}
		else if (e.getSource()==miVista.getRbNormal()) {
			miVista.getCbPrioridad().setEnabled(false);
		}

		/**
		 * b. Si se pulsa el botón “Añadir cita”, se recogerán los datos del
		 * paciente y se añadirá a nuestra agenda. Tras lo cual nos
		 * mostrará un pequeño mensaje como el que se muestra en la
		 * imagen.
		 */
		else if (e.getSource()==miVista.getbAnadirCita()) {

			if (miVista.getTfNombrePaciente().getText().isEmpty() || miVista.getTfSeguridadSocial().getText().isEmpty()) {
				JOptionPane.showMessageDialog(miVista, "Rellena los datos", "Error", 0);
				return;
			}

			List<String> motivos = miVista.getListMotivoCita().getSelectedValuesList();
			ArrayList<String> motivosLista = new ArrayList<>(motivos);

			if (miVista.getRbNormal().isSelected()) {
				miCita = new CitaMedica(
						miVista.getTfSeguridadSocial().getText(),
						miVista.getTfNombrePaciente().getText(),
						motivosLista,
						miVista.getCbEspecialidad().getSelectedItem().toString(),
						miVista.getCbHoraVisita().getSelectedItem().toString() + ":00");

				miAgenda.añadirCita(miCita);
				JOptionPane.showMessageDialog(miVista, "Cita creada", "Información", 1);
			}
			else {
				miCita = new CitaMedica(
						Integer.valueOf(miVista.getCbPrioridad().getSelectedItem().toString()),
						miVista.getTfSeguridadSocial().getText(),
						miVista.getTfNombrePaciente().getText(),
						motivosLista,
						miVista.getCbEspecialidad().getSelectedItem().toString(),
						miVista.getCbHoraVisita().getSelectedItem().toString() + ":00");

				miAgenda.añadirCita(miCita);
				JOptionPane.showMessageDialog(miVista, "Cita creada", "Información", 1);
			}

		}

		/**
		 * c. Si se pulsa el botón “Cancelar”, se limpiará todo el formulario
		 * y se dejará como al principio.
		 */
		else if (e.getSource()==miVista.getbCancelar()) {
			cancelar();
		}

		/**
		 * d. Si se pulsa el botón “Ver lista citas”, nos mostrará todos las citas de nuestra agenda en un
		 * formato similar al que se muestra en la imagen 2 que tenéis un poco más abajo. Se facilita el
		 * método que proporciona el JTable con todos los datos de las citas recogidas en vuestra colección
		 * (puede que tengáis que ajustar los nombres de algún método a los de vuestro modelo).
		 */
		else if (e.getSource()==miVista.getbListaCitas()) {
			listar();
		}

	}

	private void cancelar() {
		miVista.getRbNormal().setSelected(true);
		miVista.getCbPrioridad().setSelectedIndex(0);
		miVista.getCbPrioridad().setEnabled(false);
		miVista.getCbEspecialidad().setSelectedIndex(0);
		miVista.getTfSeguridadSocial().setText("");
		miVista.getTfNombrePaciente().setText("");
		miVista.getCbHoraVisita().setSelectedIndex(0);
		miVista.getListMotivoCita().setSelectedIndex(0);
		miVista.getListMotivoCita().ensureIndexIsVisible(0);
	}

	private void listar() {
		List<CitaMedica> listaOrdenada = miAgenda.ordenarAgendaMedica();

		if (listaOrdenada.isEmpty()) {
			JOptionPane.showMessageDialog(miVista, "No hay citas que mostrar", "Aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}

		JDialog d = new JDialog(f, "Listado de citas", true);
		d.setLayout(new FlowLayout());

		String[] nombreColumnas = {"Prioridad", "Hora", "Num SS", "Nombre", "Motivos consulta", "Especialista", "Precio"};

		String[][] datos2 = new String[listaOrdenada.size()][7];
		for (int i = 0; i < listaOrdenada.size(); i++) {
			CitaMedica cita = listaOrdenada.get(i);
			datos2[i][0] = Byte.toString((byte) cita.getPrioridadCita());
			datos2[i][1] = LibreriaFechas.toStringHora(cita.getHoraVisita());
			datos2[i][2] = String.valueOf(cita.getNumSeguridadSocial());
			datos2[i][3] = cita.getNombrePaciente();
			datos2[i][4] = cita.getColeccionMotivos().toString();
			datos2[i][5] = cita.getEspecialista();
			datos2[i][6] = Integer.toString((int) cita.devuelvePrecioCita());
		}

		// Creación de un JTable
		JTable tablaResultados = new JTable(datos2,nombreColumnas);

		// Obtener el modelo asociado a las columnas
		TableColumnModel columnModel = tablaResultados.getColumnModel();

		// Centrar algunas columnas en la tabla de resultados
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		columnModel.getColumn(0).setCellRenderer(tcr);
		columnModel.getColumn(1).setCellRenderer(tcr);
		columnModel.getColumn(6).setCellRenderer(tcr);

		// Establecer diferententes tama�os para las columnas
		columnModel.getColumn(0).setPreferredWidth(70);
		columnModel.getColumn(1).setPreferredWidth(70);
		columnModel.getColumn(2).setPreferredWidth(90);
		columnModel.getColumn(3).setPreferredWidth(150);
		columnModel.getColumn(4).setPreferredWidth(220);
		columnModel.getColumn(5).setPreferredWidth(130);
		columnModel.getColumn(6).setPreferredWidth(70);

		// Colocar el JTable en un scrollPane
		JScrollPane sp = new JScrollPane(tablaResultados);
		sp.setPreferredSize(new Dimension(800,200));

		d.add(sp);

		d.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		d.pack();  
		d.setVisible(true);   // Para mostrar el dialogo
		d.setResizable(false);
	}

	/**
	 * Método para cargar las especialidades desde un fichero
	 */
	public String[] cargarEspecialidades() {
		String especialidad;
		List<String> coleccionEspecialidades = new ArrayList<String>();
		try (BufferedReader flujoLectura = new BufferedReader(new FileReader(Path.of("./src/recursos/especialidades").toFile()))) {
			while ((especialidad = flujoLectura.readLine()) != null) {
				coleccionEspecialidades.add(especialidad);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return coleccionEspecialidades.toArray(new String[0]);
	}

	/**
	 * Método para cargar los motivos de consulta desde un fichero
	 */
	public String[] cargarMotivosConsulta() {
		String motivo;
		List<String> coleccionMotivos = new ArrayList<String>();
		try (BufferedReader flujoLectura = new BufferedReader(new FileReader(Path.of("./src/recursos/MotivosConsulta").toFile()))) {
			while ((motivo = flujoLectura.readLine()) != null) {
				coleccionMotivos.add(motivo);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return coleccionMotivos.toArray(new String[0]);
	}

	/**
	 * e. Por último al pulsar el botón de cierre de nuestra
	 * aplicación, debemos preguntar si desea volcar los datos
	 * que actualmente se encuentran en la colección a un
	 * fichero. En caso afirmativo los iremos añadiendo al
	 * fichero Citas.txt, primero se añadirá la fecha actual y a
	 * continuación las citas (podéis usar el formato de toString
	 * para guardar las citas, cada cita en una fila nueva).
	 */
	public void cerrarVentana() {
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int opcion = JOptionPane.showConfirmDialog(miVista,"¿Desea volcar las citas en un archivo?",
						"Volcado datos",JOptionPane.YES_NO_OPTION);

				if (opcion == JOptionPane.YES_OPTION) {
					guardarCitas();
				}
				f.dispose();
				System.exit(0);
			}
		});
	}

	private void guardarCitas() {
		if (miAgenda.getListaCitas().isEmpty()) {
			JOptionPane.showMessageDialog(miVista, "No hay citas que guardar", "Aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("./src/recursos/Citas.txt", true))) {
			SimpleDateFormat sdf = new SimpleDateFormat("EEEE d 'de' MMMM 'de' yyyy", Locale.of("es", "ES"));
			bw.write(sdf.format(new Date()));
			bw.newLine();

			for (CitaMedica cita : miAgenda.getListaCitas()) {
				bw.write(cita.toString());
				bw.newLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
