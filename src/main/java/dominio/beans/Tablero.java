package dominio.beans;


public class Tablero implements Cloneable{
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

	}

	public Tablero(int[][] tablero) {
		this.tablero = tablero;
	}
	
	public Tablero(Tablero t) {
		for(int i=0;i<tablero.length;i++){
			for(int j=0;j<tablero[i].length;j++)
				tablero[i][j]=t.getCasilla(i, j);
		}	
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
		}catch(ArrayIndexOutOfBoundsException e){
			//e.printStackTrace();
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
	
	public String toString(){
		String cadena="";

		for(int i=0;i<getTablero().length;i++){
			for(int j=0;j<getTablero()[i].length;j++){
				cadena+=("["+getTablero()[i][j]+"]");
			}
			cadena+="\n";
		}
		return cadena;
	}
	
	public void mostrar(){
		System.out.println(this.toString());
	}
	
	public Object clone(){
		Tablero clon= null;
		
		try {
			clon=(Tablero)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((Tablero)clon).setTablero(getTablero());
		return clon;
	}
}
