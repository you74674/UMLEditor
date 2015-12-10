package view.listener;

import java.awt.Component;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

import view.uml.CompositeView;
import view.uml.ObjectView;

public class ObjectListener extends MouseInputAdapter{
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Component i=e.getComponent();
		while(i instanceof ObjectView){
			if(i instanceof CompositeView){
				e.setSource(i);
			}
			i=i.getParent();
		}
		i.dispatchEvent(e);
	};
	@Override
	public void mousePressed(MouseEvent e) {
		Component i=e.getComponent();
		while(i instanceof ObjectView){
			if(i instanceof CompositeView){
				e.setSource(i);
			}
			i=i.getParent();
		}
		i.dispatchEvent(e);
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		Component i=e.getComponent();
		while(i instanceof ObjectView){
			if(i instanceof CompositeView){
				e.setSource(i);
			}
			i=i.getParent();
		}
		i.dispatchEvent(e);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		Component i=e.getComponent();
		while(i instanceof ObjectView){
			if(i instanceof CompositeView){
				e.setSource(i);
			}
			i=i.getParent();
		}
		i.dispatchEvent(e);
	}
	

}
