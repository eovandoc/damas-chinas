package diseno.sistemas.presentacion.principal;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import diseno.sistemas.service.Service;
import diseno.sistemas.util.DatosEvent;
import diseno.sistemas.util.DatosListener;

public class Principal implements DatosListener{

	private Service service;
	/**
	 * Launch the application.
	 */
	
	public Principal() {
		super();
		cargarServicio();
		System.out.println(service.saludo());
		LoginFrame login=new LoginFrame(this,service);
		
	}


	public void notificarCambios(DatosEvent datosEvent) {
		System.out.println("Se ingreso con los datos del usuario "+datosEvent.getUsuario().getNombres());
	}
	
	public void cargarServicio(){
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
	    service = (Service)beanFactory.getBean("httpInvokerProxy");
	}


	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
	}

}
