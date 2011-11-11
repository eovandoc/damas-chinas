package diseno.sistemas.integracion.mantenimiento.dao;

import java.util.List;

import diseno.sistemas.dominio.mantenimiento.Cliente;

public interface ClienteDAO {
	
	public List<Cliente> cargarTodosLosClientes();

}
