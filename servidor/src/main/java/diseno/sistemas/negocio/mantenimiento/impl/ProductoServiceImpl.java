package diseno.sistemas.negocio.mantenimiento.impl;

import java.util.List;

import diseno.sistemas.dominio.mantenimiento.Producto;
import diseno.sistemas.integracion.mantenimiento.dao.ProductoDAO;
import diseno.sistemas.negocio.mantenimiento.ProductoService;

public class ProductoServiceImpl implements ProductoService {
	
	private ProductoDAO productoDAO;
	
	public List<Producto> cargarTodosLosProductos() {
		return productoDAO.cargarTodosLosProductos();
	}

	public List<Producto> cargarProductos(Producto producto) {
		return productoDAO.cargarProductos(producto);
	}

	
	public void modificarProducto(Producto producto) {
		productoDAO.modificarProducto(producto);
	}

	public void eliminarProducto(Producto producto) {
		productoDAO.eliminarProducto(producto);

	}
	
	public Producto agregarProducto(Producto producto) {
		return productoDAO.agregarProducto(producto);
	}

	public ProductoDAO getProductoDAO() {
		return productoDAO;
	}

	public void setProductoDAO(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}

}
