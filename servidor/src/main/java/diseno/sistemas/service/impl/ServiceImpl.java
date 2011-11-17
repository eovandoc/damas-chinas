package diseno.sistemas.service.impl;

import java.util.List;

import diseno.sistemas.dominio.mantenimiento.Cliente;
import diseno.sistemas.dominio.mantenimiento.Usuario;
import diseno.sistemas.negocio.mantenimiento.ClienteService;
import diseno.sistemas.negocio.mantenimiento.DatosService;
import diseno.sistemas.negocio.mantenimiento.LoginService;
import diseno.sistemas.service.Service;

public class ServiceImpl implements Service {

	private LoginService loginService;
	private ClienteService clienteService;
	private DatosService datosService;
	
	public String saludo() {
		return "Hola desde el servidor 2";
	}

	
	public Usuario iniciarSesion(Usuario usuario) {
		System.out.println("Probando con "+usuario.getCuenta()+" "+usuario.getPassword());
		return loginService.iniciarSesion(usuario); 
	}

	public String getFechaSistema() {
		return datosService.getFechaSistema();
	}
	
	public List<Cliente> cargarTodosLosClientes(){
		return clienteService.cargarTodosLosClientes();	
	}
	

	public LoginService getLoginService() {
		return loginService;
	}


	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}


	public ClienteService getClienteService() {
		return clienteService;
	}


	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}


	public DatosService getDatosService() {
		return datosService;
	}


	public void setDatosService(DatosService datosService) {
		this.datosService = datosService;
	}


	

}
