package view.uml.basic;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import view.Config;
import view.uml.ObjectView;

public abstract class BasicView extends ObjectView{
	private ArrayList<PortView> ports;
	private	Point portsLocation[]=
			{
				new Point(Config.objectSize.width/2-Config.portSize.width/2, -Config.portSize.height/2),
				new Point(Config.objectSize.width/2-Config.portSize.width/2, Config.objectSize.height-Config.portSize.height/2),
				new Point(-Config.portSize.width/2, Config.objectSize.height/2-Config.portSize.height/2),
				new Point(Config.objectSize.width-Config.portSize.width/2, Config.objectSize.height/2-Config.portSize.height/2),
			};
	public BasicView() {
		setSize(Config.objectSize);
		setPreferredSize(Config.objectSize);
		

		ports=new ArrayList<PortView>(portsLocation.length);
		for(int i=0; i<portsLocation.length; i++){
			PortView portView=new PortView();
			portView.setLocation(portsLocation[i]);
			portView.setVisible(false);
			ports.add(portView);
			add(portView);
			addComponentListener(portView);
		}
	}
	
	//basicView should have no components so far.
	//for ungroup function.
	@Override
	public Component[] getComponents() {
		return new Component[]{};
	}
	
	//port
	public PortView getPort(Point p){
		Point absoluteLocation=getAbsoluteLocation();
		p.translate(-absoluteLocation.x, -absoluteLocation.y);
		p.translate(Config.portSize.width/2, Config.portSize.height/2);
		double minD=p.distance(getComponent(0).getLocation());
		Component port=getComponent(0);
		for(Component component: super.getComponents())
			if(p.distance(component.getLocation())<minD){
				port=component;
				minD=p.distance(component.getLocation());
			}
		return (PortView)port;
	}
//	public ArrayList<PortView> getPorts() {
//		return ports;
//	}
	

	@Override
	public void setSelected(boolean isSelected){
		for(PortView portView: ports)
			portView.setSelected(isSelected);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setClip(-Config.portSize.width, -Config.portSize.height, 
				getWidth()+Config.portSize.width*2, getHeight()+Config.portSize.width*2);
		super.paintComponent(g);
	}
}
