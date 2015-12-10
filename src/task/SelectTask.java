package task;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import view.EditorView;
import view.uml.ObjectView;

public class SelectTask extends Task {
	public JComponent rec;
	public Point last;


	//draw select rectangle
	@Override
	public void draggedOnCanvas(MouseEvent e) {
		rec.setSize(Math.abs(e.getX()-last.x),Math.abs(e.getY()-last.y));
		rec.setLocation(Math.min(e.getX(), last.x), Math.min(e.getY(), last.y));
		((EditorView)e.getComponent()).repaint();
	}

	@Override
	public void releasedOnCanvas(MouseEvent e) {
		/*	drag and release:
		 * 		select multiple object
		 * 
		 * */
		
		ArrayList<Component> tmp=new ArrayList<Component>();
		EditorView editorView=(EditorView) e.getComponent();
		editorView.remove(rec);
		for(Component component: editorView.getComponents())
			if(component instanceof ObjectView)
				if(rec.getBounds().contains(component.getBounds()))
					tmp.add(component);
		ObjectView selected[]=tmp.toArray(new ObjectView[tmp.size()]);
		

		editorView.setSelected(selected);
		
		last=null;
		
		editorView.repaint();
	}

	@Override
	public void pressedOnCanvas(MouseEvent e) {
		last=e.getPoint();
		rec=new JComponent() {
			{
				setLocation(last);
				setBorder(BorderFactory.createLineBorder(Color.BLACK));
			}
		};
		((EditorView)e.getComponent()).add(rec);
		((EditorView)e.getComponent()).repaint();
	}
	
	
	@Override
	public void releasedOnObject(MouseEvent e) {

	}

	@Override
	public void draggedOnObject(MouseEvent e) {
		Component component=e.getComponent();
		Point point=e.getPoint();
		point.translate(component.getX()-last.x, component.getY()-last.y);
		component.setLocation(point);
	}

	@Override
	public void pressedOnObject(MouseEvent e) {
		last=e.getPoint();
		((EditorView)e.getComponent().getParent()).setSelected(new ObjectView[]{(ObjectView) e.getComponent()});
		((ObjectView) e.getComponent()).setSelected(true);
		
		e.setSource(e.getComponent().getParent());
		e.getComponent().getParent().dispatchEvent(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Component source=e.getComponent();
		Component topComponent=SwingUtilities.getDeepestComponentAt(e.getComponent(), e.getX(), e.getY());
		if(source==topComponent){//editorView
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
