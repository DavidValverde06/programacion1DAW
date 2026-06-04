package modelo;

import java.time.*;

public class RegistroMantenimiento implements Comparable<RegistroMantenimiento> {

	/**
	 * Variables de instancia
	 */
	private LocalDate fechaMantenimento;
	private EnumTipoIntervencion tipoIntervencion;
	private String observacionMantenimiento;

	/**
	 * Constructor
	 * @throws MiExcepcion 
	 */
	public RegistroMantenimiento(String fechaMantenimento, EnumTipoIntervencion tipoIntervencion,
			String observacionMantenimiento) throws MiExcepcion {
		if (!LibFechas8.isFechaCorrecta(fechaMantenimento)) {
			this.fechaMantenimento = LocalDate.now();
			this.tipoIntervencion = tipoIntervencion;
			this.observacionMantenimiento = observacionMantenimiento;
		}
		else {
			this.fechaMantenimento = LibFechas8.convierteStringToLocalDate(fechaMantenimento);
			this.tipoIntervencion = tipoIntervencion;
			this.observacionMantenimiento = observacionMantenimiento;
		}
	}

	/**
	 * Getter y Setter
	 */
	public LocalDate getFechaMantenimento() {return fechaMantenimento;}
	public void setFechaMantenimento(LocalDate fechaMantenimento) {this.fechaMantenimento = fechaMantenimento;}

	public EnumTipoIntervencion getTipoIntervencion() {return tipoIntervencion;}
	public void setTipoIntervencion(EnumTipoIntervencion tipoIntervencion) {this.tipoIntervencion = tipoIntervencion;}

	public String getObservacionMantenimiento() {return observacionMantenimiento;}
	public void setObservacionMantenimiento(String observacionMantenimiento) {this.observacionMantenimiento = observacionMantenimiento;}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return fechaMantenimento + " - " + tipoIntervencion + " (" + observacionMantenimiento + ")";
	}

	/**
	 * Método compareTo
	 * 
	 * El orden natural (Comparable), que será 
	 * fecha de mayor a menor, y en caso de
	 * repetición de fecha, por tipo de intervención (Enum)
	 */
	@Override
	public int compareTo(RegistroMantenimiento o) {
		int compara = o.getFechaMantenimento().compareTo(this.getFechaMantenimento());
		if (compara != 0) {
			return compara;
		}
		return this.getTipoIntervencion().compareTo(o.getTipoIntervencion());
	}
}
