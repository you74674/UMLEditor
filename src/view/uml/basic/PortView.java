package view.uml.basic;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import view.Config;
import view.uml.ObjectView;
import view.uml.line.LineView;

public class PortView extends ObjectView{
	private ArrayList<LineView> lineViews;
	
	private ObjectView objectView;

	public PortView(/*ObjectView objectView*/) {
		setSize(Config.portSize);
		setBackground(Color.BLACK);
		lineViews=new ArrayList<LineView>();
//		this.objectView=objectView;
	}
	
	//basicView
	public ObjectView getObjectView() {
		return objectView;
	}
	
	//lines
	public void addLine(LineView lineView){
		lineViews.add(lineView);
		addComponentListener(lineView);
		setVisible(true);
	}

	public Point getCenter(){
		Point point=getAbsoluteLocation();
		point.translate(getWidth()/2, getHeight()/2);
		return point;
	}
	
	@Override
	public boolean contains(int x, int y) {
		return false;
	}
	
	@Override
	public void drag(Point point) {
		//deal with change port position
	}
	
	@Override
	public void setSelected(boolean isSelected) {
		if(lineViews.isEmpty())
			setVisible(isSelected);
//		if(inLines.isEmpty()&&outLines.isEmpty())
//			setVisible(isSelected);
	}
	
	
}
