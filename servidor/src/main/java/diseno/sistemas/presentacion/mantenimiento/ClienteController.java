package diseno.sistemas.presentacion.mantenimiento;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import diseno.sistemas.dominio.mantenimiento.Cliente;
import diseno.sistemas.negocio.mantenimiento.ClienteService;



@ManagedBean
@ViewScoped
public class ClienteController implements Serializable{
	
	private static final long serialVersionUID = -2965560144677348728L;

	
	@ManagedProperty("#{clienteService}")
	private ClienteService clienteService;
	
	private List<Cliente> listaClientes;
	
	public ClienteController(){

	}
	
	public void cargarClientes(){
		listaClientes=clienteService.cargarTodosLosClientes();
	}
	
	public String getVista(){
		return "administracionClientes";
	}
	
	
	public ClienteService getClienteService() {
		return clienteService;
	}
	
	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	public List<Cliente> getListaClientes() {
		return 	clienteService.cargarTodosLosClientes();
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	
	
}
