package view.uml.line;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class GeneralizationView extends LineView {
	@Override 
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setClip(-10, -10, getWidth()+20, getHeight()+20);
		
		//translate: according to line location 
		Point to=getTo().getCenter();
		to.translate(-getX(), -getY());
		Point from=getFrom().getCenter();
		from.translate(-getX(), -getY());

		Point a=new Point(to);
		a.translate(-10, 10);
		Point b=new Point(to);
		b.translate(-10, -10);
		
		Polygon polygon=new Polygon(new int[]{to.x, a.x, b.x}, new int[]{to.y, a.y, b.y}, 3);
//		AffineTransform at=AffineTransform.getRotateInstance(-Math.atan2(to.y-from.y, to.x-from.x), from.x, from.y);
//		for(int i=0; i<polygon.npoints; i++){
//			at.rotate(polygon.xpoints[i], polygon.ypoints[i]);
//		}
		
		g.setColor(Color.WHITE);
		g.fillPolygon(new int[]{to.x, a.x+1, b.x+1}, new int[]{to.y, a.y-1, b.y+1}, 3);
		g.setColor(getForeground());
		g.drawPolygon(polygon);

	}
}
