package com.testgen.panels;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.testgen.Helpers.Visuals;
public class Viewer_Panel extends JPanel
{
	private JLabel l_editorName=new JLabel("PDF/Doc Viewer");
	private JTextArea ta=new JTextArea();
	private JPanel panelButton=new JPanel(new FlowLayout(FlowLayout.LEFT));

	public Viewer_Panel() {
		
		setLayout(new BorderLayout());
		
		ta.setText("This is the pdf viewer.I think this needs a JScrollPane");
		
		//setting text
		l_editorName.setFont(Visuals.boldFont_14);
		
		//adding to panelButton
		panelButton.add(l_editorName);
		
		
		//adding to this panel
		add(panelButton,BorderLayout.NORTH);
		add(ta,BorderLayout.CENTER);
	}

}
