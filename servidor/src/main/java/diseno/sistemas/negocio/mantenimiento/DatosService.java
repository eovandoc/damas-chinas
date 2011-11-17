package diseno.sistemas.negocio.mantenimiento;

import java.util.List;

import diseno.sistemas.dominio.mantenimiento.DatoGeneral;
import diseno.sistemas.dominio.mantenimiento.Producto;

public interface DatosService {
	
	
	public String getFechaSistema();
	/**
	 * Funciones para manejar Unidades de Medida
	 */
	
	public List<DatoGeneral> cargarUnidadesMedida();
	public DatoGeneral cargarUnidadMedidaPorCodigo(int codigo);
	public void modificarUnidadMedida(DatoGeneral datoGeneral);
	public void eliminarUnidadMedida(DatoGeneral datoGeneral);
	public DatoGeneral agregarUnidadMedida(DatoGeneral datoGeneral);
	
	
	public List<DatoGeneral> cargarTiposDocumento();
	

	public List<DatoGeneral> cargarPerfiles();
	
	public List<DatoGeneral> cargarTiposComprobante();
	
	public void ingresarTipoDocumento(DatoGeneral tipoDocumento);
	
	public void ingresarTipoComprobante(DatoGeneral tipoComprobante);
	
	public void ingresarPerfil(DatoGeneral perfil);
	
	public void eliminarTipoDocumento(DatoGeneral tipoDocumento);
	
	public void eliminarTipoComprobante(DatoGeneral tipoComprobante);
	
	public void eliminarPerfil(DatoGeneral perfil);
	
	/**
	 * Funciones relacionadas con los productos
	 */
	
	public List<Producto> cargarTodosLosProductos();
	public Producto cargarProducto(int codigo);
	public void modificarProducto(Producto producto);
	public Producto agregarProducto(Producto producto);
	public Producto eliminarProducto(int codigo);
}
