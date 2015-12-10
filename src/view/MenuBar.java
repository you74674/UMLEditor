package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar implements ActionListener{
	private MainFrame parent;
	
	private JMenu fileMenu;
	private JMenu editMenu;
	
	private void setFileMenu(){
		fileMenu=new JMenu("File");
		fileMenu.add(new JMenuItem("New file"));
		fileMenu.add(new JMenuItem("Open"));
		fileMenu.add(new JMenuItem("Save"));
		
		for(int i=0; i<fileMenu.getItemCount(); i++)
			fileMenu.getItem(i).addActionListener(this);
		
		add(fileMenu);
	}
	
	private void setEditMenu(){
		editMenu=new JMenu("edit");
		editMenu.add(new JMenuItem("change object name"));
		editMenu.add(new JMenuItem("group"));
		editMenu.add(new JMenuItem("ungroup"));

		for(int i=0; i<fileMenu.getItemCount(); i++)
			editMenu.getItem(i).addActionListener(this);
		
		add(editMenu);
	}
	private void setComponents(){
		setFileMenu();
		setEditMenu();
	}
	public MenuBar(MainFrame parent){
		this.parent=parent;
		setComponents();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		parent.fireActionEvent(e);
	}
}
