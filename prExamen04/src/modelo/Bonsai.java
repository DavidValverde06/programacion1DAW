package modelo;

import java.util.SortedSet;
import java.util.TreeSet;

public class Bonsai extends Planta {

	/**
	 * Variables de instancia
	 */
	private int edadBonsai;
	private EnumEstiloBonsai estiloBonsai;
	private SortedSet<RegistroMantenimiento> historialMantenimiento; // Orden natural

	/**
	 * Constructor sobrecargado
	 */
	public Bonsai(String idPlanta, String nombreComunPlanta, double precioBasePlanta, int stockDisponible,
			int edadBonsai, EnumEstiloBonsai estiloBonsai, SortedSet<RegistroMantenimiento> historialMantenimiento) {
		super(idPlanta, nombreComunPlanta, precioBasePlanta, stockDisponible);
		this.edadBonsai = edadBonsai;
		this.estiloBonsai = estiloBonsai;
		this.historialMantenimiento = historialMantenimiento;
	}

	public Bonsai(String idPlanta, String nombreComunPlanta, double precioBasePlanta, int stockDisponible,
			int edadBonsai, EnumEstiloBonsai estiloBonsai) {
		super(idPlanta, nombreComunPlanta, precioBasePlanta, stockDisponible);
		this.edadBonsai = edadBonsai;
		this.estiloBonsai = estiloBonsai;
		this.historialMantenimiento = new TreeSet<>();
	}

	/**
	 * Getter y Setter
	 */
	public int getEdadBonsai() {return edadBonsai;}
	public void setEdadBonsai(int edadBonsai) {this.edadBonsai = edadBonsai;}

	public EnumEstiloBonsai getEstiloBonsai() {return estiloBonsai;}
	public void setEstiloBonsai(EnumEstiloBonsai estiloBonsai) {this.estiloBonsai = estiloBonsai;}

	public SortedSet<RegistroMantenimiento> getHistorialMantenimiento() {return historialMantenimiento;}
	public void setHistorialMantenimiento(SortedSet<RegistroMantenimiento> historialMantenimiento) {this.historialMantenimiento = historialMantenimiento;}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {

		String historial="";
		if (historialMantenimiento.isEmpty()) {
			historial = " [Sin registros de mantenimiento previos]";
		}
		else {
			for (RegistroMantenimiento registroMantenimiento : historialMantenimiento) {
				historial += "\n\t\t" + registroMantenimiento.toString();
			}
		}

		return super.toString() +
				"\n\tHistorial de intervenciones:" +
				historial;
	}

	@Override
	public double calcularPrecioVenta() {
		double precioVenta = getPrecioBasePlanta();
		int incremento = 15 * edadBonsai;
		return precioVenta += incremento;
	}

	@Override
	public String obtenerFichaCuidados() {
		return "--> Cuidados: Bonsái Estilo: " + this.estiloBonsai + " (" + this.estiloBonsai.getDescripcionEstilo() +
				") | Edad: " + this.edadBonsai + " años.";
	}

	/**
	 * Método sobrecargado añadir mantenimiento al historial
	 */
	public void añadirMantenimientoHistorial(RegistroMantenimiento mantenimiento) {
		historialMantenimiento.add(mantenimiento);
	}

	public void añadirMantenimientoHistorial(String fecha, EnumTipoIntervencion intervencion, String observaciones) {
		RegistroMantenimiento mantenimiento;
		try {
			mantenimiento = new RegistroMantenimiento(fecha, intervencion, observaciones);
			historialMantenimiento.add(mantenimiento);
		}
		catch (MiExcepcion e) {
			System.out.println(e.getMessage());
		}
	}
}
