package vista;

import java.awt.*;
import java.text.*;
import javax.swing.*;
import javax.swing.border.*;
import controlador.*;

public class Vista extends JPanel {

	private static final long serialVersionUID = 1342215853660410740L;

	/**
	 * Variables de instancia
	 */
	private JRadioButton rbNormal,rbUrgente;
	private JComboBox<Integer> cbPrioridad;
	private JComboBox<String> cbEspecialidad;
	private JTextField tfSeguridadSocial,tfNombrePaciente;
	private JComboBox<String> cbHoraVisita;
	private DefaultComboBoxModel<String> modeloCombo;
	private JList<String> listMotivoCita;
	private DefaultListModel<String> modeloLista;
	private JButton bAnadirCita,bCancelar,bListaCitas;

	/**
	 * Constructor
	 */
	public Vista() {
		/**
		 * panelPrincipal
		 */
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

		/**
		 * Panel datosCita
		 */
		prepararPanelDatosCita(panelPrincipal);

		/**
		 * Panel motivosCita
		 */
		prepararPanelMotivosCita(panelPrincipal);

		/**
		 * Panel operacionesBotones
		 */
		prepararPanelBotones(panelPrincipal);
	}

	/**
	 * Getter's
	 */
	public JRadioButton getRbNormal() {return rbNormal;}
	public JRadioButton getRbUrgente() {return rbUrgente;}
	public JComboBox<Integer> getCbPrioridad() {return cbPrioridad;}
	public JComboBox<String> getCbEspecialidad() {return cbEspecialidad;}
	public JTextField getTfSeguridadSocial() {return tfSeguridadSocial;}
	public JTextField getTfNombrePaciente() {return tfNombrePaciente;}
	public JComboBox<String> getCbHoraVisita() {return cbHoraVisita;}
	public DefaultComboBoxModel<String> getModeloCombo() {return modeloCombo;}
	public JList<String> getListMotivoCita() {return listMotivoCita;}
	public DefaultListModel<String> getModeloLista() {return modeloLista;}
	public JButton getbAnadirCita() {return bAnadirCita;}
	public JButton getbCancelar() {return bCancelar;}
	public JButton getbListaCitas() {return bListaCitas;}

	/**
	 * Método para preparar el panel de los botones
	 * @param panelPrincipal
	 */
	private void prepararPanelBotones(JPanel panelPrincipal) {
		JPanel operacionesBotones = new JPanel();
		ponerBordePanel(operacionesBotones, "Operaciones permitidas");

		bAnadirCita = new JButton("Añadir cita");
		bCancelar = new JButton("Cancelar");
		bListaCitas = new JButton("Ver lista citas");

		operacionesBotones.add(bAnadirCita);
		operacionesBotones.add(bCancelar);
		operacionesBotones.add(bListaCitas);

		panelPrincipal.add(operacionesBotones);

		this.add(panelPrincipal);
	}

	/**
	 * Método para preparar el panel motivos cita
	 * @param panelPrincipal
	 */
	private void prepararPanelMotivosCita(JPanel panelPrincipal) {
		JPanel motivosCita = new JPanel();
		ponerBordePanel(motivosCita, "Motivos para solicitar cita");

		listMotivoCita = new JList<String>();
		JScrollPane scrollLista = new JScrollPane(listMotivoCita);
		scrollLista.setPreferredSize(new Dimension(220, 80));
		motivosCita.add(scrollLista);

		panelPrincipal.add(motivosCita);
	}

	/**
	 * Método para preparar el panel datos cita
	 * @param panelPrincipal
	 */
	private void prepararPanelDatosCita(JPanel panelPrincipal) {
		JPanel datosCita = new JPanel(new GridLayout(6,2,5,5));
		ponerBordePanel(datosCita, "Datos cita");
		panelPrincipal.add(datosCita);

		JLabel labelTipoCita = new JLabel("Tipo de cita: ",JLabel.RIGHT);
		rbNormal = new JRadioButton("Normal");
		rbNormal.setSelected(true);
		rbUrgente = new JRadioButton("Urgente");
		JPanel panelBotones = new JPanel();
		ButtonGroup grupoBotones = new ButtonGroup();
		grupoBotones.add(rbNormal);
		grupoBotones.add(rbUrgente);
		panelBotones.add(rbNormal);
		panelBotones.add(rbUrgente);

		JLabel labelPrioridad = new JLabel("Prioridad: ",JLabel.RIGHT);
		JPanel panelPrioridad = new JPanel(new FlowLayout(FlowLayout.LEFT));
		Integer[] numPrioridad = {1,2,3};
		cbPrioridad = new JComboBox<Integer>(numPrioridad);
		cbPrioridad.setEnabled(false);
		panelPrioridad.add(cbPrioridad);

		JLabel labelEspecialidad = new JLabel("Especialidad: ",JLabel.RIGHT);
		cbEspecialidad = new JComboBox<String>();

		JLabel labelSeguridadSocial = new JLabel("Nº Seguridad Social: ",JLabel.RIGHT);
		tfSeguridadSocial = new JTextField(5);

		JLabel labelNombrePaciente = new JLabel("Nombre paciente: ",JLabel.RIGHT);
		tfNombrePaciente = new JTextField(5);

		JLabel labelHoraVisita = new JLabel("Hora visita: ",JLabel.RIGHT);
		JPanel panelHora = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cbHoraVisita = new JComboBox<String>();

		DecimalFormat formateador = new DecimalFormat("00");
		for (int hora=8;hora<20;hora++) {
			for (int min=0;min<=50;min+=10) {
				cbHoraVisita.addItem(formateador.format(hora) + ":" + formateador.format(min));
			}
		}
		panelHora.add(cbHoraVisita);

		datosCita.add(labelTipoCita);
		datosCita.add(panelBotones);

		datosCita.add(labelPrioridad);
		datosCita.add(panelPrioridad);

		datosCita.add(labelEspecialidad);
		datosCita.add(cbEspecialidad);

		datosCita.add(labelSeguridadSocial);
		datosCita.add(tfSeguridadSocial);

		datosCita.add(labelNombrePaciente);
		datosCita.add(tfNombrePaciente);

		datosCita.add(labelHoraVisita);
		datosCita.add(panelHora);
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

	/**
	 * Método para dar control a los componentes de la interfaz
	 */
	public void control(Controlador ctr) {
		rbNormal.addActionListener(ctr);
		rbUrgente.addActionListener(ctr);
		cbPrioridad.addActionListener(ctr);
		cbEspecialidad.addActionListener(ctr);
		cbHoraVisita.addActionListener(ctr);
		bAnadirCita.addActionListener(ctr);
		bCancelar.addActionListener(ctr);
		bListaCitas.addActionListener(ctr);
	}

}
