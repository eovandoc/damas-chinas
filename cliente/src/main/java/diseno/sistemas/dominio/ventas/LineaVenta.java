package diseno.sistemas.dominio.ventas;

import java.io.Serializable;

public class LineaVenta implements Serializable{


	private static final long serialVersionUID = 3013869943807371033L;
	
	private int codigo;
	private String descripcion;
	private double precio;
	private int cantidad;
	private double precioTotal;
	private int codigoUndMedida;
	private String unidadMedida;
	
	
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
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public int getCodigoUndMedida() {
		return codigoUndMedida;
	}
	public void setCodigoUndMedida(int codigoUndMedida) {
		this.codigoUndMedida = codigoUndMedida;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	
	
}
