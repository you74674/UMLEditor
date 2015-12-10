package view.uml;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;

import model.uml.object.CompositeObject;

public class CompositeView extends ObjectView{

	public CompositeView(){
		setOpaque(false);
		setBackground(Color.WHITE);
	}

	@Override
	public CompositeObject getObject(){
		return (CompositeObject) super.getObject();
	}
	
	@Override
	public void setSelected(boolean isSelected) {
		setBorder(isSelected?
				BorderFactory.createLineBorder(Color.BLACK):
					BorderFactory.createDashedBorder(null));
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
//		g.drawString(getAbsoluteLocation().x+", "+getAbsoluteLocation().y, 5, 40);
	}
}
