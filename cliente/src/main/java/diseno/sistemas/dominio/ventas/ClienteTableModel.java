package diseno.sistemas.dominio.ventas;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import diseno.sistemas.dominio.mantenimiento.Cliente;

public class ClienteTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 192856354498141579L;
	private List<Cliente> listaClientes;
	private String[] columnNames={"Código","Nombres y apellidos","Estado de cred.","Tipo Doc.","Numero Doc."};
	
	public ClienteTableModel(List<Cliente> listaClientes){
		this.listaClientes=listaClientes;
	}
	
	@Override
	public int getRowCount() {
		return listaClientes.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	public String getColumnName(int col) {
	      return columnNames[col];
	  }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
		case 0:return listaClientes.get(rowIndex).getIdCliente();
		
		case 1:return listaClientes.get(rowIndex).getNombres()+" "+
					listaClientes.get(rowIndex).getaPaterno()+" "+
					listaClientes.get(rowIndex).getaMaterno();
		case 2: return listaClientes.get(rowIndex).getEstadoCredito();
		case 3: return listaClientes.get(rowIndex).getNroDocumento();
		default:return null;	
			
		}
		
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	

}
