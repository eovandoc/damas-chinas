package dominio.algoritmos;

import dominio.beans.Estado;
import dominio.servicios.Movimientos;

public class Heuristica {
	
	private static int[][] pesos1={ {0,0,0,0,1,2,3,4,5},
									{0,0,0,1,2,3,4,5,6},
									{0,0,1,2,3,4,5,6,7},
									{0,1,2,3,4,5,6,7,8},
									{1,2,3,4,5,6,7,8,9},
									{2,3,4,5,6,7,8,9,10},
									{3,4,5,6,7,8,9,10,10},
									{4,5,6,7,8,9,10,10,10},
									{5,6,7,8,9,10,10,10,10}};
	
	private static int[][] pesos2={ {10,10,10,10,9,8,7,6,5},
									{10,10,10,9,8,7,6,5,4},
									{10,10,9,8,7,6,5,4,3},
									{10,9,8,7,6,5,4,3,2},
									{9,8,7,6,5,5,3,2,1},
									{8,7,6,5,4,3,2,1,0},
									{7,6,5,4,3,2,1,0,0},
									{6,5,4,3,2,1,0,0,0},
									{5,4,3,2,1,0,0,0,0}};	
	
	/*Evalua en base a pesos y en base a cuantas fichas estan fuera de su posicion inicial*/
	public static double evaluar(Estado e){
		int [][] mover=Movimientos.mover;
		
		double valor=0;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(e.getTurno()==2){
					if(e.getTablero().getCasilla(i,j)==1)
						valor+=pesos1[i][j];
					//Agrega 3 si el estado desocupa una posicion de inicio de 1
					if(pesos1[i][j]==0 && e.getTablero().getCasilla(i,j)!=1)
						valor+=4;
					
					/*Da 3 puntos cuanto mientras hayan mas fichas vecinas*/
					
					for(int k=0;k<6;k++){
						if(e.getTablero().getCasilla(i+mover[k][0],j+mover[k][1])==1)
							valor+=3;
					}
					
				}else if(e.getTurno()==1){
					if(e.getTablero().getCasilla(i,j)==2)
						valor+=pesos2[i][j];
					//Agrega 3 si el estado desocupa una posicion de inicio de 2
					if(pesos2[i][j]==0 && e.getTablero().getCasilla(i,j)!=2)
						valor+=4;
					
					/*Da 3 puntos cuanto mientras hayan mas fichas vecinas*/
					
					for(int k=0;k<6;k++){
						if(e.getTablero().getCasilla(i+mover[k][0],j+mover[k][1])==2)
							valor+=3;
					}
					
					
				}
				
				
				
			}
		}
		valor+=e.getEvaluacion();
		
		return valor;
	} 

}
