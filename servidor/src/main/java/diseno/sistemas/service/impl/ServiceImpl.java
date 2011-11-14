package diseno.sistemas.service.impl;

import diseno.sistemas.dominio.mantenimiento.Usuario;
import diseno.sistemas.negocio.mantenimiento.ClienteService;
import diseno.sistemas.negocio.mantenimiento.LoginService;
import diseno.sistemas.service.Service;

public class ServiceImpl implements Service {

	LoginService loginService;
	ClienteService clienteService;
	
	public String saludo() {
		return "Hola desde el servidor";
	}

	
	public Usuario iniciarSesion(Usuario usuario) {
		System.out.println("Probando con "+usuario.getCuenta()+" "+usuario.getPassword());
		return loginService.iniciarSesion(usuario); 
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

}
