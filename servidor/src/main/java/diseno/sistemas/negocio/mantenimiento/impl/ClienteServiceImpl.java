package diseno.sistemas.negocio.mantenimiento.impl;

import java.util.List;


import diseno.sistemas.dominio.mantenimiento.Cliente;
import diseno.sistemas.integracion.mantenimiento.dao.ClienteDAO;
import diseno.sistemas.negocio.mantenimiento.ClienteService;

public class ClienteServiceImpl implements ClienteService{

	private ClienteDAO clienteDAO;
	
	public List<Cliente> cargarTodosLosClientes() {
		return clienteDAO.cargarTodosLosClientes();
}



	
	
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	

}
