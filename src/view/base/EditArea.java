package view.base;

import java.awt.Component;

import javax.swing.JLayeredPane;

import view.uml.ObjectView;

public class EditArea extends JLayeredPane{
	public EditArea(){
		super();
		setOpaque(true);
	}
	
	public Component add(ObjectView objectView){
		super.add(objectView);
		setLayer(objectView, objectView.getLayer());
		return objectView;
	}
}
