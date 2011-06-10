package dominio.beans;

import java.util.List;

import dominio.servicios.Movimientos;

import excepciones.MovimientoIlegalException;

/**
 * 
 * @author Diego Montalvo
 * Clase para representar el estado del juego
 *
 */
public class Estado {
	
	private Tablero tablero;
	private int evaluacion;
	
	
	/**
	 * Este atributo representa el turno del jugador. 
	 * Por defecto iniciara el jugador 1. 
	 */
	private int turno;
	
	public Estado() {
		super();
		tablero=new Tablero();
		turno=1;
	}
	
	public Estado(Estado e){
		setTablero(e.getTablero());
		setTurno(e.getTurno());
	}
	
	public Estado(int turno){
		tablero=new Tablero();
		this.turno=turno; 
	}
	
	/**
	 * @return Verdadero si el estado es final, o falso en caso contrario
	 */
	public boolean esTerminal(){
		return tablero.esTerminal();
	}
	
	/**
	 * @return Lista de sucesores del estado.
	 * @see Arbol 
	 * M�todo que se utiliza para construir el �rbol de estados
	 */
	
	public void mover(int a,int b,int c,int d) throws MovimientoIlegalException{
		if(tablero.getCasilla(c,d)==0 && tablero.getCasilla(a,b)==turno){
			tablero.setCasilla(c,d,turno);
			tablero.setCasilla(a,b,0);
			if(getTurno()==1)
				setTurno(2);
			else
				setTurno(1);
		}else{
			throw new MovimientoIlegalException();
		}
	}
	
	public void mover(Accion a) throws MovimientoIlegalException{
		if(a.getOrigen().esValida() && a.getDestino().esValida()){
			if(tablero.getCasilla(a.getDestino())==0 && tablero.getCasilla(a.getOrigen())==turno){
				tablero.setCasilla(a.getDestino(),turno);
				tablero.setCasilla(a.getOrigen(),0);
				if(getTurno()==1)
					setTurno(2);
				else
					setTurno(1);
			}else{
				throw new MovimientoIlegalException();
			}
		}else{
			throw new MovimientoIlegalException();
		}
	}
	
	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}
	

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public int getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(int evaluacion) {
		this.evaluacion = evaluacion;
	}

}
