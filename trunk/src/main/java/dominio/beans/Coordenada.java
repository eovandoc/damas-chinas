package dominio.beans;

public class Coordenada {
	
	private int fila;
	private int columna;
	
	
	public Coordenada() {

	}

	public Coordenada(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
	}
	
	public Coordenada(Coordenada a) {
		this.fila = a.getFila();
		this.columna = a.getColumna();
	}
	
	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}
	
	public boolean igual(Coordenada a){
		//System.out.println("Comparando ("+fila+","+columna+") con ("+a.getFila()+","+a.getColumna()+")");
		if( a.getFila()==this.getFila() && a.getColumna()==this.getColumna())
			return true;
		else
			return false; 
	}
	
	public boolean esValida(){
		return getFila()>=0 && getFila()<=8 && getColumna()>=0 && getColumna()<=8;
	}
	
	public void mostrar(){
		System.out.println(this.toString());
	}
	
	public String toString(){
		return "("+fila+","+columna+")";
	}
	
}
