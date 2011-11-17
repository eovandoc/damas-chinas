package diseno.sistemas.dominio.ventas;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import diseno.sistemas.dominio.mantenimiento.Usuario;

public class UsuarioTableModel extends AbstractTableModel{


	private static final long serialVersionUID = -7260140446853572559L;
	
	private List<Usuario> listaUsuarios;
	
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}


	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	

}
