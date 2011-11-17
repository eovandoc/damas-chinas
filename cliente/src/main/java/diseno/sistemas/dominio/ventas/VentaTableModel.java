package diseno.sistemas.dominio.ventas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;


public class VentaTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 5059697108000945760L;
	
	private List<LineaVenta> listaLineaVentas;
	
	private String[] columnNames={"Código","Descripcion","Precio","Cantidad","Total"};
	
	public VentaTableModel(){
		listaLineaVentas= new ArrayList<LineaVenta>();
	}


	@Override
	public int getRowCount() {
		return listaLineaVentas.size();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}
	
	 public String getColumnName(int col){ 
         return columnNames[col]; 
     } 


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listaLineaVentas.get(rowIndex).getCodigo();
		case 1:
			return listaLineaVentas.get(rowIndex).getDescripcion();
		case 2:
			return listaLineaVentas.get(rowIndex).getPrecio();
		case 3:
			return listaLineaVentas.get(rowIndex).getCantidad();
		case 4:
			return listaLineaVentas.get(rowIndex).getPrecioTotal();
		default:
			return null;
		}
	}
	
	public void agregarLineaVenta(LineaVenta lineaVenta){
		listaLineaVentas.add(lineaVenta);
	}
	
	public List<LineaVenta> getListaLineaVentas() {
		return listaLineaVentas;
	}

	public void setListaLineaVentas(List<LineaVenta> listaLineaVentas) {
		this.listaLineaVentas = listaLineaVentas;
	}
	
	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

}
