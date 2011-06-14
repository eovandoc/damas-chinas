package excepciones;
/**
 * Excepcion en caso una se plantee un movimiento ilegal 
 * */
public class MovimientoIlegalException extends Exception {
	
	private static final long serialVersionUID = 2313134701519908779L;

	public MovimientoIlegalException(){
		super();
	}
	
	public MovimientoIlegalException(String mensaje){
		super(mensaje);
	}
	
	
}
