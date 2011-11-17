package diseno.sistemas.presentacion.principal;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import javax.swing.WindowConstants;
import org.jdesktop.application.Action;
import org.jdesktop.application.Application;
import org.jdesktop.application.ApplicationActionMap;

import diseno.sistemas.util.DatosEvent;
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
public class ObservacionesFrame extends javax.swing.JFrame {
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblObservaciones;
	private JTextArea txtArea;
	
	private DatosListener listener;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public ObservacionesFrame(DatosListener listener,String observaciones) {
		
		super();
		this.listener=listener;
		initGUI();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initGUI() {
		try {
			GridBagLayout thisLayout = new GridBagLayout();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			thisLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.1};
			thisLayout.rowHeights = new int[] {11, 43, 103, 24, 47, 7};
			thisLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
			thisLayout.columnWidths = new int[] {-1, 25, 151, 26, 150, 27};
			getContentPane().setLayout(thisLayout);
			{
				btnAceptar = new JButton();
				getContentPane().add(getBtnAceptar(), new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				btnAceptar.setName("btnAceptar");
				btnAceptar.setAction(getAppActionMap().get("aceptarAction"));
			}
			{
				btnCancelar = new JButton();
				getContentPane().add(getBtnCancelar(), new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				btnCancelar.setName("btnCancelar");
				btnCancelar.setAction(getAppActionMap().get("cancelarAction"));
			}
			{
				txtArea = new JTextArea();
				getContentPane().add(getTxtArea(), new GridBagConstraints(2, 2, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			}
			{
				lblObservaciones = new JLabel();
				getContentPane().add(getLblObservaciones(), new GridBagConstraints(2, 1, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
				lblObservaciones.setName("lblObservaciones");
			}
			pack();
			setSize(400, 300);
			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(getContentPane());
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public JButton getBtnAceptar() {
		return btnAceptar;
	}
	
	@Action
	public void aceptarAction() {
		DatosEvent evento=new DatosEvent(this,"observacionesFrame");
		evento.setObservaciones(txtArea.getText());
		System.out.println("enviando "+txtArea.getText());
		listener.notificarCambios(evento);
		this.dispose();
	}
	
    /**
    * Returns the action map used by this application.
     * Actions defined using the Action annotation
     * are returned by this method
     */
	private ApplicationActionMap getAppActionMap() {
		return Application.getInstance().getContext().getActionMap(this);
	}
    
    public JButton getBtnCancelar() {
    	return btnCancelar;
    }
    
	@Action
	public void cancelarAction() {
		this.dispose();
	}
		
	
	
	public JTextArea getTxtArea() {
		return txtArea;
	}
	
	public JLabel getLblObservaciones() {
		return lblObservaciones;
	}

	public DatosListener getListener() {
		return listener;
	}

	public void setListener(DatosListener listener) {
		this.listener = listener;
	}

}
