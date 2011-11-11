package diseno.sistemas.util;

import javax.faces.context.FacesContext;

import diseno.sistemas.dominio.mantenimiento.Usuario;

public class SessionBean {

	public static Usuario getUsuario() {
		return (Usuario) FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get("usuario");
	}
	
	public static void setUsuario(Usuario usuario){
		FacesContext.getCurrentInstance().getExternalContext()
		.getSessionMap().put("usuario",usuario);
	}
	
	public static void removeUsuario(){
		FacesContext.getCurrentInstance().getExternalContext()
		.getSessionMap().remove("usuario");
		
	}

}
