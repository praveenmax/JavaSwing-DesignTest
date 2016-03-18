package com.testgen;

import java.awt.*;

import javax.swing.*;

import com.testgen.panels.Test1_Panel;
import com.testgen.panels.EnhancedTextArea_Panel;
import com.testgen.panels.Tab_Panel;
import com.testgen.panels.TestList_Panel;
public class MainFrame extends JFrame
{
	final private JPanel RchildPanel=new JPanel(new BorderLayout());
	final private JTabbedPane tabbedpane=new JTabbedPane();
	final private JSplitPane splitpane;

	//custom classes
	final private TestList_Panel elementsPanel=new TestList_Panel();
	final private Tab_Panel editorTab=new Tab_Panel();
	final private Test1_Panel elementsAttribPanel=new Test1_Panel(elementsPanel);
	//menu
	final private MainMenu menubar=new MainMenu();
	
	MainFrame()
	{
		super("CodeGen");
		
		//adding to tabbedpane
		tabbedpane.addTab("Editor", editorTab);
		tabbedpane.addTab("Designer", new JPanel());
		
		//adding to childpanel
		RchildPanel.add(elementsPanel,BorderLayout.CENTER);
		RchildPanel.add(elementsAttribPanel,BorderLayout.SOUTH);
		
		//Adding all to splitpane
		splitpane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tabbedpane, RchildPanel);
		//splitpane.setOneTouchExpandable(true);
		splitpane.setDividerSize(10);
		splitpane.setResizeWeight(1);
		splitpane.setEnabled(false);
		
		//changing the contentpane to splitpane
		setContentPane(splitpane);
		
		//set visuals
		setJMenuBar(menubar);
		setAlwaysOnTop(true);
		setSize(800,600);
		//setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args)
	{
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				final MainFrame frame=new MainFrame();

				frame.setVisible(true);
				System.out.println("********  Max CodeGen Running!  ********");
			}
		});
	}
}
