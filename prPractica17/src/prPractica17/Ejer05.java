package prPractica17;

import javax.swing.JOptionPane;

/**
 * 5.- Por último os propongo un GUI, un poco más interactivo, utilizando los JOptionPane. Inicialmente
 * lanzaremos una ventanita, pidiendo un número: 
 */
public class Ejer05 {

	public static void main(String[] args) {

		try {
			String numIntroducido = JOptionPane.showInputDialog("Escriba un número");
			int num = Integer.parseInt(numIntroducido);

			if (numIntroducido==null || numIntroducido.equals("")) {
				JOptionPane.showMessageDialog(null, "Dato incorrecto", "Mensaje", JOptionPane.ERROR_MESSAGE);
			}
			else if (num==100) {
				JOptionPane.showMessageDialog(null, "Enhorabuena, has obtenido un premio");
			}
			else {
				JOptionPane.showMessageDialog(null, "El número introducido es " + num);
			}
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Introduce un número", "Mensaje", JOptionPane.ERROR_MESSAGE);
		}

	}

}
