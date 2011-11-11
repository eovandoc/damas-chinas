package diseno.sistemas.presentacion.principal;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import javax.swing.WindowConstants;
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
public class Splash extends javax.swing.JFrame {
	private Splash splash=this;
	private JPanel jPanel1;
	private JProgressBar progressBar;
	private JLabel label;
	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public Splash() {
		super();
		setUndecorated(true);
		initGUI();
		setLocationRelativeTo(null);
		setVisible(true);
		iniciarHilo();
	}
	
	private void initGUI() {
		try {

			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jPanel1 = new JPanel();
				GridBagLayout jPanel1Layout = new GridBagLayout();
				jPanel1Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.1};
				jPanel1Layout.rowHeights = new int[] {96, 96, 23, 7};
				jPanel1Layout.columnWeights = new double[] {0.0, 0.0, 0.1};
				jPanel1Layout.columnWidths = new int[] {50, 290, 7};
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1);
				jPanel1.setPreferredSize(new java.awt.Dimension(378, 253));
				jPanel1.setBounds(0, 0, 400, 300);
				{
					progressBar = new JProgressBar();
					jPanel1.add(progressBar, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					progressBar.setPreferredSize(new java.awt.Dimension(400, 149));
				}
				{
					label = new JLabel();
					jPanel1.add(label, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					label.setPreferredSize(new java.awt.Dimension(18, 55));
					label.setName("label");
				}
			}
			pack();
			this.setSize(400, 300);
			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(getContentPane());
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void iniciarHilo(){  
        Thread thread = new Thread(new Runnable() {  
  
            public void run() {  
                //se envia el frame del splash a la aplicacion que deseamos abrir  
                Aplicacion aplicacion = new Aplicacion(splash);  
                //centro el frame  
                aplicacion.setLocationRelativeTo(null);  
                //hago el frame visible  
                aplicacion.setVisible(true);  
                //cuando set termita de instanciar el AplicationFrame el SplashFrame se cierra  
                dispose();  
            }  
        });  
        thread.start();  
    }

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}  
	

}
