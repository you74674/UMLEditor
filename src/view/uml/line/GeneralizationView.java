package view.uml.line;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class GeneralizationView extends LineView {

	private final int UNIT=20;
	@Override 
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setClip(-UNIT, -UNIT, getWidth()+2*UNIT, getHeight()+2*UNIT);

		//translate: according to line location 
		Point to=getTo().getCenter();
		to.translate(-getX(), -getY());
		Point from=getFrom().getCenter();
		from.translate(-getX(), -getY());


		double theta=Math.atan2(to.y-from.y,to.x-from.x);
		Polygon polygon=new Polygon(new int[]{to.x, (int) (to.x+UNIT*((to.x-10)*Math.cos(theta)-(to.y-10)*Math.sin(theta))+0.5),
													(int) (to.x+UNIT*((to.x-10)*Math.cos(theta)-(to.y+10)*Math.sin(theta))+0.5)},
									new int[]{to.y, (int) (to.y+UNIT*((to.x-10)*Math.sin(theta)+(to.y-10)*Math.cos(theta))+0.5),
													(int) (to.y+UNIT*((to.x-10)*Math.sin(theta)+(to.y+10)*Math.cos(theta))+0.5)},
									3);
		
		g.setColor(Color.WHITE);
		g.fillPolygon(polygon);
		g.setColor(getForeground());
		g.drawPolygon(polygon);

	}
}
