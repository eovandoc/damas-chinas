package excepciones;

public class PosicionIlegalException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6194057601221619507L;
	
	public PosicionIlegalException(){
		super();
	}
	
	public PosicionIlegalException(String mensaje){
		super(mensaje);
	}
}
