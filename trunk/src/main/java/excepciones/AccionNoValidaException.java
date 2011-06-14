package excepciones;

public class AccionNoValidaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3619443439508315637L;
	
	public AccionNoValidaException(){
		super();
	}
	
	public AccionNoValidaException(String mensaje){
		super(mensaje);
	}
}
