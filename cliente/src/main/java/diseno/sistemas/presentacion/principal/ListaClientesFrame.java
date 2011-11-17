package diseno.sistemas.presentacion.principal;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jdesktop.application.Action;
import org.jdesktop.application.Application;
import org.jdesktop.application.ApplicationActionMap;

import diseno.sistemas.dominio.ventas.ClienteTableModel;
import diseno.sistemas.service.Service;
import diseno.sistemas.util.DatosListener;

import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class ListaClientesFrame extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2698967265616431373L;

	private Service service;
	private DatosListener listener;
	private ClienteTableModel clienteTableModel;
	private JButton btnCancelar;
	private JTable tablaClientes;
	private JLabel lblListaClientes;
	private JButton btnAceptar;
	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public ListaClientesFrame(DatosListener listener,Service service) {
		super();
		this.listener=listener;
		this.service=service;
		clienteTableModel=new ClienteTableModel(service.cargarTodosLosClientes());
		initGUI();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initGUI() {
		try {
			FormLayout thisLayout = new FormLayout(
					"max(p;5dlu), 21dlu, 104dlu, 106dlu", 
					"max(p;5dlu), 18dlu, 8dlu, 132dlu, 8dlu, 27dlu");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(thisLayout);
			{
				btnAceptar = new JButton();
				getContentPane().add(btnAceptar, new CellConstraints("3, 6, 1, 1, center, fill"));
				btnAceptar.setName("btnAceptar");
				btnAceptar.setAction(getAppActionMap().get("aceptarAction"));
			}
			{
				btnCancelar = new JButton();
				getContentPane().add(btnCancelar, new CellConstraints("4, 6, 1, 1, center, fill"));
				btnCancelar.setName("btnCancelar");
				btnCancelar.setAction(getAppActionMap().get("cancelarAction"));
			}
			{
				lblListaClientes = new JLabel();
				getContentPane().add(lblListaClientes, new CellConstraints("3, 2, 2, 1, center, default"));
				lblListaClientes.setName("lblListaClientes");
			}
			{
				tablaClientes = new JTable();
				getContentPane().add(tablaClientes, new CellConstraints("3, 4, 2, 1, fill, fill"));
				tablaClientes.setModel(clienteTableModel);
				
			}
			pack();
			this.setSize(400, 350);
			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(getContentPane());
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public ClienteTableModel getClienteTableModel() {
		return clienteTableModel;
	}

	public void setClienteTableModel(ClienteTableModel clienteTableModel) {
		this.clienteTableModel = clienteTableModel;
	}

	public void setListener(DatosListener listener) {
		this.listener = listener;
	}

	public DatosListener getListener() {
		return listener;
	}
	
	
	@Action
	public void aceptarAction() {
		
	}
	
    /**
    * Returns the action map used by this application.
     * Actions defined using the Action annotation
     * are returned by this method
     */
	private ApplicationActionMap getAppActionMap() {
		return Application.getInstance().getContext().getActionMap(this);
	}
	
	@Action
	public void cancelarAction() {
		this.dispose();
	}
	
}
