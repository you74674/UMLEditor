package task;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

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
		EditorView editorView=(EditorView) e.getComponent();

		//remove rec to clear editor view
		editorView.remove(rec);		
		
		//add object in rec into selected
		ArrayList<Component> tmp=new ArrayList<Component>();
		for(Component component: editorView.getComponents())
			if(component instanceof ObjectView)
				if(rec.getBounds().contains(component.getBounds()))
					tmp.add(component);
		ObjectView selected[]=tmp.toArray(new ObjectView[tmp.size()]);
		
		//select
		editorView.select(selected);
		
		//clear last pressed
		last=null;
		
		//update
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
	public void draggedOnObject(MouseEvent e) {
		Component component=e.getComponent();
		Point point=e.getPoint();
		point.translate(component.getX()-last.x, component.getY()-last.y);
		component.setLocation(point);
		component.getParent().repaint();
	}

	@Override
	public void pressedOnObject(MouseEvent e) {
		last=e.getPoint();
		//set select
		((EditorView)e.getComponent().getParent()).select(new ObjectView[]{(ObjectView) e.getComponent()});
		((ObjectView) e.getComponent()).setSelected(true);
		e.getComponent().getParent().repaint();
	}
	
	@Override
	public void exit(EditorView editorView) {
		super.exit(editorView);
		editorView.select(new ObjectView[]{});
	}
}
