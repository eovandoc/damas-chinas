package diseno.sistemas.presentacion.mantenimiento;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;

import diseno.sistemas.dominio.mantenimiento.Usuario;
import diseno.sistemas.negocio.mantenimiento.LoginService;
import diseno.sistemas.util.SessionBean;

@ManagedBean
@RequestScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 3210911292116596461L;
	
	
	private Usuario usuario = new Usuario();

	@ManagedProperty(value="#{loginService}")
	private LoginService loginService;
	
	public LoginController(){
		
	}
	
	public String iniciarSesion() {
		
		System.out.println("entrar a iniciar sesion");
		usuario = loginService.iniciarSesion(usuario);

		if (usuario != null) {
			SessionBean.setUsuario(usuario);
			return "bienvenida";
		} else {
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_WARN,
									"Usuario o contraseña incorrectos =( . Intente otra vez",
									""));
			return null;
		}
	}
	
	public String cerrarSesion(){
		SessionBean.removeUsuario();
		return "default";
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
