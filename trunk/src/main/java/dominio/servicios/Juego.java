package dominio.servicios;

import java.util.ArrayList;
import java.util.List;

import dominio.algoritmos.Minimax;
import dominio.beans.Accion;
import dominio.beans.Arbol;
import dominio.beans.Coordenada;
import dominio.beans.Estado;
import excepciones.MovimientoIlegalException;
import excepciones.PosicionIlegalException;

public class Juego {
	
	/** 0: facil
	 *  1: intermedio
	 *  2: dificil
	 *  3: muy dificil
	 */
	int nivel;
	Estado estadoActual;
	
	public Juego() {
		nivel=1;
		estadoActual=new Estado();
	}
	
	public Juego(int nivel, int turno, Estado estadoActual,
			Arbol<Estado> arbolBusqueda) {
		super();
		this.nivel = nivel;
		this.estadoActual = estadoActual;

	}
	
	public Juego(int nivel) {
		nivel=1;
		estadoActual=new Estado();
	}
	
	public void jugadaHumano(Accion accion) throws MovimientoIlegalException{
		List<Coordenada> movimientosPosibles=new ArrayList<Coordenada>();

		try{
			movimientosPosibles=Movimientos.movimientosPosibles(getEstadoActual().getTablero(),
																accion.getOrigen().getFila(),accion.getOrigen().getColumna());
		}catch(PosicionIlegalException e){
			System.out.println("Accion no válida. Coordenada fuera del tablero");
		}
		
		if(Movimientos.contiene(movimientosPosibles,accion.getDestino()))
			estadoActual.mover(accion);
		else{
			throw new MovimientoIlegalException();
		}
	}
	
	public void jugadaMaquina()throws MovimientoIlegalException{
		Estado aux=estadoActual;
		Accion accion;
		System.out.println("Jugando la maquina! Se va a caeeer!!!");
		
		if(nivel==1)
			accion=Minimax.minimax(aux);
		else
			accion=Minimax.minimax(aux);
		
		System.out.println("La maquina jugara de "+accion.getOrigen().mostrar()+" a "+accion.getDestino().mostrar());
		estadoActual.mover(accion);
		
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
