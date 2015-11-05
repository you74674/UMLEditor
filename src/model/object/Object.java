package model.object;


public abstract class Object{
	private String name;
	private Coord location;
	private Depth depth;

	//name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	
	//location
	public Coord getLocation() {
		return location;
	}
	public void setLocation(Coord location) {
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
