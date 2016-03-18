package com.testgen.panels;
/*
 * When pressed "Ctrl+P", this panel changes to PREVIEW mode.
 */
import java.awt.*;
import javax.swing.*;

public class Tab_Panel extends JPanel
{
	
	//splitpane
	final private JSplitPane splitpane;

	//other classes
	final private EnhancedTextArea_Panel editorPanel=new EnhancedTextArea_Panel();
	final private Viewer_Panel pdfPanel=new Viewer_Panel();

	public Tab_Panel() {
		
		//set layout
		setLayout(new BorderLayout());
		
		splitpane=new JSplitPane(JSplitPane.VERTICAL_SPLIT, pdfPanel, editorPanel);
			splitpane.setOpaque(true);
			splitpane.setOneTouchExpandable(true);
			splitpane.setDividerLocation(300);
		//adding to this panel
		add(splitpane,BorderLayout.CENTER);
		
	}

}
