package view.uml.line;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ComponentEvent;

import view.uml.ObjectView;
import view.uml.basic.PortView;

public abstract class LineView extends ObjectView{
	private PortView from, to;
	
	public LineView() {
		setOpaque(false);
		removeMouseListener(getMouseListeners()[0]);
		removeMouseMotionListener(getMouseMotionListeners()[0]);
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
	}
	public void resetBound(){
		setLocation(Math.min(from.getCenter().x, to.getCenter().x), Math.min(from.getCenter().y, to.getCenter().y));
		setSize(Math.abs(to.getCenter().x-from.getCenter().x)+1, Math.abs(to.getCenter().y-from.getCenter().y)+1);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(from.getCenter().x<=to.getCenter().x==from.getCenter().y<=to.getCenter().y)
			g.drawLine(0, 0, getWidth()-1, getHeight()-1);
		else
			g.drawLine(0, getHeight()-1, getWidth()-1, 0);
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
		return 100;
	}
	
	
	
	//component listener
	@Override
	public void componentHidden(ComponentEvent e) {
	}
	@Override
	public void componentMoved(ComponentEvent e) {
		resetBound();
	}
	@Override
	public void componentResized(ComponentEvent e) {
	}
	@Override
	public void componentShown(ComponentEvent e) {
	}


}
