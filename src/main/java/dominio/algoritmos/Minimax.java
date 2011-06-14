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
		//System.out.println("Iniciando analisis minimax. Estado actual");
		//estado.getTablero().mostrar();
		//System.out.println("Turno:"+ estado.getTurno());
		
		Accion mejor_mov=new Accion();
		double max,max_actual;
		max=-1.0/0.0;
		
		Estado aux=new Estado(estado);
		
		profundidad++;
		List<Accion> movPosibles=movimientosPosibles(aux);
		List<Double> listaSimetria=new ArrayList<Double>();
		
		for(Accion a:movPosibles){
			try{
				aux.mover(a);
				/*Verficia que no haya un estado con la misma heuristica*/
				double eva=Heuristica.evaluar(aux);
				if(!listaSimetria.contains(eva)){
					max_actual=valorMin(aux);
					if(max_actual>max){
						max=max_actual;
						mejor_mov=a;
					}
					listaSimetria.add(eva);
				}
					
			}catch(MovimientoIlegalException e){
				//e.printStackTrace();
			}
			aux=new Estado(estado);
		}
		System.out.println("Sucesores de profundidad 1 analizados "+movPosibles.size());
		
		profundidad--;
		return mejor_mov;
	}

	public static double valorMax(Estado estado){
		double valor_max=0.0;
		double valor_min=0.0;
		Estado aux=new Estado(estado);
		
		List<Double> listaSimetria=new ArrayList<Double>();
		
		profundidad++;
		
		if(testCorte(estado)){
			profundidad--;
			return Heuristica.evaluar(estado);
		}else{
			valor_max=-1.0/0.0;
			for(Accion a:movimientosPosibles(estado)){
				try{
					aux=new Estado(estado);
					aux.mover(a);
					
					/*Verficia que no haya un estado con la misma heuristica*/
					double eva=Heuristica.evaluar(aux);
					if(!listaSimetria.contains(eva)){
						valor_min=valorMin(aux);
						if(valor_min>valor_max)
							valor_max=valor_min;
						listaSimetria.add(eva);
					}
					
				}catch(MovimientoIlegalException e){
					//e.printStackTrace();
				}
				aux=new Estado(estado);
			}
			profundidad--;
			return valor_max;
		}
	}

	public static double valorMin(Estado estado){
		double valor_min=0.0;
		double valor_max=0.0;
		
		Estado aux=new Estado(estado);
		List<Double> listaSimetria=new ArrayList<Double>();
		
		profundidad++;

		if(testCorte(estado)){
			profundidad--;
			return Heuristica.evaluar(estado);
		}
		else{
			valor_min=1.0/0.0;
			for(Accion a:movimientosPosibles(estado)){
				try{
				aux=new Estado(estado);
				aux.mover(a);
				
				/*Verficia que no haya un estado con la misma heuristica*/
				double eva=Heuristica.evaluar(aux);
				if(!listaSimetria.contains(eva)){
					valor_max=valorMax(aux);
					if(valor_max<valor_min)
						valor_min=valor_max;
				}
				listaSimetria.add(eva);	
					
				}catch(MovimientoIlegalException e){
					//e.printStackTrace();
				}
				
				aux=new Estado(estado);
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
			//e1.printStackTrace();
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