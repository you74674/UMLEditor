package model.uml.object;

public class Depth {
	private int depth;

	private static int min=0;
	private static int max=99;
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		if(depth<min)
			depth=min;
		else if(depth>max)
			depth=max;
		this.depth=depth;
	}
	
}
