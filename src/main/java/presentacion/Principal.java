package presentacion;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import dominio.beans.Accion;
import dominio.beans.Coordenada;
import dominio.beans.Tablero;
import dominio.servicios.Juego;
import dominio.servicios.Movimientos;
import excepciones.AccionNoValidaException;
import excepciones.FinDeJuegoException;
import excepciones.MovimientoIlegalException;
import excepciones.NivelInvalidoException;
import excepciones.PosicionIlegalException;
import excepciones.TurnoNoValidoException;

import javax.swing.JTable;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Point;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;


public class Principal extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenuItem jMenNuevoJuego = null;
	private JMenuItem jMenuSalir = null;
	
	private Coordenada origen=null;  
	private Coordenada destino=null;  //  @jve:decl-index=0:
	
	
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
	
	private Juego juego;
	private int nivel=-1;
	
	private JRadioButtonMenuItem jRadioButtonFacil = null;
	private JMenu jMenuNiveles = null;
	private JRadioButtonMenuItem jRadioButtonMenuNormal = null;
	private JRadioButtonMenuItem jRadioButtonMenuDificil = null;
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
			jMenu.add(getJMenuNiveles());
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
			jMenNuevoJuego.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
					juego.iniciar(nivel);
					actualizaTablero();
					}catch(NivelInvalidoException e1){
						labelInfo.setText(e1.getMessage());
					}
					
				}
			});
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
			jMenuSalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});

		}
		return jMenuSalir;
	}

	
	/**
	 * This is the default constructor
	 */
	
	public Principal() {
		super();
		juego=new Juego();
		juego.addObserver(this);
		initialize();
		
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(648, 560);
		this.setResizable(false);
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
					final int i2=i;
					final int j2=j;
					casillas[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
						public void mouseClicked(java.awt.event.MouseEvent e) {
							presionar(i2,j2);
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
	
	public void presionar(int i,int j){
		labelInfo.setText("");

		if(origen==null){
				if(juego.getEstadoActual().getTablero().getCasilla(i, j)!=0){
					seleccionar(i,j);
					origen=new Coordenada(i,j);
				}
		}else{
			destino=new Coordenada(i,j);
			try {
				juego.jugadaHumano(new Accion(origen,destino));
				actualizaTablero();
			}catch (Exception e1){
				labelInfo.setText(e1.getMessage());
				deseleccionar(origen.getFila(),origen.getColumna());
				deseleccionar(destino.getFila(),destino.getColumna());
				e1.printStackTrace();
			}
			
			origen=null;
			destino=null;
		}
	}
	
	public void actualizaTablero(){
		for(int i=0;i<casillas.length;i++)
			for(int j=0;j<casillas[i].length;j++)
				deseleccionar(i,j);
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

	/**
	 * This method initializes jRadioButtonFacil	
	 * 	
	 * @return javax.swing.JRadioButtonMenuItem	
	 */
	private JRadioButtonMenuItem getJRadioButtonFacil() {
		if (jRadioButtonFacil == null) {
			jRadioButtonFacil = new JRadioButtonMenuItem();
			jRadioButtonFacil.setText("Facil");
			jRadioButtonFacil.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jRadioButtonFacil.isSelected()){	
					jRadioButtonMenuDificil.setSelected(false);
					jRadioButtonMenuDificil.repaint();
					jRadioButtonMenuNormal.setSelected(false);
					jRadioButtonMenuNormal.repaint();
					setNivel(0);
					}else
						setNivel(-1);
				}
			});
		}
		return jRadioButtonFacil;
	}

	/**
	 * This method initializes jMenuNiveles	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuNiveles() {
		if (jMenuNiveles == null) {
			jMenuNiveles = new JMenu();
			jMenuNiveles.setText("Niveles");
			jMenuNiveles.add(getJRadioButtonFacil());
			jMenuNiveles.add(getJRadioButtonMenuNormal());
			jMenuNiveles.add(getJRadioButtonMenuDificil());
		}
		return jMenuNiveles;
	}

	/**
	 * This method initializes jRadioButtonMenuNormal	
	 * 	
	 * @return javax.swing.JRadioButtonMenuItem	
	 */
	private JRadioButtonMenuItem getJRadioButtonMenuNormal() {
		if (jRadioButtonMenuNormal == null) {
			jRadioButtonMenuNormal = new JRadioButtonMenuItem();
			jRadioButtonMenuNormal.setText("Normal");
			jRadioButtonMenuNormal.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jRadioButtonMenuNormal.isSelected()){	
					jRadioButtonFacil.setSelected(false);
					jRadioButtonFacil.repaint();
					jRadioButtonMenuDificil.setSelected(false);
					jRadioButtonMenuDificil.repaint();
					setNivel(1);
					}else
						setNivel(-1);
				}
			});
		}
		return jRadioButtonMenuNormal;
	}

	/**
	 * This method initializes jRadioButtonMenuDificil	
	 * 	
	 * @return javax.swing.JRadioButtonMenuItem	
	 */
	private JRadioButtonMenuItem getJRadioButtonMenuDificil() {
		if (jRadioButtonMenuDificil == null) {
			jRadioButtonMenuDificil = new JRadioButtonMenuItem();
			jRadioButtonMenuDificil.setText("Dificil");
			jRadioButtonMenuDificil.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jRadioButtonMenuDificil.isSelected()){					
						jRadioButtonFacil.setSelected(false);
						jRadioButtonFacil.repaint();
						jRadioButtonMenuNormal.setSelected(false);
						jRadioButtonMenuNormal.repaint();
						setNivel(2);
					}else
						setNivel(-1);
				}
			});
		}
		return jRadioButtonMenuDificil;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public void update(Observable o, Object arg) {
		
		if(o==juego){
			actualizaTablero();
			
			if(!juego.termino()){
				if(juego.getEstadoActual().getTurno()==2){
					try {
						juego.jugadaMaquina();
						actualizaTablero();
					} catch (MovimientoIlegalException e) {
						e.printStackTrace();
						labelInfo.setText(e.getMessage());
					}
				}
			}else{
				JOptionPane.showMessageDialog(null,
						"El jugador "+juego.getEstadoActual().getTurno()+" gano la partida",
						"Fin del Juego",
						JOptionPane.INFORMATION_MESSAGE);
				
			}
		}
	}

}
