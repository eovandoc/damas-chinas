package dominio.beans;

import java.util.ArrayList;
import java.util.List;

public class Arbol <E> {
	private E nodo;
	private List<Arbol<E>> hijos;

	public Arbol() {
		super();
		hijos=new ArrayList<Arbol<E>>();
		// TODO Auto-generated constructor stub
	}
	
	public Arbol(E e){
		this.nodo=e;
		hijos=new ArrayList<Arbol<E>>();
	}

	public boolean esTerminal(){
		if (hijos== null) return true;
		else if (hijos.size()==0) return true;
		else return false;
	}
	
	public void agregarHijo(Arbol<E> hijo){
		hijos.add(hijo);
	}

	public E getNodo() {
		return nodo;
	}

	public void setNodo(E nodo) {
		this.nodo = nodo;
	}

	public List<Arbol<E>> getHijos() {
		return hijos;
	}

	public void setHijos(List<Arbol<E>> hijos) {
		this.hijos = hijos;
	}
	
	@SuppressWarnings("unchecked")
	public E getHijo(int i){
		return (E)getHijos().get(i);
	}
	
}
