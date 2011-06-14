package excepciones;

public class EstadoFinalException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -122906432837503694L;
	
	public EstadoFinalException(){
		super();
	}

	public EstadoFinalException(String mensaje){
		super(mensaje);
	}
}
