package diseno.sistemas.negocio.mantenimiento.impl;

import diseno.sistemas.dominio.mantenimiento.Usuario;
import diseno.sistemas.integracion.mantenimiento.dao.LoginDAO;
import diseno.sistemas.negocio.mantenimiento.LoginService;


public class LoginServiceImpl implements LoginService {
	

	LoginDAO loginDAO;
	
	public Usuario iniciarSesion(Usuario usuario){
		return loginDAO.iniciarSesion(usuario);
	}

	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	

}
