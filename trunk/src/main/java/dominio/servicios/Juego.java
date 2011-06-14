package dominio.servicios;

import java.util.ArrayList;
import java.util.Observable;

 
import java.util.List;

import dominio.algoritmos.Minimax;
import dominio.beans.Accion;
import dominio.beans.Arbol;
import dominio.beans.Coordenada;
import dominio.beans.Estado;
import excepciones.FinDeJuegoException;
import excepciones.MovimientoIlegalException;
import excepciones.NivelInvalidoException;
import excepciones.PosicionIlegalException;
import excepciones.TurnoNoValidoException;


public class Juego extends Observable {
	
	/** 0: facil
	 *  1: intermedio
	 *  2: dificil
	 *  3: muy dificil
	 */
	private int nivel;
	private Estado estadoActual;
	private boolean jugando;
	private boolean fin;
	
	
	public Juego() {
		nivel=1;
		estadoActual=new Estado();
		jugando=true;
		fin=false;
	}
	
	public Juego(int nivel, int turno, Estado estadoActual,
			Arbol<Estado> arbolBusqueda) {
		super();
		this.nivel = nivel;
		this.estadoActual = estadoActual;
		jugando=true;
		fin=false;
	}
	
	public void iniciar(int nivel) throws NivelInvalidoException{
		if(nivel==-1)
			throw new NivelInvalidoException("Debe seleccionar un nivel");
		System.out.println("Iniciando con nivel "+nivel);
		this.nivel=nivel;
		estadoActual=new Estado();
		jugando=true;
		fin=false;
	}
	
	public void jugadaHumano(Accion accion) throws MovimientoIlegalException, PosicionIlegalException, TurnoNoValidoException, FinDeJuegoException{
		
		List<Coordenada> movimientosPosibles=new ArrayList<Coordenada>();
		
		if(estadoActual.getTablero().getCasilla(accion.getOrigen())==getEstadoActual().getTurno()){
		
			if(accion.getDestino().esValida() && accion.getOrigen().esValida()){
			
				movimientosPosibles=Movimientos.movimientosPosibles(getEstadoActual().getTablero(),
																	accion.getOrigen().getFila(),accion.getOrigen().getColumna());
							
				if(Movimientos.contiene(movimientosPosibles,accion.getDestino())){
					estadoActual.mover(accion);
					
					if(estadoActual.esTerminal())
						throw new FinDeJuegoException("Terminó el juego");
					
					setChanged();
					this.notifyObservers();
					
					
				}
				else{
					throw new MovimientoIlegalException("Movimiento no válido");
				}
			}else{
				throw new MovimientoIlegalException("Movimiento no válido");
			}
		}else{
			throw new TurnoNoValidoException("No es el turno de esta ficha");
		}
		
		
		
	}
	
	public void jugadaMaquina()throws MovimientoIlegalException{
		Estado aux;
		aux=new Estado(estadoActual);
		Accion accion;
		if(nivel==0)
			accion=Minimax.minimax(aux);
		else if(nivel==1)
			accion=Minimax.minimax(aux);
		else if(nivel==2)
			accion=Minimax.minimax(aux);
		else{
			accion=null;
		}
			
		estadoActual.mover(accion);
	
		if(estadoActual.esTerminal()){
			this.fin=true;
			setChanged();
			notifyObservers();
		}
			
		
			
	
		
		
	}
	
	public boolean termino(){
		return fin;
	}
	
	public int getNivel() {
		return nivel;
	}


	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Estado getEstadoActual() {
		return estadoActual;
	}

	public void setEstadoActual(Estado estadoActual) {
		this.estadoActual = estadoActual;
	}
}
