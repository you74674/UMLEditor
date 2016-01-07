package view.listener;

import java.awt.Component;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

import view.uml.ObjectView;

public class ObjectListener extends MouseInputAdapter{
	
	@Override
	public void mousePressed(MouseEvent e) {
		Component c=e.getComponent();
		if(c.getParent() instanceof ObjectView)
			e.setSource(c.getParent());
		c.getParent().dispatchEvent(e);
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		Component c=e.getComponent();
		if(c.getParent() instanceof ObjectView)
			e.setSource(c.getParent());
		c.getParent().dispatchEvent(e);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		Component c=e.getComponent();
		if(c.getParent() instanceof ObjectView)
			e.setSource(c.getParent());
		c.getParent().dispatchEvent(e);
	}
	

}
