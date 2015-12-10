package view.uml.line;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

import model.uml.line.ConnectionLine;
import view.uml.basic.BasicView;

public class LineView extends JComponent{
	private ConnectionLine connectionLine;
	private BasicView from, to;
	//model
	public ConnectionLine getConnectionLine() {
		return connectionLine;
	}
	public void setConnectionLine(ConnectionLine connectionLine) {
		this.connectionLine = connectionLine;
	}	
	public void connect(BasicView from, Point fromPoint, BasicView to, Point toPoint){
		this.from=from;
		this.to=to;
		fromPoint=from.getPort(from.getPortNum(fromPoint));
		toPoint=to.getPort(to.getPortNum(toPoint));
		setLocation(Math.min(fromPoint.x, toPoint.x), Math.min(fromPoint.y, toPoint.y));
		setSize(Math.abs(to.getX()-from.getX()), Math.abs(to.getY()-from.getY()));
	}
	
	public void reset(){
		Point fromPoint=getFromPoint(), toPoint=getToPoint();
		setSize(Math.max(1,Math.abs(toPoint.x-fromPoint.x)), Math.max(1,Math.abs(toPoint.y-fromPoint.y)));
		setLocation(Math.min(fromPoint.x, toPoint.x), Math.min(fromPoint.y, toPoint.y));
	}
	
	public Point getFromPoint(){
		return from.getPort(connectionLine.getFrom().getPortNum());
	}
	public Point getToPoint(){
		return to.getPort(connectionLine.getTo().getPortNum());
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Point fromPoint=getFromPoint(), toPoint=getToPoint();
		fromPoint.translate(-getX(), -getY());
		toPoint.translate(-getX(), -getY());
		g.drawLine(fromPoint.x, fromPoint.y, toPoint.x, toPoint.y);
		reset();
		System.out.println(getX()+", "+getY()+" "+fromPoint.x+", "+fromPoint.y+" "+toPoint.x+", "+toPoint.y);
	}
}
