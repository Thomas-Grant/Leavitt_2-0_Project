import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class CreateTable extends JPanel{
	
	JTable jt;
	String [] columns;
	String [][] data;

	public CreateTable(String [][] data, String [] columns){
		this.columns = columns;
		this.data = data;
		
		jt = new JTable(data, columns) {
			
			public boolean isCellEditable(int data, int columns) {
				return false;
			}
			
			public Component prepareRenderer(TableCellRenderer r, int data, int columns) {
				Component c = super.prepareRenderer(r, data, columns);
				
				setAlignmentX(Component.CENTER_ALIGNMENT);
				
				if(data % 2 == 0) {
					c.setBackground(Color.WHITE);
				}
				else {
					c.setBackground(SystemColor.activeCaption);
				}

				if(isCellSelected(data, columns)) {
					c.setBackground(Color.LIGHT_GRAY);
				}
				return c;
			}
		};
		
		jt.setPreferredScrollableViewportSize(new Dimension(940, 450));
		jt.setFillsViewportHeight(true);
		
		JScrollPane jps = new JScrollPane(jt);
		add(jps);
	}
	
	public void clearTable() {
		jt.removeAll();
	}
	
	public void fillTable(String [][] data, String [] columns) {
		jt = new JTable(data, columns);
	}
	
	@SuppressWarnings("deprecation")
	public void resizeTable(int width, int height) {
		jt.resize(width, height);
	}
	
}
