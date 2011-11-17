package diseno.sistemas.integracion.mantenimiento.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import diseno.sistemas.dominio.mantenimiento.DatoGeneral;
import diseno.sistemas.dominio.mantenimiento.Producto;
import diseno.sistemas.integracion.mantenimiento.dao.DatosDAO;

public class DatosDAOImpl extends SqlMapClientDaoSupport implements DatosDAO{
		
	public String getFechaSistema() {
		return (String)getSqlMapClientTemplate().queryForObject("mantenimiento.DATOS.fechaSistema");
	}
	
	/**
	 * Funciones para manejar Unidades de Medida
	 */
	
	@SuppressWarnings("unchecked")
	public List<DatoGeneral> cargarUnidadesMedida() {
		return getSqlMapClientTemplate().queryForList("mantenimiento.DATOS.cargarUnidadesMedida"); 
	}

	public DatoGeneral cargarUnidadMedidaPorCodigo(int codigo) {
		return (DatoGeneral)getSqlMapClientTemplate().queryForObject("mantenimiento.DATOS.cargarUnidadMedidaPorCodigo",codigo);
	}

	public void modificarUnidadMedida(DatoGeneral datoGeneral) {
		getSqlMapClientTemplate().update("mantenimiento.DATOS.modificarUnidadesMedida",datoGeneral);
	}

	public void eliminarUnidadMedida(DatoGeneral datoGeneral) {
		getSqlMapClientTemplate().delete("mantenimiento.DATOS.eliminarUnidadMedida",datoGeneral);
		
	}

	public DatoGeneral agregarUnidadMedida(DatoGeneral datoGeneral) {
		return (DatoGeneral)getSqlMapClientTemplate().insert("mantenimiento.DATOS.agregarUnidadMedida", datoGeneral);
	}

	
	@SuppressWarnings("unchecked")
	public List<DatoGeneral> cargarTiposDocumento() {
		return getSqlMapClientTemplate().queryForList("mantenimiento.MANTENIMIENTO.cargarTiposDocumento");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DatoGeneral> cargarPerfiles() {
		return getSqlMapClientTemplate().queryForList("mantenimiento.MANTENIMIENTO.cargarPerfiles");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DatoGeneral> cargarTiposComprobante() {
		return getSqlMapClientTemplate().queryForList("mantenimiento.MANTENIMIENTO.cargarTiposComprobante");
	}

	@Override
	public void ingresarTipoDocumento(DatoGeneral tipoDocumento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ingresarTipoComprobante(DatoGeneral tipoComprobante) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ingresarPerfil(DatoGeneral perfil) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarTipoDocumento(DatoGeneral tipoDocumento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarTipoComprobante(DatoGeneral tipoComprobante) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarPerfil(DatoGeneral perfil) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	public List<Producto> cargarTodosLosProductos() {
		System.out.println("Esntro al dao");
		return getSqlMapClientTemplate().queryForList("mantenimiento.PRODUCTO.cargarTodosLosProductos");		
	}



}
