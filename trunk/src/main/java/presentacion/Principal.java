package presentacion;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import dominio.beans.Accion;
import dominio.beans.Coordenada;
import dominio.beans.Tablero;
import dominio.servicios.Juego;
import dominio.servicios.Movimientos;
import excepciones.MovimientoIlegalException;
import excepciones.PosicionIlegalException;

import javax.swing.JTable;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Point;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenuItem jMenNuevoJuego = null;
	private JMenuItem jMenuSalir = null;
	
	private Coordenada origen=null;  
	private Coordenada destino=null;  
	
	
	private JLabel[][] casillas={   {null,null,null,null,null,null,null,null,null,},
									{null,null,null,null,null,null,null,null,null,},
									{null,null,null,null,null,null,null,null,null,},
									{null,null,null,null,null,null,null,null,null,},
									{null,null,null,null,null,null,null,null,null,},
									{null,null,null,null,null,null,null,null,null,},
									{null,null,null,null,null,null,null,null,null,},
									{null,null,null,null,null,null,null,null,null,},
									{null,null,null,null,null,null,null,null,null,}};
	
	//private Tablero tablero=new Tablero();  
	private JLabel labelInfo = null;
	
	private static Juego juego=new Juego();  //  @jve:decl-index=0:
	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.setPreferredSize(new Dimension(0, 20));
			jJMenuBar.add(getJMenu());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new JMenu();
			jMenu.setText("Juego");
			jMenu.add(getJMenNuevoJuego());
			jMenu.add(getJMenuSalir());
		}
		return jMenu;
	}

	/**
	 * This method initializes jMenNuevoJuego	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenNuevoJuego() {
		if (jMenNuevoJuego == null) {
			jMenNuevoJuego = new JMenuItem();
			jMenNuevoJuego.setText("Nuevo Juego");
		}
		return jMenNuevoJuego;
	}

	/**
	 * This method initializes jMenuSalir	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuSalir() {
		if (jMenuSalir == null) {
			jMenuSalir = new JMenuItem();
			jMenuSalir.setText("Salir");
			 

		}
		return jMenuSalir;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Principal thisClass = new Principal();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
				
		
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public Principal() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(648, 560);
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("Damas Chinas");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		int tam=28;
		int x=280,y=10;
		
		if (jContentPane == null) {
			
			for(int i=0;i<casillas.length;i++){
				
				x=280-i*14;
				y=10+i*28;
				
				for(int j=0;j<casillas[i].length;j++){
					casillas[i][j]=new JLabel();
					casillas[i][j].setBounds((x+j*14),(y+j*28),tam,tam);
					
					deseleccionar(i,j);
					
					
					final int i2=i;
					final int j2=j;
					
					casillas[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
						public void mouseClicked(java.awt.event.MouseEvent e) {
							labelInfo.setText("");
							
							if(juego.getEstadoActual().getTablero().getCasilla(i2, j2)==juego.getEstadoActual().getTurno() || juego.getEstadoActual().getTablero().getCasilla(i2, j2)==0){
								if(origen==null){
									if(juego.getEstadoActual().getTablero().getCasilla(i2, j2)!=0){
										seleccionar(i2,j2);
										origen=new Coordenada(i2,j2);
									}
								}else{
									destino=new Coordenada(i2,j2);
									
									try {
										System.out.println("moviendo de "+origen.mostrar()+" a "+destino.mostrar());
										mover(new Accion(origen,destino));
										juego.jugadaHumano(new Accion(origen,destino));
										
									}catch (MovimientoIlegalException e1){
										e1.printStackTrace();
										labelInfo.setText("Movimiento No válido");
										deseleccionar(origen.getFila(),origen.getColumna());
										deseleccionar(destino.getFila(),destino.getColumna());
										origen=null;
									}
									origen=null;
									destino=null;
									
									try {
										juego.jugadaMaquina();
									} catch (MovimientoIlegalException e1) {
										e1.printStackTrace();
									}
	
								}
							}else{
								labelInfo.setText("No es el turno de esta ficha");
							}
							
						}
					});
				}
			}
			
			labelInfo = new JLabel();
			labelInfo.setBounds(new Rectangle(1, 487, 636, 16));
			labelInfo.setText("");

						
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(labelInfo, null);
			
			for(int i=0;i<casillas.length;i++){
				for(int j=0;j<casillas[i].length;j++)
					jContentPane.add(casillas[i][j],null);
			}
	
		}
		return jContentPane;
	}
	
	public void mover(Accion a) throws MovimientoIlegalException{
		if(juego.getEstadoActual().getTablero().getCasilla(a.getOrigen())!=0){
			if(juego.getEstadoActual().getTablero().getCasilla(a.getOrigen())==1){
				casillas[a.getDestino().getFila()][a.getDestino().getColumna()].setIcon(new ImageIcon(getClass().getResource("/img/roja.png")));
				//juego.getEstadoActual().getTablero().setCasilla(a.getOrigen(),0);
				//juego.getEstadoActual().getTablero().setCasilla(a.getDestino(),1);
			}
			else if(juego.getEstadoActual().getTablero().getCasilla(a.getOrigen())==2){
				casillas[a.getDestino().getFila()][a.getDestino().getColumna()].setIcon(new ImageIcon(getClass().getResource("/img/azul.png")));
				//juego.getEstadoActual().getTablero().setCasilla(a.getOrigen(),0);
				//juego.getEstadoActual().getTablero().setCasilla(a.getDestino(),2);
			}
			casillas[a.getOrigen().getFila()][a.getOrigen().getColumna()].setIcon(new ImageIcon(getClass().getResource("/img/vacia.png")));
		}
		else{
			throw new MovimientoIlegalException();
		}
	}
	
	
	public void seleccionar(int a,int b){
		if(juego.getEstadoActual().getTablero().getCasilla(a, b)==1){
			casillas[a][b].setIcon(new ImageIcon(getClass().getResource("/img/roja_sel.png")));
		}
		else if(juego.getEstadoActual().getTablero().getCasilla(a, b)==2){
			casillas[a][b].setIcon(new ImageIcon(getClass().getResource("/img/azul_sel.png")));
		}else{
			casillas[a][b].setIcon(new ImageIcon(getClass().getResource("/img/vacia.png")));
		}
	}
	
	public void deseleccionar(int a,int b){
		if(juego.getEstadoActual().getTablero().getCasilla(a, b)==1){
			casillas[a][b].setIcon(new ImageIcon(getClass().getResource("/img/roja.png")));
		}
		else if(juego.getEstadoActual().getTablero().getCasilla(a, b)==2){
			casillas[a][b].setIcon(new ImageIcon(getClass().getResource("/img/azul.png")));
		}else{
			casillas[a][b].setIcon(new ImageIcon(getClass().getResource("/img/vacia.png")));
		}
	}

	public Coordenada getOrigen() {
		return origen;
	}

	public void setOrigen(Coordenada origen) {
		this.origen = origen;
	}

	public Coordenada getDestino() {
		return destino;
	}

	public void setDestino(Coordenada destino) {
		this.destino = destino;
	}

}  //  @jve:decl-index=0:visual-constraint="19,11"
