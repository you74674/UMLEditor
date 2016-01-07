package view.uml.basic;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import view.Config;
import view.uml.ObjectView;
import view.uml.line.LineView;

public class PortView extends ObjectView{
	private ArrayList<LineView> lineViews;
	
	public PortView() {
		setSize(Config.portSize);
		setBackground(Color.BLACK);
		lineViews=new ArrayList<LineView>();
	}
	public ArrayList<LineView> getLineViews() {
		return lineViews;
	}
	public void addLine(LineView lineView){
		lineViews.add(lineView);
	}
	
	@Override
	public void setSelected(boolean isSelected) {

	}

	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
//		g.setColor(Color.BLACK);
//		g.drawRect(0, 0, Config.portSize.width, Config.portSize.height);
//		

//		for(LineView lineView: lineViews){
//			g.drawString(lineView.getFrom().getAbsoluteLocation().toString(), 0, y);
//			y+=10;
//		}
	}
}
