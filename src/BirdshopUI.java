
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class BirdshopUI {
	
	private  ActionStore shop;
	Birds bird = null;

	public  BirdshopUI (ActionStore shop) {
		this.shop = shop;
		
		
		JFrame f = new JFrame("order window");
		f.setMinimumSize(new Dimension(500, 200));
		f.setLocation(400, 200);
		
		f.getContentPane().add(createSellingPanel());
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
		
	}
	
	private  JPanel createSellingPanel(){
		JPanel panel = new JPanel();
		GridBagLayout grid = new GridBagLayout();
		panel.setLayout(grid);
		GridBagConstraints constr = new GridBagConstraints();
		
		
		JLabel name = new JLabel("Name:");
		constr.gridx = 0;
		constr.gridy = 0;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.weightx = 1;
		constr.weighty = 1;
		constr.fill = GridBagConstraints.HORIZONTAL;
        constr.anchor = GridBagConstraints.FIRST_LINE_END;
        constr.insets = new Insets(10,50,0,0);
		panel.add(name, constr);
		
		JTextField jtf = new JTextField(10);
		constr.gridx = 1;
		constr.gridy = 0;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.fill = GridBagConstraints.HORIZONTAL;
        constr.anchor = GridBagConstraints.FIRST_LINE_END;
        constr.insets = new Insets(10,-350,0,30);
		panel.add(jtf, constr);
		
		JPanel radioPanel = new JPanel();
		JLabel birds = new JLabel("Birds:     ");
		
		JRadioButton gooseButton = new JRadioButton("goose");
		gooseButton.setActionCommand("goose");
		JRadioButton duckButton = new JRadioButton("duck");
		JRadioButton chickenButton = new JRadioButton("chicken");
		JRadioButton ostrichButton = new JRadioButton("ostrich");
		JRadioButton falconButton = new JRadioButton("falcon");
		JRadioButton eagleButton = new JRadioButton("eagle");
		
		ButtonGroup group = new ButtonGroup();
		group.add(gooseButton);
		group.add(duckButton);
		group.add(chickenButton);
		group.add(ostrichButton);
		group.add(falconButton);
		group.add(eagleButton);
		
		gooseButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			setBird(shop.goose);
			}
		});
		
		duckButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			setBird(shop.duck);
			}
		});
		chickenButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			setBird(shop.chicken);
			}
		});
		ostrichButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			setBird(shop.ostrich);
			}
		});
		falconButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			setBird(shop.falcon);
			}
		});
		eagleButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			setBird(shop.eagle);
			}
		});
		
		
		 radioPanel.add(birds);
		radioPanel.add(gooseButton);
	    radioPanel.add(duckButton);
	    radioPanel.add(chickenButton);
	    radioPanel.add(ostrichButton);
	    radioPanel.add(falconButton);
	    radioPanel.add(eagleButton);
	   
	    
	    constr.gridx = 0;
		constr.gridy = 1;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.fill = GridBagConstraints.HORIZONTAL;
        constr.anchor = GridBagConstraints.PAGE_START;
        constr.insets = new Insets(0,0,0,0);
        
        panel.add(radioPanel, constr);
        
        JLabel count = new JLabel("Count:");
        constr.gridx = 0;
		constr.gridy = 2;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.fill = GridBagConstraints.HORIZONTAL;
        constr.anchor = GridBagConstraints.PAGE_START;
        constr.insets = new Insets(10,50,0,0);
        panel.add(count, constr);
		
        JTextField tfc = new JTextField(3);
        constr.gridx = 1;
		constr.gridy = 2;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.fill = GridBagConstraints.HORIZONTAL;
        constr.anchor = GridBagConstraints.FIRST_LINE_END;
        constr.insets = new Insets(10,-350,0,300);
        panel.add(tfc, constr);
        
        JButton buy = new JButton("buy");
		buy.setBounds(100, 100, 50, 20);
		constr.gridx = 1;
		constr.gridy = 2;
		constr.gridheight = 1;
		constr.gridwidth = 1;
		constr.fill = GridBagConstraints.HORIZONTAL;
	    constr.anchor = GridBagConstraints.PAGE_START;
	    constr.insets = new Insets(5,0,0,40);
		panel.add(buy, constr);
		
		buy.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				shop.transactoin(jtf.getText(), bird, Integer.valueOf(tfc.getText()));
				shop.transactionsToday();
				new SimpleTable(shop).createAndShowGUI();
			}
		});
        	    
		return panel;
	}
	
	private void setBird(Birds b){
		bird = b;
	}
}
