package diseno.sistemas.integracion.mantenimiento.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import diseno.sistemas.dominio.mantenimiento.Producto;
import diseno.sistemas.integracion.mantenimiento.dao.ProductoDAO;

public class ProductoDAOImpl extends SqlMapClientDaoSupport implements ProductoDAO{

	
	@SuppressWarnings("unchecked")
	public List<Producto> cargarTodosLosProductos() {
		return getSqlMapClientTemplate().queryForList("mantenimiento.PRODUCTO.cargarTodosLosProductos");
	}

	
	@SuppressWarnings("unchecked")
	public List<Producto> cargarProductos(Producto producto) {
		return getSqlMapClientTemplate().queryForList("mantenimiento.PRODUCTO.cargarProductos",producto);
	}


	public void modificarProducto(Producto producto) {
		getSqlMapClientTemplate().update("mantenimiento.PRODUCTO.modificarProducto",producto);
	}

	
	public void eliminarProducto(Producto producto) {
		getSqlMapClientTemplate().delete("mantenimiento.PRODUCTO.eliminarProducto",producto);
	}

	
	public Producto agregarProducto(Producto producto) {
		return (Producto)getSqlMapClientTemplate().insert("mantenimiento.PRODUCTO.agregarProducto",producto);
	}
	
	

}
