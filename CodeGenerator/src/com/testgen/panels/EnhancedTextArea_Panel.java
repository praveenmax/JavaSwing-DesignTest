package com.testgen.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

import com.testgen.Helpers.Visuals;

/*
 * This panel contains a JTextArea embedded into JScrollPane.
 * 
 * 
 */
public class EnhancedTextArea_Panel extends JPanel
{
	//buttons
	private JToggleButton b_previewCode=new JToggleButton("Preview Code");
	private JButton b_alignCode=new JButton("Align Code");
	private JLabel l_editorName=new JLabel("Doc");
	
	//Editors
	private JEditorPane ta_gencode;
	private Document doc;
	
	//scrollpane
	private JScrollPane scrollpane;
	
	String rawCode="nothing";
	
	//panels
	JPanel panelButton=new JPanel(new FlowLayout(FlowLayout.LEFT));

	
	//listener class
	ButtonHandler b_Handler=new ButtonHandler();
	
	public EnhancedTextArea_Panel()
	{                                    
		setLayout(new BorderLayout());

		ta_gencode=new JEditorPane();
		doc=ta_gencode.getDocument();
		
		if (doc instanceof PlainDocument) {
		    doc.putProperty(PlainDocument.tabSizeAttribute, 2);
		}

		//setting custom fonts
		ta_gencode.setFont(Visuals.boldFont_14);
		l_editorName.setFont(Visuals.boldFont_15);
		
		scrollpane=new JScrollPane(ta_gencode);
		
		//adding listeners
		b_previewCode.addActionListener(b_Handler);
		
		//adding to panel
			panelButton.add(l_editorName);
			panelButton.add(Box.createHorizontalStrut(50));
			panelButton.add(b_previewCode);
			panelButton.add(b_alignCode);
		add(scrollpane,BorderLayout.CENTER);
		add(panelButton,BorderLayout.NORTH);

	}

	public void setCodeText(String temp)
	{
		ta_gencode.setText(temp);
	}
	
	public JEditorPane getTextAreaObject()
	{
		return ta_gencode;
	}
	
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{

			if(ae.getSource()==b_previewCode)
			{
				if(b_previewCode.isSelected())
				{
					//get the current rawHTML code from this panel's JTextArea
					rawCode=ta_gencode.getText();
					System.out.println(rawCode);
					
					//System.out.println("Previewing code:");
					ta_gencode.setContentType("text/html");
					ta_gencode.setEditable(false);
					ta_gencode.setText(rawCode);
				}
				else
				{
					ta_gencode.setContentType("text/plain");
					ta_gencode.setDocument(doc);
					ta_gencode.setEditable(true);
					ta_gencode.setText(rawCode);

					//System.out.println("Released");
				}
			}
		}
	}
	
}
