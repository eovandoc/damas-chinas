package diseno.sistemas.dominio.ventas;

import java.util.ArrayList;
import java.util.List;

import diseno.sistemas.dominio.mantenimiento.Cliente;
import diseno.sistemas.dominio.mantenimiento.Usuario;

public class Venta {
	
	private int codigo;
	private Cliente cliente;
	private Usuario usuario;
	private List<LineaVenta> listaProductos;
	private String fecha;
	private double total;
	private double igv;
	private String observaciones;
	
	public Venta(){
		listaProductos=new ArrayList<LineaVenta>();
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getIgv() {
		return igv;
	}
	public void setIgv(double igv) {
		this.igv = igv;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public List<LineaVenta> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<LineaVenta> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	
}
