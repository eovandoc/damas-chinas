package diseno.sistemas.presentacion.mantenimiento;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class NavigationController implements Serializable{

	private static final long serialVersionUID = 2118559142733246368L;
	
	public String administracionClientes(){
		System.out.println("Entro al navegador clientes");
		return "pages/administracionClientes";
	}
	
	public String administracionProductos(){
		System.out.println("Entro al navegador productos");
		return "pages/administracionProductos";
	}
	
	public String administracionPerfiles(){
		return "pages/administracionPerfiles";
	}
	
	public String administracionUsuarios(){
		return "pages/administracionUsuarios";
	}
	
	public String administracionTipoComprobante(){
		return "pages/administracionTipoComprobante";
	}
	public String administracionTipoDocumento(){
		return "pages/administracionTipoDocumento";
	}
	public String administracionEstadoCredito(){
		return "pages/administracionEstadoCredito";
	}

}
