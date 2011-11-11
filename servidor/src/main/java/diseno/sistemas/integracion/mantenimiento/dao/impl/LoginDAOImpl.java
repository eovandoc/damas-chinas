package diseno.sistemas.integracion.mantenimiento.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import diseno.sistemas.dominio.mantenimiento.Usuario;
import diseno.sistemas.integracion.mantenimiento.dao.LoginDAO;



public class LoginDAOImpl extends SqlMapClientDaoSupport implements LoginDAO {
	
	
	public Usuario iniciarSesion(Usuario usuario) {
		Usuario u=(Usuario)getSqlMapClientTemplate().queryForObject("mantenimiento.USUARIOS.iniciarSesion",usuario);
		return u;
	}	
}
