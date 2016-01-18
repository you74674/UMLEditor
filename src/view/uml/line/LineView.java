package view.uml.line;

import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JComponent;
import view.uml.basic.PortView;

public class LineView extends JComponent implements ComponentListener{
	private PortView from, to;
	
	public LineView() {
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
//	@Override
//	public void setSelected(boolean isSelected) {
//		// TODO Auto-generated method stub
//		
//	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(from.getCenter().x<to.getCenter().x==from.getCenter().y<to.getCenter().y)
			g.drawLine(0, 0, getWidth(), getHeight());
		else
			g.drawLine(0, getHeight(), getWidth(), 0);
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentMoved(ComponentEvent e) {
		setLocation(Math.min(from.getCenter().x, to.getCenter().x), Math.min(from.getCenter().y, to.getCenter().y));
		setSize(Math.abs(to.getCenter().x-from.getCenter().x), Math.abs(to.getCenter().y-from.getCenter().y));
	}
	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
}
