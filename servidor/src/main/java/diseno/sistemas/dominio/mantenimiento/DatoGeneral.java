package diseno.sistemas.dominio.mantenimiento;

import java.io.Serializable;

public class DatoGeneral implements Serializable {
	

	private static final long serialVersionUID = 1030455087842506168L;
	private int codigo;
	private String descripcion;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
