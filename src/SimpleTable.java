import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SimpleTable extends JPanel{
	
	private boolean DEBUG = true;
	Transaction[] t;
	Object[][] data;
	ActionStore as;
	
	public SimpleTable(ActionStore as){
		
		super(new GridLayout(1,0));
		this.as = as;
	
		
		String[] columnNames = {
                "Buyer",
                "Bird",
                "Price",
                "Count",
                "Total"};
		
		
		t = as.archive.transactionToday;
		int c = 0;
		while(t[c]!=null){
			c++;
		}
		data = new Object[c][];
		
		for(int i = 0; i< c; i++){
			if(t[i].getT()!=null){
			data[i] = t[i].getT();}
		}
		
		
		final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 80));
        table.setFillsViewportHeight(true);
        
        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }
        
        JScrollPane scrollPane = new JScrollPane(table);
        
        add(scrollPane);
        
	}
        
        private void printDebugData(JTable table) {
            int numRows = table.getRowCount();
            int numCols = table.getColumnCount();
            javax.swing.table.TableModel model = table.getModel();

            System.out.println("Value of data: ");
            for (int i=0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j=0; j < numCols; j++) {
                    System.out.print("  " + model.getValueAt(i, j));
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
        
        public void createAndShowGUI() {
            //Create and set up the window.
            JFrame frame = new JFrame("SimpleTableDemo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Create and set up the content pane.
            SimpleTable newContentPane = new SimpleTable(as);
            newContentPane.setOpaque(true); //content panes must be opaque
            frame.setContentPane(newContentPane);

            //Display the window.
            frame.pack();
            frame.setVisible(true);
		
        }
}
