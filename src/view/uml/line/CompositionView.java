package view.uml.line;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class CompositionView extends LineView {
	@Override 
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setClip(-20, -20, getWidth()+40, getHeight()+40);
		
		//translate: according to line location 
		Point to=getTo().getCenter();
		to.translate(-getX(), -getY());
		Point from=getFrom().getCenter();
		from.translate(-getX(), -getY());

		Point a=new Point(to);
		a.translate(-10, 10);
		Point b=new Point(to);
		b.translate(-10, -10);
		
		Polygon polygon=new Polygon(new int[]{to.x, a.x, to.x-20, b.x}, new int[]{to.y, a.y, to.y, b.y}, 4);
//		double theta=Math.atan2(to.y-from.y, to.x-from.x);
		

		
		g.setColor(Color.WHITE);
		g.fillPolygon(new int[]{to.x, a.x+1, to.x-20, b.x+1}, new int[]{to.y, a.y-1, to.y, b.y+1}, 4);
		g.setColor(getForeground());
		g.drawPolygon(polygon);
	}
}
