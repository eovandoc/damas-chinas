package diseno.sistemas.integracion.mantenimiento.dao;

import java.util.List;

import diseno.sistemas.dominio.mantenimiento.Producto;

public interface ProductoDAO {
	
	public List<Producto> cargarTodosLosProductos();
	public List<Producto> cargarProductos(Producto producto);
	public void modificarProducto(Producto producto);
	public void eliminarProducto(Producto producto);
	public Producto agregarProducto(Producto producto);
	
}
