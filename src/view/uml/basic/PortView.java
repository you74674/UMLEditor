package view.uml.basic;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import view.Config;
import view.uml.ObjectView;
import view.uml.line.LineView;

public class PortView extends ObjectView{
//	private ArrayList<LineView> lineViews;
	
	private ObjectView basicView;
	private ArrayList<LineView> inLines;
	private ArrayList<LineView> outLines;

	
	public PortView() {
		setSize(Config.portSize);
		setBackground(Color.BLACK);
//		lineViews=new ArrayList<LineView>();
		
		inLines=new ArrayList<LineView>();
		outLines=new ArrayList<LineView>();
	}
	
	//basicView
	public ObjectView getBasicView() {
		return basicView;
	}
	public void setBasicView(ObjectView basicView) {
		this.basicView = basicView;
	}	
	
	//lines
//	public ArrayList<LineView> getLineViews() {
//		return lineViews;
//	}
	public ArrayList<LineView> getOutLines(){
		return outLines;
	}
	public void addLine(LineView lineView){
//		lineViews.add(lineView);
		if(lineView.getFrom().equals(this))
			addOutLine(lineView);
		else if(lineView.getTo().equals(this))
			addInLine(lineView);
		setVisible(true);
	}
	private void addInLine(LineView lineView){
		inLines.add(lineView);
		setVisible(true);
	}
	private void addOutLine(LineView lineView){
		outLines.add(lineView);
		setVisible(true);
	}

	public Point getCenter(){
		Point point=getAbsoluteLocation();
//		point.translate(getParent().getX(), getParent().getY());
		point.translate(getWidth()/2, getHeight()/2);
		return point;
	}
	@Override
	public void drag(Point point) {
		//deal with bending line
	}
	
	@Override
	public void setSelected(boolean isSelected) {
		if(inLines.isEmpty()&&outLines.isEmpty())
			setVisible(isSelected);
	}

	@Override
	public void componentHidden(ComponentEvent e) {
	}
	@Override
	public void componentMoved(ComponentEvent e) {
//		resetBound();
	}
	@Override
	public void componentResized(ComponentEvent e) {
	}
	@Override
	public void componentShown(ComponentEvent e) {
	}
}
