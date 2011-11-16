package diseno.sistemas.presentacion.principal;
import com.cloudgarden.layout.AnchorLayout;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jdesktop.application.Application;
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
public class BaseFrame extends javax.swing.JFrame {
	private JMenuBar menuBar;
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
	private JButton jButton1;
	private JButton btnBuscarVendedor;
	private JLabel lblCliente;
	private JLabel txtCodigo;
	private JTextField txtVendedor;
	private JLabel lblVendedor;
	private JButton btnBuscarClientes;
	private JTextField txtCliente;
	private JLabel lblProductos;
	private JLabel lblCodigo;
	private JPanel panelNuevaVenta;
	private JButton btnNuevaVenta;
	private JPanel panelCentral;
	private JMenu Sistema;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public BaseFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(thisLayout);
			{
				panelCentral = new JPanel();
				GridBagLayout panelCentralLayout = new GridBagLayout();
				getContentPane().add(panelCentral, BorderLayout.CENTER);
				panelCentralLayout.rowWeights = new double[] {0.0, 0.1, 0.1, 0.1};
				panelCentralLayout.rowHeights = new int[] {64, 7, 7, 7};
				panelCentralLayout.columnWeights = new double[] {0.0, 0.0, 0.1, 0.1};
				panelCentralLayout.columnWidths = new int[] {226, 223, 7, 7};
				panelCentral.setLayout(panelCentralLayout);
				{
					btnNuevaVenta = new JButton();
					panelCentral.add(btnNuevaVenta, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					btnNuevaVenta.setName("btnNuevaVenta");
				}
			}
			{
				menuBar = new JMenuBar();
				setJMenuBar(menuBar);
				{
					Sistema = new JMenu();
					menuBar.add(Sistema);
					Sistema.setName("Sistema");
					Sistema.setSize(50, 21);
				}
			}
			pack();
			this.setSize(700, 450);
			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(getContentPane());
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private JPanel getPanelNuevaVenta() {
		if(panelNuevaVenta == null) {
			panelNuevaVenta = new JPanel();
			GridBagLayout panelNuevaVentaLayout = new GridBagLayout();
			panelNuevaVentaLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
			panelNuevaVentaLayout.rowHeights = new int[] {11, 20, 20, 24, 163, 20, 20, 20, 19};
			panelNuevaVentaLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1};
			panelNuevaVentaLayout.columnWidths = new int[] {18, 106, 92, 82, 31, 86, 63, 81, 20};
			panelNuevaVenta.setPreferredSize(new java.awt.Dimension(585, 356));
			panelNuevaVenta.setLayout(panelNuevaVentaLayout);
			panelNuevaVenta.setSize(692, 391);
			panelNuevaVenta.add(getLblCodigo(), new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getLblCliente(), new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getTxtCodigo(), new GridBagConstraints(-1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getLblProductos(), new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getTxtCliente(), new GridBagConstraints(2, 2, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getJButton1(), new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getLblVendedor(), new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getTxtVendedor(), new GridBagConstraints(2, 6, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getBtnBuscarVendedor(), new GridBagConstraints(4, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getLblObservaciones(), new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getJButton1x(), new GridBagConstraints(2, 7, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getTablaProductos(), new GridBagConstraints(1, 4, 7, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getLblTotal(), new GridBagConstraints(6, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getLblIGV(), new GridBagConstraints(6, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getTxtTotal(), new GridBagConstraints(7, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getTxtIGV(), new GridBagConstraints(7, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getBtnGuardar(), new GridBagConstraints(6, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getBtnCancelar(), new GridBagConstraints(7, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getLblFecha(), new GridBagConstraints(6, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			panelNuevaVenta.add(getTxtFecha(), new GridBagConstraints(7, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		}
		return panelNuevaVenta;
	}
	
	private JLabel getLblCodigo() {
		if(lblCodigo == null) {
			lblCodigo = new JLabel();
			lblCodigo.setName("lblCodigo");
		}
		return lblCodigo;
	}

	private JLabel getLblCliente() {
		if(lblCliente == null) {
			lblCliente = new JLabel();
			lblCliente.setName("lblCliente");
		}
		return lblCliente;
	}
	
	private JLabel getTxtCodigo() {
		if(txtCodigo == null) {
			txtCodigo = new JLabel();
		}
		return txtCodigo;
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
	
	private JButton getJButton1x() {
		if(jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setName("jButton1");
		}
		return jButton1;
	}
	
	private JTable getTablaProductos() {
		if(tablaProductos == null) {
			TableModel tablaProductosModel = 
				new DefaultTableModel(
						new String[][] { { "One", "Two" }, { "Three", "Four" } },
						new String[] { "Column 1", "Column 2" });
			tablaProductos = new JTable();
			tablaProductos.setModel(tablaProductosModel);
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
		}
		return btnCancelar;
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
		}
		return txtFecha;
	}

}
