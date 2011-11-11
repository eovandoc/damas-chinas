package diseno.sistemas.negocio.mantenimiento.impl;

import java.io.Serializable;
import java.util.List;

import diseno.sistemas.dominio.mantenimiento.DatoGeneral;
import diseno.sistemas.integracion.mantenimiento.dao.MantenimientoDAO;
import diseno.sistemas.negocio.mantenimiento.MantenimientoService;

public class MantenimientoServiceImpl implements MantenimientoService,Serializable {
	
	private MantenimientoDAO mantenimientoDAO;
	
	public MantenimientoDAO getMantenimientoDAO() {
		return mantenimientoDAO;
	}

	public void setMantenimientoDAO(MantenimientoDAO mantenimientoDAO) {
		this.mantenimientoDAO = mantenimientoDAO;
	}

	@Override
	public List<DatoGeneral> cargarTiposDocumento() {
		return mantenimientoDAO.cargarTiposDocumento();
	}

	@Override
	public List<DatoGeneral> cargarPerfiles() {
		return mantenimientoDAO.cargarPerfiles();
	}

	@Override
	public List<DatoGeneral> cargarTiposComprobante() {
		return mantenimientoDAO.cargarTiposComprobante();
	}

	@Override
	public void ingresarTipoDocumento(DatoGeneral tipoDocumento) {
		mantenimientoDAO.ingresarTipoDocumento(tipoDocumento);
		
	}

	@Override
	public void ingresarTipoComprobante(DatoGeneral tipoComprobante) {
		mantenimientoDAO.ingresarTipoComprobante(tipoComprobante);
		
	}

	@Override
	public void ingresarPerfil(DatoGeneral perfil) {
		mantenimientoDAO.ingresarPerfil(perfil);
		
	}

	@Override
	public void eliminarTipoDocumento(DatoGeneral tipoDocumento) {
		mantenimientoDAO.eliminarTipoDocumento(tipoDocumento);
		
	}

	@Override
	public void eliminarTipoComprobante(DatoGeneral tipoComprobante) {
		mantenimientoDAO.eliminarTipoComprobante(tipoComprobante);
	}

	@Override
	public void eliminarPerfil(DatoGeneral perfil) {
		mantenimientoDAO.eliminarPerfil(perfil);
	}

}
