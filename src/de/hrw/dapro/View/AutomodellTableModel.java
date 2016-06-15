package de.hrw.dapro.View;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import de.hrw.dapro.Models.Automodell;

class AutomodellTableModel extends DefaultTableModel
{
	private static final long serialVersionUID = -4538274618925024868L;
	
	public AutomodellTableModel(ArrayList<Automodell> modelle, String[] columnNames) {

	}
	
	
	
	
	/*
	private Vector<Automodell> m_cars = new Vector<>();
	private Vector<TableModelListener> m_listener = new Vector<>();
	
	public void addCar(Automodell automodell)
	{
		int index = m_cars.size();
		m_cars.add(automodell);
		
		TableModelEvent e = new TableModelEvent(this, index, index, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		for (int i = 0, n = m_listener.size(); i < n; i++) {
			((TableModelListener)m_listener.get(i)).tableChanged(e);
		}
	}

*/
}
