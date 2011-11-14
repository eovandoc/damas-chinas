package diseno.sistemas.negocio.mantenimiento.impl;

import java.io.Serializable;
import java.util.List;

import diseno.sistemas.dominio.mantenimiento.DatoGeneral;
import diseno.sistemas.dominio.mantenimiento.Producto;
import diseno.sistemas.integracion.mantenimiento.dao.DatosDAO;
import diseno.sistemas.negocio.mantenimiento.DatosService;

public class DatosServiceImpl implements DatosService {
	
	private DatosDAO datosDAO;
	
	
	@Override
	public List<DatoGeneral> cargarTiposDocumento() {
		return datosDAO.cargarTiposDocumento();
	}

	@Override
	public List<DatoGeneral> cargarPerfiles() {
		return datosDAO.cargarPerfiles();
	}

	@Override
	public List<DatoGeneral> cargarTiposComprobante() {
		return datosDAO.cargarTiposComprobante();
	}

	@Override
	public void ingresarTipoDocumento(DatoGeneral tipoDocumento) {
		datosDAO.ingresarTipoDocumento(tipoDocumento);
		
	}

	@Override
	public void ingresarTipoComprobante(DatoGeneral tipoComprobante) {
		datosDAO.ingresarTipoComprobante(tipoComprobante);
		
	}

	@Override
	public void ingresarPerfil(DatoGeneral perfil) {
		datosDAO.ingresarPerfil(perfil);
		
	}

	@Override
	public void eliminarTipoDocumento(DatoGeneral tipoDocumento) {
		datosDAO.eliminarTipoDocumento(tipoDocumento);
		
	}

	@Override
	public void eliminarTipoComprobante(DatoGeneral tipoComprobante) {
		datosDAO.eliminarTipoComprobante(tipoComprobante);
	}

	@Override
	public void eliminarPerfil(DatoGeneral perfil) {
		datosDAO.eliminarPerfil(perfil);
	}
	
	/**
	 * Funciones relacionadas con los productos
	 */
	
	@Override
	public List<Producto> cargarTodosLosProductos() {
		return datosDAO.cargarTodosLosProductos();
	}

	@Override
	public Producto cargarProducto(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarProducto(Producto producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto agregarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto eliminarProducto(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	public DatosDAO getDatosDAO() {
		return datosDAO;
	}

	public void setDatosDAO(DatosDAO datosDAO) {
		this.datosDAO = datosDAO;
	}
	
	
	/**
	 *	Funciones para manejar Unidades de Medida 
	 */
	
	
	public List<DatoGeneral> cargarUnidadesMedida() {
		return datosDAO.cargarUnidadesMedida();
	}

	public DatoGeneral cargarUnidadMedidaPorCodigo(int codigo) {
		return datosDAO.cargarUnidadMedidaPorCodigo(codigo);
	}


	public void modificarUnidadMedida(DatoGeneral datoGeneral) {
		datosDAO.modificarUnidadMedida(datoGeneral);
	}


	public void eliminarUnidadMedida(DatoGeneral datoGeneral) {
		datosDAO.eliminarUnidadMedida(datoGeneral);
	}

	public DatoGeneral agregarUnidadMedida(DatoGeneral datoGeneral) {
		return datosDAO.agregarUnidadMedida(datoGeneral);
	}

}
