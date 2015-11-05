package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
	private MainFrame parent;
	
	private JMenu fileMenu;
	private JMenu editMenu;
	
	private void setFileMenu(){
		fileMenu=new JMenu("File");
		fileMenu.add(new JMenuItem("New file"){
			{
				addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						parent.getModel();
					}
				});
			}			
		});
		fileMenu.add(new JMenuItem("Open"){
			{
				addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
//						JFileChooser fileChooser=new JFileChooser()
					}
				});
			}
		});
		fileMenu.add(new JMenuItem("Save"){
			{
				addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
					}
				});
			}
		});
		add(fileMenu);		
	}
	private void setEditMenu(){
		editMenu=new JMenu("edit");
		editMenu.add(new JMenuItem("change object name"){
			{
				addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
					}
				});
			}
		});
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
}
