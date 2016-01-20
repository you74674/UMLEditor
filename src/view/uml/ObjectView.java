package view.uml;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;

import view.Config;
import view.listener.ObjectListener;
import view.uml.basic.PortView;

public abstract class ObjectView extends JPanel implements ComponentListener{

//	protected Object object;
	
	public ObjectView(){
		setLayout(null);
//		setOpaque(true);
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

	//default: no port
	public PortView getPort(Point lastPoint){
		return null;
	}
	//default: setLocation
	public void drag(Point point){
		setLocation(point);
	}
	
	abstract public void setSelected(boolean isSelected);
	public void ungroup(){
		
	}
	
	public int getLayer() {
		return Config.objectLayer;
	}
	
	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentMoved(ComponentEvent e) {
		processComponentEvent(e);
	}
	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
}
