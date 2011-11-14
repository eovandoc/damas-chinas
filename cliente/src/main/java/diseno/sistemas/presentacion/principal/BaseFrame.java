package diseno.sistemas.presentacion.principal;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
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
	private JPanel jPanel1;
	private JMenu jMenu1;

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
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.SOUTH);
				jPanel1.setPreferredSize(new java.awt.Dimension(694, 30));
				jPanel1.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			}
			{
				menuBar = new JMenuBar();
				setJMenuBar(menuBar);
				{
					jMenu1 = new JMenu();
					menuBar.add(jMenu1);
					jMenu1.setName("jMenu1");
				}
			}
			pack();
			this.setSize(600, 450);
			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(getContentPane());
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
