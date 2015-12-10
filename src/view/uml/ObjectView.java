package view.uml;

import java.awt.Component;
import java.awt.Point;

import javax.swing.JPanel;

import model.uml.object.Object;
import view.listener.ObjectListener;

public abstract class ObjectView extends JPanel{

	protected Object object;
	
	abstract public void setSelected(boolean isSelected);

	public ObjectView(){
		setLayout(null);
		ObjectListener objectListener=new ObjectListener();
		addMouseListener(objectListener);
		addMouseMotionListener(objectListener);
//		for(MouseListener mouseListener: getMouseListeners())
//		removeMouseListener(mouseListener);
//	for(MouseMotionListener mouseMotionListener: getMouseMotionListeners())
//		removeMouseMotionListener(mouseMotionListener);
	}
	
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
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
//		if(p.x<getParent().getX())
//			if(p.y<getParent().getY())
//				super.setLocation(new Point(0, 0));
//			else
//				super.setLocation(new Point(0, p.y));
//		else
//			super.setLocation(p);
//		
//		if(p.x>getParent().getWidth())
//			if(p.y>getParent().getHeight())
//				super.setLocation(new Point(getParent().getWidth()-getWidth(), getParent().getHeight()-getHeight()));
//			else
//				super.setLocation(new Point(getParent().getWidth()-getWidth(), p.y));
//		else
//			super.setLocation(p);
		}
	}
}
