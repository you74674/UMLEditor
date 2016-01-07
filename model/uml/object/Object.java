package model.uml.object;

import java.awt.Point;

public abstract class Object{
	private String name;
	private Point location;
	private Depth depth;

	//name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	
	//location
	public Point getLocation() {
		return location;
	}
	public void setLocation(Point location) {
		this.location = location;
	}

	//depth
	public Depth getDepth() {
		return depth;
	}
	public void setDepth(Depth depth) {
		this.depth = depth;
	}


}
