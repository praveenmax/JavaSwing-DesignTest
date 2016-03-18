package com.testgen.panels;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.testgen.Helpers.Visuals;

public class TestList_Panel extends JPanel implements ActionListener,MouseListener
{
	ButtonGroup bg_RadioButtons;
	
	private JLabel l_paneltitle,l_grouptitle;
	private JRadioButton rb_test1;
	private JRadioButton rb_test2;
	private JRadioButton rb_test3;
	private JRadioButton rb_test4;
	private JRadioButton rb_test5;
	private JRadioButton rb_test6;
	private JRadioButton rb_test7;
	private JRadioButton rb_test8;
	private JRadioButton rb_test9;
	private JRadioButton rb_test10;
	private JRadioButton rb_test11;
	private JRadioButton rb_test12;
	private JRadioButton rb_test13;
	private JRadioButton rb_test14;
	
	//group fields
	private JRadioButton rd_GroupChk;

	//multi-label checker
	private boolean isMultiLabel;
	
	public TestList_Panel()
	{
		setLayout(new GridLayout(17,1,0,6));
		setBorder(BorderFactory.createEtchedBorder(1));
	//	setPreferredSize(new Dimension(200,450));
		
		//comps
		l_paneltitle=new JLabel("Input-fields:\t");
		l_paneltitle.setFont(Visuals.boldFont_15);
		
		l_grouptitle=new JLabel("Testing:\t");
		l_grouptitle.setFont(Visuals.boldFont_15);
		
		bg_RadioButtons=new ButtonGroup();
		
		rb_test1=new JRadioButton("Testing");
		rb_test1.setActionCommand("SectionTitleLightGrey");
		
		rb_test2=new JRadioButton("Testing");
		rb_test2.setActionCommand("TextField");
		
		rb_test3=new JRadioButton("Testing");
		rb_test3.setActionCommand("RadioButtonYN");
		
		rb_test4=new JRadioButton("Testing");
		rb_test4.setActionCommand("TextArea");
		
		rb_test5=new JRadioButton("Testing");
		rb_test5.setActionCommand("FreeTextField");
		
		rb_test6=new JRadioButton("Testing");
		rb_test6.setActionCommand("CheckBox-TextField");
		
		rb_test7=new JRadioButton("Testing");
		rb_test7.setActionCommand("CheckBox-FreeTextField");
		rb_test7.setToolTipText("Testing");

		rb_test8=new JRadioButton("Testing");
		rb_test8.setActionCommand("CheckBox-FreeTextField_v2");
		rb_test8.setToolTipText("Testing");
		
		rb_test9=new JRadioButton("Testing");
		rb_test9.setActionCommand("CheckBox");
		
		rb_test10=new JRadioButton("Testing");
		rb_test10.setActionCommand("DateField");		
		
		rb_test11=new JRadioButton("Testing");
		rb_test11.setActionCommand("TableTemplate");		
		
		rb_test12=new JRadioButton("Testing");
		rb_test12.setActionCommand("DropDownMenu-Time");		

		rb_test13=new JRadioButton("Testing");
		rb_test13.setActionCommand("DropDownMenu-Custom");	
		rb_test13.setToolTipText("DropDown menu of 'n' options.");
		
		rb_test14=new JRadioButton("Testing");
		rb_test14.setActionCommand("RadioButtons-Custom");	      
		rb_test14.setToolTipText("RadioButtons of 'n' choices.");
		
		rd_GroupChk=new JRadioButton("Testing");
		rd_GroupChk.setActionCommand("CheckBoxes-Group");	      
		rd_GroupChk.setToolTipText("Create an array of Checkbox");		
		
		//radio button group
		bg_RadioButtons.add(rb_test2);
		bg_RadioButtons.add(rb_test1);		
		bg_RadioButtons.add(rb_test3);
		bg_RadioButtons.add(rb_test4);
		bg_RadioButtons.add(rb_test5);
		bg_RadioButtons.add(rb_test6);
		bg_RadioButtons.add(rb_test7);
		bg_RadioButtons.add(rb_test8);
		bg_RadioButtons.add(rb_test9);
		bg_RadioButtons.add(rb_test10);
		bg_RadioButtons.add(rb_test11);
		bg_RadioButtons.add(rb_test12);
		bg_RadioButtons.add(rb_test13);
		bg_RadioButtons.add(rb_test14);
		bg_RadioButtons.add(rd_GroupChk);
		
		//adding listeners to each radiobuttons
        
		rb_test11.addActionListener(this);         
		rb_test1.addActionListener(this);         
		rb_test2.addActionListener(this); 
		rb_test5.addActionListener(this); 
		rb_test4.addActionListener(this); 
		rb_test9.addActionListener(this); 
		rb_test6.addActionListener(this); 
		rb_test7.addActionListener(this); 
		rb_test8.addActionListener(this); 
		rb_test3.addActionListener(this); 
		rb_test10.addActionListener(this); 
		rb_test12.addActionListener(this); 
		rb_test13.addActionListener(this); 
		rb_test14.addActionListener(this); 
		rd_GroupChk.addActionListener(this); 
		
		//add mouselisteners 
		
		rb_test11.addMouseListener(this);         
		rb_test1.addMouseListener(this);         
		rb_test2.addMouseListener(this); 
		rb_test5.addMouseListener(this); 
		rb_test4.addMouseListener(this); 
		rb_test9.addMouseListener(this); 
		rb_test6.addMouseListener(this); 
		rb_test7.addMouseListener(this); 
		rb_test8.addMouseListener(this); 
		rb_test3.addMouseListener(this); 
		rb_test10.addMouseListener(this); 
		rb_test12.addMouseListener(this); 
		rb_test13.addMouseListener(this); 
		rb_test14.addMouseListener(this); 
		rd_GroupChk.addMouseListener(this); 		

		
		//adding each elementchoice to this panel
		add(l_paneltitle);

		add(rb_test11);
		add(rb_test1);
		add(rb_test2);
		add(rb_test5);
		add(rb_test4);
		add(rb_test9);
		add(rb_test6);
		add(rb_test7);
		add(rb_test8);
		add(rb_test3);
		add(rb_test14);
		add(rb_test10);
		add(rb_test12);
		add(rb_test13);
		//group fields
		add(l_grouptitle);
		add(rd_GroupChk);
	}
	
	public ButtonModel getSelectedElement()
	{
		return bg_RadioButtons.getSelection();
	}
	
	public boolean getLabelMode()
	{
		return isMultiLabel;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if( ae.getSource()==rb_test13 ||  ae.getSource()==rb_test14)
		{
			System.out.println("Multi-label importer enabled.");
			isMultiLabel=true;
		}
		else
		{
			isMultiLabel=false;
		}
	}

	/*
	 *Display a menu containing "wrap" options when clicked on a particular element
	 * 
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		System.out.println("Mouse clicked on :"+getSelectedElement().getActionCommand());
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}	
