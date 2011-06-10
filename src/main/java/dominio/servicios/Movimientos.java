package dominio.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Position;
import javax.swing.text.TableView.TableRow;

import dominio.beans.Accion;
import dominio.beans.Arbol;
import dominio.beans.Coordenada;
import dominio.beans.Estado;
import dominio.beans.Tablero;

import excepciones.MovimientoIlegalException;
import excepciones.PosicionIlegalException;

/**
 * 
 * @author Diego Montalvo
 * Clase que maneja los movimientos del juego
 */

public class Movimientos {
	
	/**
	 * 
	 * @param estado 
	 * 				Estado inicial al que se le aplica la regla del juego
	 * @param a
	 * 				Fila origen
	 * @param b
	 * 				Columna origen
	 * @param c
	 * 				Fila destino
	 * @param d
	 * 				Columna destino
	 * @param jugador
	 * 				Jugador que est� moviendo
	 * 
	 * @return Retorna el nuevo estado despues de haber aplicado el movimiento 
	 */
	
	/*ESTE,SURESTE,SUROESTE,OESTE,NOROESTE,NORESTE
	 * Valores a sumar a las filas y las columnas*/
	static int [][] mover= {	{-1,1},
								{0,1},
								{1,0},
								{1,-1},
								{0,-1},
								{-1,0}};
	
	
	/**
	 * 
	 * @param tablero
	 * 				Tablero a partir del cual se calculan los movimientos
	 * @param a
	 * 				Fila de la ficha a mover
	 * @param b
	 * 				Columna de la ficha a mover
	 * @return
	 * 				Lista de coordenas posibles a las que se puede mover la ficha
	 * @throws PosicionIlegalException
	 * 				En caso la posici�n de partida sea incorrecta
	 */
	public static List<Coordenada> movimientosSimples(Tablero tablero,int a,int b) throws PosicionIlegalException{
		int a2,b2;
		
		List<Coordenada> movimientos=new ArrayList<Coordenada>();
		
		if(a>=0 && a<=8 && b>=0 && b<=8){
			for(int i=0;i<6;i++){
				/*Posicion de la casilla destino*/
				a2=a+mover[i][0];
				b2=b+mover[i][1];

				if(a2>=0 && a2<=8 && b2>=0 && b2<=8 && tablero.getCasilla(a2,b2)==0)
					movimientos.add(new Coordenada(a2,b2));
			}	
		}else{
				throw new PosicionIlegalException();
		}			
		
		return movimientos;
	}
	
	/**
	 * 
	 * @param tablero
	 * 				Tablero a partir del cual se calculan los movimientos
	 * @param a
	 * 				Fila de la ficha a mover
	 * @param b
	 * 				Columna de la ficha a mover
	 * @return
	 * 				Lista de coordenas posibles a las que se puede mover la ficha
	 * @throws PosicionIlegalException
	 * 				En caso la posici�n de partida sea incorrecta
	 */
	public static List<Coordenada> saltosSimples(Tablero tablero,int a,int b) throws PosicionIlegalException{
			List<Coordenada> movimientos=new ArrayList<Coordenada>();
			int a1,b1,a2,b2;
			
			if(a>=0 && a<=8 && b>=0 && b<=8){
				for(int i=0;i<6;i++){
					/*Posicion de la ficha a saltar*/
					a1=a+mover[i][0];
					b1=b+mover[i][1];
					/*Posicion de la casilla a destino*/
					a2=a+2*mover[i][0];
					b2=b+2*mover[i][1];

					if(a2>=0 && a2<=8 && b2>=0 && b2<=8 && tablero.getCasilla(a2,b2)==0 && tablero.getCasilla(a1,b1)!=0)
						movimientos.add(new Coordenada(a2,b2));
				}
			}else{
				throw new PosicionIlegalException();
			}			
			return movimientos;
	}
	
	public static List<Coordenada> movimientosPosibles(Tablero tablero,int a,int b)throws PosicionIlegalException{
		
		/*Lista de destinos finales*/
		List<Coordenada> destinos=new ArrayList<Coordenada>();
		
		/*Lista de casillas visitadas*/
		List<Coordenada> visitadas=new ArrayList<Coordenada>();
		
		
		/*Arbol donde se construiran todos los saltos posibles*/
		Arbol<Coordenada> arbol=new Arbol<Coordenada>(new Coordenada(a,b));

		if(saltosSimples(tablero, a, b).size()>0)
			buscarSaltos(tablero,arbol,visitadas,destinos);
		
		/*Agrega movimientos simples*/
		destinos.addAll(movimientosSimples(tablero, a, b));
		
		return destinos;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void buscarSaltos(Tablero tablero,Arbol<Coordenada> arbol,List visitadas,List destinos)throws PosicionIlegalException{
		List<Coordenada> sucesores=saltosSimples(tablero,arbol.getNodo().getFila(),arbol.getNodo().getColumna());
		System.out.println("Analizando coordenada"+arbol.getNodo().getFila()+","+arbol.getNodo().getColumna());
		visitadas.add(new Coordenada(arbol.getNodo().getFila(),arbol.getNodo().getColumna()));
		
		for(int i=0;i<sucesores.size();i++){
			if(!contiene(visitadas,sucesores.get(i)))
				arbol.agregarHijo(new Arbol<Coordenada>(sucesores.get(i)));
		}
		if(arbol.getHijos().size()>0){

			for(int j=0;j<arbol.getHijos().size();j++){
				destinos.add(new Coordenada(arbol.getHijos().get(j).getNodo().getFila(),
											arbol.getHijos().get(j).getNodo().getColumna()));
				buscarSaltos(tablero, arbol.getHijos().get(j), visitadas,destinos);
			}
		}
	}
	
	public static boolean contiene(List<Coordenada> lista,Coordenada coordenada){
		int i=0;
		boolean encontrado=false;
		while(i<lista.size() && !encontrado){
			encontrado=lista.get(i).igual(coordenada);
			i++;
		}
		return encontrado;
	}
	
	
	/*
	 * METODOS MODIFICADOS
	 * 
	 * */
	
	public static List<Accion> movimientos_posibles(Tablero tablero,Coordenada origen)throws PosicionIlegalException{
		Tablero aux=tablero;
		
		/*Lista de acciones o movimientos posibles*/
		List<Accion> posibles=new ArrayList<Accion>();
		
		/*Lista de coordenadas destinos posibles*/
		List<Coordenada> destinos=new ArrayList<Coordenada>();
		
		/*Lista de casillas visitadas*/
		List<Coordenada> visitadas=new ArrayList<Coordenada>();
		
		/*Arbol donde se construiran todos los saltos posibles*/
		Arbol<Coordenada> arbol=new Arbol<Coordenada>(origen);

		if(saltos_simples(aux,origen).size()>0)
			buscar_saltos(aux,arbol,visitadas,destinos);
		
		for(Coordenada a:destinos)
			posibles.add(new Accion(origen,a));
		
		/*Agrega movimientos simples*/
		posibles.addAll(movimientos_simples(aux,origen));

		return posibles;
	}
	
	public static List<Accion> saltos_simples(Tablero tablero,Coordenada origen) throws PosicionIlegalException{
		
		List<Accion> movimientos=new ArrayList<Accion>();
		
		Coordenada medio=new Coordenada();
		Coordenada destino=new Coordenada();
		
		if(origen.esValida()){
			for(int i=0;i<6;i++){
				/*Posicion de la ficha a saltar*/
				medio.setFila(origen.getFila()+mover[i][0]);
				medio.setColumna(origen.getColumna()+mover[i][1]);
				/*Posicion de la casilla a destino*/
				destino.setFila(origen.getFila()+2*mover[i][0]);
				destino.setColumna(origen.getColumna()+2*mover[i][1]);
		
				if(destino.esValida() && tablero.getCasilla(destino)==0 && tablero.getCasilla(medio)!=0)
					movimientos.add(new Accion(origen,destino));
			}
		}else{
			throw new PosicionIlegalException();
		}			
		return movimientos;
	}
	
	public static List<Accion> movimientos_simples(Tablero tablero,Coordenada origen) throws PosicionIlegalException{

		Coordenada destino=new Coordenada();
		
		List<Accion> movimientos=new ArrayList<Accion>();
		
		if(origen.esValida()){
			for(int i=0;i<6;i++){
				/*Posicion de la casilla destino*/
				destino.setFila(origen.getFila()+mover[i][0]);
				destino.setColumna(origen.getColumna()+mover[i][1]);

				if(destino.esValida() && tablero.getCasilla(destino)==0)
					movimientos.add(new Accion(origen,destino));
			}	
		}else{
				throw new PosicionIlegalException();
		}			
		
		return movimientos;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void buscar_saltos(Tablero tablero,Arbol<Coordenada> arbol,List visitadas,List destinos)throws PosicionIlegalException{
		List<Coordenada> sucesores=saltosSimples(tablero,arbol.getNodo().getFila(),arbol.getNodo().getColumna());
		System.out.println("Analizando coordenada"+arbol.getNodo().getFila()+","+arbol.getNodo().getColumna());
		visitadas.add(new Coordenada(arbol.getNodo().getFila(),arbol.getNodo().getColumna()));
		
		for(int i=0;i<sucesores.size();i++){
			if(!contiene(visitadas,sucesores.get(i)))
				arbol.agregarHijo(new Arbol<Coordenada>(sucesores.get(i)));
		}
		if(arbol.getHijos().size()>0){

			for(int j=0;j<arbol.getHijos().size();j++){
				destinos.add(new Coordenada(arbol.getHijos().get(j).getNodo().getFila(),
											arbol.getHijos().get(j).getNodo().getColumna()));
				buscarSaltos(tablero, arbol.getHijos().get(j), visitadas,destinos);
			}
		}
	}
}
