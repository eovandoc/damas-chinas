package dominio.algoritmos;

import dominio.beans.Estado;

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
		double valor=0;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(e.getTurno()==1){
					if(e.getTablero().getCasilla(i,j)==2)
						valor+=pesos2[i][j];
					if(pesos2[i][j]==0 && e.getTablero().getCasilla(i,j)!=2)
						valor++;
				}else if(e.getTurno()==2){
					if(e.getTablero().getCasilla(i,j)==1)
						valor+=pesos1[i][j];
					if(pesos1[i][j]==0 && e.getTablero().getCasilla(i,j)!=1)
						valor++;
				}
			}
		}
		
		return 0;
	} 

}
