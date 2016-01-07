package view.uml.basic;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.border.AbstractBorder;

import view.Config;
import view.uml.ObjectView;

public abstract class BasicView extends ObjectView{
	private ArrayList<PortView> ports;

	public BasicView() {
		setSize(Config.objectSize);
		setPreferredSize(Config.objectSize);
		
		Point portsLocation[]=
			{
				new Point(getWidth()/2-Config.portSize.width/2, -Config.portSize.height/2),
				new Point(getWidth()/2-Config.portSize.width/2, getHeight()-Config.portSize.height/2),
				new Point(-Config.portSize.width/2, getHeight()/2-Config.portSize.height/2),
				new Point(getWidth()-Config.portSize.width/2, getHeight()/2-Config.portSize.height/2),
			};
		ports=new ArrayList<PortView>(4);
		for(int i=0; i<4; i++){
			PortView portView=new PortView();
			portView.setLocation(portsLocation[i]);
			portView.setVisible(false);
			getPorts().add(portView);
			add(portView);
		}
	}
	
	//port
	public PortView getPort(Point p){
		Point portsLocation[]={new Point(getWidth()/2,0),
				new Point(getWidth()/2,getHeight()),
				new Point(0,getHeight()/2),
				new Point(getWidth(),getHeight()/2),
				};
		p.translate(-getX(), -getY());
		int minI=0;
		double minD=p.distance(portsLocation[0]);
		for(int i=1; i<portsLocation.length; i++)
			if(p.distance(portsLocation[i])<minD){
				minI=i;
				minD=p.distance(portsLocation[i]);
			}
		return getPorts().get(minI);
	}
	public ArrayList<PortView> getPorts() {
		return ports;
	}
	
	@Override
	public void paint(Graphics g) {
		g.setClip(-10, -10, getWidth()+20, getHeight()+20);
		super.paint(g);
	}
	@Override
	public void paintComponents(Graphics g) {
//		g.setClip(-10, -10, getWidth()+20, getHeight()+20);
		super.paintComponents(g);
	}

	//view
	@Override
	public void setSelected(boolean isSelect){
//		setBorder(isSelect?new PortBorder():null);
		for(PortView portView: ports){
			portView.setVisible(isSelect);
		}
		getParent().repaint();
	}

	
//	class PortBorder extends AbstractBorder{
//		private final Dimension portSize=Config.portSize;
//		@Override
//		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
//			g.fillRect(x+width/2-portSize.width/2, 0, portSize.width, portSize.height);
//			g.fillRect(x+width/2-portSize.width/2, height-portSize.height, portSize.width, portSize.height);
//			g.fillRect(0, y+width/2-portSize.height/2, portSize.width, portSize.height);
//			g.fillRect(width-portSize.width, y+width/2-portSize.height/2, portSize.width, portSize.height);
//		}
//		
//		@Override
//		public boolean isBorderOpaque() {
//			// TODO Auto-generated method stub
//			return false;
//		}
//		
//		@Override
//		public Insets getBorderInsets(Component c) {
//			// TODO Auto-generated method stub
//			return new Insets(10, 10, 10, 10);
//		}
//	}
//

}
