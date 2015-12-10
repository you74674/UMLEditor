package view.uml.basic;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.border.AbstractBorder;

import model.uml.object.BasicObject;
import view.Config;
import view.listener.ObjectListener;
import view.uml.ObjectView;
import view.uml.line.LineView;

public abstract class BasicView extends ObjectView{
	private ArrayList<LineView> inLines, outLines;
	
	public BasicView(BasicObject object){
		this();
		setObject(object);
	}
	public BasicView() {
		setSize(Config.objectSize);
		setPreferredSize(Config.objectSize);
		
		ObjectListener objectListener=new ObjectListener();
		addMouseListener(objectListener);
		addMouseMotionListener(objectListener);
//		for(MouseListener mouseListener: getMouseListeners())
//			removeMouseListener(mouseListener);
//		for(MouseMotionListener mouseMotionListener: getMouseMotionListeners())
//			removeMouseMotionListener(mouseMotionListener);
		outLines=new ArrayList<LineView>();
		inLines=new ArrayList<LineView>();
	}
	
	//port
	public int getPortNum(Point p){
		Point ports[]={new Point(getWidth()/2,0),
				new Point(getWidth()/2,getHeight()),
				new Point(0,getHeight()/2),
				new Point(getWidth(),getHeight()/2),
				};
		p.translate(-getX(), -getY());
		int minI=0;
		double minD=p.distance(ports[0]);
		for(int i=1; i<ports.length; i++)
			if(p.distance(ports[i])<minD){
				minI=i;
				minD=p.distance(ports[i]);
			}
		return minI;
	}
	public Point getPort(int i){
		Point ports[]={new Point(getWidth()/2,0),
				new Point(getWidth()/2,getHeight()),
				new Point(0,getHeight()/2),
				new Point(getWidth(),getHeight()/2),
				};
		Point p=new Point(ports[i]);
		Point location=getAbsoluteLocation();
		p.translate(location.x, location.y);
		return p;
	}
	public void addInLine(LineView lineView){
		inLines.add(lineView);
	}
	public void addOutLine(LineView lineView){
		outLines.add(lineView);
	}
	public ArrayList<LineView> getInLines() {
		return inLines;
	}
	public ArrayList<LineView> getOutLine() {
		return outLines;
	}
	@Override
	public BasicObject getObject(){
		return (BasicObject) super.getObject();
	}
	
	//view
	@Override
	public void setSelected(boolean isSelect){
		setBorder(isSelect?new PortBorder():null);
	}


	class PortBorder extends AbstractBorder{
		private final Dimension portSize=Config.portSize;
		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			g.fillRect(x+width/2-portSize.width/2, 0, portSize.width, portSize.height);
			g.fillRect(x+width/2-portSize.width/2, height-portSize.height, portSize.width, portSize.height);
			g.fillRect(0, y+width/2-portSize.height/2, portSize.width, portSize.height);
			g.fillRect(width-portSize.width, y+width/2-portSize.height/2, portSize.width, portSize.height);
		}
		
		@Override
		public boolean isBorderOpaque() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public Insets getBorderInsets(Component c) {
			// TODO Auto-generated method stub
			return new Insets(10, 10, 10, 10);
		}
	}
}
