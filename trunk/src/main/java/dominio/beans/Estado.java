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
public class Estado implements Cloneable {
	
	private Tablero tablero;
	private double evaluacion;
	
	
	/**
	 * Este atributo representa el turno del jugador. 
	 * Por defecto iniciara el jugador 1. 
	 */
	private int turno;
	
	public Estado() {
		
		tablero=new Tablero();
		turno=1;
	}
	
	public Estado(Estado e){
		evaluacion=e.getEvaluacion();
		turno=e.getTurno();
		tablero=new Tablero(e.getTablero());
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
	 * Mï¿½todo que se utiliza para construir el ï¿½rbol de estados
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
			throw new MovimientoIlegalException("Coordenadas no validas");
		}
	}
	
	public void mover(Accion a) throws MovimientoIlegalException{
		if(a.getOrigen().esValida() && a.getDestino().esValida()){
			if(tablero.getCasilla(a.getDestino())==0 && tablero.getCasilla(a.getOrigen())==turno){
				tablero.setCasilla(a.getDestino(),turno);
				tablero.setCasilla(a.getOrigen(),0);
				//Mientras la accion recorra mas distancia, tiene mayor evaluacion
				evaluacion=Math.sqrt(Math.pow(a.getDestino().getFila()-a.getOrigen().getFila(),2)+
									 Math.pow(a.getDestino().getColumna()-a.getOrigen().getColumna(),2));
				if(getTurno()==1)
					setTurno(2);
				else
					setTurno(1);
			}else{
				throw new MovimientoIlegalException("Destino ocupado o origen desocupado");
			}
		}else{
			throw new MovimientoIlegalException("Coordenadas de la accion no válidas");
		}
	}
	
	public Object clone(){
		Estado clon=null;
		try {
			clon=(Estado) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
		((Estado)clon).setEvaluacion(getEvaluacion());
		((Estado)clon).setTurno(getTurno());
		((Estado)clon).setTablero((Tablero)getTablero().clone());
		
		
		return clon;
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

	public double getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(double evaluacion) {
		this.evaluacion = evaluacion;
	}

}
