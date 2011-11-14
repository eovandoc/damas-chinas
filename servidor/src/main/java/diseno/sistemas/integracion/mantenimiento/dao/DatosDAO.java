package diseno.sistemas.integracion.mantenimiento.dao;

import java.util.List;

import diseno.sistemas.dominio.mantenimiento.DatoGeneral;
import diseno.sistemas.dominio.mantenimiento.Producto;

public interface DatosDAO {
	
public List<DatoGeneral> cargarTiposDocumento();
	
	/**
	 * Funciones para manejar Unidades de Medida
	 */
	
	public List<DatoGeneral> cargarUnidadesMedida();
	public DatoGeneral cargarUnidadMedidaPorCodigo(int codigo);
	public void modificarUnidadMedida(DatoGeneral datoGeneral);
	public void eliminarUnidadMedida(DatoGeneral datoGeneral);
	public DatoGeneral agregarUnidadMedida(DatoGeneral datoGeneral);

	public List<DatoGeneral> cargarPerfiles();
	
	public List<DatoGeneral> cargarTiposComprobante();
	
	public void ingresarTipoDocumento(DatoGeneral tipoDocumento);
	
	public void ingresarTipoComprobante(DatoGeneral tipoComprobante);
	
	public void ingresarPerfil(DatoGeneral perfil);
	
	public void eliminarTipoDocumento(DatoGeneral tipoDocumento);
	
	public void eliminarTipoComprobante(DatoGeneral tipoComprobante);
	
	public void eliminarPerfil(DatoGeneral perfil);
	
	public List<Producto> cargarTodosLosProductos();
}
