package diseno.sistemas.presentacion.principal;

import java.awt.SplashScreen;

import javax.swing.WindowConstants;


import javax.swing.SwingUtilities;

public class Aplicacion extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 355066965463462970L;
	/**
	* Auto-generated main method to display this JFrame
	*/
	
	private Splash splash;
		
	public Aplicacion(Splash splash) {
		
		super();
		this.splash=splash;
		setProgress(0,"Cargando componentes...");
		initGUI();
		incrementarBarra();
		
	}
	
	private void setProgress(int percent, String information){  
		splash.getLabel().setText(information);  
		splash.getProgressBar().setValue(percent);  
          
        /* 
         este Thread.sleep es solamente para que el Thread se duerma un momento 
         * cada vez que ingresamos un nuevo porcentaje al SplashScreen, de lo contrario 
         * la barra avanzaria demasiado rapido y no la veriamos, en una 
         * aplicacion real, esto no seria nesesario, ya que la aplicacion 
         * en verdad se tardaria al cargar acciones y metodos 
         */  
        try {  
            Thread.sleep(1000);  
        } catch (InterruptedException ex) {  
        }  
    } 
	
	public void incrementarBarra(){
        setProgress(40, "Conectandose al servidor...");  
        setProgress(80, "Cargando interfaz grafica...");  
        setProgress(100, "¡Bienvenido al sistema!");  
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	
	public void setSplash(Splash splash) {
		this.splash = splash;
	}

	public Splash getSplash() {
		return splash;
	}

}
