package task.line;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;

import task.Task;
import view.uml.ObjectView;
import view.uml.basic.PortView;
import view.uml.line.LineView;

public abstract class LineTask extends Task {
	private Point lastPoint;
	private Component lastComponent;
	
	public abstract LineView getView();

	@Override
	public void releasedOnObject(MouseEvent e) {
//		EditorView editorView=(EditorView)e.getComponent().getParent();
		
		//adjust lastPoint
		lastPoint.translate(lastComponent.getX(), lastComponent.getY());
		
		//adjust event point
		Point p=new Point(e.getPoint());//according to "from"
		p.translate(lastComponent.getX(), lastComponent.getY());//according to editorView
		
		//get objects
		ObjectView from=(ObjectView) e.getComponent();
		ObjectView to=null;
		Component component=editorView.findComponentAt(p);
		if(component!=editorView)
			to=(ObjectView) component;
		
		//get ports
		PortView fromPort=from.getPort(lastPoint);
		PortView toPort=null;
		if(to!=null)
			toPort=to.getPort(p);
		
		//if ports exist, connect them
		if(fromPort!=null && toPort!=null){
			LineView lineView=getView();
			lineView.connect(fromPort, toPort);
			from.addComponentListener(lineView);
			to.addComponentListener(lineView);
			lineView.resetBound();
			
			editorView.add(lineView);
			editorView.repaint();
		}
	}

	@Override
	public void pressedOnObject(MouseEvent e) {
		lastPoint=e.getPoint();
		lastComponent=e.getComponent();
	}

	public void mousePressed(MouseEvent e){
		lastPoint=e.getPoint();
		lastComponent=e.getComponent();
	}
	public void mouseReleased(MouseEvent e){
		if(e.getComponent()!=editorView){
			//adjust lastPoint
			lastPoint.translate(lastComponent.getX(), lastComponent.getY());
			
			//adjust event point
			Point p=new Point(e.getPoint());//according to "from"
			p.translate(lastComponent.getX(), lastComponent.getY());//according to editorView
			
			//get objects
			ObjectView from=(ObjectView) e.getComponent();
			ObjectView to=null;
			Component component=editorView.findComponentAt(p);
			if(component!=editorView)
				to=(ObjectView) component;
			
			//get ports
			PortView fromPort=from.getPort(lastPoint);
			PortView toPort=null;
			if(to!=null)
				toPort=to.getPort(p);
			
			//if ports exist, connect them
			if(fromPort!=null && toPort!=null){
				LineView lineView=getView();
				lineView.connect(fromPort, toPort);
				from.addComponentListener(lineView);
				to.addComponentListener(lineView);
				lineView.resetBound();
				
				editorView.add(lineView);
				editorView.repaint();
			}
		}
	}
	public void mouseDragged(MouseEvent e){}
	
}
