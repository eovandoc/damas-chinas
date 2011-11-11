package diseno.sistemas.presentacion.principal;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import diseno.sistemas.dominio.mantenimiento.Usuario;
import diseno.sistemas.service.Service;
import diseno.sistemas.util.DatosEvent;
import diseno.sistemas.util.DatosListener;
import info.clearthought.layout.TableLayout;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import javax.swing.WindowConstants;
import org.jdesktop.application.Action;
import org.jdesktop.application.Application;
import org.jdesktop.application.ApplicationActionMap;
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
public class LoginFrame extends javax.swing.JFrame {
	private JLabel lblSapo;
	private JLabel lblLogo;
	private JButton btnIngresar;
	private JLabel jLabel1;
	private JLabel lblPassword;
	private JLabel lblCuenta;
	private JPasswordField txtPassword;
	private JTextField txtxCuenta;
	private JPanel panelForm;
	
	private DatosListener listener;
	private Service service;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public LoginFrame(DatosListener listener,Service service) {
		super();
		initGUI();
		setLocationRelativeTo(null);
		this.listener=listener;
		this.service=service;
		this.setVisible(true);
	}
	
	private void initGUI() {
		try {
			{
			}
			GridBagLayout thisLayout = new GridBagLayout();
			thisLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.1};
			thisLayout.rowHeights = new int[] {14, 70, 113, 20};
			thisLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.0};
			thisLayout.columnWidths = new int[] {43, 231, 79, 18};
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(thisLayout);
			{
				lblSapo = new JLabel();
				getContentPane().add(lblSapo, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				lblSapo.setName("lblSapo");
				lblSapo.setSize(100, 20);
			}
			{
				panelForm = new JPanel();
				GridBagLayout panelFormLayout = new GridBagLayout();
				panelFormLayout.columnWidths = new int[] {92, 11, 7, 7};
				panelFormLayout.rowHeights = new int[] {20, 7, 7, 7};
				panelFormLayout.columnWeights = new double[] {0.0, 0.0, 0.1, 0.0};
				panelFormLayout.rowWeights = new double[] {0.0, 0.1, 0.1, 0.1};
				getContentPane().add(panelForm, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				panelForm.setLayout(panelFormLayout);
				{
					txtxCuenta = new JTextField();
					panelForm.add(txtxCuenta, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					txtxCuenta.setName("txtxCuenta");
				}
				{
					txtPassword = new JPasswordField();
					panelForm.add(txtPassword, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					lblCuenta = new JLabel();
					panelForm.add(lblCuenta, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					lblCuenta.setName("lblCuenta");
				}
				{
					lblPassword = new JLabel();
					panelForm.add(lblPassword, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					lblPassword.setName("lblPassword");
				}
			}
			{
				lblLogo = new JLabel();
				getContentPane().add(lblLogo, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				lblLogo.setName("lblLogo");
			}
			{
				jLabel1 = new JLabel();
				jLabel1.setLayout(null);
				getContentPane().add(jLabel1, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				jLabel1.setName("jLabel1");
			}
			{
				btnIngresar = new JButton();
				getContentPane().add(btnIngresar, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
				btnIngresar.setName("btnIngresar");
				btnIngresar.setAction(getAppActionMap().get("iniciarSesionAction"));
			}
			pack();
			setSize(400, 300);
			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(getContentPane());
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	public DatosListener getListener() {
		return listener;
	}

	public void setListener(DatosListener listener) {
		this.listener = listener;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	@Action
	public void iniciarSesionAction() {
		Usuario usuario=new Usuario();
		usuario.setCodigo(txtxCuenta.getText());
		usuario.setPassword(txtPassword.getText());
		try {
			usuario=service.iniciarSesion(usuario);
			DatosEvent datosEvent=new DatosEvent(this,usuario,"InicioSesion");
			listener.notificarCambios(datosEvent);
			this.dispose();
		} catch (NullPointerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this,"Usuario o contraseña incorrectos","Error de Inicio de Sesión",JOptionPane.ERROR_MESSAGE);
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

}
