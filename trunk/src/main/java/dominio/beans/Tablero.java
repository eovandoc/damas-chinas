package dominio.beans;

public class Tablero {
	private int [][] tablero={{1,1,1,1,0,0,0,0,0},
							 {1,1,1,0,0,0,0,0,0},
							 {1,1,0,0,0,0,0,0,0},
							 {1,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,2},
							 {0,0,0,0,0,0,0,2,2},
							 {0,0,0,0,0,0,2,2,2},
							 {0,0,0,0,0,2,2,2,2}};

	public Tablero() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tablero(int[][] tablero) {
		super();
		this.tablero = tablero;
	}


	public int[][] getTablero() {
		return tablero;
	}

	public void setTablero(int[][] tablero) {
		this.tablero = tablero;
	}
	
	public int getCasilla(int i,int j) {
		try{
		return tablero[i][j];
		}catch(IndexOutOfBoundsException e){
			/*En caso la coordenada no est� dentro del tablero*/
			e.printStackTrace();
			return -1;
		}
	}

	public void setCasilla(int i,int j,int valor) {
		this.tablero[i][j]=valor;
	}
	
	public int getCasilla(Coordenada a) {
		try{
		return tablero[a.getFila()][a.getColumna()];
		}catch(IndexOutOfBoundsException e){
			/*En caso la coordenada no est� dentro del tablero*/
			e.printStackTrace();
			return -1;
		}
	}

	public void setCasilla(Coordenada a,int valor) {
		this.tablero[a.getFila()][a.getColumna()]=valor;
	}
	
	public boolean esTerminal(){
		/* Gana 2*/
		if(tablero[0][0]==2 && tablero[0][1]==2 && tablero[0][2]==2 && tablero[0][3]==2 &&
		   tablero[1][0]==2 && tablero[1][1]==2 && tablero[1][2]==2 &&
		   tablero[2][0]==2 && tablero[2][1]==2 &&
		   tablero[3][0]==2)
		return true;
		/*Gana 1*/
		else if(tablero[8][8]==1 && tablero[8][7]==1 && tablero[8][6]==1 && tablero[8][5]==1 &&
				tablero[7][8]==1 && tablero[7][7]==1 && tablero[7][6]==1 &&
				tablero[6][8]==1 && tablero[6][7]==1 &&
				tablero[5][8]==1)
			return true;
		else
			return false;
	}
	
	public boolean equals(Tablero e){
		return e.getTablero()==this.getTablero();
	}
	


}
