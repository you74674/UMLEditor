package view.uml.basic;

import java.awt.Graphics;

import model.uml.object.BasicObject;

public class UseCaseView extends BasicView{

	public UseCaseView(BasicObject object) {
		super(object);
		// TODO Auto-generated constructor stub
	}

	public UseCaseView() {
		super();
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawOval(0, 0, getWidth()-1, getHeight()-1);
		g.drawString(getObject().getName(), 10, getHeight()/2+10);
	}
}
