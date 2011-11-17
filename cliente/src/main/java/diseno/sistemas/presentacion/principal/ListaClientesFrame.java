package diseno.sistemas.presentacion.principal;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

import javax.swing.WindowConstants;

import org.jdesktop.application.Action;
import org.jdesktop.application.Application;
import org.jdesktop.application.ApplicationActionMap;

import diseno.sistemas.dominio.ventas.ClienteTableModel;
import diseno.sistemas.service.Service;
import diseno.sistemas.util.DatosEvent;
import diseno.sistemas.util.DatosListener;


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
	private JButton btnAceptar;
	private JLabel lblListaClientes;
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
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				lblListaClientes = new JLabel();
				getContentPane().add(lblListaClientes, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				lblListaClientes.setName("lblListaClientes");
				lblListaClientes.setBounds(161, 12, 132, 20);
			}
			{
				btnCancelar = new JButton();
				getContentPane().add(btnCancelar, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
				btnCancelar.setName("btnCancelar");
				btnCancelar.setAction(getAppActionMap().get("cancelarAction"));
				btnCancelar.setBounds(263, 261, 104, 58);
			}
			{
				btnAceptar = new JButton();
				getContentPane().add(btnAceptar, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
				btnAceptar.setName("btnAceptar");
				btnAceptar.setAction(getAppActionMap().get("aceptarAction"));
				btnAceptar.setBounds(94, 260, 93, 59);
			}
			{

				tablaClientes = new JTable();
				getContentPane().add(tablaClientes, new GridBagConstraints(1, 3, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				tablaClientes.setModel(clienteTableModel);
				tablaClientes.setBounds(41, 44, 386, 203);
			}
			pack();
			this.setSize(484, 367);
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
		if(tablaClientes.getSelectedRow()!=-1){
			DatosEvent evento= new DatosEvent(this,"listaClientesFrame");
			evento.setCliente(clienteTableModel.getCliente(tablaClientes.getSelectedRow()));
			listener.notificarCambios(evento);
			this.dispose();
		}
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
	
	public JTable getTablaClientes() {
		return tablaClientes;
	}

}
