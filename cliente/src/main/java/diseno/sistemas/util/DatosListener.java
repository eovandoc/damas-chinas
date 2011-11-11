package diseno.sistemas.util;

import java.util.EventListener;
import java.util.EventObject;

/**
 * 
 * @author Diego
 *	Interface que define una única función 
 *	La clase cuyos objetos(listeners) quieran recibir eventos de tipo DatosEvent 
 *	han de implementar dicho metodo.
 */


public interface DatosListener extends EventListener {
	
	public void notificarCambios(DatosEvent datosEvent);	
	
}