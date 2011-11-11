package diseno.sistemas.integracion.mantenimiento.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import diseno.sistemas.dominio.mantenimiento.DatoGeneral;
import diseno.sistemas.integracion.mantenimiento.dao.MantenimientoDAO;

public class MantenimientoDAOImpl extends SqlMapClientDaoSupport implements MantenimientoDAO {

	@SuppressWarnings("unchecked")
	@Override
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

}
