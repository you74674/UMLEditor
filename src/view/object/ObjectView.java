package view.object;

import javax.swing.JComponent;

import model.object.Object;

public abstract class ObjectView extends JComponent{
	//model
	private Object object;
	public ObjectView(){
		
	}
	public Object getObject() {
		return object;
	}
}
