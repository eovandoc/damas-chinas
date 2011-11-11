package diseno.sistemas.service;

import diseno.sistemas.dominio.mantenimiento.Usuario;

public interface Service {
	
	public String saludo();
	public Usuario iniciarSesion(Usuario usuario);

}
