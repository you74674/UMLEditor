package view.uml.basic;

import java.awt.Graphics;

public class UseCaseView extends BasicView{


	public UseCaseView() {
		super();
		setOpaque(false);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(getBackground());
		g.fillOval(0, 0, getWidth()-1, getHeight()-1);
		g.setColor(getForeground());
		g.drawOval(0, 0, getWidth()-1, getHeight()-1);
		g.drawString(getName(), 10, getHeight()/2+5);
	}
}
