package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class DialogoInicial extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1281122815066585881L;

	/**
	 * Variables de instancia
	 */
	private JButton bIniciarSesion,bSalir;
	private JTextField tfUsuario,tfPassword;
	private JCheckBox chRecordarme;

	public DialogoInicial() {

		JPanel panelPrincipal = new JPanel(new GridLayout(1,2));

		preparaPanelIzquierdo(panelPrincipal);

		preparaPanelDerecho(panelPrincipal);

		this.add(panelPrincipal);

		control();

		// Establecer tamaño, pack, ...
		this.setIconImage(new ImageIcon("./img/iconoSesion.png").getImage());
		this.setModal(true);
		this.setTitle("Inicio sesión");
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * Getter's
	 */
	public JButton getbIniciarSesion() {return bIniciarSesion;}
	public JButton getbSalir() {return bSalir;}
	public JTextField getTfUsuario() {return tfUsuario;}
	public JTextField getTfPassword() {return tfPassword;}
	public JCheckBox getChRecordarme() {return chRecordarme;}

	/**
	 * Método Panel Derecho
	 */
	private void preparaPanelDerecho(JPanel panelPrincipal) {
		JPanel panelDerecho = new JPanel();
		panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));

		JPanel panelCentral = new JPanel(new BorderLayout());

		JPanel panelAcceso = new JPanel(new GridLayout(2,2,5,5));
		ponerBordePanel(panelAcceso, "Acceso");

		JLabel etiquetaUsuario = new JLabel("Usuario:  ",JLabel.RIGHT);
		tfUsuario = new JTextField(10);
		JLabel etiquetaPassword = new JLabel("Contraseña: ",JLabel.RIGHT);
		tfPassword = new JTextField(10);

		JPanel panelRecuerdame = new JPanel(new FlowLayout(FlowLayout.LEFT));
		chRecordarme = new JCheckBox("Recuérdame");

		panelAcceso.add(etiquetaUsuario);
		panelAcceso.add(tfUsuario);
		panelAcceso.add(etiquetaPassword);
		panelAcceso.add(tfPassword);

		panelRecuerdame.add(chRecordarme);

		panelCentral.add(panelAcceso,BorderLayout.NORTH);
		panelCentral.add(panelRecuerdame,BorderLayout.SOUTH);

		JPanel panelBotones = new JPanel();
		bIniciarSesion = new JButton("Iniciar sesión");
		bSalir = new JButton("Salir");

		panelBotones.add(bIniciarSesion);
		panelBotones.add(bSalir);

		panelDerecho.add(panelCentral,BorderLayout.NORTH);
		panelDerecho.add(panelBotones,BorderLayout.SOUTH);

		panelPrincipal.add(panelDerecho);
	}

	/**
	 * Método Panel Izquierdo
	 */
	private void preparaPanelIzquierdo(JPanel panelPrincipal) {
		JPanel panelIzquierdo = new JPanel();
		panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo,BoxLayout.Y_AXIS));

		// Panel Imagen
		JPanel panelImagen = new JPanel(new BorderLayout());
		ImageIcon icono = new ImageIcon("./img/iconoCine2.png");
		JLabel etiquetaImagen = new JLabel(icono, JLabel.CENTER);
		panelImagen.add(etiquetaImagen);

		panelIzquierdo.add(panelImagen);

		panelPrincipal.add(panelIzquierdo);
	}

	/**
	 * Método Para Poner Bordes Paneles
	 */
	public void ponerBordePanel(JPanel panel, String textoDelBorde) {
		TitledBorder titledBorder = new TitledBorder(textoDelBorde);
		panel.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5),titledBorder));
	}

	/**
	 * Método para dar control a los componentes de la interfaz
	 */
	public void control() {
		bIniciarSesion.addActionListener(this);
		bSalir.addActionListener(this);
	}

	/**
	 * Método de la interfaz ActionListener (JButtons y JComboBox)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==bSalir) {
			System.exit(0);
		}
		else if (e.getSource()==bIniciarSesion) {
			if (tfUsuario.getText().equals("admin") && tfPassword.getText().equals("admin")) {
				JOptionPane.showMessageDialog(this, "Bienvenid@ " + tfUsuario.getText(), "Inicio de sesión", 1);
				if (!chRecordarme.isSelected()) {
					this.dispose();
				}
				else {
					this.setVisible(false);
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error inicio sesión", 0);
			}
		}
	}

}
