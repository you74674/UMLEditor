package view.uml.line;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import view.Config;
import view.uml.ObjectView;
import view.uml.basic.PortView;

public abstract class LineView extends ObjectView implements ComponentListener{
	private PortView from, to;
	
	public LineView() {
		setOpaque(false);
		removeMouseListener(getMouseListeners()[0]);
		removeMouseMotionListener(getMouseMotionListeners()[0]);
		setEnabled(false);
	}
	public void setFrom(PortView from){
		this.from=from;
	}
	public PortView getFrom() {
		return from;
	}
	public PortView getTo() {
		return to;
	}

	public void connect(PortView from, PortView to) {
		this.from=from;
		this.to=to;
		from.addLine(this);
		to.addLine(this);
		resetBound();
	}
	public void resetBound(){
		setLocation(Math.min(from.getCenter().x, to.getCenter().x), Math.min(from.getCenter().y, to.getCenter().y));
		setSize(Math.abs(to.getCenter().x-from.getCenter().x)+1, Math.abs(to.getCenter().y-from.getCenter().y)+1);
	}
	
	@Override
	public boolean contains(int x, int y) {
//		if(from.getCenter().x<=to.getCenter().x==from.getCenter().y<=to.getCenter().y){
//			double a=(to.getCenter().y-from.getCenter().y)/(to.getCenter().x-from.getCenter().x);
//
//			if(
//			(x*(to.getCenter().y-from.getCenter().y)-y*(to.getCenter().x-from.getCenter().x))/
//			Math.sqrt((to.getCenter().y-from.getCenter().y)*(to.getCenter().y-from.getCenter().y)+
//			(to.getCenter().x-from.getCenter().x)*(to.getCenter().x-from.getCenter().x))
//			<5
//			)
//				return true;
//			else
//				return false;
//		
//		}
//		else
//			;
		return false;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Point fromPoint=from.getCenter();
		fromPoint.translate(-getX(), -getY());
		//{0, 0} -> {getWidth()-1, getHeight()-1}
		//{0, getHeight()-1} -> {getWidth()-1, 0}
		//{getWidth()-1, getHeight()-1} -> {0, 0}
		//{getWidth()-1, 0} -> {0, getHeight()-1}
		Point toPoint=new Point((fromPoint.x==0?getWidth()-1:0), (fromPoint.y==0?getHeight()-1:0));
		g.drawLine(fromPoint.x, fromPoint.y, toPoint.x, toPoint.y);
	}
	@Override
	public void setSelected(boolean isSelected) {
		//deal with select line. show turning point.
	}
	@Override
	public void drag(Point point) {
		//deal with bending line
	}
	@Override
	public int getLayer() {
		return Config.lineLayer;
	}
	
	
	
	//component listener
	@Override
	public void componentMoved(ComponentEvent e) {
		resetBound();
	}
}
