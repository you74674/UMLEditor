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
//	private LineView lineView;
	
	public abstract LineView getView();

	public void mousePressed(MouseEvent e){


		//show selected port
		if(e.getComponent()!=editorView){
			lastPoint=e.getPoint();
			lastComponent=e.getComponent();
			
//			Point lastPoint=new Point(e.getPoint());
//			lastPoint.translate(e.getComponent().getX(), e.getComponent().getY());
//			lastComponent=editorView.findComponentAt(lastPoint);
//			PortView portView=((ObjectView)lastComponent).getPort(lastPoint);
//			if(portView!=null){
//				portView.setSelected(true);
//				editorView.repaint();
//			}
			
//			lineView=getView();
//			lineView.setFrom(((ObjectView)lastComponent).getPort(lastPoint));
//			editorView.add(lineView);
		}
	}
	public void mouseReleased(MouseEvent e){
		if(e.getComponent()!=editorView){
			//adjust lastPoint
			Point lastPoint=new Point(this.lastPoint);
			lastPoint.translate(lastComponent.getX(), lastComponent.getY());

			//adjust event point
			Point p=new Point(e.getPoint());//according to "from"
			p.translate(lastComponent.getX(), lastComponent.getY());//according to editorView
			
			//get objects
			ObjectView from=(ObjectView) e.getComponent();
			Component component=editorView.findComponentAt(p);
			
			//if released on object
			if(component!=editorView&&component!=null){
				ObjectView to=(ObjectView) component;
				
				//get ports
				PortView fromPort=from.getPort(lastPoint);
				PortView toPort=to.getPort(p);
			
				//if ports exist, connect them
				if(fromPort!=null && toPort!=null){
					LineView lineView=getView();
					lineView.connect(fromPort, toPort);
					editorView.add(lineView);
					editorView.repaint();
				}
			}
			else{//released on canvas or other
//				Point lastPoint2=new Point(this.lastPoint);
//				lastPoint2.translate(lastComponent.getX(), lastComponent.getY());
//				System.out.println(lastPoint2);
//				PortView portView=((ObjectView)lastComponent).getPort(lastPoint2);
//				if(portView!=null)
//					portView.setSelected(false);
////				editorView.remove(lineView);
//				editorView.repaint();
			}
		}
	}
	public void mouseDragged(MouseEvent e){
//		if(e.getComponent()!=editorView){
//			Point lastPoint=new Point(this.lastPoint);
//			lastPoint.translate(lastComponent.getX(), lastComponent.getY());
//			
//			Point point=new Point(e.getPoint());
//			point.translate(lastComponent.getX(), lastComponent.getY());
//			
//			lineView.setLocation(Math.min(point.x, lastPoint.x), Math.min(point.y, lastPoint.y));
//			lineView.setSize(Math.abs(point.x-lastPoint.x), Math.abs(point.y-lastPoint.y));
//		}
	}
	
}
