package diseno.sistemas.integracion.mantenimiento.dao;

import diseno.sistemas.dominio.mantenimiento.Usuario;

public interface LoginDAO {

	public Usuario iniciarSesion(Usuario usuario);
}
