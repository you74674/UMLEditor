package view.uml;

import java.awt.Component;
import java.awt.Point;

import javax.swing.JPanel;

import view.listener.ObjectListener;

public abstract class ObjectView extends JPanel{

//	protected Object object;
	
	abstract public void setSelected(boolean isSelected);

	public ObjectView(){
		setLayout(null);
		ObjectListener objectListener=new ObjectListener();
		addMouseListener(objectListener);
		addMouseMotionListener(objectListener);
	}
	
	
	public Point getAbsoluteLocation(){
		Point p=getLocation();
		for(Component c=getParent(); c instanceof ObjectView; c=c.getParent())
			p.translate(c.getX(), c.getY());
		return p;
	}
	
	

	@Override 
	public void setLocation(Point p){
		super.setLocation(p);
		if(getParent()!=null){
			getParent().repaint();
		}
	}
}
