package diseno.sistemas.presentacion.mantenimiento;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import diseno.sistemas.dominio.mantenimiento.DatoGeneral;
import diseno.sistemas.negocio.mantenimiento.MantenimientoService;

@ManagedBean
@SessionScoped
public class MantenimientoController implements Serializable{

	private static final long serialVersionUID = 5662298712058774241L;
	
	@ManagedProperty("#{mantenimientoService}")
	private MantenimientoService mantenimientoService;
	
	private List<DatoGeneral> listaTipoDocumentos;
	private List<DatoGeneral> listaProductos;
	private List<DatoGeneral> listaPerfiles;
	private List<DatoGeneral> listaTipoComprobantes;
	private List<DatoGeneral> listaEstadoCredito;
	
	public MantenimientoController() {
		listaTipoDocumentos=mantenimientoService.cargarTiposDocumento();
		listaPerfiles=mantenimientoService.cargarPerfiles();
		listaTipoComprobantes=mantenimientoService.cargarTiposComprobante();
		
	}
	
	
	public MantenimientoService getMantenimientoService() {
		return mantenimientoService;
	}
	public void setMantenimientoService(MantenimientoService mantenimientoService) {
		this.mantenimientoService = mantenimientoService;
	}
	public List<DatoGeneral> getListaTipoDocumentos() {
		return listaTipoDocumentos;
	}
	public void setListaTipoDocumentos(List<DatoGeneral> listaTipoDocumentos) {
		this.listaTipoDocumentos = listaTipoDocumentos;
	}
	public List<DatoGeneral> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(List<DatoGeneral> listaProductos) {
		this.listaProductos = listaProductos;
	}
	public List<DatoGeneral> getListaPerfiles() {
		return listaPerfiles;
	}
	public void setListaPerfiles(List<DatoGeneral> listaPerfiles) {
		this.listaPerfiles = listaPerfiles;
	}
	public List<DatoGeneral> getListaTipoComprobantes() {
		return listaTipoComprobantes;
	}
	public void setListaTipoComprobantes(List<DatoGeneral> listaTipoComprobantes) {
		this.listaTipoComprobantes = listaTipoComprobantes;
	}
	public List<DatoGeneral> getListaEstadoCredito() {
		return listaEstadoCredito;
	}
	public void setListaEstadoCredito(List<DatoGeneral> listaEstadoCredito) {
		this.listaEstadoCredito = listaEstadoCredito;
	}
}
