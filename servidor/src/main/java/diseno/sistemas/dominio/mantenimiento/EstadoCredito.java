package diseno.sistemas.dominio.mantenimiento;

import java.io.Serializable;

public class EstadoCredito implements Serializable{
	

	private static final long serialVersionUID = -6622204056748758524L;
	private int codigo;
	private String descripcion;
	private double maximo;
	
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
	public double getMaximo() {
		return maximo;
	}
	public void setMaximo(double maximo) {
		this.maximo = maximo;
	}
}
