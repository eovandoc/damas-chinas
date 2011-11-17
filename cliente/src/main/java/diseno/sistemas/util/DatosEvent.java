package diseno.sistemas.util;

import java.util.EventObject;

import diseno.sistemas.dominio.mantenimiento.Cliente;
import diseno.sistemas.dominio.mantenimiento.Usuario;
	
//Clase que define el suceso(event) personalizado, es decir 
//indica que algo ha sucedido, en este caso que los valores 
//de las propiedades de Data_General han cambiado

public class DatosEvent extends EventObject {	

	private static final long serialVersionUID = -2088981285848768238L;
	private Usuario usuario;
	private String origen;
	private Cliente cliente;
		
	//El primer parametro indica la fuente del sucesso
	
	public DatosEvent(Object fuente,String origen){
		super(fuente);
		this.origen=origen;
	}
	
	public DatosEvent(Object fuente, Usuario usuario, String origen,Cliente cliente) {		
		super(fuente);
		this.usuario=usuario;
		this.origen=origen;
		this.cliente=cliente;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

}