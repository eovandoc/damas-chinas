package dominio.beans;

public class Accion {
	
	Coordenada origen;
	Coordenada destino;
	
	public Accion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Accion(Coordenada origen, Coordenada destino) {
		super();
		this.origen = origen;
		this.destino = destino;
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
	
	
}
