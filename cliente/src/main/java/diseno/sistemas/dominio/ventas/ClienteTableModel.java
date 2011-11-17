package diseno.sistemas.dominio.ventas;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import diseno.sistemas.dominio.mantenimiento.Cliente;
import diseno.sistemas.presentacion.principal.ListaClientesFrame;

public class ClienteTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 192856354498141579L;
	
	private List<Cliente> listaClientes=new ArrayList<Cliente>();
	private String[] columnNames={"Código","Nombres y apellidos","Estado de cred.","Tipo Doc.","Numero Doc."};
	
	public ClienteTableModel(List<Cliente> listaClientes){
		super();
		this.listaClientes=listaClientes;
	}
	
	
	public int getRowCount() {
		if(listaClientes!=null)
			return listaClientes.size();
		else 
			return 0;
	}
	
	public Cliente getCliente(int rowindex){
		if(listaClientes!=null)
			return listaClientes.get(rowindex);
		else 
			return null;
	}
	
	public int getColumnCount() {
		return columnNames.length;
	}
	
	public String getColumnName(int col) {
	      return columnNames[col];
	  }
	
	public void addRow(Cliente rowData) {
		// TODO Auto-generated method stub
		listaClientes.add(rowData);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(listaClientes!=null){
			switch(columnIndex){
				case 0:	return listaClientes.get(rowIndex).getIdCliente();
				case 1:	return listaClientes.get(rowIndex).getNombres()+" "+listaClientes.get(rowIndex).getaPaterno()+" "+listaClientes.get(rowIndex).getaMaterno();
				case 2: return listaClientes.get(rowIndex).getEstadoCredito();
				case 3: return listaClientes.get(rowIndex).getNroDocumento();
				default: ;
			}
		}
		
		return "";
		
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	

}
