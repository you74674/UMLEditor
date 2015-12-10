package task.line;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;

import model.uml.line.ConnectionLine;
import task.Task;
import view.EditorView;
import view.uml.basic.BasicView;
import view.uml.line.LineView;

public abstract class LineTask extends Task {
	
	private Point lastPoint;
	private Component lastComponent;
	
	public abstract ConnectionLine getLine();
	public abstract LineView getView();
	

	@Override
	public void draggedOnCanvas(MouseEvent e) {

	}

	@Override
	public void releasedOnCanvas(MouseEvent e) {

	}


	@Override
	public void releasedOnObject(MouseEvent e) {
		if(e.getComponent() instanceof BasicView){
			EditorView editorView=(EditorView)e.getComponent().getParent();
	
			//get the other objectView
			Point p=new Point(e.getPoint());//according to "from"
			lastPoint.translate(lastComponent.getX(), lastComponent.getY());
			p.translate(lastComponent.getX(), lastComponent.getY());//according to editorView
			Component component=editorView.getComponentAt(p);
			if(component instanceof BasicView){
				BasicView from=(BasicView) lastComponent;
				BasicView to=(BasicView) component;
				
//				//model
				ConnectionLine connectionLine=getLine();
				connectionLine.connect(from.getObject(), from.getPortNum(lastPoint) , to.getObject(), to.getPortNum(p));
				//view
				LineView lineView=getView();
				lineView.setConnectionLine(connectionLine);
				lineView.connect(from, lastPoint, to, p);
				
				from.addOutLine(lineView);
				to.addInLine(lineView);
				
//				editorView.add(lineView);
				editorView.repaint();
			}
		}
	}

	@Override
	public void draggedOnObject(MouseEvent e) {
//		System.out.println(e.getX()+", "+e.getY());
	}

	@Override
	public void pressedOnObject(MouseEvent e) {
		lastPoint=e.getPoint();
		lastComponent=e.getComponent();
	}

	@Override
	public void pressedOnCanvas(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
