package prPractica18;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Cómo segunda tarea os propongo que diseñéis el siguiente interfaz gráfico, en el que tendréis
 * un panel (GridLayout(2,3)) que colocaréis en la zona central del panel principal, una etiqueta que
 * colocaréis al sur del panel principal, y un borde vacio alrededor. El panel principal al que me
 * refiero no puede ser el panel contendor del JFrame, ya que a ese no le podéis poner bordes.
 * Vais a necesitar otro panel intermedio, que es al que yo he llamado panel principal.
 */
public class ValidarUser extends JFrame implements ActionListener {

	private static final long serialVersionUID = 6081198801913704237L;

	// Variables de instancia
	private JLabel etiquetaSur;

	private JLabel etiquetaUsuario;
	private JLabel etiquetaPassword;

	private JTextField tfUsuario;
	private JPasswordField tfPassword;

	private JButton bAceptar;
	private JButton bCancelar;

	// Constructor
	public ValidarUser() {

		super("Ventana password");

		Container cp = this.getContentPane();
		cp.setLayout(new FlowLayout());

		JPanel panelPrincipal = new JPanel(new BorderLayout());
		panelPrincipal.setBorder(new EmptyBorder(20,20,20,20));

		// Panel Centro (Principal)
		JPanel panelCentral = new JPanel(new GridLayout(2,3,5,5));

		etiquetaUsuario = new JLabel("Usuario",JLabel.RIGHT);
		etiquetaPassword = new JLabel("Password",JLabel.RIGHT);

		tfUsuario = new JTextField(5);
		tfPassword = new JPasswordField(5);

		bAceptar = new JButton("Aceptar");
		bCancelar = new JButton("Cancelar");

		bAceptar.addActionListener(this);
		bCancelar.addActionListener(this);

		panelCentral.add(etiquetaUsuario,BorderLayout.WEST);
		panelCentral.add(tfUsuario,BorderLayout.CENTER);
		panelCentral.add(bAceptar,BorderLayout.EAST);

		panelCentral.add(etiquetaPassword,BorderLayout.WEST);
		panelCentral.add(tfPassword,BorderLayout.CENTER);
		panelCentral.add(bCancelar,BorderLayout.EAST);

		// Panel Sur
		JPanel panelSur = new JPanel();
		etiquetaSur = new JLabel("Introduzca usuario y clave",JLabel.CENTER);
		panelSur.add(etiquetaSur);

		// Añadir todo al Contendor Principal
		panelPrincipal.add(panelCentral);
		panelPrincipal.add(panelSur,BorderLayout.SOUTH);
		cp.add(panelPrincipal,BorderLayout.CENTER);
	}

	public static void main(String[] args) {

		ValidarUser ventana = new ValidarUser();

		// ventana.setResizable(false);

		ventana.pack();

		ventana.setVisible(true);

		ventana.setLocationRelativeTo(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String miUsuario = "David";
		String miPassword = "123";

		if (e.getSource()==bAceptar) {
			if (miUsuario.equalsIgnoreCase(tfUsuario.getText()) && miPassword.equals(tfPassword.getPassword())) {
				etiquetaSur.setText("Datos correctos");
			}
			else {
				etiquetaSur.setText("Datos incorrectos");
				etiquetaSur.setForeground(Color.RED);
			}
		}

		if (e.getSource()==bCancelar) {
			tfUsuario.setText("");
			tfPassword.setText("");
			etiquetaSur.setText("Introduzca usuario y clave");
			etiquetaSur.setForeground(Color.BLACK);
		}
	}

}
