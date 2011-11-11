package diseno.sistemas.integracion.mantenimiento.dao;

import java.util.List;

import diseno.sistemas.dominio.mantenimiento.DatoGeneral;

public interface MantenimientoDAO {
	
public List<DatoGeneral> cargarTiposDocumento();
	
	public List<DatoGeneral> cargarPerfiles();
	
	public List<DatoGeneral> cargarTiposComprobante();
	
	public void ingresarTipoDocumento(DatoGeneral tipoDocumento);
	
	public void ingresarTipoComprobante(DatoGeneral tipoComprobante);
	
	public void ingresarPerfil(DatoGeneral perfil);
	
	public void eliminarTipoDocumento(DatoGeneral tipoDocumento);
	
	public void eliminarTipoComprobante(DatoGeneral tipoComprobante);
	
	public void eliminarPerfil(DatoGeneral perfil);
	
}
