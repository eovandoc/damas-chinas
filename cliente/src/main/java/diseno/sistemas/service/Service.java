package diseno.sistemas.service;

import java.util.List;

import diseno.sistemas.dominio.mantenimiento.Cliente;
import diseno.sistemas.dominio.mantenimiento.Usuario;

public interface Service {
	
	public String saludo();
	public Usuario iniciarSesion(Usuario usuario);
	public String getFechaSistema();
	public List<Cliente> cargarTodosLosClientes();

}