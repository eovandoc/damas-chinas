package dominio.beans;

import excepciones.AccionNoValidaException;

public class Accion {
	
	Coordenada origen;
	Coordenada destino;
	
	public Accion() {
		super();
		origen=new Coordenada(0,0);
		destino=new Coordenada(0,0);
		// TODO Auto-generated constructor stub
	}

	public Accion(Coordenada origen, Coordenada destino) throws AccionNoValidaException {
		if(origen.esValida() && destino.esValida()){
			this.origen = origen;
			this.destino = destino;
		}else
			throw new AccionNoValidaException("Coordenadas de la acción no válidas");
	}

	public Coordenada getOrigen() {
		return origen;
	}

	public void setOrigen(Coordenada origen) {
		this.origen = origen;
	}

	public Coordenada getDestino() {
		return destino;
	}

	public void setDestino(Coordenada destino) {
		this.destino = destino;
	}
	
	public String toString(){
		return "De "+origen.toString()+" a "+destino.toString();
	} 
	
	public void mostrar(){
		System.out.println(this.toString());
	}
	
}
