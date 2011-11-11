package diseno.sistemas.negocio.mantenimiento;

import java.util.List;

import diseno.sistemas.dominio.mantenimiento.Cliente;

public interface ClienteService {
	
	public List<Cliente> cargarTodosLosClientes();

}
