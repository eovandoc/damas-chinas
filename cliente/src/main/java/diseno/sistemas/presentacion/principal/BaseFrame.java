package diseno.sistemas.presentacion.principal;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.jdesktop.application.Action;
import org.jdesktop.application.Application;
import org.jdesktop.application.ApplicationActionMap;

import diseno.sistemas.dominio.ventas.VentaTableModel;
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
public class BaseFrame extends javax.swing.JFrame implements DatosListener {

	private JMenuItem helpMenuItem;
	private JMenu jMenu5;
	private JButton btnNuevaVenta;
	private JPanel panelNuevaVenta;
	private JPanel panelInicial;
	private JPanel panelBase;
	private JMenuItem deleteMenuItem;
	private JSeparator jSeparator1;
	private JMenuItem pasteMenuItem;
	private JMenuItem copyMenuItem;
	private JMenuItem cutMenuItem;
	private JMenu jMenu4;
	private JMenuItem exitMenuItem;
	private JSeparator jSeparator2;
	private JMenuItem closeFileMenuItem;
	private JMenuItem saveAsMenuItem;
	private JMenuItem saveMenuItem;
	private JMenuItem openFileMenuItem;
	private JMenuItem newFileMenuItem;
	private JMenu jMenu3;
	private JMenuBar jMenuBar1;
	private JLabel lblObservaciones;
	private JLabel txtFecha;
	private JLabel lblFecha;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JTextField txtIGV;
	private JTextField txtTotal;
	private JLabel lblIGV;
	private JLabel lblTotal;
	private JTable tablaProductos;
	private JButton btnBuscarVendedor;
	private JLabel lblCliente;
	private JTextField txtVendedor;
	private JLabel lblVendedor;
	private JButton btnBuscarClientes;
	private JTextField txtCliente;
	private JLabel lblProductos;
	private JButton btnObservaciones;
	private JLabel lblNuevaVenta;

	private VentaTableModel ventaTableModel;
	
	private DatosListener listener;
	private Service service;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public BaseFrame(DatosListener listener, Service service) {
		super();
		this.setListener(listener);
		this.service = service;
		initGUI();
		setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initGUI() {
		try {
			{
				panelBase = new JPanel();
				CardLayout panelBaseLayout = new CardLayout();
				getContentPane().add(panelBase, BorderLayout.CENTER);
				panelBase.setLayout(panelBaseLayout);
				panelBase.setPreferredSize(new java.awt.Dimension(692, 391));
				panelBase.add(getPanelInicial(), "cardInicial");
				panelBase.add(getPanelNuevaVenta(), "cardNuevaVenta");
				
			}
			this.setSize(700, 450);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					;
					jMenu3.setName("menuSistema");
					jMenu3.setText("Sistema");
					{
						newFileMenuItem = new JMenuItem();
						jMenu3.add(newFileMenuItem);
						newFileMenuItem.setText("New");
					}
					{
						openFileMenuItem = new JMenuItem();
						jMenu3.add(openFileMenuItem);
						openFileMenuItem.setText("Open");
					}
					{
						saveMenuItem = new JMenuItem();
						jMenu3.add(saveMenuItem);
						saveMenuItem.setText("Save");
					}
					{
						saveAsMenuItem = new JMenuItem();
						jMenu3.add(saveAsMenuItem);
						saveAsMenuItem.setText("Save As ...");
					}
					{
						closeFileMenuItem = new JMenuItem();
						jMenu3.add(closeFileMenuItem);
						closeFileMenuItem.setText("Close");
					}
					{
						jSeparator2 = new JSeparator();
						jMenu3.add(jSeparator2);
					}
					{
						exitMenuItem = new JMenuItem();
						jMenu3.add(exitMenuItem);
						exitMenuItem.setText("Exit");
					}
				}
				{
					jMenu4 = new JMenu();
					jMenuBar1.add(jMenu4);
					;
					jMenu4.setName("menuEditar");
					jMenu4.setText("Editar");
					{
						cutMenuItem = new JMenuItem();
						jMenu4.add(cutMenuItem);
						cutMenuItem.setText("Cut");
					}
					{
						copyMenuItem = new JMenuItem();
						jMenu4.add(copyMenuItem);
						copyMenuItem.setText("Copy");
					}
					{
						pasteMenuItem = new JMenuItem();
						jMenu4.add(pasteMenuItem);
						pasteMenuItem.setText("Paste");
					}
					{
						jSeparator1 = new JSeparator();
						jMenu4.add(jSeparator1);
					}
					{
						deleteMenuItem = new JMenuItem();
						jMenu4.add(deleteMenuItem);
						deleteMenuItem.setText("Delete");
					}
				}
				{
					jMenu5 = new JMenu();
					jMenuBar1.add(jMenu5);
					;
					jMenu5.setName("menuAyuda");
					jMenu5.setText("Ayuda");
					{
						helpMenuItem = new JMenuItem();
						jMenu5.add(helpMenuItem);
						helpMenuItem.setText("Help");
					}
				}
			}
			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(getContentPane());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cambiarPanel(String nombrePanel){
		((CardLayout)panelBase.getLayout()).show(panelBase,nombrePanel);
	}

	private JLabel getLblCliente() {
		if(lblCliente == null) {
			lblCliente = new JLabel();
			lblCliente.setName("lblCliente");
		}
		return lblCliente;
	}

	private JLabel getLblProductos() {
		if(lblProductos == null) {
			lblProductos = new JLabel();
			lblProductos.setName("lblProductos");
		}
		return lblProductos;
	}
	
	private JTextField getTxtCliente() {
		if(txtCliente == null) {
			txtCliente = new JTextField();
		}
		return txtCliente;
	}
	
	private JButton getJButton1() {
		if(btnBuscarClientes == null) {
			btnBuscarClientes = new JButton();
			btnBuscarClientes.setName("btnBuscarClientes");
			btnBuscarClientes.setAction(getAppActionMap().get("mostrarListaClientesAction"));
		}
		return btnBuscarClientes;
	}
	
	private JLabel getLblVendedor() {
		if(lblVendedor == null) {
			lblVendedor = new JLabel();
			lblVendedor.setName("lblVendedor");
		}
		return lblVendedor;
	}
	
	private JTextField getTxtVendedor() {
		if(txtVendedor == null) {
			txtVendedor = new JTextField();
		}
		return txtVendedor;
	}
	
	private JButton getBtnBuscarVendedor() {
		if(btnBuscarVendedor == null) {
			btnBuscarVendedor = new JButton();
			btnBuscarVendedor.setName("btnBuscarVendedor");
		}
		return btnBuscarVendedor;
	}
	
	private JLabel getLblObservaciones() {
		if(lblObservaciones == null) {
			lblObservaciones = new JLabel();
			lblObservaciones.setName("lblObservaciones");
		}
		return lblObservaciones;
	}
	
	private JTable getTablaProductos() {
		if(tablaProductos == null) {
			ventaTableModel=new VentaTableModel();
			tablaProductos = new JTable();
			tablaProductos.setModel(ventaTableModel);
			tablaProductos.setName("tableVentas");
		}
		return tablaProductos;
	}
	
	private JLabel getLblTotal() {
		if(lblTotal == null) {
			lblTotal = new JLabel();
			lblTotal.setName("lblTotal");
		}
		return lblTotal;
	}
	
	private JLabel getLblIGV() {
		if(lblIGV == null) {
			lblIGV = new JLabel();
			lblIGV.setName("lblIGV");
		}
		return lblIGV;
	}
	
	private JTextField getTxtTotal() {
		if(txtTotal == null) {
			txtTotal = new JTextField();
			txtTotal.setName("txtTotal");
		}
		return txtTotal;
	}
	
	private JTextField getTxtIGV() {
		if(txtIGV == null) {
			txtIGV = new JTextField();
			txtIGV.setName("txtIGV");
		}
		return txtIGV;
	}
	
	private JButton getBtnGuardar() {
		if(btnGuardar == null) {
			btnGuardar = new JButton();
			btnGuardar.setName("btnGuardar");
		}
		return btnGuardar;
	}
	
	private JButton getBtnCancelar() {
		if(btnCancelar == null) {
			btnCancelar = new JButton();
			btnCancelar.setName("btnCancelar");
			btnCancelar.setAction(getAppActionMap().get("cancelarVentaAction"));
		}
		return btnCancelar;
	}
	
	private JButton getJButton1x() {
		if(btnObservaciones == null) {
			btnObservaciones = new JButton();
			btnObservaciones.setName("btnObservaciones");
		}
		return btnObservaciones;
	}
	
	private JLabel getLblFecha() {
		if(lblFecha == null) {
			lblFecha = new JLabel();
			lblFecha.setName("lblFecha");
		}
		return lblFecha;
	}
	
	private JLabel getTxtFecha() {
		if(txtFecha == null) {
			txtFecha = new JLabel();
			txtFecha.setText(getService().getFechaSistema());
		}
		return txtFecha;
	}

	public VentaTableModel getVentaTableModel() {
		return ventaTableModel;
	}

	public void setVentaTableModel(VentaTableModel ventaTableModel) {
		this.ventaTableModel = ventaTableModel;
	}
	
	public JPanel getPanelInicial(){
		if(panelInicial==null){
			panelInicial = new JPanel();
			GridBagLayout panelInicialLayout = new GridBagLayout();
			
			panelInicialLayout.rowWeights = new double[] {0.1, 0.0, 0.1, 0.1};
			panelInicialLayout.rowHeights = new int[] {7, 61, 7, 7};
			panelInicialLayout.columnWeights = new double[] {0.0, 0.0, 0.1};
			panelInicialLayout.columnWidths = new int[] {242, 253, 7};
			panelInicial.setLayout(panelInicialLayout);
			{
				panelInicial.add(getBtnNuevaVenta(), new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			}
		}return panelInicial;
	}
	
	
	@Action
	public void abstractAction1() {
		cambiarPanel("cardNuevaVenta");
	}
	
    /**
    * Returns the action map used by this application.
     * Actions defined using the Action annotation
     * are returned by this method
     */
	private ApplicationActionMap getAppActionMap() {
		return Application.getInstance().getContext().getActionMap(this);
	}
    
  
    private JButton getBtnNuevaVenta(){
    	if(btnNuevaVenta==null){
    		btnNuevaVenta = new JButton();
    		btnNuevaVenta.setName("btnNuevaVenta");
			btnNuevaVenta.setAction(getAppActionMap().get("abstractAction1"));
    	}return btnNuevaVenta;
    }
    
    private JPanel getPanelNuevaVenta() {
		if(panelNuevaVenta == null) {
			panelNuevaVenta = new JPanel();
			GridBagLayout panelNuevaVentaLayout = new GridBagLayout();
			panelNuevaVentaLayout.columnWidths = new int[] {20, 7, 7, 7, 7, 7, 95, 95, 20};
			panelNuevaVentaLayout.rowHeights = new int[] {20, 20, 20, 25, 166, 10, 20, 20, 10, 37, 20};
			panelNuevaVentaLayout.columnWeights = new double[] {0.0, 0.1, 0.1, 0.1, 0.1, 0.1, 0.0, 0.0, 0.0};
			panelNuevaVentaLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1};
			panelNuevaVenta.setPreferredSize(new java.awt.Dimension(692, 416));
			panelNuevaVenta.setLayout(panelNuevaVentaLayout);
			panelNuevaVenta.setSize(692, 416);
			panelNuevaVenta.add(getLblCliente(), new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getLblProductos(), new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getTxtCliente(), new GridBagConstraints(2, 2, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getJButton1(), new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getLblVendedor(), new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getTxtVendedor(), new GridBagConstraints(2, 7, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getBtnBuscarVendedor(), new GridBagConstraints(4, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getLblObservaciones(), new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getJButton1x(), new GridBagConstraints(2, 9, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getTablaProductos(), new GridBagConstraints(1, 4, 7, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getLblTotal(), new GridBagConstraints(6, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getLblIGV(), new GridBagConstraints(6, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getTxtTotal(), new GridBagConstraints(7, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getTxtIGV(), new GridBagConstraints(7, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getBtnGuardar(), new GridBagConstraints(6, 9, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getBtnCancelar(), new GridBagConstraints(7, 9, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getLblFecha(), new GridBagConstraints(6, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getTxtFecha(), new GridBagConstraints(7, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getLblNuevaVenta(), new GridBagConstraints(1, 0, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		}
		return panelNuevaVenta;
	}
	
	@Action
	public void cancelarVentaAction() {
		cambiarPanel("cardInicial");
	}

	public void setListener(DatosListener listener) {
		this.listener = listener;
	}

	public DatosListener getListener() {
		return listener;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	private JLabel getLblNuevaVenta() {
		if(lblNuevaVenta == null) {
			lblNuevaVenta = new JLabel();
			lblNuevaVenta.setName("lblNuevaVenta");
		}
		return lblNuevaVenta;
	}
	
	@Action
	public void mostrarListaClientesAction() {
		//new ListaClientesFrame(this,getService());
		ListaClientesFrame listaClientesFrame=new ListaClientesFrame(this,service);
	}

	@Override
	public void notificarCambios(DatosEvent datosEvent) {
		if(datosEvent.getOrigen().equals("listaClientes"))
			System.out.println("Se vino de lista Clientes con el cliente"+datosEvent.getCliente().getNombres());
		
	}

}
