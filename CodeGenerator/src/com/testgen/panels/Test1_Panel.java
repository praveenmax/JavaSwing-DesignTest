package com.testgen.panels;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

import helpers.StringProcessor;

public class Test1_Panel extends JPanel implements FocusListener,ActionListener
{
	final private JLabel l_eName;
	final private JLabel l_eLabel;
	final private JLabel l_fName;
	
	private JTextField t_eName;
	private JTextField t_eLabel;
	private JTextField t_fName;
	
	private JButton b_importLabels;

	//ElementsList_Panel class
	private TestList_Panel elementListPanel;
	
	//inner class
	LabelImporter labelImporter;
	public Test1_Panel(TestList_Panel elementListPanel)
	{
		
		//other classes
		this.elementListPanel=elementListPanel;
		labelImporter=new LabelImporter();
		
		//setting layout
		setLayout(new FlowLayout(FlowLayout.LEFT));

		b_importLabels=new JButton("X");
			b_importLabels.setToolTipText("To import labels");
			b_importLabels.setPreferredSize(new Dimension(30,2));
			b_importLabels.addActionListener(this);
			b_importLabels.setEnabled(false);
		l_eName=new JLabel("F Name:");
		l_eLabel=new JLabel("Label:");
		l_fName=new JLabel("F Name:");

		t_eName=new JTextField(8);
			t_eName.setToolTipText("Testing");
		t_eLabel=new JTextField(8);
			t_eLabel.addFocusListener(this);
			t_eLabel.setToolTipText("Testing");
		t_fName=new JTextField(5);
			t_fName.setToolTipText("Testing");

			
		Box box_labels_v1=Box.createVerticalBox();
			box_labels_v1.add(l_eName);
			box_labels_v1.add(Box.createVerticalStrut(5));
			box_labels_v1.add(l_eLabel);
			box_labels_v1.add(Box.createVerticalStrut(5));
			box_labels_v1.add(l_fName);
			
		Box box_textfields_v2=Box.createVerticalBox();
			box_textfields_v2.add(t_eName); 
			box_textfields_v2.add(t_eLabel);
			box_textfields_v2.add(t_fName);
			
		Box box_buttons_v3=Box.createVerticalBox();
			box_buttons_v3.add(b_importLabels);

		Box box_parent_horizontal=Box.createHorizontalBox();
			box_parent_horizontal.add(box_labels_v1);
			box_parent_horizontal.add(box_textfields_v2);
			box_parent_horizontal.add(box_buttons_v3);
			
		//adding to this panel
		add(box_parent_horizontal);
//		add(box_textfields_v2);
//		add(box_buttons_v3);
		
		setPreferredSize(new Dimension(200,80));

	}
	
	public String getFormname()
	{
		return t_fName.getText().trim();
	}
	
	public String getElementname()
	{
		return t_eName.getText().trim();
	}
	
	public String getElementlabel()
	{
		return t_eLabel.getText().trim();
	}

	@Override
	public void focusGained(FocusEvent e) {
		if(elementListPanel.getLabelMode())
		{
			b_importLabels.setEnabled(true);
		}
		else
		{
			b_importLabels.setEnabled(false);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource()==t_eLabel)
		{
			System.out.println("Grabbing Label content...");
		}	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b_importLabels)
		{
			if(!labelImporter.isVisible())
				labelImporter.setVisible(true);
		}
	}
	
	private class LabelImporter extends JFrame
	{
		private JTextArea lCPanel;
		private JButton b_import;
		
		public LabelImporter() {
			super("Import window");
			
			setLayout(new FlowLayout(FlowLayout.LEFT));
			
			lCPanel=new JTextArea(10,20);
			b_import=new JButton("Insert");
			b_import.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent ae)
						{
							t_eLabel.setText(StringProcessor.getStringArrayasCSV(StringProcessor.getTextAreaLines(lCPanel)));
							
						}
					}
			);
			
			//adding to this container
			add(new JLabel("Testing:                   "));
				add(new JLabel("NOTE : Testing           "));
				add(new JLabel("              Testing           "));
			add(new JScrollPane(lCPanel));
			add(b_import);
			
			//set visuals
			setSize(240,310);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(this);
			setAlwaysOnTop(true);
			setResizable(false);
			setVisible(false);
		}
	}
}//class
