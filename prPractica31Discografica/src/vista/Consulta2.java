package vista;
/**
 *  Clase que muestra un dialogo con el JTable de una consulta
 *  
 *  Recibe los datos en un un objeto DefaultTableModel
 *  
 */


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class Consulta2 extends JDialog 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	// Constructor
	public Consulta2(DefaultTableModel datos)
	{ 
		// Poner el dialogo modal, darle titulo y gestor de esquemas
		this.setModal(true);
		this.setTitle("Consulta de discos vendidos en este año");
		this.setLayout(new FlowLayout());
	
		JTable tablaResultados = new JTable(datos);
	//	tablaResultados.setModel(datos);
		JScrollPane sp = new JScrollPane(tablaResultados);

		this.add(sp);
	   
	    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    	this.pack();  
		this.setVisible(true);   // Para mostrar el dialogo
		this.setResizable(false);

	}
}
