package com.testgen;

import java.awt.event.KeyEvent;

import javax.swing.*;
public class MainMenu extends JMenuBar
{
	//menus
	private final JMenu m_File=new JMenu("File");
	private final JMenu m_Settings=new JMenu("Settings");
	private final JMenu m_Process=new JMenu("Process");
	
	//menu-items
		//1.Under "File" menu
		private final JMenuItem mi_Open=new JMenuItem("Open *.HTML Doc",KeyEvent.VK_O);
		private final JMenuItem mi_Exit=new JMenuItem("Exit",KeyEvent.VK_X);
		
	MainMenu()
	{
		
		
		
		//adding menuitems to menu
			//1.File menu
				m_File.add(mi_Open);
				m_File.add(mi_Exit);
				
			//2.Process
				
			//3.Settings
			
		
		//adding all menus to this menubar
		add(m_File);
		add(m_Process);
		add(m_Settings);
		
		
	}
	
}
