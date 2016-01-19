package view.uml.line;

import java.awt.Graphics;
import java.awt.Point;

public class CompositionView extends LineView {
	@Override 
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Point to=getTo().getCenter();
		Point from=getFrom().getCenter();
		double a=(to.y-from.y)/(to.y-from.y);
		
		g.drawPolyline(new int[]{}, new int[]{}, 3);
	}
}
