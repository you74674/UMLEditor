package task.line;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;

import task.Task;
import view.EditorView;
import view.uml.basic.BasicView;
import view.uml.line.LineView;

public abstract class LineTask extends Task {
	private Point lastPoint;
	private Component lastComponent;
	
	public abstract LineView getView();

	@Override
	public void releasedOnObject(MouseEvent e) {
		if(e.getComponent() instanceof BasicView){//from BasicView
			EditorView editorView=(EditorView)e.getComponent().getParent();
	
			//get the other objectView
			Point p=new Point(e.getPoint());//according to "from"
			lastPoint.translate(lastComponent.getX(), lastComponent.getY());
			p.translate(lastComponent.getX(), lastComponent.getY());//according to editorView
			Component component=editorView.findComponentAt(p);
			if(component instanceof BasicView){//to BasicView
				BasicView from=(BasicView) e.getComponent();
				BasicView to=(BasicView) component;
				
				//view
				LineView lineView=getView();
				lineView.connect(from.getPort(lastPoint), to.getPort(p));
				from.addComponentListener(lineView);
				to.addComponentListener(lineView);
				lineView.setLocation(Math.min(lineView.getFrom().getCenter().x, lineView.getTo().getCenter().x), 
										Math.min(lineView.getFrom().getCenter().y, lineView.getTo().getCenter().y));
				lineView.setSize(Math.abs(lineView.getFrom().getCenter().x-lineView.getTo().getCenter().x), 
										Math.abs(lineView.getFrom().getCenter().y-lineView.getTo().getCenter().y));
				
				editorView.add(lineView);
				editorView.repaint();
			}
		}
	}

	@Override
	public void pressedOnObject(MouseEvent e) {
		lastPoint=e.getPoint();
		lastComponent=e.getComponent();
	}

}
