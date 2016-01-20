package view.uml.line;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class CompositionView extends LineView {
	
	private final int UNIT=10;
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
		
		double theta=Math.atan2(to.y-from.y,to.x-from.x);
		Polygon polygon=new Polygon(new int[]{to.x, to.x+(int)((-UNIT)*Math.cos(theta)-(UNIT)*Math.sin(theta)+0.5),
													to.x+(int)((-2*UNIT)*Math.cos(theta)+0.5),
													to.x+(int)((-UNIT)*Math.cos(theta)-(-UNIT)*Math.sin(theta)+0.5)
													},
									new int[]{to.y, to.y+(int)((-UNIT)*Math.sin(theta)+(UNIT)*Math.cos(theta)+0.5),
													to.y+(int)((-2*UNIT)*Math.sin(theta)+0.5),
													to.y+(int)((-UNIT)*Math.sin(theta)+(-UNIT)*Math.cos(theta)+0.5)
													},
									4);
		
		g.setColor(Color.WHITE);
		g.fillPolygon(polygon);
		g.setColor(getForeground());
		g.drawPolygon(polygon);
	}
}
