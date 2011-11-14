package diseno.sistemas.presentacion.mantenimiento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import diseno.sistemas.dominio.mantenimiento.Producto;
import diseno.sistemas.negocio.mantenimiento.DatosService;
import diseno.sistemas.negocio.mantenimiento.ProductoService;

@ManagedBean
@ViewScoped
public class ProductoController implements Serializable {

	private static final long serialVersionUID = -4542212410023236117L;

	@ManagedProperty(value = "#{productoService}")
	private ProductoService productoService;

	private List<Producto> listaProductos = new ArrayList<Producto>();
	private Producto productoSeleccionado;
	private Producto nuevoProducto;
	
	public ProductoController(){
			productoSeleccionado=new Producto();
			nuevoProducto=new Producto();
	}
	
	
	@PostConstruct
	public void cargarProductos() {
		listaProductos = productoService.cargarTodosLosProductos();
	}

	public void eliminarProducto(){
		try {
			productoService.eliminarProducto(productoSeleccionado);
			FacesContext.getCurrentInstance().
			addMessage(null,new FacesMessage("Producto eliminado",
					"Se elimin\u00F3 el producto "+productoSeleccionado.getDescripcion()));
			listaProductos.remove(productoSeleccionado);
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().
			addMessage(null,new FacesMessage("Problema al eliminar producto",
					"Se produjo un error al eliminar el producto "+productoSeleccionado.getDescripcion()));
		}
		
	}
	
	public void agregarProducto(){
		try {
			nuevoProducto=productoService.agregarProducto(nuevoProducto);
			listaProductos.add(nuevoProducto);
			FacesContext.getCurrentInstance().
			addMessage(null,new FacesMessage("Producto agregado",
					"Se agreg\u00F3 el producto "+nuevoProducto.getDescripcion()));
			nuevoProducto=new Producto();
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().
			addMessage(null,new FacesMessage("Problema al agregar producto",
					"Se produjo un error al agregar el producto "+nuevoProducto.getDescripcion()));
		}
		
	}
	
	public void editarProducto(){
		try {
			productoService.modificarProducto(productoSeleccionado);
			FacesContext.getCurrentInstance().
			addMessage(null,new FacesMessage("Producto modificado",
					"Se modific\u00F3 el producto "+productoSeleccionado.getDescripcion()));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().
			addMessage(null,new FacesMessage("Problema al modificar producto",
					"Se produjo un error al modificar el producto "+productoSeleccionado.getDescripcion()));
		}
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public Producto getProductoSeleccionado() {
		return productoSeleccionado;
	}

	public void setProductoSeleccionado(Producto productoSeleccionado) {
		this.productoSeleccionado = productoSeleccionado;
	}


	public void setNuevoProducto(Producto nuevoProducto) {
		this.nuevoProducto = nuevoProducto;
	}


	public Producto getNuevoProducto() {
		return nuevoProducto;
	}


	public ProductoService getProductoService() {
		return productoService;
	}


	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}
}
