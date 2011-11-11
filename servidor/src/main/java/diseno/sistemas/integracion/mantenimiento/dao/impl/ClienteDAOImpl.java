package diseno.sistemas.integracion.mantenimiento.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import diseno.sistemas.dominio.mantenimiento.Cliente;
import diseno.sistemas.integracion.mantenimiento.dao.ClienteDAO;


public class ClienteDAOImpl extends SqlMapClientDaoSupport implements ClienteDAO {

	@SuppressWarnings("unchecked")
	public List<Cliente> cargarTodosLosClientes() {
		System.out.println("Entro al DAO");
		return getSqlMapClientTemplate().queryForList("mantenimiento.CLIENTES.cargarTodosLosClientes");
	}
	
	

}
