package view.uml.basic;

import java.awt.Graphics;

public class UseCaseView extends BasicView{


	public UseCaseView() {
		super();
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawOval(0, 0, getWidth()-1, getHeight()-1);
		g.drawString(getName(), 10, getHeight()/2+10);
	}
}
