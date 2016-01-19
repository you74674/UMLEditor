package view.uml;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;

import view.listener.ObjectListener;
import view.uml.basic.PortView;

public abstract class ObjectView extends JPanel implements ComponentListener{

//	protected Object object;
	
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

	public PortView getPort(Point lastPoint){
		return null;
	}
	
	public void ungroup(){

	}
	public void drag(Point point){
		setLocation(point);
	}
	
	abstract public void setSelected(boolean isSelected);

	public int getLayer() {
		return 0;
	}
}
