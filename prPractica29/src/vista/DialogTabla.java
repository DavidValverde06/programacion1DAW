package vista;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import modelo.*;

public class DialogTabla {

	private AgendaCitas miAgenda;
	private JFrame f;

	public DialogTabla(AgendaCitas miAgenda, JFrame f) {
		this.miAgenda = miAgenda;
		this.f = f;
	}

	private void listar() {

		// Ordenar usando el método correcto de tu clase AgendaCitas
		List<CitaMedica> listaOrdenada = miAgenda.ordenarAgendaMedica();

		JDialog d = new JDialog(f, "Listado de citas", true);
		d.setLayout(new FlowLayout());

		String[] nombreColumnas = {"Prioridad", "Hora", "Num SS", "Nombre", "Motivos consulta", "Especialista", "Precio"};

		String[][] datos2 = new String[listaOrdenada.size()][7];
		for (int i = 0; i < listaOrdenada.size(); i++) {
			CitaMedica miCita = listaOrdenada.get(i);
			datos2[i][0] = Integer.toString(miCita.getPrioridadCita());          // getPrioridadCita(), devuelve int
			datos2[i][1] = CitaMedica.toStringHora(miCita.getHoraVisita());      // método estático en CitaMedica
			datos2[i][2] = Integer.toString(miCita.getNumSeguridadSocial());     // getNumSeguridadSocial(), devuelve int
			datos2[i][3] = miCita.getNombrePaciente();                           // getNombrePaciente()
			datos2[i][4] = miCita.getColeccionMotivos().toString();              // getColeccionMotivos()
			datos2[i][5] = miCita.getEspecialista();
			datos2[i][6] = String.valueOf(miCita.devuelvePrecioCita());          // devuelvePrecioCita(), devuelve float
		}

		JTable tablaResultados = new JTable(datos2, nombreColumnas);

		TableColumnModel columnModel = tablaResultados.getColumnModel();

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		columnModel.getColumn(0).setCellRenderer(tcr);
		columnModel.getColumn(1).setCellRenderer(tcr);
		columnModel.getColumn(6).setCellRenderer(tcr);

		columnModel.getColumn(0).setPreferredWidth(70);
		columnModel.getColumn(1).setPreferredWidth(70);
		columnModel.getColumn(2).setPreferredWidth(90);
		columnModel.getColumn(3).setPreferredWidth(150);
		columnModel.getColumn(4).setPreferredWidth(220);
		columnModel.getColumn(5).setPreferredWidth(130);
		columnModel.getColumn(6).setPreferredWidth(70);

		JScrollPane sp = new JScrollPane(tablaResultados);
		sp.setPreferredSize(new Dimension(800, 200));

		d.add(sp);

		d.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		d.pack();
		d.setVisible(true);
		d.setResizable(false);
	}
}