package view.uml.basic;

import java.awt.Graphics;

import model.uml.object.BasicObject;

public class ClassView extends BasicView{

	public ClassView(BasicObject object) {
		super(object);
	}

	public ClassView() {
		super();
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);
		
		g.drawString(getObject().getName(), 5, 10);
//		g.drawString(getAbsoluteLocation().x+", "+getAbsoluteLocation().y, 5, 20);
	}
}
