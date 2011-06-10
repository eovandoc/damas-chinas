package dominio.algoritmos;

import java.util.ArrayList;
import java.util.List;

import dominio.beans.Accion;
import dominio.beans.Coordenada;
import dominio.beans.Estado;
import dominio.servicios.Movimientos;
import excepciones.MovimientoIlegalException;
import excepciones.PosicionIlegalException;

public class Minimax {
	
	private static int profundidad=0;
	
	public static Accion minimax(Estado estado){
		Accion mejor_mov=new Accion();
		double max,max_actual;
		max=-1.0/0.0;
		Estado aux=new Estado();
		
		profundidad++;
		for(Accion a:movimientosPosibles(estado)){
			try{
				aux=estado;
				aux.mover(a);
				max_actual=valorMin(aux);
				if(max_actual>max){
					max=max_actual;
					mejor_mov=a;
				}
			}catch(MovimientoIlegalException e){
				
			}
		}
		profundidad--;
		return mejor_mov;
	}

	public static double valorMax(Estado estado){
		double valor_max=0.0;
		double valor_min=0.0;
		Estado aux=new Estado();
		
		profundidad++;
		
		if(testCorte(estado)){
			profundidad--;
			return Heuristica.evaluar(estado);
		}else{
			valor_max=-1.0/0.0;
			for(Accion a:movimientosPosibles(estado)){
				try{
				aux=estado;
				aux.mover(a);
				valor_min=valorMin(aux);
				if(valor_min>valor_max)
					valor_max=valor_min;
				}catch(MovimientoIlegalException e){
					
				}
			}
			profundidad--;
			return valor_max;
		}
	}

	public static double valorMin(Estado estado){
		double valor_min=0.0;
		double valor_max=0.0;
		Estado aux=new Estado();
		
		profundidad++;

		if(testCorte(estado)){
			profundidad--;
			return Heuristica.evaluar(estado);
		}
		else{
			valor_min=1.0/0.0;
			for(Accion a:movimientosPosibles(estado)){
				try{
				aux=estado;
				aux.mover(a);
				valor_max=valorMax(aux);
				if(valor_max<valor_min)
					valor_min=valor_max;
				}catch(MovimientoIlegalException e){
					
				}
			}
			profundidad--;
			return valor_min;
		}
	}
	
	public static List<Accion> movimientosPosibles(Estado e) {
		List<Accion> movimientos=new ArrayList<Accion>();
		
		try{
			for(int i=0;i<e.getTablero().getTablero().length;i++){
				for(int j=0;j<e.getTablero().getTablero()[i].length;j++){
					if(e.getTablero().getCasilla(i, j)==e.getTurno())
						movimientos.addAll(Movimientos.movimientos_posibles(e.getTablero(),new Coordenada(i,j)));
				}
			}
		}catch(PosicionIlegalException e1){
			
		}
		
		return movimientos;
	}
	
	public static boolean testCorte(Estado estado){
		/*Faltaria agregar un test de estabilidad*/
		if (profundidad>3 || estado.esTerminal())
			return true;
		else
			return false;
	}

}