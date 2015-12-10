package view.base;

import java.awt.Component;

import javax.swing.JLayeredPane;

public class EditArea extends JLayeredPane{
	public EditArea(){
		super();
		setOpaque(true);
	}
	
	@Override
	public Component add(Component component){
		super.add(component);
		moveToFront(component);
		return component;
	}
}
